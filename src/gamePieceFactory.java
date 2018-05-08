import javax.swing.tree.TreeNode;
import java.util.*;

public class gamePieceFactory
{

	public final String[][] asciiArtArray = {
		{"           ","     _     ","    (-)    "},
		{"           ","     |     ","    (-)    "},
		{"           ","     _     ","    (+)    "},
		{"           ","     |     ","    (+)    "},
		{"     _     ","    (-)    ","    ( )    "},
		{"     |     ","    (-)    ","    ( )    "},
		{"     _     ","    (+)    ","    ( )    "},
		{"     |     ","    (+)    ","    ( )    "},
		{"           ","     _     ","    |-|    "},
		{"           ","     |     ","    |-|    "},
		{"           ","     _     ","    |+|    "},
		{"           ","     |     ","    |+|    "},
		{"     _     ","    |-|    ","    | |    "},
		{"     |     ","    |-|    ","    | |    "},
		{"     _     ","    |+|    ","    | |    "},
		{"     |     ","    |+|    ","    | |    "}
	};

	public gamePieceFactory()
	{
		for(int i = 0; i < asciiArtArray.length; i++)
		{
			System.out.println(asciiArtArray[i]+"\n");
		}
	}

	public List<gamePiece> generateGamePieces()
	{
		ArrayList<gamePiece> gamePiecesList = new ArrayList<gamePiece>();
		for(int i = 0; i < 16; i++)
		{
          		int[] currentAttributes = {0,0,0,0};
			String bitString = Integer.toBinaryString(i);
			while(bitString.length() < 4)
			{
				bitString = "0"+bitString;
			}
			int attributeIndex = 3;
			System.out.println(bitString);
			for(int j = bitString.length(); j > 0; j--)
			{
				currentAttributes[attributeIndex] = Character.getNumericValue(bitString.charAt(j-1));
				attributeIndex -= 1;
			}
			gamePiecesList.add(new gamePiece(currentAttributes,asciiArtArray[i]));
		}
		return gamePiecesList;
	}
}
