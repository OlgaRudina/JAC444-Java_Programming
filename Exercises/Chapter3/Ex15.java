import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Ex15 {

	public static void main(String[] args) {
		
		DecimalFormat numberFormat = new DecimalFormat("#.#####");
    	numberFormat.setRoundingMode(RoundingMode.FLOOR);
    	
		float t, speed;
		double wcIndex;

		Scanner input = new Scanner(System.in);

		System.out.println("Enter the temperature in Fahrenheit between -58°F and 41°F: ");

		t = input.nextFloat();
		
		System.out.println("Enter the wind speed (>=2) in miles per hour: ");
		
		speed = input.nextFloat();
		
		if(t < 41 && t > -58 && speed >= 2) {
			
			wcIndex = 35.74 + (0.6215 * t) - (35.75 * Math.pow(speed, 0.16)) + (0.4275 * t * Math.pow(speed, 0.16));
			System.out.println("The wind chill index is " + numberFormat.format(wcIndex));
		}

		else {
			
			System.out.println("Invalid input");
		}
		
		
		input.close();
	}

}

