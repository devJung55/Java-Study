package threadTest;

public class Thread1 extends Thread {
//	실무에서는 Thread를 상속 받아서 사용하는 일이 없다.
//	추가로 상속을 받을 수 없기 때문에.
	
	public String data;

	public Thread1() {;}

	public Thread1(String data) {
		this.data = data;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(data);
			try {sleep(500);} catch (InterruptedException e) {;}
		}
	}
	
	
}
