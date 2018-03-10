import java.util.*;

public class gamePieceFactory
{
	public gamePieceFactory()
	{
	}

	public List<int[]> generateGamePieces()
	{
		ArrayList<int[]> gamePiecesList = new ArrayList<int[]>();
		for(int i = 0; i < 16; i++)
		{
            int[] currentGamePiece = {0,0,0,0};
			String bitString = Integer.toBinaryString(i);
			int gamePieceIndex = 3;
			for(int j = bitString.length(); j > 0; j--)
			{
				currentGamePiece[gamePieceIndex] = Character.getNumericValue(bitString.charAt(j-1));
				gamePieceIndex -= 1;
			}
			gamePiecesList.add(currentGamePiece);
		}
		return gamePiecesList;
	}
}