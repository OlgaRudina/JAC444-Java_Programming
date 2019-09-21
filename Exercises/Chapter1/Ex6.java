
public class Ex6 {
	
	static double distance;
	static double time;
	static double avg;

	public static void main(String[] args) {
		// calculate distance in miles;
		
		distance = 14.0 * 0.6;
		
		//calculate time in min
		
		time = (45 * 60 + 30) / 60;
		
		avg = (distance / (time / 60));
		
		System.out.println(avg);
	
	}

}
