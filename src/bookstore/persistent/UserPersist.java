package bookstore.persistent;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.PreparedStatement;
import bookstore.object.User;
import bookstore.object.UserType;

public class UserPersist {

	private static Connection conn = null;
	
	public static void registerUser(User user) {
		String insertSql = "INSERT INTO bookstore.users VALUES (?, ?, ?, ?, ?, ?, ?, null, 'waiting', ?, ?)";
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
			
			stmt1.setInt(1, user.getId());
			stmt1.setString(2,  user.getFirstName());
			stmt1.setString(3,  user.getLastName());
			stmt1.setString(4, user.getPhoneNumber());
			stmt1.setString(5,  user.getEmail());
			stmt1.setString(6,  user.getPassword());
			stmt1.setInt(7,  user.getUserType().ordinal());
			stmt1.setString(8,  user.getShippingAddress());
			stmt1.setString(9,  user.getBillingAddress());
			
			stmt1.executeUpdate();
			
			System.out.println(stmt1.toString());
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	private static UserType[] userTypeValues = UserType.values();
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
				user.setStatus(rs.getString(5));
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
					user.setStatus(rs.getString(5));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return user;
	}

	public static void setVerificationCode(User newUser, String verificationCode) {
		String insertSql = "UPDATE bookstore.users SET verifcode = ? WHERE email = ?";
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
			
			stmt1.setString(1, verificationCode);
			stmt1.setString(2, newUser.getEmail());
			stmt1.executeUpdate();
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void setStatus(User currentUser, String status) {
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
			
			stmt1.setString(1, status);
			stmt1.setString(2, currentUser.getEmail());
			stmt1.executeUpdate();
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
