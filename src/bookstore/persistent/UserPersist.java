package bookstore.persistent;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.mysql.jdbc.PreparedStatement;
import com.sun.imageio.plugins.common.SubImageInputStream;

import bookstore.object.Book;
import bookstore.object.User;
import bookstore.object.UserStatus;
import bookstore.object.UserType;

public class UserPersist {

	private static Connection conn = null;
	
	public static void registerUser(User user) {
		/*1:	`userid` int(11) NOT NULL,
		  2:	`firstname` varchar(255) NOT NULL,
		  3:	`lastname` varchar(255) NOT NULL,
		  4:	`phonenumber` varchar(255) NOT NULL,
		  5:	`email` varchar(255) NOT NULL,
		  6:	`password` varchar(255) NOT NULL COMMENT 'Hashed and stored.',
		  7:	`usertype` int(11) NOT NULL COMMENT 'Type 2 is Admin.',
		  8:	`verifcode` tinyint(4) NOT NULL,
		  9:	`shippingaddress` varchar(255) NOT NULL,
		  10:	`billingaddress` varchar(255) NOT NULL,
		  11:	`status` int(11) NOT NULL,
		  12:	`fogotpasswordcode` varchar(255) NOT NULL*/
		String insertSql = "INSERT INTO bookstore.users VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, null, ?)";
		PreparedStatement stmt1;
		
		try {
			if(conn == null || conn.isClosed())
			{
				try {
					conn = DbUtils.connect();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			stmt1 = (PreparedStatement) conn.prepareStatement(insertSql);
			
			stmt1.setInt	(1, user.getId());
			stmt1.setString	(2, user.getFirstName());
			stmt1.setString	(3, user.getLastName());
			stmt1.setString	(4, user.getPhoneNumber());
			stmt1.setString	(5, user.getEmail());
			stmt1.setString	(6, user.getPassword());
			stmt1.setInt	(7, user.getUserType().ordinal());
			stmt1.setString	(8, user.getVerificationCode());
			stmt1.setString	(9, user.getShippingAddress());
			stmt1.setString	(10,user.getBillingAddress());
			stmt1.setInt(11,  user.getStatus().ordinal());
			if (user.isSuscribed()) {
				stmt1.setInt(12, 1);
			}else {
				stmt1.setInt(12, 0);
			}
			
			
			stmt1.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	private static UserType[] userTypeValues = UserType.values();
	private static UserStatus[] userStatusValues = UserStatus.values();
	public static User verifyUser(String username, String pass) {
		User user = new User();
		String sql = "SELECT userid, firstname, lastname, usertype, status FROM bookstore.users WHERE email = ? AND password = ?";
		PreparedStatement stmt;
		try {
			if(conn == null || conn.isClosed())
			{
				try {
					conn = DbUtils.connect();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		boolean notEmail = false;		
		try {
			stmt = (PreparedStatement) conn.prepareStatement(sql);
			stmt.setString(1, username);
			stmt.setString(2,  pass);
			stmt.executeQuery();
			ResultSet rs = stmt.getResultSet();
			if (rs.next()) {
				notEmail = false;
				user.setId(rs.getInt(1));
				user.setFirstName(rs.getString(2));
				user.setLastName(rs.getString(3));
				user.setUserType(userTypeValues[rs.getInt(4)]);
				user.setStatus(userStatusValues[rs.getInt(5)]);
				user.setEmail(username);
			}
			else {
				notEmail = true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (notEmail) {
			String sql2 = "SELECT email, firstname, lastname, usertype, status FROM bookstore.users WHERE userid = ? AND password = ?";
			try {
				stmt = (PreparedStatement) conn.prepareStatement(sql2);
				stmt.setString(1, username);
				stmt.setString(2,  pass);
				stmt.executeQuery();
				ResultSet rs = stmt.getResultSet();
				if (rs.next()) {
					user.setId(Integer.parseInt(username));
					user.setEmail(rs.getString(1));
					user.setFirstName(rs.getString(2));
					user.setLastName(rs.getString(3));
					user.setUserType(userTypeValues[rs.getInt(4)]);
					user.setStatus(userStatusValues[rs.getInt(5)]);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return user;
	}

	public static void setStatus(User currentUser, UserStatus status) {
		String insertSql = "UPDATE bookstore.users SET status = ? WHERE email = ?";
		PreparedStatement stmt1;
		
		try {
			if(conn == null || conn.isClosed())
			{
				try {
					conn = DbUtils.connect();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			stmt1 = (PreparedStatement) conn.prepareStatement(insertSql);
			
			stmt1.setInt(1, status.ordinal());
			stmt1.setString(2, currentUser.getEmail());
			stmt1.executeUpdate();
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static List<Book> getBooksByTitle(String value) {
		List<Book> searchResults = new ArrayList<Book>();
		boolean isEmpty = true;
		String sql = "SELECT title, price, coverphoto, rating, author, isbn FROM bookstore.book WHERE title=? ORDER BY title ASC";
		PreparedStatement stmt1;
		
		try {
			if(conn == null || conn.isClosed())
			{
				try {
					conn = DbUtils.connect();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			stmt1 = (PreparedStatement) conn.prepareStatement(sql);

			stmt1.setString(1, value);
			stmt1.executeQuery();
			
			ResultSet rs = stmt1.getResultSet();
			while (rs.next()) {
				isEmpty = false;
				Book temp = new Book();
				temp.title = rs.getString(1);
				temp.price = rs.getFloat(2);
				temp.coverphoto = rs.getString(3);
				temp.rating = rs.getFloat(4);
				temp.author = rs.getString(5);
				temp.ISBN = rs.getInt(6);
				searchResults.add(temp);
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		if (isEmpty) {
			return null;
		}else {
			return searchResults;
		}
		
	}

	public static List<Book> getBooksBySubject(String value) {
		List<Book> searchResults = new ArrayList<Book>();
		boolean isEmpty = true;
		String sql = "SELECT title, price, coverphoto, rating, author, isbn FROM bookstore.book WHERE category=? ORDER BY title ASC";
		PreparedStatement stmt1;
		
		try {
			if(conn == null || conn.isClosed())
			{
				try {
					conn = DbUtils.connect();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			stmt1 = (PreparedStatement) conn.prepareStatement(sql);

			stmt1.setString(1, value);
			stmt1.executeQuery();
			
			ResultSet rs = stmt1.getResultSet();
			while (rs.next()) {
				isEmpty = false;
				Book temp = new Book();
				temp.title = rs.getString(1);
				temp.price = rs.getFloat(2);
				temp.coverphoto = rs.getString(3);
				temp.rating = rs.getFloat(4);
				temp.author = rs.getString(5);
				temp.ISBN = rs.getInt(6);
				searchResults.add(temp);
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		if (isEmpty) {
			return null;
		}else {
			return searchResults;
		}
	}

	public static List<Book> getBooksByAuthor(String value) {
		List<Book> searchResults = new ArrayList<Book>();
		boolean isEmpty = true;
		String sql = "SELECT title, price, coverphoto, rating, author, isbn FROM bookstore.book WHERE author=? ORDER BY title ASC";
		PreparedStatement stmt1;
		
		try {
			if(conn == null || conn.isClosed())
			{
				try {
					conn = DbUtils.connect();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			stmt1 = (PreparedStatement) conn.prepareStatement(sql);

			stmt1.setString(1, value);
			stmt1.executeQuery();
			
			ResultSet rs = stmt1.getResultSet();
			while (rs.next()) {
				isEmpty = false;
				Book temp = new Book();
				temp.title = rs.getString(1);
				temp.price = rs.getFloat(2);
				temp.coverphoto = rs.getString(3);
				temp.rating = rs.getFloat(4);
				temp.author = rs.getString(5);
				temp.ISBN = rs.getInt(6);
				searchResults.add(temp);
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		if (isEmpty) {
			return null;
		}else {
			return searchResults;
		}
	}

	public static List<Book> getBooksByISBN(String value) {
		List<Book> searchResults = new ArrayList<Book>();
		boolean isEmpty = true;
		String sql = "SELECT title, price, coverphoto, rating, author, isbn FROM bookstore.book WHERE isbn=? ORDER BY title ASC";
		PreparedStatement stmt1;
		
		try {
			if(conn == null || conn.isClosed())
			{
				try {
					conn = DbUtils.connect();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			stmt1 = (PreparedStatement) conn.prepareStatement(sql);

			stmt1.setString(1, value);
			stmt1.executeQuery();
			
			ResultSet rs = stmt1.getResultSet();
			while (rs.next()) {
				isEmpty = false;
				Book temp = new Book();
				temp.title = rs.getString(1);
				temp.price = rs.getFloat(2);
				temp.coverphoto = rs.getString(3);
				temp.rating = rs.getFloat(4);
				temp.author = rs.getString(5);
				temp.ISBN = rs.getInt(6);
				searchResults.add(temp);
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		if (isEmpty) {
			return null;
		}else {
			return searchResults;
		}
	}

	public static void addToCart(int id, int quantity, int isbn) {
		String sql = "INSERT INTO bookstore.shoppingcart VALUES (?, ?, ?)";
		PreparedStatement stmt1;
		
		try {
			if(conn == null || conn.isClosed())
			{
				try {
					conn = DbUtils.connect();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			stmt1 = (PreparedStatement) conn.prepareStatement(sql);

			stmt1.setInt(1, id);
			stmt1.setInt(2, quantity);
			stmt1.setInt(3,  isbn);
			stmt1.executeUpdate();
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void addPromotion(String promocode, int percentage) {
		String sql = "INSERT INTO bookstore.promocodes VALUES (?, ?)";
		PreparedStatement stmt1;
		
		try {
			if(conn == null || conn.isClosed())
			{
				try {
					conn = DbUtils.connect();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			stmt1 = (PreparedStatement) conn.prepareStatement(sql);

			stmt1.setString(1, promocode);
			stmt1.setInt(2, percentage);
			stmt1.executeUpdate();
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static List<User> getSubscribedUsers() {
		List<User> results = new ArrayList<User>();
		boolean isEmpty = true;
		String sql = "SELECT email FROM bookstore.users WHERE subscribed = 1";
		PreparedStatement stmt1;
		
		try {
			if(conn == null || conn.isClosed())
			{
				try {
					conn = DbUtils.connect();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			stmt1 = (PreparedStatement) conn.prepareStatement(sql);
			stmt1.executeQuery();
			
			ResultSet rs = stmt1.getResultSet();
			while (rs.next()) {
				isEmpty = false;
				User temp = new User();
				temp.setEmail(rs.getString(1));
				results.add(temp);
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		if (isEmpty) {
			return null;
		}else {
			return results;
		}
	}

	public static Vector<Integer> getBookNumbers(int id) {
		Vector<Integer> results = new Vector();
		boolean isEmpty = true;
		String sql = "SELECT isbn FROM bookstore.shoppingcart WHERE userid = ?";
		PreparedStatement stmt1;
		
		try {
			if(conn == null || conn.isClosed())
			{
				try {
					conn = DbUtils.connect();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			stmt1 = (PreparedStatement) conn.prepareStatement(sql);
			stmt1.setInt(1, id);
			stmt1.executeQuery();
			
			ResultSet rs = stmt1.getResultSet();
			while (rs.next()) {
				isEmpty = false;
				int isbn = rs.getInt(1);
				results.add(isbn);
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		if (isEmpty) {
			return null;
		}else {
			return results;
		}
	}
}
