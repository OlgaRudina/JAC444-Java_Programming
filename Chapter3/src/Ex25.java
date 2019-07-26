// 3.33

import java.util.Scanner;

public class Ex25 {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);

		float price1, price2, weight1, weight2, pw1, pw2;

		System.out.print("Enter weight and price for package 1: ");

		price1 = input.nextFloat();
		weight1 = input.nextFloat();

		System.out.print("Enter weight and price for package 2: ");

		price2 = input.nextFloat();
		weight2 = input.nextFloat();

		pw1 = weight1 / price1;
		pw2 = weight2 / price2;

		if (pw1 == pw2) {

			System.out.print("Two packages have the same price.");
		}

		else if (pw1 > pw2) {

			System.out.print("Package 2 has a better price.");
		}
		
		else {
			
			System.out.print("Package 1 has a better price.");
			
		}
	}

}
