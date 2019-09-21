import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Ex17 {

	public static void main(String[] args) {

		DecimalFormat numberFormat = new DecimalFormat("#.#");
    	numberFormat.setRoundingMode(RoundingMode.CEILING);
    	
		float x1, x2, x3, y1, y2, y3;

		double s1, s2, s3, S, area;

		Scanner input = new Scanner(System.in);

		System.out.println("Enter three points for a triangle: ");
		
		x1 = input.nextFloat();
		y1 = input.nextFloat();
		x2 = input.nextFloat();
		y2 = input.nextFloat();
		x3 = input.nextFloat();
		y3 = input.nextFloat();
		
		//Calculate sides of triangle using coordinates
		
		s1 = Math.sqrt((Math.pow((x2 - x1), 2)) + (Math.pow((y2 - y1), 2)));
		s2 = Math.sqrt((Math.pow((x3 - x2), 2)) + (Math.pow((y3 - y2), 2)));
		s3 = Math.sqrt((Math.pow((x1 - x3), 2)) + (Math.pow((y1 - y3), 2)));
		
		S = (s1 + s2 + s3) / 2;
		
		area = Math.sqrt(S * ((S - s1) * (S - s2) * (S - s3)));
		
	
		System.out.println("The area of the triangle is " + numberFormat.format(area));
		input.close();

	}

}
