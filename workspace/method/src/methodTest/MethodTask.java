package methodTest;

public class MethodTask {
//   1~10까지 println()으로 출력하는 메소드
	void printFrom1To10() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i + 1);
		}
	}

//   "홍길동"을 n번 println()으로 출력하는 메소드
	void printHong(int count) {
		for (int i = 0; i < count; i++) {
			System.out.println("홍길동");
		}
	}

//   이름을 n번 println()으로 출력하는 메소드
	void printName(String name, int count) {
		for (int i = 0; i < count; i++) {
			System.out.println(name);
		}
	}

//   세 정수의 뺄셈을 해주는 메소드
	int sub(int number1, int number2, int number3) {
		int result = number1 - number2 - number3;
		return result;
	}

//   두 정수의 나눗셈 후 몫과 나머지 두 개를 구하는 메소드
	int[] div(int number1, int number2) {
		int[] result = null;

		if (number2 != 0) {
			result = new int[2];
			result[0] = number1 / number2;
			result[1] = number1 % number2;
		}
		return result;
	}

//   1~n까지의 합을 구해주는 메소드
	int getTotalFrom1(int end) {
		int total = 0;
		for (int i = 0; i < end; i++) {
			total += i + 1;
		}
		return total;
	}

//   홀수를 짝수로, 짝수를 홀수로 바꿔주는 메소드
	int change(int number) {
		return ++number;
	}

//   문자열을 입력받고 소문자는 대문자로, 대문자는 소문자로 바꿔주는 메소드
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

//   문자열을 입력받고 원하는 문자의 개수를 구해주는 메소드
	int getCount(String str, char c) {
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == c) {
				count++;
			}
		}
		return count;
	}

//   5개의 정수를 입력받은 후 원하는 인덱스의 값을 구해주는 메소드
	int getValue(int[] arData, int index) {
		return arData[index];
	}

//   한글을 정수로 바꿔주는 메소드(일공이사 -> 1024)
	int changeToInteger(String hangle) {
		String hangleOriginal = "공일이삼사오육칠팔구";
		String result = "";
		for (int i = 0; i < hangle.length(); i++) {
			result += hangleOriginal.indexOf(hangle.charAt(i));
		}
		return Integer.parseInt(result);
	}

//   5개의 정수를 입력받고 최대값과 최소값을 구해주는 메소드
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

//   5개의 정수를 입력받고 최대값과 최소값을 구해주는 메소드(void)
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

//	indexOf() 만들기
//	문자열과 문자를 입력 받은 뒤 해당 문자가 몇 번째 인덱스에 있는 지 검사하고
//	만약 해당 문자가 없으면 -1을 리턴한다.
	int indexOf(String str, char c) {
		int result = 0;

		result = str.indexOf(c);

		return result;
	}

	public static void main(String[] args) {
		MethodTask methodTask = new MethodTask();
//      methodTask.printFrom1To10();
//      methodTask.printHong(10);
//      methodTask.printName("한동석", 5);
//      System.out.println(methodTask.sub(5, 5 , 10));
//      int[] result = methodTask.div(10, 0);
//      if (result == null) {
//         System.out.println("0으로 나눌 수 없습니다.");
//      } else {
//         System.out.println("몫: " + result[0]);
//         System.out.println("나머지: " + result[1]);
//      }
//		int[] result = new int[2];
//		int[] arData = { 3, 5, 6, 2, 1 };
//		methodTask.getMaxAndMin(arData, result);
//		System.out.println("최대값: " + result[0]);
//		System.out.println("최소값: " + result[1]);

		System.out.println(methodTask.indexOf("ABC", 'B'));

	}
}

//package methodTest;
//
//public class MethodTask {
////	1~10까지 println()으로 출력하는 메소드
//	void printFrom1To10() {
//		for (int i = 0; i < 10; i++) {
//			System.out.println(i + 1);
//		}
//	}
//
////	"홍길동"을 n번 println()으로 출력하는 메소드
//	void printName(int number) {
//		for (int i = 0; i < number; i++) {
//			System.out.println("홍길동");
//		}
//	}
//
////	이름을 n번 println()으로 출력하는 메소드
//	void printMyName(String name, int number) {
//		for (int i = 0; i < number; i++) {
//			System.out.println(name);
//		}
//	}
//
////	세 정수의 뺄셈을 해주는 메소드
//	void subtraction(int number1, int number2, int number3) {
//		int result = number1 - number2 - number3;
//
//		System.out.println("세 정수의 뺄셈값 : " + result);
//	}
//
////	두 정수의 나눗셈 후 몫과 나머지 두 개를 구하는 메소드
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
////	1~n까지의 합을 구해주는 메소드
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
////	홀수를 짝수로, 짝수를 홀수로 바꿔주는 메소드
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
////	문자열을 입력 받고 소문자는 대문자로, 대문자는 소문자로 바꿔주는 메소드
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
////	문자열을 입력 받고 원하는 문자의 개수를 구해주는 메소드
//	int countString(String str) {
//		return str.length();
//	}
//
////	5개의 정수를 입력 받은 후 원하는 인덱스의 값을 구해주는 메소드
//
////	한글을 정수로 바꿔주는 메소드(일공이사 -> 1024)
//	void changeNumber(String hangle) {
//		String index = "공일이삼사오육칠팔구";
//
//		for (int i = 0; i < hangle.length(); i++) {
//			System.out.print(index.indexOf(hangle.charAt(i)));
//		}
//	}
//
////	5개의 정수를 입력 받고 최대값과 최소값을 구해주는 메소드
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
////	5개의 정수를 입력 받고 최대값과 최소값을 구해주는 메소드(void)
//
//	public static void main(String[] args) {
//		MethodTask methodTask = new MethodTask();
//
////		methodTask.printNumber();
////		methodTask.printName(5);
////		methodTask.printMyName("정지영", 5);
////		methodTask.subtraction(10, 1, 1);
////		System.out.println("몫 : " + methodTask.division(11, 2)[0]);
////		System.out.println("나머지 : " + methodTask.division(11, 2)[1]);
//
////		System.out.println(methodTask.add(10));
////		System.out.println(methodTask.changeNumber(10));
////		System.out.println(methodTask.changeText("aBcDeF!@aa"));
////		System.out.println(methodTask.countString("kkk"));
////		methodTask.changeNumber("일공이사");
////		System.out.println(methodTask.maxMin(1, 2, 3, 4, 6)[0]);
////		System.out.println(methodTask.maxMin(1, 2, 0, 4, 5)[1]);
//
//	}
//}
