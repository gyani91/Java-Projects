
/*
 * Make audible sequence like
 * 	s = 3; n = 11
 * 	3
 * 	13
	1113
	3113
	132113
	1113122113
	311311222113
	13211321322113
	1113122113121113222113
	31131122211311123113322113
	31131122211311123113322113
	
	where s is the start s number and n is number of lines
	odd digits are number of occurrence and even digit are the digits
	
	Output is the last 4 digits of the sequence.
	[2113]
 */


public class Question3 {

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		int n = Integer.parseInt(args[1]);
		
		String output = args[0];
		
		
		for(int count=0; count<n-1; count++)
		{
			char[] buffer = output.toCharArray();
			int length = output.length(), index = 0, counter = 1;
			output = "";
			if(count<10)
			{
				while(index<length)
				{
					if(index == length-1)
					{
						output = output.concat(String.valueOf(counter)).concat(String.valueOf(buffer[index]));
						break;
					}	
					if(buffer[index] == buffer[index+1])
						counter++;
					else
					{
						output = output.concat(String.valueOf(counter)).concat(String.valueOf(buffer[index]));
						counter = 1;
					}
					index++;
				}
			}
			else
			{
				char[] buf = new char[4];
				buf[3] = buffer[length-1];
				index = 3;
				while(index>=0)
				{
					if(buffer[index] == buffer[index-1])
						counter++;
					else
						break;
					index--;
				}
				buf[2] = String.valueOf(counter).charAt(0);
				index--;
				counter = 1;
				buf[1] = buffer[index];
				while(index>0)
				{
					if(buffer[index] == buffer[index-1])
						counter++;
					else
						break;
					index--;
				}
				buf[0] = String.valueOf(counter).charAt(0);
				
				output = "" + buf[0] + buf[1] + buf[2] + buf[3];
				if(buf[0] == buffer[0] &&
						buf[1] == buffer[1] &&
						buf[2] == buffer[2] &&
						buf[3] == buffer[3])
					break;
				
			}
			//System.out.println(output);

		}
		
		int l = output.length();
		char[] out = output.toCharArray();
		//System.out.println(output);
		
		System.out.println("[" + out[l-4] + out[l-3] + out[l-2] + out[l-1] + "]");
	}
}
