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

		while (t > 41 || t < -58) {

			System.out.println("The temperature must be between -58°F and 41°F");
			System.out.println("Enter the temperature in Fahrenheit between -58°F and 41°F: ");
			t = input.nextFloat();
		}

		System.out.println("Enter the wind speed (>=2) in miles per hour: ");
		speed = input.nextFloat();
		
		while (speed < 2) {

			System.out.println("The speed must be greater or equal to 2");
			System.out.println("Enter the wind speed (>=2) in miles per hour: ");
			speed = input.nextFloat();
		}
		
		wcIndex = 35.74 + (0.6215 * t) - (35.75 * Math.pow(speed, 0.16)) + (0.4275 * t * Math.pow(speed, 0.16));
		System.out.println("The wind chill index is " + numberFormat.format(wcIndex));
		input.close();
	}

}
