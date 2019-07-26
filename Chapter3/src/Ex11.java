import java.util.Random;


//Task 3.16


public class Ex11 {

	public static void main(String[] args) {

		int x,y;
		
		Random r = new Random();
		
		y = r.nextInt(100) - 50;
		x = r.nextInt(200) - 100;
		
		System.out.println("(" + x + "," + y + ")");
		
	}

}
