import java.util.Scanner;

public class Ex10 {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);

		int number, last_digit, temp;
		
		int [] arr = new int [3];

		System.out.println("Enter a three-digit integer: ");
		
		number = input.nextInt();
		temp = number;
		
		for(int i = 0; i < 3; i++) {
			
			last_digit = temp%10;
			temp /= 10;
			arr[i] = last_digit;
		}
		
		if(arr[0] == arr[2]) {
			
			System.out.println(number + " is a palindrome");
		}
		
		else {
			System.out.println(number + " is not a palindrome");
		}
		

	}

}
