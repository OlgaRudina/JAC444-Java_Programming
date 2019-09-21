//Task 2.20
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Ex18 {

	public static void main(String[] args) {
		
		DecimalFormat numberFormat = new DecimalFormat("#.#####");
    	numberFormat.setRoundingMode(RoundingMode.CEILING);
    	
		float balance, intRate;
		float interest;
		
		System.out.println("Enter balance and interest rate (e.g., 3 for 3%): ");
		Scanner input = new Scanner(System.in);
		
		balance = input.nextFloat();
		intRate = input.nextFloat();
		
		interest = balance * (intRate / 1200);
		
		System.out.println("The interest is " + numberFormat.format(interest));
		input.close();
	}

}
