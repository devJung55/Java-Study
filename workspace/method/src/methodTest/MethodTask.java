package methodTest;

public class MethodTask {
//   1~10���� println()���� ����ϴ� �޼ҵ�
	void printFrom1To10() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i + 1);
		}
	}

//   "ȫ�浿"�� n�� println()���� ����ϴ� �޼ҵ�
	void printHong(int count) {
		for (int i = 0; i < count; i++) {
			System.out.println("ȫ�浿");
		}
	}

//   �̸��� n�� println()���� ����ϴ� �޼ҵ�
	void printName(String name, int count) {
		for (int i = 0; i < count; i++) {
			System.out.println(name);
		}
	}

//   �� ������ ������ ���ִ� �޼ҵ�
	int sub(int number1, int number2, int number3) {
		int result = number1 - number2 - number3;
		return result;
	}

//   �� ������ ������ �� ��� ������ �� ���� ���ϴ� �޼ҵ�
	int[] div(int number1, int number2) {
		int[] result = null;

		if (number2 != 0) {
			result = new int[2];
			result[0] = number1 / number2;
			result[1] = number1 % number2;
		}
		return result;
	}

//   1~n������ ���� �����ִ� �޼ҵ�
	int getTotalFrom1(int end) {
		int total = 0;
		for (int i = 0; i < end; i++) {
			total += i + 1;
		}
		return total;
	}

//   Ȧ���� ¦����, ¦���� Ȧ���� �ٲ��ִ� �޼ҵ�
	int change(int number) {
		return ++number;
	}

//   ���ڿ��� �Է¹ް� �ҹ��ڴ� �빮�ڷ�, �빮�ڴ� �ҹ��ڷ� �ٲ��ִ� �޼ҵ�
	String changeToUpperOrLower(String str) {
		String result = "";
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c >= 65 && c <= 90) {
				result += (char) (c + 32);

			} else if (c >= 97 && c <= 122) {
				result += (char) (c - 32);

			} else {

				result += c;
			}
		}
		return result;
	}

//   ���ڿ��� �Է¹ް� ���ϴ� ������ ������ �����ִ� �޼ҵ�
	int getCount(String str, char c) {
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == c) {
				count++;
			}
		}
		return count;
	}

//   5���� ������ �Է¹��� �� ���ϴ� �ε����� ���� �����ִ� �޼ҵ�
	int getValue(int[] arData, int index) {
		return arData[index];
	}

//   �ѱ��� ������ �ٲ��ִ� �޼ҵ�(�ϰ��̻� -> 1024)
	int changeToInteger(String hangle) {
		String hangleOriginal = "�����̻�����ĥ�ȱ�";
		String result = "";
		for (int i = 0; i < hangle.length(); i++) {
			result += hangleOriginal.indexOf(hangle.charAt(i));
		}
		return Integer.parseInt(result);
	}

//   5���� ������ �Է¹ް� �ִ밪�� �ּҰ��� �����ִ� �޼ҵ�
	int[] getMaxAndMin(int[] arData) {
		int[] result = { arData[0], arData[0] };

		for (int i = 0; i < arData.length; i++) {
			if (result[0] < arData[i]) {
				result[0] = arData[i];
			}
			if (result[1] > arData[i]) {
				result[1] = arData[i];
			}
		}
		return result;
	}

//   5���� ������ �Է¹ް� �ִ밪�� �ּҰ��� �����ִ� �޼ҵ�(void)
	void getMaxAndMin(int[] arData, int[] result) {
		result[0] = arData[0];
		result[1] = arData[0];

		for (int i = 0; i < arData.length; i++) {
			if (result[0] < arData[i]) {
				result[0] = arData[i];
			}
			if (result[1] > arData[i]) {
				result[1] = arData[i];
			}
		}
	}

//	indexOf() �����
//	���ڿ��� ���ڸ� �Է� ���� �� �ش� ���ڰ� �� ��° �ε����� �ִ� �� �˻��ϰ�
//	���� �ش� ���ڰ� ������ -1�� �����Ѵ�.
	int indexOf(String str, char c) {
		int result = 0;

		result = str.indexOf(c);

		return result;
	}

	public static void main(String[] args) {
		MethodTask methodTask = new MethodTask();
//      methodTask.printFrom1To10();
//      methodTask.printHong(10);
//      methodTask.printName("�ѵ���", 5);
//      System.out.println(methodTask.sub(5, 5 , 10));
//      int[] result = methodTask.div(10, 0);
//      if (result == null) {
//         System.out.println("0���� ���� �� �����ϴ�.");
//      } else {
//         System.out.println("��: " + result[0]);
//         System.out.println("������: " + result[1]);
//      }
//		int[] result = new int[2];
//		int[] arData = { 3, 5, 6, 2, 1 };
//		methodTask.getMaxAndMin(arData, result);
//		System.out.println("�ִ밪: " + result[0]);
//		System.out.println("�ּҰ�: " + result[1]);

		System.out.println(methodTask.indexOf("ABC", 'B'));

	}
}

