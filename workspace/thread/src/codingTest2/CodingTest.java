package codingTest2;

public class CodingTest {
	public int printCount(String s) {
		int count = 0, result = 0;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '1') {
				count++;
				result = count;
			} else {
				count = 0;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		CodingTest codingTest = new CodingTest();

		System.out.println(codingTest.printCount("00000"));
	}

}


//package codingTest;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class OneOrZero {
//   public int solution(String s) {
//      int result = 0;
//      
//      List<Integer> results = new ArrayList<String>(Arrays.asList(s.split("0")))
//            .stream().map(String::length).sorted(Collections.reverseOrder())
//            .collect(Collectors.toList());
////      try {
////         result = new ArrayList<String>(Arrays.asList(s.split("0")))
////               .stream().map(String::length).sorted(Collections.reverseOrder())
////               .collect(Collectors.toList()).get(0);
////      } catch (Exception e) {
////         result = 0;
////      }
//      return results.size() == 0 ? 0 : results.get(0);
//   }
//   
//   public static void main(String[] args) {
//      String s = "00000";
//      System.out.println(new OneOrZero().solution(s));
//   }
//}




