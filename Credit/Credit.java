// 4388576018402626 - INVALID

//4388576018410707 - VALID


	import java.util.Scanner;

	public class Credit {
		
		static String card;
	

		public static void main(String[] args) {

			System.out.println("Enter a credit card number as long integer: ");
			Scanner input = new Scanner(System.in);
			card = input.next();
	        isValid(card);
			
			input.close();

		}
		
	public static boolean isValid(String card) { //Return true if the card number is valid
			
			Boolean TF=false;
			Step2(Step1(card));
			SingleSumm(Step2(Step1(card)));
			OddSumm(Step1(card));
			WholeSumm(card);
			
			if(isPrefix(card)==true&&isDiv(WholeSumm(card))==true) {
				System.out.println(card + " is valid");
				TF=true;
			}
			
			else {
				
				System.out.println(card + " is invalid");
				TF = false;
			}
			
			
			return TF;
		}

		public static int[] Step1(String card) 
		{
			int[] result = new int[card.length()];
			char[] card_new = card.toCharArray();
		
			for (int i = 0; i < card.length(); i++) { // create integer array with digits

				int digit = (int) card_new[i] - (int) '0';

				result[i] *= 10;
				result[i] += digit;

			}

			return result;

		}

		public static int[] Step2(int[] arr) {
			int counter = 0;

			for (int k = arr.length - 2; k >= 0; k = k - 2) {

				counter++;
			}

			int[] f_result = new int[counter];

			
			for (int j = arr.length - 2; j >= 0; j = j - 2) { // double every second digit in array. If the result is 2
																// digits sum these digits

				arr[j] *= 2;
				arr[j] = arr[j];

				if (arr[j] > 9) {

					for (int k = 0; k < 2; k++) {

						arr[j] = ((arr[j] / 10) % 10) + ((arr[j] / 1) % 10);
						arr[j] = arr[j];

					}

				}

			}

			int count = 0;
			while (count != f_result.length) {
				for (int j = arr.length - 2; j >= 0; j = j - 2) {

					f_result[count] = arr[j];
					count++;
				}
			}
			return f_result; // return modified array of digits

		}

		public static int SingleSumm(int[] arr) { //calculates sum of all single digits in modified array

			int singleSum = 0;

			for (int i = 0; i < arr.length; i++) {

				singleSum += arr[i];

			}

			return singleSum;

		}

		public static int OddSumm(int[] arr) { //calculates sum of digits on odd positions
			
			
			int oddSumm = 0;
			
		    for (int j = arr.length - 1; j >= 0; j = j - 2) {

		    	oddSumm  += arr[j];
				}

			return oddSumm;

		}
		
		
	public static int WholeSumm(String arr) { 
			
		int Summ = (SingleSumm(Step2(Step1(arr)))) + OddSumm(Step1(arr));
		return Summ;

		}


	public static boolean isPrefix(String arr) { //validation of prefix
		
		Boolean TF = false;
		
		if(Step1(arr)[0] == 4 || Step1(arr)[0] == 6 || Step1(arr)[0] == 5 || (Step1(arr)[0] == 3&&Step1(arr)[1] == 7)) {
			
			TF = true;
		}
		
		return TF;
		
		}

	public static int DigitsNum(String card) {  //Return the number of digits

		
		int counter = 0;
		card.toCharArray();
		
		for(int i = 0; i < card.length(); i++) {
		
			counter++;
		
		}
		
		return counter;
		
	}

	public static boolean isDiv(int v) { //is divisible by 10 or not
		
		Boolean TF = false;
		
		if(v%10 == 0) {
			
			TF = true;
		}
		
		return TF;
		
		}
	}



	
