
public class Problem4
{
	public boolean palindromes(long number)
	{
		StringBuffer buffer = new StringBuffer(String.valueOf(number));
		return buffer.reverse().toString().equals(String.valueOf(number));
	}
}
