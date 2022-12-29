package castingTest;

import java.util.Scanner;

public class InputTask {

	public static void main(String[] args) {
//		두 정수를 입력한 뒤 덧셈 결과 출력
//		단, next()만 사용한다.
		
		Scanner sc = new Scanner(System.in);
		
		int num1 = 0, num2 = 0, result = 0;
		
		System.out.print("정수입력1 : ");
		num1 = Integer.parseInt(sc.next());
		
		System.out.print("정수입력2 : ");
		num2 = Integer.parseInt(sc.next());
		
		result = num1 + num2;
		
		System.out.println("총 합 : " + result);
	}

}
