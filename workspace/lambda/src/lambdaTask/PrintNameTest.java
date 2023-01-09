package lambdaTask;

public class PrintNameTest {

	public String printFullName(PrintName printName) {
		return printName.getFullName("Á¤", "Áö¿µ");
	}

	public static void main(String[] args) {
		PrintNameTest printNameTest = new PrintNameTest();
		
//		PrintName printName = new PrintName() {
//			
//			@Override
//			public void getFullName(String lastName, String firstName) {
//				System.out.println(lastName + firstName);
//			}
//		};
		
//		PrintName printName = (lastName, firstName) -> {
//			return lastName + firstName;
//		};
		
		PrintName printName = ((lastName, firstName) -> lastName + firstName);

		System.out.println(printNameTest.printFullName(printName));
	}

}
