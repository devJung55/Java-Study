package threadTest;

public class ThreadTest {
	public static void main(String[] args) {
		
//		여러 개의 쓰레드가 하나의 자원에 접근한 것이 멀티쓰레드
//		Thread2 thread = new Thread2();
//		Runnable thread = new Thread2();
		
		Runnable target = () -> {
//		익명 클래스로 일회성으로만 사용되기 때문에 밑에서 추가로 사용해준다면 재사용 목적으로 변수에 담아준다.
			for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread().getName());
				try {Thread.sleep(500);} catch (InterruptedException e) {;}
			}
		};
		
//		Thread t1 = new Thread(thread, "!");
//		Thread t2 = new Thread(thread, "?");
		
		Thread t1 = new Thread(() /* run 메소드 */ -> {
//			람다식(익명 클래스)이 할당 된 클래스의 주소 값

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
		
//		t1.run();	// JVM(운영체제)에 스케줄링은 하지 않아서 단일 쓰레드로 메소드만 사용하는 것
//		t2.run();
	}
}
