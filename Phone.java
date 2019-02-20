import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Phone {

	// ---------------------------------------------------METHODS---------------------------------------------------//
	public static ArrayList<String> Permutations(String str) { //counts all permutations for a single chunk of characters
		
	    ArrayList<String> perms = new ArrayList<>();
	    if (str.length() == 1) {
	        perms.add(str);
	    } else {
	        String chr = str.substring(0,1);
	        String rest = str.substring(1);
	        ArrayList<String> subPerms = Permutations(rest);
	        for (String s : subPerms) {
	            for (int j = 0; j <= s.length(); j++) {
	                String newPerm = s.substring(0,j) + chr + s.substring(j);
	                perms.add(newPerm);
	            }
	        }
	    }
	    return perms;
	}

	
	public static String[] readFromFile(String filename) throws FileNotFoundException { //read from file function

		// read all combinations from created file

		Scanner inFile = new Scanner(new File(filename)); // read from file.
		String token = "";
		List<String> temps = new ArrayList<String>();

		while (inFile.hasNext()) {
			// find next line
			token = inFile.next();
			temps.add(token);
		}

		inFile.close();

		String[] tempsArray = temps.toArray(new String[temps.size()]);

		StringBuilder builder = new StringBuilder();

		for (String s : tempsArray) {
			builder.append(s);

			// System.out.println(s);
		}

		return tempsArray;
	}

	public static List<String> letterCombinations(String digits) {  //create letter combinations for one phone number
		HashMap<Character, char[]> dict = new HashMap<Character, char[]>();
		dict.put('0', new char[] { ' ', ' ', ' ' });
		dict.put('1', new char[] { ' ', ' ', ' ' });
		dict.put('2', new char[] { 'a', 'b', 'c' });
		dict.put('3', new char[] { 'd', 'e', 'f' });
		dict.put('4', new char[] { 'g', 'h', 'i' });
		dict.put('5', new char[] { 'j', 'k', 'l' });
		dict.put('6', new char[] { 'm', 'n', 'o' });
		dict.put('7', new char[] { 'p', 'r', 's' });
		dict.put('8', new char[] { 't', 'u', 'v' });
		dict.put('9', new char[] { 'w', 'x', 'y' });

		List<String> result = new ArrayList<String>();
		if (digits == null || digits.length() == 0) {
			return result;
		}

		char[] arr = new char[digits.length()];
		helper(digits, 0, dict, result, arr);

		return result;
	}

	// helper function
	private static void helper(String digits, int index, HashMap<Character, char[]> dict, List<String> result, //recursive function to get all letter combinations
			char[] arr) {
		if (index == digits.length()) {
			result.add(new String(arr));
			return;
		}

		char number = digits.charAt(index);
		char[] candidates = dict.get(number);
		for (int i = 0; i < candidates.length; i++) {
			arr[index] = candidates[i];
			helper(digits, index + 1, dict, result, arr);
		}
	}



	public static boolean isValid(String number) { 	// check if the phone number is VALID

		boolean isValid = true;

		for (int i = 0; i < number.length(); i++) {

			if (number.charAt(i) == '1' || number.charAt(i) == '0' || number.length() != 7) {


				isValid = false;

			}

		}
		
		if(isValid == false) {
			
			System.out.println("No 0 or 1 allowed. Number must contain 7 digits without spaces or non-digit charachers");
		}
		return isValid;
	}

}
