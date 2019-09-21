
import java.util.*;

public class Ex3 {

	public static void main(String[] args) {
		
		float feet;
		double meters;
		
		System.out.println("Enter a value for feet: ");
		Scanner input = new Scanner(System.in);
		
		feet = input.nextFloat();
		meters = feet * 0.305;
		
		System.out.println(feet + " feet is " + meters + " meters");
		input.close();

	}

}
