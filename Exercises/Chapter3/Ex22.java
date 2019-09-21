import java.util.Scanner;

public class Ex22 {

	public static void main(String[] args) {
		
		// points (0,0), (200,0), (0,100);
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);

		System.out.println("Enter a point's x- and y-coordinates: ");
		
		float x, y, s;
		
		x = input.nextFloat();
		y = input.nextFloat();
		s = 200 * (y - 100) - x * (0 - 100);
		
		System.out.print("The point is" + ((s > 0) || (x < 0) || (y < 0) ? " not" : "") + " in the triangle");

		
	}

}