//package methodTest;
//
//public class MethodTask {
////	1~10���� println()���� ����ϴ� �޼ҵ�
//	void printFrom1To10() {
//		for (int i = 0; i < 10; i++) {
//			System.out.println(i + 1);
//		}
//	}
//
////	"ȫ�浿"�� n�� println()���� ����ϴ� �޼ҵ�
//	void printName(int number) {
//		for (int i = 0; i < number; i++) {
//			System.out.println("ȫ�浿");
//		}
//	}
//
////	�̸��� n�� println()���� ����ϴ� �޼ҵ�
//	void printMyName(String name, int number) {
//		for (int i = 0; i < number; i++) {
//			System.out.println(name);
//		}
//	}
//
////	�� ������ ������ ���ִ� �޼ҵ�
//	void subtraction(int number1, int number2, int number3) {
//		int result = number1 - number2 - number3;
//
//		System.out.println("�� ������ ������ : " + result);
//	}
//
////	�� ������ ������ �� ��� ������ �� ���� ���ϴ� �޼ҵ�
//	int[] division(int number1, int number2) {
//
//		int[] arResult = null;
//		if (number2 != 0) {
//			arResult = new int[2];
//
//			arResult[0] = number1 / number2;
//			arResult[1] = number1 % number2;
//		}
//
//		return arResult;
//	}
//
////	1~n������ ���� �����ִ� �޼ҵ�
//	int add(int range) {
//		int total = 0;
//
//		for (int i = 1; i < range + 1; i++) {
//			total += range;
//		}
//
//		return total;
//	}
//
////	Ȧ���� ¦����, ¦���� Ȧ���� �ٲ��ִ� �޼ҵ�
//	int changeNumber(int number) {
//		int changeResult = 0;
//
//		if (number / 2 == 0) {
//			changeResult = number + 1;
//		} else {
//			changeResult = number + 1;
//		}
//
//		return changeResult;
//	}
//
////	���ڿ��� �Է� �ް� �ҹ��ڴ� �빮�ڷ�, �빮�ڴ� �ҹ��ڷ� �ٲ��ִ� �޼ҵ�
//	String changeText(String text) {
//		String changeResult = "";
//
//		for (int i = 0; i < text.length(); i++) {
//			char textChar = text.charAt(i);
//
//			if (65 <= textChar && textChar <= 90) {
//				changeResult += (char) (textChar + 32);
//			} else if (97 <= textChar && textChar <= 122) {
//				changeResult += (char) (textChar - 32);
//			} else {
//				changeResult += textChar;
//			}
//		}
//		return changeResult;
//	}
//
////	���ڿ��� �Է� �ް� ���ϴ� ������ ������ �����ִ� �޼ҵ�
//	int countString(String str) {
//		return str.length();
//	}
//
////	5���� ������ �Է� ���� �� ���ϴ� �ε����� ���� �����ִ� �޼ҵ�
//
////	�ѱ��� ������ �ٲ��ִ� �޼ҵ�(�ϰ��̻� -> 1024)
//	void changeNumber(String hangle) {
//		String index = "�����̻�����ĥ�ȱ�";
//
//		for (int i = 0; i < hangle.length(); i++) {
//			System.out.print(index.indexOf(hangle.charAt(i)));
//		}
//	}
//
////	5���� ������ �Է� �ް� �ִ밪�� �ּҰ��� �����ִ� �޼ҵ�
//	int[] maxMin(int number1, int number2, int number3, int number4, int number5) {
//		int[] number = new int[5];
//		int[] result = new int[2];
//		int max = number1;
//		int min = number1;
//		number[0] = number1;
//		number[1] = number2;
//		number[2] = number3;
//		number[3] = number4;
//		number[4] = number5;
//
//		for (int i = 0; i < number.length; i++) {
//			if (max < number[i]) {
//				max = number[i];
//			}
//
//			if (min > number[i]) {
//				min = number[i];
//			}
//		}
//		result[0] = max;
//		result[1] = min;
//
//		return result;
//	}
//
////	5���� ������ �Է� �ް� �ִ밪�� �ּҰ��� �����ִ� �޼ҵ�(void)
//
//	public static void main(String[] args) {
//		MethodTask methodTask = new MethodTask();
//
////		methodTask.printNumber();
////		methodTask.printName(5);
////		methodTask.printMyName("������", 5);
////		methodTask.subtraction(10, 1, 1);
////		System.out.println("�� : " + methodTask.division(11, 2)[0]);
////		System.out.println("������ : " + methodTask.division(11, 2)[1]);
//
////		System.out.println(methodTask.add(10));
////		System.out.println(methodTask.changeNumber(10));
////		System.out.println(methodTask.changeText("aBcDeF!@aa"));
////		System.out.println(methodTask.countString("kkk"));
////		methodTask.changeNumber("�ϰ��̻�");
////		System.out.println(methodTask.maxMin(1, 2, 3, 4, 6)[0]);
////		System.out.println(methodTask.maxMin(1, 2, 0, 4, 5)[1]);
//
//	}
//}
