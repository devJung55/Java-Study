package variableTest;

public class FormatTest {

	public static void main(String[] args) {
		String name = "������";
		int age = 20;
		double height = 123.5;
		
		System.out.printf("�̸� : %s\n", name);
		System.out.printf("���� : %d\n", age);
		System.out.printf("Ű : %.1fcm", height);

	}
}
