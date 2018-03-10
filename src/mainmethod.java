import java.util.List;

public class mainmethod{
	public static void main(String args[])
    {
		gamePieceFactory myFactory = new gamePieceFactory();
		List<int[]> gamePiecesList = myFactory.generateGamePieces();
		gameBoard board = new gameBoard();
		int[] foo = {0,1,0,1};
		int[] bar = {1,0,1,1};
		gamePiece doo = new gamePiece(foo);
		gamePiece crew = new gamePiece(bar);
		board.placeGamePiece(0,3,doo);
		board.placeGamePiece(1,2,doo);
		board.placeGamePiece(2,1,doo);
		board.placeGamePiece(3,0,doo);
	}
}