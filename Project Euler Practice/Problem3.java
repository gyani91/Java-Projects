import java.util.ArrayList;
import java.util.List;


public class Problem3 
{
	List<Integer> list = new ArrayList<Integer>();
	
	public void factor(long number)
	{
		long divisor;
		if(number>1)
		{
			for(divisor = 2; number % divisor > 0; divisor++);
			
			list.add(new Integer((int)divisor));
			
			factor(number/divisor);	
		}
	}
	public void displayList()
	{
		for(Integer i : list)
		{
			System.out.println(i);
		}
	}
}
