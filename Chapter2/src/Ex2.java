import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;

public class Ex2 {
	
	final static double PI = 3.14159;

	public static void main(String[] args) {
		DecimalFormat numberFormat = new DecimalFormat("#.##");
    	numberFormat.setRoundingMode(RoundingMode.CEILING);
    	
		float area, radius, length, volume;
		
		System.out.println("Enter the radius and length of a cylinder: ");
		
		Scanner input = new Scanner(System.in);
		
		
		radius = input.nextFloat();
		length = input.nextFloat();
		area = (float) (radius * radius * PI);
		volume = area * length;
		System.out.println("The area is " + area);
		System.out.println("The volume is " + numberFormat.format(volume));
		input.close();
	}

}
