package bookstore.object;

public class User {
	private int id;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String email;
	private String password;
	private UserType userType;
	private String shippingAddress;
	private String billingAddress;
	private String verificationCode;
	private UserStatus status;
	private boolean suscribed;
	
	


	public User(int id, String firstName, String lastName, String phoneNumber, String email, String password,
			UserType userType, String shippingAddress, String billingAddress, UserStatus status, boolean subscribed) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.password = password;
		this.userType = userType;
		this.shippingAddress = shippingAddress;
		this.billingAddress = billingAddress;
		this.status = status;
		this.setSuscribed(subscribed);
	}
	
	
	public User() {
		// TODO Auto-generated constructor stub
		id = 0;
		firstName = "";
		lastName = "";
		phoneNumber = "";
		email = "";
		password = "";
		userType = UserType.None;
		shippingAddress = "";
		billingAddress = "";
		verificationCode = "";
		status = UserStatus.None;
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
	
	public UserType getUserType() {
		return userType;
	}
	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	
	public String getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}

	public String getVerificationCode() {
		return verificationCode;
	}
	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}
	
	public UserStatus getStatus() {
		return status;
	}
	public void setStatus(UserStatus status) {
		this.status = status;
	}


	public boolean isSuscribed() {
		return suscribed;
	}


	public void setSuscribed(boolean suscribed) {
		this.suscribed = suscribed;
	}

}
