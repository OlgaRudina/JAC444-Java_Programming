import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Ex11 {

	public static void main(String[] args) {
		DecimalFormat numberFormat = new DecimalFormat("#.##");
    	numberFormat.setRoundingMode(RoundingMode.FLOOR);
    	
        @SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		double intRate = (1 + (0.05/12));
		double savings;
		double monthly;
		
		System.out.println("Enter the monthly saving amount: ");
		
		savings = input.nextDouble(); //100
		
		monthly = savings * intRate;
		
		for (int i = 0; i < 5; i++) {
			
			monthly = (savings + monthly) * intRate;
			
		}
		
		System.out.println("After the sixth month, the account value is $" + numberFormat.format(monthly));
	}

}
