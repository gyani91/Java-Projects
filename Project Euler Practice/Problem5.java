

public class Problem5
{
	public static long gcd_2(long a, long b)
	{
		if(b==0)
			return a;
		else
			return (gcd_2(b,a%b));
	}
	
	public static long lcm_2(long a, long b)
	{
		return a * (b / gcd_2(a,b));
	}
	
	public static long gcd(long[] input)
	{
		long result = input[0];
		int length = input.length;
		for(int i=1; i<length; i++)
			result = gcd_2(result, input[i]);
		return result;
	}
	
	public static long lcm(long[] input)
	{
		long result = input[0];
		int length = input.length;
		for(int i=1; i<length; i++)
			result = lcm_2(result, input[i]);
		return result;
	}
	
	
}
