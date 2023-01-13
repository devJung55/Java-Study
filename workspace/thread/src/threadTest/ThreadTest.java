package threadTest;

public class ThreadTest {
	public static void main(String[] args) {
		
//		���� ���� �����尡 �ϳ��� �ڿ��� ������ ���� ��Ƽ������
//		Thread2 thread = new Thread2();
//		Runnable thread = new Thread2();
		
		Runnable target = () -> {
//		�͸� Ŭ������ ��ȸ�����θ� ���Ǳ� ������ �ؿ��� �߰��� ������شٸ� ���� �������� ������ ����ش�.
			for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread().getName());
				try {Thread.sleep(500);} catch (InterruptedException e) {;}
			}
		};
		
//		Thread t1 = new Thread(thread, "!");
//		Thread t2 = new Thread(thread, "?");
		
		Thread t1 = new Thread(() /* run �޼ҵ� */ -> {
//			���ٽ�(�͸� Ŭ����)�� �Ҵ� �� Ŭ������ �ּ� ��

			for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread().getName());
				try {Thread.sleep(500);} catch (InterruptedException e) {;}
			}
		}, "!");
		Thread t2 = new Thread(target, "?");
		
		t1.start();
		
		try {t1.join();} catch (InterruptedException e) {}
		
		t2.start();
		
//		Thread t1 = new Thread1("1");
//		Thread t2 = new Thread1("2");
		
//		t1.start();
//		t2.start();
		
//		t1.run();	// JVM(�ü��)�� �����ٸ��� ���� �ʾƼ� ���� ������� �޼ҵ常 ����ϴ� ��
//		t2.run();
	}
}
