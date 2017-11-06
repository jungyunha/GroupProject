package bookstore.logic;

import bookstore.object.User;
import bookstore.persistent.UserPersist;

public class UserLogic {
	
	public static void registerUser(User user) {
		UserPersist.registerUser(user);
	}

	public static int verifyUser(String email, String pass) {
		return UserPersist.verifyUser(email, pass);
	}

}
