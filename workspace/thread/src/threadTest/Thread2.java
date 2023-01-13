package threadTest;

public class Thread2 implements Runnable {
//	인터페이스로 여러 개 지정 할 수 있어서 실무에서 상속보단 인터페이스 지정으로 쓴다.
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName());
			try {Thread.sleep(500);} catch (InterruptedException e) {;}
		}
	}
}
