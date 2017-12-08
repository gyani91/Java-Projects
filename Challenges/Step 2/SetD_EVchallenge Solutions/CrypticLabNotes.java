
public class CrypticLabNotes
{
	public String logic(String input)
	{
		String[] data = input.split(" ");
		int length = Integer.parseInt(data[0]);
		String output = "[";
		data[0] = "0";
		for(int count=1; count<=length; count++)
		{
			int repetations = Integer.parseInt(data[count]) - 
								Integer.parseInt(data[count-1]);
			for(int count2=0; count2<repetations; count2++)
			{
				output = output.concat(String.valueOf(count));
				if(!(count == length && count2 == repetations-1))
				{
					output = output.concat(" ");
				}
			}
		}
		
		output = output.concat("]");
		return output;
	}

}
