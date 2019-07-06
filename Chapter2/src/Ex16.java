
public class Ex16 {

	public static void main(String[] args) {
		
		int b = 2;
		
		System.out.println("Task 2.18");
		System.out.println("a\tb\tpow(a, b)");

		for(int a = 1; a < 6; a ++, b++) {
			System.out.print(a + "\t");
			System.out.print(b + "\t");
			System.out.println(Math.round(Math.pow(a, b)));
			
	}

}
}
