package castingTest;

import java.util.Scanner;

public class InputTask2 {

	public static void main(String[] args) {
//		3���� ������ �� ���� �Է� ���� ��
//		�� ������ ���� ���
//		next()�� ���.

		Scanner sc = new Scanner(System.in);
		int num1 = 0, num2 = 0, num3 = 0, result = 0;

		System.out.print("�� ���� ���� �Է� : ");
		num1 = Integer.parseInt(sc.next());
		num2 = Integer.parseInt(sc.next());
		num3 = Integer.parseInt(sc.next());

		result = num1 * num2 * num3;

		System.out.println("�� ������ �� : " + result);
	}
}
