package bookstore.object;

public enum UserStatus {
	None, // This should not be seen after user is initialized
	//
	Waiting, // Waiting for the user to enter verification code
	Active, // User has entered verification code
	Suspened, // Account suspended...
}
