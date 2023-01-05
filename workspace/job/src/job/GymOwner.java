package job;

import java.util.Random;
import java.util.Scanner;

class BenchPress {
//	������ ��ġ������ �ʱ� ���� Ȯ�� 70% �ο��Ѵ�.
//	������ �� ���� + 1, ������ �� ���� - 1
//	���� 5ȸ ���� �� ���� �� + 1
//	���� ��� �� ���� Ȯ�� 10%�� ���

	String ownerName; // ������ �̸�
	boolean successOrFail; // �������� ����
	int successCount; // ���� Ƚ��
	int level; // ����
	int muscle; // ������

	{
		level++; // �⺻ ��
	}

//	������
//	BenchPress() {;}

	BenchPress(String ownerName) {
		this.ownerName = ownerName;
	}

//	��ġ������ ���� �޼ҵ�
	boolean challengeBenchPress() {
		Random random = new Random();

		if (level > 3) {
			level = 4;
//			System.out.println(level);
//			System.out.println("����");
		}

		int[] rating = new int[10];
		int data = 70 + (level - 1) * 10; // �ʱ� ���� Ȯ�� 70%, ������ ���������� ���� Ȯ�� 10% ���

		for (int i = 0; i < data / 10; i++) {
//			System.out.println(data);
			rating[i] = 1;
		}

		if (rating[random.nextInt(10)] == 1) { // ��ġ�������� �����Ѵ�.
			successCount++; // ����Ƚ���� �����Ѵ�.
			successOrFail = true; // ���� ���θ� true ���ش�.

			return successOrFail; // true ����
		}
		successCount = 0; // ���� 5ȸ �����̱� ������ ���� �� ����Ƚ�� 0���� �ʱ�ȭ ���ش�.
		return successOrFail; // false ����
	}

//	��ٰ� �ټս��� �������� �޼ҵ�
	int getMuscle() {
		if (successOrFail) {
			muscle += 1; // ���� �� ������ + 1 �����Ѵ�.

			return muscle;
		}
		muscle -= 1; // ���� �� ������ - 1 �����Ѵ�.
		return muscle;
	}

}

public class GymOwner {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BenchPress benchPress = new BenchPress("\"�ѵ���\""); // ����� �̸� �����ڿ� �Ű������� ����

		String menu = "1. �����ϱ�\n2. ������ ��ȸ�ϱ�.\n3. ��ġ������ �����ϱ�.";
		int choice = 0;

		while (true) {
			System.out.println(benchPress.ownerName + "�� ��ġ������ ���� !\n");
			System.out.println(menu);
			choice = Integer.parseInt(sc.nextLine());

			if (choice == 1) {
				benchPress.challengeBenchPress();
				if (benchPress.successOrFail) {
					benchPress.getMuscle();
					System.out.println("���ƿ�� ~!\n���� ������ : " + benchPress.muscle + "\n");
					benchPress.successOrFail = false;
				} else {
					benchPress.getMuscle();
					System.out.println("\n���� ������ : " + benchPress.muscle + "\n");
				}

				if (benchPress.successCount > 4) {
					benchPress.level++;
					if (benchPress.level == 5) {
						System.out.println("������ MAX�Դϴ�.");
						System.out.println("��ġ�������� ���� ������ ���� ����� �Ѿ�ϴ�.");
						break;
					} else {
						System.out.println("������ ����Ͽ����ϴ�.\n���� ���� : " + benchPress.level + "\n");
					}
					benchPress.successCount = 0;
				}

			} else if (choice == 2) {
				System.out.println("���� ������ : " + benchPress.muscle + "\n");
			} else if (choice == 3) {
				System.out.println(benchPress.ownerName + "�� ��ġ������ �����մϴ�.");
				break;
			} else {
				System.out.println("�ٽ� �Է����ֽʽÿ�.\n");
			}

		}

	}

}
