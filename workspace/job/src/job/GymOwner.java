package job;

import java.util.Random;
import java.util.Scanner;

class BenchPress {
//	관장의 벤치프레스 초기 성공 확률 70% 부여한다.
//	성공할 시 근육 + 1, 실패할 시 근육 - 1
//	연속 5회 성공 시 레벨 업 + 1
//	레벨 상승 시 성공 확률 10%씩 상승

	String ownerName; // 관장의 이름
	boolean successOrFail; // 성공여부 변수
	int successCount; // 성공 횟수
	int level; // 레벨
	int muscle; // 근육량

	{
		level++; // 기본 값
	}

//	생성자
//	BenchPress() {;}

	BenchPress(String ownerName) {
		this.ownerName = ownerName;
	}

//	벤치프레스 도전 메소드
	boolean challengeBenchPress() {
		Random random = new Random();

		if (level > 3) {
			level = 4;
//			System.out.println(level);
//			System.out.println("들어옴");
		}

		int[] rating = new int[10];
		int data = 70 + (level - 1) * 10; // 초기 성공 확률 70%, 레벨이 높아질수록 성공 확률 10% 상승

		for (int i = 0; i < data / 10; i++) {
//			System.out.println(data);
			rating[i] = 1;
		}

		if (rating[random.nextInt(10)] == 1) { // 벤치프레스에 성공한다.
			successCount++; // 성공횟수를 누적한다.
			successOrFail = true; // 성공 여부를 true 해준다.

			return successOrFail; // true 리턴
		}
		successCount = 0; // 연속 5회 성공이기 때문에 실패 시 성공횟수 0으로 초기화 해준다.
		return successOrFail; // false 리턴
	}

//	득근과 근손실의 양자택일 메소드
	int getMuscle() {
		if (successOrFail) {
			muscle += 1; // 성공 시 근육량 + 1 누적한다.

			return muscle;
		}
		muscle -= 1; // 실패 시 근육량 - 1 누적한다.
		return muscle;
	}

}

public class GymOwner {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BenchPress benchPress = new BenchPress("\"한동석\""); // 사용자 이름 생성자에 매개변수로 전달

		String menu = "1. 도전하기\n2. 근육량 조회하기.\n3. 벤치프레스 종료하기.";
		int choice = 0;

		while (true) {
			System.out.println(benchPress.ownerName + "의 벤치프레스 시작 !\n");
			System.out.println(menu);
			choice = Integer.parseInt(sc.nextLine());

			if (choice == 1) {
				benchPress.challengeBenchPress();
				if (benchPress.successOrFail) {
					benchPress.getMuscle();
					System.out.println("좋아요우 ~!\n현재 근육량 : " + benchPress.muscle + "\n");
					benchPress.successOrFail = false;
				} else {
					benchPress.getMuscle();
					System.out.println("\n현재 근육량 : " + benchPress.muscle + "\n");
				}

				if (benchPress.successCount > 4) {
					benchPress.level++;
					if (benchPress.level == 5) {
						System.out.println("레벨이 MAX입니다.");
						System.out.println("벤치프레스를 숙달 했으니 다음 운동으로 넘어갑니다.");
						break;
					} else {
						System.out.println("레벨이 상승하였습니다.\n현재 레별 : " + benchPress.level + "\n");
					}
					benchPress.successCount = 0;
				}

			} else if (choice == 2) {
				System.out.println("현재 근육량 : " + benchPress.muscle + "\n");
			} else if (choice == 3) {
				System.out.println(benchPress.ownerName + "의 벤치프레스 종료합니다.");
				break;
			} else {
				System.out.println("다시 입력해주십시오.\n");
			}

		}

	}

}
