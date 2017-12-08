

/*
 * Make Absolute Fractions
 * like 134/536, here 3 can be cancelled from both numerator and denominator
 * making it 14/56 which == 134/536 again 
 */
public class Question2
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		System.out.println("[");
		for(int n=100; n<1000; n++)
		{
			int[] num = new int[3];
			
			num[0] = (n/100);
			num[1] = (n/10)%10;
			num[2] = n%10;
			
			if(num[1] == 0 || num[2] == 0
					|| num[0] == num[1]
					|| num[0] == num[2]
					|| num[1] == num[2])
				continue;
			
			for(int d=100; d<1000; d++)
			{
				
				int[] den = new int[3];
				
				if(d<=n)
					continue;
				
				den[0] = (d/100);
				den[1] = (d/10)%10;
				den[2] = d%10;
				
				if(den[1] == 0 || den[2] == 0
						|| den[0] == den[1]
						|| den[0] == den[2]
						|| den[1] == den[2])
					continue;
				
				int flag = 0;
				
				for(int count=0; count<3; count++)
				{
					for(int count2=0; count2<3; count2++)
					{
						if(num[count] == den[count2])
						{
							double value1, value2;
							int new_n=0, new_d=0;
							value1 = (double) n / (double) d;
							for(int count3=0; count3<3; count3++)
							{
								if(count3 != count)
								{
									new_n*=10;
									new_n+=num[count3];
								}
								if(count3 != count2)
								{
									new_d*=10;
									new_d+=den[count3];
								}
							}
							value2 = (double) new_n / (double) new_d;
							
							if(value1 == value2)
							{
								System.out.println(n + "/" + d + " ");
								flag = 1;
								break;
							}
								
						}
						if(flag == 1)
							break;
					}
				}
			}
		}
		
		System.out.println("]");

	}

}
