import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class CombinationLock
{
	String output;
	public String logic(String rawkey, String phrase)
	{
		Double key = Double.parseDouble(rawkey);
		int length = phrase.length();
		List<String> listdata = new ArrayList<String>();
		String[] data = phrase.split("");
		
		for(int count=0; count<=length; count++)
			listdata.add(data[count]);
		
		//Collections.sort(listdata);
		//Collections.reverse(listdata);
		
		Collections.sort(listdata, Collections.reverseOrder());
		
		phrase = "";
		
		for(String it : listdata)
			phrase += it;
		System.out.println(phrase);
		permute(phrase, key);
		return output;
	}
	
	void permute(String input, double key)
	{
	  int length = input.length();
	  output = "[no solution]";
	  boolean[] used = new boolean[length];
	  StringBuffer outputString = new StringBuffer();
	  char[] in = input.toCharArray();
	  try
	  {
		  doPermute(in, outputString, used, length, 0, key);
	  }
	  catch(Exception E)
	  {
		  //System.out.println("Exception Caught");
	  }

	}

	  void doPermute (char[] in, StringBuffer outputString, 
	                    boolean[] used, int length, int level, double key) throws Exception
	  {
	     if(level == 5)
	     {
	    	 double v,w,x,y,z;
	    	 String com = outputString.toString();
	    	 //System.out.println(com);
	    	 
	    	 v = Double.parseDouble(String.valueOf(com.charAt(0) - 'A' + 1));
				w = Double.parseDouble(String.valueOf(com.charAt(1) - 'A' + 1));
				x = Double.parseDouble(String.valueOf(com.charAt(2) - 'A' + 1));
				y = Double.parseDouble(String.valueOf(com.charAt(3) - 'A' + 1));
				z = Double.parseDouble(String.valueOf(com.charAt(4) - 'A' + 1));
			
			if(key == v - Math.pow(w, 2.0) + Math.pow(x, 3.0)
						- Math.pow(y, 4.0) + Math.pow(z, 5.0))
			{
					output = "[" + (char) (v + 'A' - 1) + 
								(char) (w + 'A' - 1) +
								(char) (x + 'A' - 1) +
								(char) (y + 'A' - 1) +
								(char) (z + 'A' - 1) + "]";
					throw new Exception();
			}
	    	return;
	     }

	     for(int i = 0; i < length; ++i )
	     {
	    	 if(used[i]) continue;
	    	 outputString.append(in[i]);
	    	 used[i] = true;
	    	 doPermute(in, outputString, used, length, level + 1, key);
	    	 used[i] = false;
	    	 outputString.setLength(outputString.length()-1);
	     }
	 }


}
