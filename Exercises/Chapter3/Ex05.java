import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

//Task 3.6

public class Ex05 {

	public static void main(String[] args) {
		DecimalFormat numberFormat = new DecimalFormat("#.####");
    	numberFormat.setRoundingMode(RoundingMode.CEILING);
    	
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		float weight, feet, inches;
		double height;
		double BMI;
		
		System.out.println("Enter weight in pounds: ");
		weight = input.nextFloat();
		weight *= 0.45359237; 

		System.out.println("Enter feet: ");
		feet = input.nextFloat();
		
		System.out.println("Enter inches: ");
		inches = input.nextFloat();
		
		
		height = (feet*12 + inches) * 0.0254;
		
		BMI = weight / Math.pow(height, 2);
		
		System.out.println("BMI is " + numberFormat.format(BMI));
		
		if (BMI < 18.5)
		System.out.println("Underweight");
		else if (BMI < 25)
		System.out.println("Normal");
		else if (BMI < 30)
		System.out.println("Overweight");
		else
		System.out.println("Obese");

	}

}
