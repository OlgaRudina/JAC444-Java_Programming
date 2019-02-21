import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class TesterClass extends Phone{

	public static boolean YN(String message, Scanner scan) {

		System.out.println(message + "Enter 'Y' or 'N'");

		while (true) {

			String input = scan.nextLine().toLowerCase();
			if (input.equals("y") || input.equals("yes")) {
				return true;
			}

			else if (input.equals("n") || input.equals("no")) {

				return false;
			}

			else {

				System.out.println("Please, enter Y or N");
			}

		}
	}

	public static void main(String[] args) throws IOException {
		Scanner inp = new Scanner(System.in); //Combinations input
		Scanner input = new Scanner(System.in); // answer YN
		Scanner inputUser = new Scanner(System.in); // User inputs letters
		String token = "";
		Scanner user = new Scanner(System.in);

		// --------------------------------------------------------------HANGMAN GAME--------------------------------------------------------------//
		do{
	    	
		while (YN("Do you want to guess word?", input)) {


			@SuppressWarnings("resource")
			Scanner inFile = new Scanner(new File("hangman.txt")).useDelimiter(" "); // read from file. Using Scanner
																						// method because

			List<String> temps = new ArrayList<String>();

			// while loop
			while (inFile.hasNext()) {
				// find next line
				token = inFile.next();
				temps.add(token);
			}

			inFile.close();

			String[] words = temps.toArray(new String[temps.size()]);

			String word = words[(int) (Math.random() * words.length)]; // finds random index of the word in array

			String secret = new String(new char[word.length()]).replace("\0", "*"); // creates new string random word
																					// length and replaces it with *

			int counter = 0; // amount of mistakes

			while (secret.contains("*")) {

				System.out.println("(Guess) Enter a letter in word " + secret + " > ");

				String answer = inputUser.next();
				String newSecret = ""; // empty string that will contain answers

				for (int j = 0; j < word.length(); j++) {

					if (answer.charAt(0) == word.charAt(j)) { // if there is a matching letter in the word, add it to
																// empty string newSecret

						newSecret += answer.charAt(0);

					} else if (secret.charAt(j) != '*') {
						newSecret += word.charAt(j);

					} else {
						newSecret += "*";
					}

				}

				if (secret.equals(newSecret)) {

					System.out.println(answer + " is not in the word");

					counter++;

				} else {
					secret = newSecret;
				}

				if (secret.equals(word)) {

					System.out.println("The word is " + word + ". " + "You missed " + counter + " time(s)");
					counter = 0;
				}

			}

		} // hangman game end

		// --------------------------------------------------------------COUNT LETTERS--------------------------------------------------------------//

		while (YN("Do you want to count letters in a file?", input)) {

			String inputFileName;

			System.out.println("Enter a name of txt file > "); //user enters filename

			inputFileName = user.nextLine().trim();
			if (!inputFileName.endsWith(".txt")) { //if file doesn't end with extention add extention

				inputFileName = inputFileName + ".txt";
			}
			
			File in = new File(inputFileName); // read file
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(in).useDelimiter(",\\s*");

			String token1 = "";

			List<String> temps = new ArrayList<String>();

			// while loop
			while (scan.hasNext()) {
				// find next line
				token1 = scan.next();
				temps.add(token1);
			}
			scan.close();

			String[] tempsArray = temps.toArray(new String[temps.size()]);

			StringBuilder builder = new StringBuilder();

			for (String s : tempsArray) {
				builder.append(s);
			}

			String str = builder.toString();

			int[] arr = new int[26];

			for (char c : str.toUpperCase().toCharArray()) {
				if ((c >= 'A') && (c <= 'Z')) {
					arr[c - 'A']++;
				}
			}
			for (int i = 0; i < 26; i++) {
				if (arr[i] != 0) {
					System.out.print("Number of " + (char) ('A' + i) + "'s");
					System.out.print(" : ");
					System.out.println(arr[i]);
				}
			}

			scan.close(); // user file name
		} // end of counting letters
		
		// --------------------------------------------------------------COMBINATIONS--------------------------------------------------------------//

		while (YN("Do you want to find word combinations?", input)) {
			
		System.out.println("Enter a 7 digit phone");
		String phone = inp.next().trim();

		// the phone is not valid case

		while (!isValid(phone)) {
			System.out.println("Enter a 7 digit phone");
			phone = inp.next().trim();
		}

		// the phone is valid case

		if (isValid(phone)) {

			// write to file all possible letters combinations

			FileWriter writer = new FileWriter("phone.txt");
			ArrayList<String> arrData = new ArrayList<String>(letterCombinations(phone));

			int size = arrData.size();
			for (int i = 0; i < size; i++) {
				String str = arrData.get(i).toString();
				writer.write(str);
				writer.write(" ");
				if (i < size - 1) // This prevents creating a blank line at the end of the file
					writer.write("\n");
			}
			writer.close(); // end of writing

			String[] wordarray = readFromFile("dict.txt");
			ArrayList<String> candidates = new ArrayList<String>(); // creates list of 7 letter words

			for (String k : wordarray) { // add 7 letter words into the list from dictionary
				//System.out.println(k);
				if (k.length() == 7) {
					candidates.add(k);
				}

			}

			String [] anagrams = readFromFile("phone.txt");
			Set<String> res = new HashSet<String>();

			for (String m : anagrams) {
			//System.out.println(m);	
				res.addAll(Permutations(m));
					
				}
			
			ArrayList<String> allWords = new ArrayList<String>();
			for (String m : candidates) {
			
			if(res.contains(m)) {
				if(!allWords.contains(m)) {
				allWords.add(m);
				}
			}
			}
			
			for(String s : allWords) {
				
				System.out.println(s);	
			}
			}

		
		}

		 // end of valid phone case
		} while(!YN("Do you want to exit? ",input));
		
		// --------------------------------------------------------------CLOSE INPUTS--------------------------------------------------------------//
        
		inp.close(); //combinations input closed
		inputUser.close(); // user answer input closed
		input.close(); // YN input closed
		user.close(); // user file name input closed

		System.out.println("Bye!");
	}

}
