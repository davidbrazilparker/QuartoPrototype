public class gamePiece
{
	private int[] attributes;

	public gamePiece(int[] attributesArray)
	{
		this.attributes = attributesArray;
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
}