public class gamePiece
{
	private int[] attributes;
	private String[] ascii;

	public gamePiece(int[] attributesArray, String[] ascii)
	{
		this.attributes = attributesArray;
		this.ascii = ascii;
	}

	public int[] getAttributes()
	{
		return this.attributes;
	}

	public void setAttributes(int[] newAttributesArray)
	{
		this.attributes = newAttributesArray;
	}

	public String toString()
	{
		StringBuilder result = new StringBuilder();
		result.append("[");
		for(int i = 0; i < attributes.length; i++)
		{
			result.append(attributes[i]);
		}
		result.append("]");
		return result.toString();
	}

	public String[] getGamePieceArt()
	{
		return this.ascii;
	}

	public void setGamePieceArt(String[] asciiArt)
	{
		this.ascii = asciiArt;
	}

	public void printAsciiArt()
	{
		for(int i = 0; i < 3; i++)
		{
			System.out.println(ascii[i]);
		}
	}
}
