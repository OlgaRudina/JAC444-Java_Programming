import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Ex12 {

	public static void main(String[] args) {
		
		DecimalFormat numberFormat = new DecimalFormat("#.####");
    	numberFormat.setRoundingMode(RoundingMode.CEILING);
    	
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		float weight, height;
		double BMI;
		
		System.out.println("Enter weight in pounds: ");
		weight = input.nextFloat();
		weight *= 0.45359237; 

		System.out.println("Enter height in inches: ");
		height = input.nextFloat();
		height *= 0.0254;
		
		BMI = weight / Math.pow(height, 2);
		System.out.println("BMI is " + numberFormat.format(BMI));
	}

}
