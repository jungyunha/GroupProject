package bookstore.persistent;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
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
		  7:	`usertype` int(11) NOT NULL COMMENT 'Type 1 is Admin.',
		  8:	`verifcode` tinyint(4) NOT NULL,
		  9:	`shippingaddress` varchar(255) NOT NULL,
		  10:	`billingaddress` varchar(255) NOT NULL,
		  11:	`status` int(11) NOT NULL,
		  12:	`fogotpasswordcode` varchar(255) NOT NULL*/
		String insertSql = "INSERT INTO bookstore.users VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 1, null)";
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
			
			stmt1.executeUpdate();
			
			System.out.println(stmt1.toString());
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
		String sql = "SELECT title, price, coverphoto, rating, author FROM bookstore.book WHERE title=? ORDER BY title ASC";
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
				temp.price = rs.getString(2);
				temp.coverphoto = rs.getString(3);
				System.out.println(temp.coverphoto);
				temp.rating = rs.getFloat(4);
				temp.author = rs.getString(5);
				searchResults.add(temp);
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		if (isEmpty) {
			return null;
		}else {
			System.out.println("returning a list");
			return searchResults;
		}
		
	}
}
