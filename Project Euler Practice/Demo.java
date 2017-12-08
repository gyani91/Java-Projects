
public class Demo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*Problem3 trial = new Problem3();
		
		trial.factor(600851475143L);
		trial.displayList();*/
		
		long[] input = new long[20];
		for(int i=0;i<20;i++)
			input[i]=i+1;
		
		System.out.println(Problem5.lcm(input));
		
	}

}
