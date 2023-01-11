package arrayListTask3;

public class Love {
	private String userPhoneNumber;
	private String userName;
	private int userAge;

	public Love() {;}

	
	public Love(String userPhoneNumber, String userName, int userAge) {
		this.userPhoneNumber = userPhoneNumber;
		this.userName = userName;
		this.userAge = userAge;
	}

	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}

	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserAge() {
		return userAge;
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}

	@Override
	public String toString() {
		return "Love [userPhoneNumber=" + userPhoneNumber + ", userName=" + userName + ", userAge=" + userAge + "]";
	}

}
