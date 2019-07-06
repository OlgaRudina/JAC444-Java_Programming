import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Ex10 {

	public static void main(String[] args) {
		DecimalFormat numberFormat = new DecimalFormat("#.###");
    	numberFormat.setRoundingMode(RoundingMode.CEILING);
    	
		Scanner input = new Scanner(System.in);
		
		double a, v, length;
		
		System.out.println("Enter speed and acceleration: ");
		v = input.nextDouble();
		a = input.nextDouble();
		
		length = Math.pow(v, 2) / (2 * a);
		
		System.out.println("The minimum runway length for this airplane is " + numberFormat.format(length));
		input.close();

	}

}
