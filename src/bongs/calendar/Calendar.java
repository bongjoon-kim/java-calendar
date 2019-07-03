package bongs.calendar;

public class Calendar {
	
	public static final int[] MAXDAY_OF_MONTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	public static final int[] LEAF_MAXDAY_OF_MONTH = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public void printCalendar(int year, int month, String weekday) {
		
		int week = getWeekday(weekday);
		
		System.out.printf("    <<%4d년%3d월>>\n", year, month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println("---------------------");

		for (int i = 0; i < week; i++) {
			System.out.print("   ");
		}
		
		for (int i = 1; i <= getMaxdayOfMonth(year, month); i++) {
			System.out.printf("%3d", i);
			if ((i + week) % 7 == 0) {
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
	
	public int getWeekday (String weekday) {
		if (weekday.equals("sun"))	return 0;
		else if (weekday.equals("mon"))	return 1;
		else if (weekday.equals("tue"))	return 2;
		else if (weekday.equals("wed"))	return 3;
		else if (weekday.equals("thu"))	return 4;
		else if (weekday.equals("fri"))	return 5;
		else if (weekday.equals("sat"))	return 6;
		else return 0;
	}

}
