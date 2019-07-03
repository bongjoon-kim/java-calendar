package bongs.calendar;

import java.util.Scanner;

public class Prompt {

	public static final String PROMPT = "cal> ";
	
	public static void main(String[] args) {

		// 숫자를 입력받아 해당하는 달의 최대일수를 출력하는 프로그램
		Scanner sc = new Scanner(System.in);
		Calendar cal = new Calendar();
		
		int year = -1;
		int month = -1;
		String weekday = "sun";
		
		while (true) {
			System.out.println("년도를 입력하세요.");
			System.out.print("YEAR > ");
			year = sc.nextInt();
			
			System.out.println("월을 입력하세요.");
			System.out.print("MONTH > ");
			month = sc.nextInt();
			
			System.out.println("요일을 입력하세요.(sun, mon, tue, wed, thu, fri, sat)");
			System.out.print("Weekday > ");
			weekday = sc.next();			
			
			if (month == -1) {
				break;
			}
			
			if (month < 1 || month > 12) {
				continue;
			}			
				
			cal.printCalendar(year, month, weekday);
		}
		
		System.out.println("Bye~");
		
		sc.close();
	}

}
