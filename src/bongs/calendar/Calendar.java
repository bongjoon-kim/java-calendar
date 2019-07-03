package bongs.calendar;

public class Calendar {
	
	public static final int[] MAXDAY_OF_MONTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	public static final int[] LEAF_MAXDAY_OF_MONTH = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public void printCalendar(int year, int month) {
		
		System.out.printf("    <<%4d년%3d월>>\n", year, month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println("---------------------");
		
		for (int i = 1; i <= getMaxdayOfMonth(year, month); i++) {
			
			System.out.printf("%3d", i);
			
			if (i % 7 == 0) {
				System.out.println();
			}
		}
		System.out.println();
	}
	
	public int getMaxdayOfMonth(int year, int month) {
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			return LEAF_MAXDAY_OF_MONTH[month - 1];
		} else {
			return MAXDAY_OF_MONTH[month - 1];
		}
	}

}
