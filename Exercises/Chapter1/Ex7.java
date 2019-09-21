
public class Ex7 {
	
	static int curpop = 312032486;
	static double birth;
	static double death;
	static double immigrants;

	public static void main(String[] args) {
		
		//birth per day (every 7 sec)
		
		int year = 365 * 24 * 60 * 60; //seconds in 1 year
		
		birth = year / 7.0;
		
		System.out.println(birth);
		
		//death per day (every 13 sec)
		
		death = year / 13.0;
		
		System.out.println(death);
		
		//immigrants per day (every 45 sec)
		
		immigrants = year / 45.0;
		
		System.out.println(immigrants);
		
		double popInyear = birth - death + immigrants;
		
		System.out.println(curpop + (int)(popInyear));
		System.out.println(curpop + (int)(2 * popInyear));
		System.out.println(curpop + (int)(3 * popInyear));
		System.out.println(curpop + (int)(4 * popInyear));
		System.out.println(curpop + (int)(5 * popInyear));

	}

}
