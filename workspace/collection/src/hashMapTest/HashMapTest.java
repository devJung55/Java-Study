package hashMapTest;

import java.util.HashMap;

public class HashMapTest {
	public static void main(String[] args) {
//		���̵�, ��й�ȣ, �̸�, ����
		HashMap<String, Object> userMap = new HashMap<String, Object>();
		
		userMap.put("id", "jjy1234");
		userMap.put("password", "1234");
		userMap.put("name", "������");
		userMap.put("age", 20);
		
		System.out.println(userMap);
		
		System.out.println(userMap.get("id"));
		
	}

}
