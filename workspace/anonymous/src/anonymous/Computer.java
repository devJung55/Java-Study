package anonymous;

public class Computer {

	public static void main(String[] args) {
//		�������̽��� �������� ���� �ʵ尡 �����ϱ� ������,
//		�͸� Ŭ������ ���� �� �������̽��� �����Ͽ� ������Ų��.
//		������ �͸� Ŭ������ �ʵ尡 �޸𸮿� �Ҵ�� �� �������̽� Ÿ����
//		��ü�� up casting�ȴ�.
		
		Game game = new Game() {
			
			@Override
			public void play() {
				
			}

			@Override
			public void exit() {

			}
		};
	}

}
