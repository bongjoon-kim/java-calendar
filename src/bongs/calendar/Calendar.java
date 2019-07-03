package bongs.calendar;

import java.util.Scanner;

public class Calendar {
	
	public static final int[] MAXDAY_OF_MONTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};		
	
	public void sampleCalendar() {
		System.out.println("SU MO TU WE TH FR SA");
		System.out.println("--------------------");
		System.out.println("01 02 03 04 05 06 07");
		System.out.println("08 09 10 11 12 13 14");
		System.out.println("15 16 17 18 19 20 21");
		System.out.println("22 23 24 25 26 27 28");		
	}
	
	public int getMaxdayOfMonth(int month) {
		return MAXDAY_OF_MONTH[month - 1];
	}

	public static void main(String[] args) {

		// 숫자를 입력받아 해당하는 달의 최대일수를 출력하는 프로그램
		System.out.println("1~12를 입력하세요.");
		Scanner sc = new Scanner(System.in);
		int month = sc.nextInt();
		sc.close();

		Calendar cal = new Calendar();
		System.out.printf("%d월의 마지막 날은 %d일 입니다.\n\n", month, cal.getMaxdayOfMonth(month));
		
		cal.sampleCalendar();
	}

}
