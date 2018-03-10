import java.util.ArrayList;

public class gameBoard
{
    private final int[] defaultAttributes = {-7,-7,-7,-7};
    private final gamePiece defaultPiece = new gamePiece(defaultAttributes);
    private gamePiece[][] board = {
            {defaultPiece,defaultPiece,defaultPiece,defaultPiece},
            {defaultPiece,defaultPiece,defaultPiece,defaultPiece},
            {defaultPiece,defaultPiece,defaultPiece,defaultPiece},
            {defaultPiece,defaultPiece,defaultPiece,defaultPiece}
    };
    public gameBoard(){}

    public gamePiece[][] getBoard()
    {
        return board;
    }

    public void setBoard(gamePiece[][] board)
    {
        this.board = board;
    }

    public void placeGamePiece(int x, int y, gamePiece piece)
    {
        board[x][y] = piece;
        System.out.println(checkVictory());
    }

    public String checkVictory()
    {
        if(checkHorizontal() || checkVertical() || checkDiagonal())
        {
            return "WINNER";
        }
        else
        {
            return "LOSER";
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

}
