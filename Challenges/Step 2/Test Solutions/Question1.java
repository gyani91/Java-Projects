

/*
 * Mine Keeper game
 * you can travel only the number of steps written in that box
 * either left or either right
 * return if its zero
 * 
 * input:
 * n p-sequence
 * 
 * where n = side of square grid
 * and p is sequence of data separated by space
 * 
 * output:
 * [o]
 * 
 * where o is number of solutions
 * 
 * test cases:
 * 
 * 4 2331 1213 1231 3110
 * 4 3332 1213 1232 2120
 * 5 11101 01111 11111 11101 11101
 *
 */
public class Question1
{
	static int solutions;
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		solutions = 0;
		int n = Integer.parseInt(args[0]);
		char[][] data = new char[n][n];
		int[][] field = new int[n][n];
		
		for(int count=0; count<n; count++)
		{
			data[count] = args[count+1].toCharArray();
		}
		
		for(int count=0; count<n; count++)
			for(int count2=0; count2<n; count2++)
				field[count][count2] = Integer.parseInt(String.valueOf(data[count][count2]));
		
		/*for(int count=0; count<n; count++)
			for(int count2=0; count2<n; count2++)
				System.out.println(field[count][count2]);
		*/
		
		traverse(field, 0, 0, n);
		System.out.println("[" + solutions + "]");
	}
	
	
	public static void traverse(int[][] field,int currentx,int currenty, int n)
	{
		if(currentx == n-1 && currenty == n-1)
		{
			solutions++;
			return;
		}
		
		if(field[currentx][currenty] == 0)
			return;
		
		if(currentx+field[currentx][currenty]<n)
			traverse(field, currentx+field[currentx][currenty], currenty, n);
		
		
		if(currenty+field[currentx][currenty]<n)
			traverse(field, currentx, currenty+field[currentx][currenty], n);
		
	}

}
