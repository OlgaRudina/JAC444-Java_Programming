import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

//Task 2.23

public class Ex21 {

	public static void main(String[] args) {
		
		DecimalFormat numberFormat = new DecimalFormat("#.##");
    	numberFormat.setRoundingMode(RoundingMode.FLOOR);
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		double distance, mPerGallon, pPerGallon, costOfDriving;
		
		System.out.println("Enter the driving distance: ");
		
		distance = input.nextDouble();
		
		System.out.println("Enter miles per gallon: ");
		
		mPerGallon = input.nextDouble();
		
		System.out.println("Enter price per gallon: ");
		
		pPerGallon = input.nextDouble();
		
		costOfDriving = (distance / mPerGallon) * pPerGallon;
		
		System.out.println("The cost of driving is $" + numberFormat.format(costOfDriving));

	}

}
