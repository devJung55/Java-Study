package castingTest;

import java.util.Scanner;

public class InputTask {

	public static void main(String[] args) {
//		�� ������ �Է��� �� ���� ��� ���
//		��, next()�� ����Ѵ�.
		
		Scanner sc = new Scanner(System.in);
		
		int num1 = 0, num2 = 0, result = 0;
		
		System.out.print("�����Է�1 : ");
		num1 = Integer.parseInt(sc.next());
		
		System.out.print("�����Է�2 : ");
		num2 = Integer.parseInt(sc.next());
		
		result = num1 + num2;
		
		System.out.println("�� �� : " + result);
	}

}
