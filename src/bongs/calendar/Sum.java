package bongs.calendar;

import java.util.Scanner;

public class Sum {

	public static void main(String[] args) {

		// 두 수를 입력받는다.
		Scanner sc = new Scanner(System.in);
		
		System.out.println("합을 계산할 정수 두 개를 입력하세요");
		String str1 = sc.next();
		String str2 = sc.next();
		sc.close();

		int n1, n2;
		n1 = Integer.parseInt(str1);
		n2 = Integer.parseInt(str2);
		
		// 두 숫자의 합을 계산
		System.out.printf("%d와 %d의 합은 %d입니다.", n1, n2, n1 + n2);
	}

}
