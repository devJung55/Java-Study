package apiTest;

public class API_TEST {
	public static void main(String[] args) {
		Calc calculate = new Calc();
	
		try {
			System.out.println(calculate.div(10, 0));
		} catch (ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다.");
		}
	}
}
