package arrayListTask2;

public class Field {

	public static void main(String[] args) {
		Food bulgogi = new Food("�Ұ�� ����", 30000, "�ѽ�");
		Food bibibab = new Food("���� �����", 12000, "�ѽ�");
		Restaurant restaurant = new Restaurant();

//		���� �߰� �׽�Ʈ
		restaurant.insertFood(bulgogi);
		System.out.println(bulgogi);

		restaurant.insertFood(bibibab);
		System.out.println(bibibab);

//		���� �̸����� ���� ���� ��ȸ �׽�Ʈ
		System.out.println(restaurant.selectkindOfFood("�Ұ�� ����"));

//		����ڰ� ���ϴ� ������ ���� ��ü ��ȸ �׽�Ʈ
		System.out.println(restaurant.selectAll("�ѽ�"));

//		���� ���� ���� �� ���� 10% ���
		System.out.println(restaurant.updateFood(bibibab, "���"));

//		����ڰ� ���ϴ� ������ ���� ���� ��ȸ
		System.out.println(restaurant.selectCountFood("�ѽ�"));
	}

}
