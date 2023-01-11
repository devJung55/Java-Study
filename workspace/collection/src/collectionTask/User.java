package collectionTask;

public class User {
	private String userName;
	private String userId;
	private String userPassword;
	private String userPhoneNumber;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}

	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}

	public User() {;}

	
	public User(String userName, String userId, String userPassword, String userPhoneNumber) {
		this.userName = userName;
		this.userId = userId;
		this.userPassword = userPassword;
		this.userPhoneNumber = userPhoneNumber;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", userId=" + userId + ", userPassword=" + userPassword
				+ ", userPhoneNumber=" + userPhoneNumber + "]";
	}

}
