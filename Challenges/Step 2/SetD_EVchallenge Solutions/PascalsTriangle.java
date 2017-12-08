import java.text.DecimalFormat;


public class PascalsTriangle
{
	public String logic(int row)
	{
		if(row<4)
			return "[0.0]";
		
		double[][] data = new double[row+1][row+1];
		double result = 0.0;
		
		data[0][0] = 1.0;
		data[1][0] = 1.0;
		data[1][1] = 1.0;
		
		for(int x = 2; x<=row; x++)
		{
			data[x][0] = data[x-1][0];
			int y = 2;
			for(; y<=x; y++)
			{
				data[x][y-1] = data[x-1][y-2] + data[x-1][y-1];
			}
			data[x][y-1] = data[x-1][y-2];
		}
		
		/*for(int x = 0; x<=row; x++)
		{
			for(int y = 0; y<=x; y++)
				System.out.print(data[x][y]);
			System.out.println("");
		}*/
		
		for(int x = 4; x<=row; x++)
			for(int y=2; y<=x-2; y++)
				result+=(1/data[x][y]);
		
		DecimalFormat df = new DecimalFormat("0.0");
		
		return "[" + df.format(result) + "]";
		
	}
}
