package bongs.calendar;

import java.util.Scanner;

//이름 : 간단한 은행 프로그램
//조건 : 
//	"1. 입금" 선택 시 금액 입력 후 예금액 합산 후 출력
//	"2. 출금" 선택 시 금액 입력 후 남은 금액 출력
//	"3. 잔고" 선택 시 현재 가지고 있는 금액 출력
//	"4. 종료" 선택 시 종료
//	이외에 다른 숫자 입력 시 "다시 입력해주세요" 출력

public class Account {
	
	static int balance = 0;

	public static void main(String[] args) {
		
		printMenu();
		
		Scanner sc = new Scanner(System.in);
		int menu = 0;
		
		while (true) {
			System.out.print("명령을 입력하세요. (1 ~ 4) > ");
			menu = sc.nextInt();
			
			if (menu == 0)	printMenu();
			else if (menu == 1)	setDeposit(sc);
			else if (menu == 2)	setWithdraw(sc);
			else if (menu == 3)	getBalance();
			else if (menu == 4)	break;
			else
				System.out.println("잘못된 입력입니다. 1 ~ 4 숫자를 입력해 주세요.");
		}
		System.out.println("Thank you. Bye~");
		sc.close();
	}

	private static void getBalance() {
		System.out.printf("잔고 : %d원 \n", balance);
	}

	private static void setWithdraw(Scanner sc) {
		System.out.print("출금액 입력 > ");
		int Withdraw = sc.nextInt(); 
		balance -= Withdraw;		
	}

	private static void setDeposit(Scanner sc) {
		System.out.print("입금액 입력 > ");
		int deposit = sc.nextInt(); 
		balance += deposit;
	}

	private static void printMenu() {
		System.out.println("+--- 메뉴 --------+");
		System.out.println("| 1. 입금         |");
		System.out.println("| 2. 출금         |");
		System.out.println("| 3. 잔고         |");
		System.out.println("| 4. 종료         |");
		System.out.println("| 0. 도움말       |");
		System.out.println("+-----------------+");
	}
}
