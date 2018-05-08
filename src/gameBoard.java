import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class gameBoard
{
    private gamePiece currentPiece;	
    private List<gamePiece> pieces;
    private final String middle = "]           !           !           !           [\n";
    private final String bottom = "]-----------!-----------!-----------!-----------[\n";
    private final int[] defaultAttributes = {-7,-7,-7,-7};
    private final String[] defaultArt = {"           ","           ","           "};
    private final gamePiece defaultPiece = new gamePiece(defaultAttributes,defaultArt);
    private gamePiece[][] board = {
            {defaultPiece,defaultPiece,defaultPiece,defaultPiece},
            {defaultPiece,defaultPiece,defaultPiece,defaultPiece},
            {defaultPiece,defaultPiece,defaultPiece,defaultPiece},
            {defaultPiece,defaultPiece,defaultPiece,defaultPiece}
    };
    public gameBoard(List<gamePiece> pieceList)
    {
    	this.pieces = pieceList;
    }

    public gamePiece[][] getBoard()
    {
        return board;
    }

    public void setBoard(gamePiece[][] board)
    {
        this.board = board;
    }

    public void fillBoardWithPieces(List<gamePiece> pieceList)
    {
    	int index = 0;
	for(int i = 0; i < 4; i++)
	{
		for(int j = 0; j < 4; j++)
		{
			board[i][j] = pieceList.get(index);
			index++;
		}
	}
    }

    public void placeGamePiece(int x, int y, gamePiece piece)
    {
        board[x][y] = piece;
    }

    public boolean checkVictory()
    {
        if(checkHorizontal() || checkVertical() || checkDiagonal())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    private boolean checkHorizontal()
    {
        ArrayList<gamePiece> gamePieces = new ArrayList<>();
        for(int i = 0; i < 4; i++)
        {
            for(int j = 0; j < 4; j++)
            {
                gamePieces.add(board[j][i]);
            }
            if(compareGamePieces(gamePieces)) return true;
            gamePieces.clear();
        }
        return false;
    }

    private boolean checkVertical()
    {
        ArrayList<gamePiece> gamePieces = new ArrayList<>();
        for(int i = 0; i < 4; i++)
        {
            for(int j = 0; j < 4; j++)
            {
                gamePieces.add(board[i][j]);
            }
            if(compareGamePieces(gamePieces)) return true;
            gamePieces.clear();
        }
        return false;
    }

    private boolean checkDiagonal()
    {
        if(checkLeftDiagonal() || checkRightDiagonal()) return true;
        return false;
    }

    private boolean checkLeftDiagonal()
    {
        ArrayList<gamePiece> gamePieces = new ArrayList<>();
        for(int i = 0; i < 4; i++)
        {
            gamePieces.add(board[i][i]);
        }
        if(compareGamePieces(gamePieces)) return true;
        gamePieces.clear();
        return false;
    }

    private boolean checkRightDiagonal()
    {
        ArrayList<gamePiece> gamePieces = new ArrayList<>();
        for(int i = 0; i < 4; i++)
        {
            gamePieces.add(board[i][3-i]);
        }
        if(compareGamePieces(gamePieces)) return true;
        gamePieces.clear();
        return false;
    }

    private boolean compareGamePieces(ArrayList<gamePiece> gamePieceListParam)
    {
        System.out.println(gamePieceListParam.toString());
        int[] one = gamePieceListParam.get(0).getAttributes();
        int[] two = gamePieceListParam.get(1).getAttributes();
        int[] three = gamePieceListParam.get(2).getAttributes();
        int[] four = gamePieceListParam.get(3).getAttributes();
        int sum;
        for(int i = 0; i < 4; i++)
        {
            sum = one[i]+two[i]+three[i]+four[i];
            if(sum == 4 || sum == 0) return true;
        }
        return false;
    }

    public String getRowString(int index)
    {
	gamePiece[][] board = getBoard();
	StringBuilder row = new StringBuilder();
	for(int i=0; i<3; i++)
	{	
		row.append("]");
		for(int j=0; j<4; j++)
		{
			row.append(board[j][index].getGamePieceArt()[i]);
			if(j==3)
			{
				row.append("[\n");
			}
			else
			{
				row.append("!");
			}
		}
	}
	row.append(bottom);
	return row.toString();
    }

    public void printCurrentBoard()
    {
        StringBuilder currentBoard = new StringBuilder();
	currentBoard.append(bottom);
	for(int i = 0; i < 4; i++)
	{
		currentBoard.append(getRowString(i));
	}
	System.out.println(currentBoard.toString());
    }

    public void printAvailablePieces()
    {
    	StringBuilder availablePieces = new StringBuilder();
	for(int i = 0; i < pieces.size(); i++)
	{
		availablePieces.append(i + ": \n");
		for(int j = 0; j < 3; j++)
		{
			availablePieces.append(pieces.get(i).getGamePieceArt()[j]);
			availablePieces.append("\n");
		}
		availablePieces.append("\n");
	}
	System.out.println(availablePieces);
    }

    public void play()
    {
	List<gamePiece> piecesCopy = pieces;    
	Scanner scan = new Scanner(System.in);
	while(!checkVictory())
	{
		printCurrentBoard();
		System.out.println("Please select a valid piece from the selection provided");
		printAvailablePieces();
		int piece = scan.nextInt();
		while(checkPieceValid(piece))
		{
			System.out.println("Please select a valid piece from the selection provided");
			printAvailablePieces();
			piece = scan.nextInt();
		}
		currentPiece = pieces.get(piece);
		pieces.set(piece,null);
		System.out.println("Please select a valid space to place your piece");
		printCurrentBoard();
		currentPiece.printAsciiArt();
		System.out.println("Select x value");
		piece = scan.nextInt();
		int x = piece;
		System.out.println("Select y value");
		piece = scan.nextInt();
		int y = piece;
		while(checkSpotValid(x,y))
		{
			System.out.println("Please select a valid space to place your piece");
			printCurrentBoard();
			currentPiece.printAsciiArt();
			System.out.println("Select x value");
			piece = scan.nextInt();
			x = piece;
			System.out.println("Select y value");
			piece = scan.nextInt();
			y = piece;
		}
		placeGamePiece(x,y,currentPiece);
		printCurrentBoard();
	}
    	printCurrentBoard();
    }

    public boolean checkPieceValid(int index)
    {
    	gamePiece current = pieces.get(index);
	return (current == null) ? false : true;
    }

    public boolean checkSpotValid(int xIndex, int yIndex)
    {
    	return (board[xIndex][yIndex].getAttributes()==defaultAttributes) ? true : false;	
    }
}
