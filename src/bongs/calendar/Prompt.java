package bongs.calendar;

import java.util.Scanner;

public class Prompt {

	public static void main(String[] args) {

		// 숫자를 입력받아 해당하는 달의 최대일수를 출력하는 프로그램
		Scanner sc = new Scanner(System.in);
		Calendar cal = new Calendar();

		printMenu();

		String sel = "";
		
		Boolean isLoop = true;
		while (isLoop) {
			System.out.println("명령 (1, 2, 3, h, q)");
			sel = sc.next();
			
			switch (sel) {
				case "1":	savePlan(sc, cal);	break;
				case "2":	searchPlan(sc, cal);	break;
				case "3":	CalendarPrint(sc, cal);	break;
				case "h":	printMenu();	break;
				case "q":	isLoop = false;	break;
				default:	System.out.println("잘못된 입력입니다.");	break;
			}
		}

		System.out.println("Thank you. Bye~");
		sc.close();
	}

	private static void CalendarPrint(Scanner sc, Calendar cal) {
		int year = 1700;
		int month = 1;

		System.out.println("년도를 입력하세요.");
		System.out.print("YEAR > ");
		year = sc.nextInt();

		if (year < 1700 || year > 3000) {
			System.out.println("잘못된 입력입니다.");
			return;
		}

		System.out.println("월을 입력하세요.");
		System.out.print("MONTH > ");
		month = sc.nextInt();

		if (month < 1 || month > 12) {
			System.out.println("잘못된 입력입니다.");
			return;
		}

		cal.printCalendar(year, month);
	}

	private static void savePlan(Scanner sc, Calendar cal) {
		System.out.println("[새 일정을 등록하세요.]");
		System.out.print("날짜입력 > ");
		String strDate = sc.next();
		sc.nextLine();	//next()입력시 마지막의 엔터가 다음에 오는 nextLine() 에 입력되는 걸 방지하기 위함.
		
		System.out.print("일정입력 > ");
		String strPlan = sc.nextLine(); 

		cal.setPlan(strDate, strPlan);
	}

	private static void searchPlan(Scanner sc, Calendar cal) {
		System.out.println("[일정을 검색하세요.]");
		System.out.print("날짜입력 > ");
		String strDate = sc.next();

		System.out.println(cal.getPlan(strDate));
	}

	private static void printMenu() {
		System.out.println("+----------------------+");
		System.out.println("| 1. 일정 등록         |");
		System.out.println("| 2. 일정 검색         |");
		System.out.println("| 3. 달력 보기         |");
		System.out.println("| h. 도움말            |");
		System.out.println("| q. 종료              |");
		System.out.println("+----------------------+");
	}

}
