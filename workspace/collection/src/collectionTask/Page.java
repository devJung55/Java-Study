package collectionTask;

public class Page {
	public static void main(String[] args) {

		UserField userField = new UserField();

//		ȸ������ �׽�Ʈ
		System.out.println(userField.join("������", "jung_7122", "1234", "01071228966"));

//		���̵� �ߺ��˻� �׽�Ʈ
		System.out.println(userField.checkId("jung_7122"));

//		�α��� �׽�Ʈ
		System.out.println(userField.login("jung_7122", "1234"));

//		������ȣ ���� �׽�Ʈ
		System.out.println(userField.sendCode("jung_7122", "01071228966"));

//		��й�ȣ ���� �׽�Ʈ
		System.out.println(userField.changePassword("jung_7122", "5678", userField.code));

//		��й�ȣ ���� �� �α��� �׽�Ʈ
		System.out.println(userField.login("jung_7122", "5678"));
	}
}
