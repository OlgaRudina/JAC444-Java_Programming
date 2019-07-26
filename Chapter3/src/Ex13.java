import java.util.Scanner;

//Task *3.18

public class Ex13 {

	public static void main(String[] args) {
		
		System.out.print("Enter the weight of a package (in pounds): ");
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);

		float weight;

		weight = input.nextFloat();

		if (weight <= 20 && weight > 0) {

			System.out.print("The cost of shipping is ");

			if (weight <= 1) {

				System.out.print(" $3.5");

			}

			else if (weight > 1 && weight <= 3) {

				System.out.print(" $5.5");
			}

			else if (weight > 3 && weight <= 10) {

				System.out.print(" $8.5");
			}

			else if (weight > 10) {

				System.out.print(" $10.5");
			}

		}

		else {
			System.out.print("The package cannot be shipped.");
		}

	}

}
