import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

//Task 3.1

public class Ex01 {

	public static void main(String[] args) {
		
		DecimalFormat numberFormat = new DecimalFormat("#.######");
    	numberFormat.setRoundingMode(RoundingMode.FLOOR);
    	
		System.out.println("Enter a, b, c: ");
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		double a, b, c, r1, r2;
		
		a = input.nextDouble();
		b = input.nextDouble();
		c = input.nextDouble();
		
		if((Math.pow(b, 2) - (4 * a *c)) > 0) {
			
			r1 = (-b + (Math.sqrt((Math.pow(b, 2) - (4 * a *c))))) / (2 *a);
			r2 = (-b - (Math.sqrt((Math.pow(b, 2) - (4 * a *c))))) / (2 *a);
			
			System.out.println("The equation has two roots " + numberFormat.format(r1) + " and " + numberFormat.format(r2));
		}
		
		else if ((Math.pow(b, 2) - (4 * a *c)) == 0) {
			
			r1 = - b / (2 * a);
			System.out.println("The equation has one root " + (int)r1 );
		}
		
		else {
			
			System.out.println("The equation has no real roots");
		}

	}

}
