import java.util.List;
import java.util.Scanner;

public class mainmethod{
	public static void main(String args[])
    {
		gamePieceFactory myFactory = new gamePieceFactory();
		List<int[]> gamePiecesList = myFactory.generateGamePieces();
		gameBoard board = new gameBoard();
		Scanner reader = new Scanner(System.in);

	}
}