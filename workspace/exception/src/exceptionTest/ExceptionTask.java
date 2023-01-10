package exceptionTest;

import java.util.Scanner;

public class ExceptionTask {
	public static void main(String[] args) {
//		5개의 정수만 입력받기
//		- 무한 입력 상태로 구현
//		- q 입력 시 나가기
//		- 각 정수는 배열에 담기
//		- if문은 딱 한 번만 사용하기

		Scanner sc = new Scanner(System.in);
		String[] input = new String[5];
		int i = 0;

		while (true) {
			try {
				System.out.print(i + 1 + "번째 정수 입력 : ");
				input[i] = sc.next();

				if (input[i].contains("q")) {
					System.out.println("종료");
					break;
				}
				i++;
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("인덱스가 초과하였습니다.");
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}
}
