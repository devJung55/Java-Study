package exceptionTest;

import java.util.Scanner;

public class ExceptionTask {
	public static void main(String[] args) {
//		5���� ������ �Է¹ޱ�
//		- ���� �Է� ���·� ����
//		- q �Է� �� ������
//		- �� ������ �迭�� ���
//		- if���� �� �� ���� ����ϱ�

		Scanner sc = new Scanner(System.in);
		String[] input = new String[5];
		int i = 0;

		while (true) {
			try {
				System.out.print(i + 1 + "��° ���� �Է� : ");
				input[i] = sc.next();

				if (input[i].contains("q")) {
					System.out.println("����");
					break;
				}
				i++;
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("�ε����� �ʰ��Ͽ����ϴ�.");
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}
}
