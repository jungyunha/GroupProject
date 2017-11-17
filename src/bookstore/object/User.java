package bookstore.object;

public class User {
	private int id;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String email;
	private String password;
	private int userType;
	
	
	public User(int id, String firstName, String lastName, String phoneNumber, String email, String password,
			int userType) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.password = password;
		this.userType = userType;
	}
	
	
	public User() {
		// TODO Auto-generated constructor stub
		id = 0;
		firstName = "";
		lastName = "";
		phoneNumber = "";
		email = "";
		password = "";
		userType = 0;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	
	

}
