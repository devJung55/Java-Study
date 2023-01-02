package arrayTest;

import java.util.Scanner;

public class ArTask2 {
	public static void main(String[] args) {
//      �� ��ư�� ������ ��, �̵��ϴ� �������� ������ ����.

//      btn1 : ȸ������ ������
//      btn2 : �α��� ������
//      btn3 : ���� ������

//      ȸ������ -> �α��� -> ���� ������
//      �� ������� �Է��ؾ� �ϸ�, ���� ���� �ܰ踦 �����ϱ� ���� ���� �ܰ� ��ư�� ���� ���, ���� �ܰ迡 ���� �޼����� ������ش�.
//      ��) �α��� Ŭ�� ��, "ȸ�������� ���� �������ּ���" ���

//      �˸��� �ܰ��� ��ư�� ������, �ش� �ܰ迡 ���� �޼����� ������ش�.
//      ��)   ȸ������ Ŭ�� ��, ȸ������ ����
//         ���� ������ Ŭ�� ��, ���� �̸��� ���� ���

//      ��ư �迭
		String[] arButton = { "btn1", "btn2", "btn3", "btn4" };
//      ���� �޼��� �迭
		String[] arMessage = { "ȸ������ ����", "�α��� ����", "�ѵ���(20)", "�α׾ƿ� ����" };
//      ���� �޼��� �迭
		String[] arError = { "ȸ�������� ���� �������ּ���.", "�α����� ���� �������ּ���" };
//      ���� �޼���
		String errorMessage = "�ٽ� �õ����ּ���";

		Scanner sc = new Scanner(System.in);
//      choice : ����ڰ� �Է��� ��ȣ, temp : ����ڰ� ������ �Է��� ��ȣ
		int choice = 0, temp = 0;
		boolean condition = false;

		while (true) {
//         �޴� ���
			for (int i = 0; i < arButton.length; i++) {
				System.out.println(i + 1 + "." + arButton[i]);
			}

//         ���� temp�� 0�� ����ִٸ�, 0�� �����ؾ� �Ѵ�.
			temp = temp == 0 ? 0 : choice;
//         ����ڰ� ������ ��ư ��ȣ
			choice = sc.nextInt();
//         ��ư ��ȣ �̿��� ��ȣ�� �Է����� ��� ���� �޼��� ���
			if (choice < 1 || choice > 4) {
				System.out.println(errorMessage);
				continue;
			}
//         �α׾ƿ� �� ���α׷� ����
			if (choice == 4) {
				System.out.println(arMessage[choice - 1]);
				break;
			}

//         ����ڰ� ������ ��ư�� ��ȣ - 1�� ������ ����ڰ� �Է��� ��ȣ�� ���� �� ��
//         �� �ܰ踦 ���� �ߴ� �� �˻�
			condition = choice - 1 == temp;

			if (!condition) { // �� �ܰ踦 ������ ���
				temp = 0; // ȸ�����Ժ��� �����϶�� ��.
				System.out.println(arError[choice - 2]);
				continue;
			}
			// �� �ܰ踦 �������� ���
			System.out.println(arMessage[choice - 1]);
			if (choice == 3) { // ���� �������� �������� ������
				temp = 0; // ȸ�����Ժ��� �����϶�� ��.
				continue;
			}
//         ���� ������ �̿��� ���񽺸� �̿����� ��� �Է��ߴ� ��ȣ�� temp�� �����Ѵ�.
			temp = choice;

		}
	}
}

//package arrayTest;
//
//import java.util.Scanner;
//
//public class ArTask2 {
//
//	public static void main(String[] args) {
////		�� ��ư�� ������ ��, �̵��ϴ� �������� ������ ����.
//
////		btn1 : ȸ������ ������
////		btn2 : �α��� ������
////		btn3 : ���� ������
//
////		ȸ������ -> �α��� -> ���� ������
////		�� ������� �Է��ؾ� �ϸ�, ���� ���� �ܰ踦 �����ϱ� ���� ���� �ܰ� ��ư�� ���� ���, ���� �ܰ迡 ���� �޼����� ������ش�.
////		��) �α��� Ŭ�� ��, "ȸ�������� ���� �������ּ���." ���
//
////		�˸��� �ܰ��� ��ư�� ������, �ش� �ܰ迡 ���� �޼����� ������ش�.
////		��) ȸ������ Ŭ�� ��, ȸ������ ����
////			���� ������ Ŭ�� ��, ���� �̸��� ���� ���
//
//		Scanner sc = new Scanner(System.in);
//
//		String[] arBtn = { "btn1", "btn2", "btn3", "btn4" };
//		String[] arError = { "ȸ�������� ���� �������ּ���.", "�α����� ���� �������ּ���." };
//		String[] arInfo = new String[2];
//		int[] check = new int[3];
//		int inputBtn = 0;
//
//		while (true) {
//
//			for (int i = 0; i < arBtn.length; i++) {
//				System.out.println(arBtn[i]);
//			}
//			inputBtn = sc.nextInt();
//
//			if (inputBtn == 1) {
//				check[0] = 1;
//
//				System.out.print("�̸� �Է� : ");
//				arInfo[0] = sc.next();
//
//				System.out.print("���� �Է� : ");
//				arInfo[1] = sc.next();
//
//				System.out.println("ȸ������ ���� !\n");
//
//			} else if (inputBtn == 2) {
//				if (check[0] != 1) {
//					System.out.println(arError[0] + "\n");
//					continue;
//				}
//				check[1] = 2;
//
//				System.out.println("�α��� ���� !\n");
//
//			} else if (inputBtn == 3) {
//				if (check[1] != 2) {
//					System.out.println(arError[1] + "\n");
//					continue;
//				}
//				System.out.println("�̸� : " + arInfo[0]);
//				System.out.println("���� : " + arInfo[1] + "\n");
//
//			} else if (inputBtn == 4) {
//				System.out.println("����");
//				break;
//			}
//		}
//	}
//}
