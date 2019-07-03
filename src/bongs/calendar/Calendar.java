package bongs.calendar;

import java.util.Scanner;

public class Calendar {
	
	public static final int[] MAXDAY_OF_MONTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};		
	
	public void sampleCalendar(int maxDayOfMonth) {
		System.out.println("SU MO TU WE TH FR SA");
		System.out.println("--------------------");
		
		for (int i = 1; i <= maxDayOfMonth; i++) {
			if (i < 10) {
				System.out.print(" 0" + i);
			} else {
				System.out.print(" " + i);
			}
			
			if (i % 7 == 0) {
				System.out.println();
			}
		}
		System.out.println();
	}
	
	public int getMaxdayOfMonth(int month) {
		return MAXDAY_OF_MONTH[month - 1];
	}

	/*
	* 월을 입력하면 해당월의 달력을 출력한다.
	* 달력의 모양은 1단계에서 작성한 모양으로 만든다.
	* 1일은 일요일로 정해도 무방하다.
	* -1을 입력받기 전까지 반복 입력받는다.
	* 프롬프트를 출력한다.
	*/
	public static void main(String[] args) {

		// 숫자를 입력받아 해당하는 달의 최대일수를 출력하는 프로그램
		Scanner sc = new Scanner(System.in);
		Calendar cal = new Calendar();
		
		while (true) {
			System.out.println("월을 입력하세요.");
			System.out.print("cal> ");
			int month = sc.nextInt();
			
			if (month == -1) {
				break;
			}
			
			if (month < 1 || month > 12) {
				continue;
			}			
				
			cal.sampleCalendar(cal.getMaxdayOfMonth(month));
		}
		
		System.out.println("Bye~");
		
		sc.close();
	}

}
