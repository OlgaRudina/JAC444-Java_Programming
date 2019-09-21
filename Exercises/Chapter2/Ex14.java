import java.util.Scanner;

public class Ex14 {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);

		float s;
		double area;

		System.out.println("Enter the side: ");
		
		s = input.nextFloat();
		area = ((3 * Math.sqrt(3)) / 2) * Math.pow(s, 2);
		
		System.out.println("The area of the hexagon is " + area);
	}

}
