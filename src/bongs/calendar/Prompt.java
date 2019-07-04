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
		
		while (true) {
			System.out.println("년도를 입력하세요.");
			System.out.print("YEAR > ");
			year = sc.nextInt();
			
			if (year == -1) {
				break;
			}			
			
			System.out.println("월을 입력하세요.");
			System.out.print("MONTH > ");
			month = sc.nextInt();
			
			if (month == -1) {
				break;
			}
			
			if (month < 1 || month > 12) {
				System.out.println("잘못된 입력입니다.");
				continue;
			}					
			
			cal.printCalendar(year, month);
		}
		
		System.out.println("Bye~");
		
		sc.close();
	}

}
