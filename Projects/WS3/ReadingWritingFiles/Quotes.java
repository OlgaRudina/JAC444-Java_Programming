import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;

public class Quotes {
	
	
	public static void main(String[] args) throws IOException{
		// preparing input file
		
		
		Scanner user = new Scanner( System.in ); 
	    String  inputFileName;
	    
	    System.out.println("Enter a filename > ");
	    
	    inputFileName = user.nextLine().trim();
	    if(!inputFileName.endsWith(".txt")) {
	    	
	    	inputFileName = inputFileName + ".txt";
	    }
	    
	    File input = new File(inputFileName);      
	    Scanner scan = new Scanner(input).useDelimiter(",\\s*");
	    
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

	   // for (String s : tempsArray) {
	    //  System.out.println(s);
	   // }
	    
	    StringBuilder builder = new StringBuilder();
	    
	    for(String s : tempsArray) {
	        builder.append(s);
	    }
	    
	    String str = builder.toString();
	    //System.out.println(str);
	    

	    int [] arr = new int [26];
	    
	    for (char c :str.toUpperCase().toCharArray()){
	        if ((c >= 'A') && (c <= 'Z')) {
	            arr[c - 'A']++;
	        }
	    }
	    for (int i = 0 ; i < 26 ; i++) {
	        if (arr[i] != 0) {
	            System.out.print("Number of " + (char)('A' + i) + "'s");
	            System.out.print(" : ");
	            System.out.println(arr[i]);
	        }
	    }

}
}