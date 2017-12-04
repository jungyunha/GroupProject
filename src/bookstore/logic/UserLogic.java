package bookstore.logic;

import java.util.List;
import java.util.Vector;

import bookstore.object.*;
import bookstore.persistent.UserPersist;
import javafx.util.Pair;

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

	public static List<Book> getBooksBySubject(String value) {
		return UserPersist.getBooksBySubject(value);
	}

	public static List<Book> getBooksByAuthor(String value) {
		return UserPersist.getBooksByAuthor(value);
	}

	public static List<Book> getBooksByISBN(String value) {
		return UserPersist.getBooksByISBN(value);
	}

	public static void addToCart(int id, int quantity, int isbn) {
		UserPersist.addToCart(id, quantity, isbn);
	}

	public static void addPromotion(String promocode, int percentage) {
		UserPersist.addPromotion(promocode, percentage);
	}

	public static List<User> getSubscribedUsers() {
		return UserPersist.getSubscribedUsers();
	}

	public static Vector<Pair<Long,Integer>> getCart(int id) {
		return UserPersist.getCart(id);
	}

	public static void insertBook(int iSBN, String title, String price, int quantity, String coverphoto,
			String category, String description, int thresholdLimit, int rating, String author) {
		UserPersist.insertBook(iSBN, title, price, quantity, coverphoto, category,  description, thresholdLimit, rating, author);
	}

	public static Book getBookByISBN(Long key) {
		return UserPersist.getBookByISBN(key);
	}

	public static void placeOrder(Cart currentCart, String dateTime, int newID, int userID) {
		UserPersist.placeOrder(currentCart, dateTime, newID, userID);
	}

	public static void emptyCart(int id) {
		UserPersist.emptyCart(id);
	}

	public static String getUserPasswordWithEmail(String emailEntered) {
		return UserPersist.getUserPasswordWithEmail(emailEntered);
	}


	public static void updateBook(int iSBN, String title, String price, int quantity, String coverphoto,
			String category, String description, int thresholdLimit, int rating, String author, int iSBN2) {
		UserPersist.updateBook(iSBN, title, price, quantity, coverphoto, category, description, thresholdLimit, rating, author, iSBN2);
	}

	public static void deleteBook(int iSBN){
		UserPersist.deleteBook(iSBN);
	}

	public static void updateOrderStatus(int transactionID, String status) {
		UserPersist.updateOrderStatus(transactionID, status);
		
	}

	public static int getUserIDFromTransactionID(int transactionID) {
		return UserPersist.getUserIDFromTransactionID(transactionID);
	}

	public static String getEmailWithUserID(int id) {
		return UserPersist.getEmailWithUserID(id);
	}

}
