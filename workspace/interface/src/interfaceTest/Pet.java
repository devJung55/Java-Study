package interfaceTest;

public interface Pet {
	final static int EYES = 2;	// 모든 값들이 공유하기 위해서 static이 붙는다.
	public int NOSE = 1;
	
	public abstract void giveYourHand();
	public void bang();
	public void sitDown();
	public void waitNow();
	public void getNose();
	
}
