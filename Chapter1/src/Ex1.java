
public class Ex1 {

	public static void main(String[] args) {
		
		/*
		  1.4 (Print a table) Write a program that displays the following table:
		a a^2 a^3
		1 1 1
		2 4 8
		3 9 27
		4 16 64
		 */

		int j = 1;
		System.out.println("Task 1.4");
		System.out.println("a\ta^2\ta^3");
		//System.out.println("");
		for(int i = 0; i < 4; i ++) {
			System.out.print(j + "\t");
			System.out.print(Math.round(Math.pow(j, 2)) + "\t");
			System.out.println(Math.round(Math.pow(j, 3)));
		j++;

	}

}
	
	
	}



