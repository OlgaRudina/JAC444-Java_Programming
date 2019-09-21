
import java.util.Scanner;

public class Ex08 {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		
		Scanner input = new Scanner(System.in);

		int number, remainingNumber, lastDigit, checkSum;

		int[] intArray = new int[9];

		System.out.println("Enter the first 9 digits of an ISBN as integer: ");

		number = input.nextInt();

		remainingNumber = number;

		for (int i = 8; i >= 0; i--) {
			lastDigit = remainingNumber % 10;
			remainingNumber = remainingNumber / 10;
			intArray[i] = lastDigit;

		}
		
		checkSum = (intArray[0] * 1 + intArray[1] * 2 + intArray[2] * 3 + intArray[3] * 4 + intArray[4] * 5 + 
				intArray[5] * 6 + intArray[6] * 7 + intArray[7] * 8 + intArray[8] * 9) % 11;
		
		if(checkSum == 10) {
			System.out.println("The ISBN-10 number is " + number + "X");
		}
		
		else {
			System.out.println("The ISBN-10 number is " + number + checkSum);
		}

	}

}
