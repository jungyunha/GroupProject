package bookstore.logic;

import java.util.List;

import bookstore.object.*;
import bookstore.persistent.UserPersist;

public class UserLogic {
	
	public static void registerUser(User user) {
		UserPersist.registerUser(user);
	}

	public static User verifyUser(String email, String pass) {
		return UserPersist.verifyUser(email, pass);
	}

	public static void setStatus(User currentUser, UserStatus status) {
		currentUser.setStatus(status);
		UserPersist.setStatus(currentUser, status);
	}

	public static List<Book> getBooksByTitle(String value) {
		return UserPersist.getBooksByTitle(value);
	}

}
