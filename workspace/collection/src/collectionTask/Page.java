package collectionTask;

public class Page {
	public static void main(String[] args) {

		UserField userField = new UserField();

//		회원가입 테스트
		System.out.println(userField.join("정지영", "jung_7122", "1234", "01071228966"));

//		아이디 중복검사 테스트
		System.out.println(userField.checkId("jung_7122"));

//		로그인 테스트
		System.out.println(userField.login("jung_7122", "1234"));

//		인증번호 전송 테스트
		System.out.println(userField.sendCode("jung_7122", "01071228966"));

//		비밀번호 변경 테스트
		System.out.println(userField.changePassword("jung_7122", "5678", userField.code));

//		비밀번호 변경 후 로그인 테스트
		System.out.println(userField.login("jung_7122", "5678"));
	}
}
