package arrayListTask3;

public class Field {

	public static void main(String[] args) {
		DateApp dateApp = new DateApp();
		Love lee = new Love("01071228966", "��", 15);
		Love jung = new Love("01071228966", "��", 12);
		Love kim = new Love("01071228966", "��", 17);
		Love park = new Love("01071228966", "��", 20);
		
		dateApp.loves.add(lee);
		dateApp.loves.add(jung);
		dateApp.loves.add(kim);
		dateApp.loves.add(park);
		
		System.out.println(dateApp.orderByAge());
		
	}

}
