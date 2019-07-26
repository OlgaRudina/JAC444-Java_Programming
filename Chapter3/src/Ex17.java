import java.util.Scanner;

//3.22

public class Ex17 {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		double x, y, distance;
		
		System.out.println("Enter a point with two coordinates: ");
		
		x = input.nextDouble();
		y = input.nextDouble();
		distance = Math.sqrt(Math.pow(x,2) + Math.pow(y,2));
		
		if(distance <= 10) {
			
			System.out.println("Point " + "(" + x + ", " + y + ") " + "is in the circle");
		}
		
		else
		{
			System.out.println("Point " + "(" + x + ", " + y + ") " + "is not in the circle");
		}

	}

}
