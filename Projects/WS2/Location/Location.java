import java.util.Scanner;
import java.math.RoundingMode;
import java.text.DecimalFormat;


public class Location {
	
	public static int rows, col;
	public static double maxValue = 0;
	
	public static void main(String[] args) {
		
		DecimalFormat numberFormat = new DecimalFormat("#");
    	numberFormat.setRoundingMode(RoundingMode.CEILING);

		
		System.out.println("Enter number of rows and columns in the array: ");
		
		Scanner input = new Scanner(System.in);
		rows = input.nextInt();
		col = input.nextInt();
		

		double [][] arr = new double[rows][col]; 
		
		System.out.println("Enter the array: ");
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < col; j++) {
				
				arr[i][j] = input.nextDouble();
			}
		}
		
		 double[] largest = new double[3];
		 largest = locateLargest(arr);
         System.out.println("The location of the largest element is " + numberFormat.format(largest[2]) + " at "+ "("+ numberFormat.format(largest[0]) +", " + numberFormat.format(largest[1]) + ")");
         
         input.close();
	}
	
	public static double[] locateLargest(double[][] a)
	{
		//double[] largest = new double[3];
		int maxRow = 0;
        int maxCol = 0;
        
        double maxVal = a[0][0];

        for (int i = 0; i < a.length; i++)
        {
                for (int j = 0; j < a[i].length; j++)
                {
                        if (a[i][j] > maxVal)
                        {
                        	 maxRow = i;
                             maxCol = j;
                             maxVal = a[i][j];
                        }
                }
        }

        return new double[]{maxRow,maxCol,maxVal};

}}
