package castingTest;

import java.util.Scanner;

public class InputTask2 {

	public static void main(String[] args) {
//		3개의 정수를 한 번에 입력 받은 후
//		세 정수의 곱셈 출력
//		next()만 사용.

		Scanner sc = new Scanner(System.in);
		int num1 = 0, num2 = 0, num3 = 0, result = 0;

		System.out.print("세 개의 정수 입력 : ");
		num1 = Integer.parseInt(sc.next());
		num2 = Integer.parseInt(sc.next());
		num3 = Integer.parseInt(sc.next());

		result = num1 * num2 * num3;

		System.out.println("세 정수의 곱 : " + result);
	}
}
