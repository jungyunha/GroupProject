package bookstore.persistent;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.PreparedStatement;
import bookstore.object.User;

public class UserPersist {

	private static Connection conn = null;
	
	public static void registerUser(User user) {
		String insertSql = "INSERT INTO bookstore.users VALUES (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement stmt1;
		
		try {
			try {
				conn = DbUtils.connect();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
			stmt1 = (PreparedStatement) conn.prepareStatement(insertSql);
			
			stmt1.setInt(1, user.getId());
			stmt1.setString(2,  user.getFirstName());
			stmt1.setString(3,  user.getLastName());
			stmt1.setString(4, user.getPhoneNumber());
			stmt1.setString(5,  user.getEmail());
			stmt1.setString(6,  user.getPassword());
			stmt1.setInt(7,  user.getUserType());
			
			stmt1.executeUpdate();
			
			System.out.println(stmt1.toString());
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public static User verifyUser(String username, String pass) {
		User user = new User();
		String sql = "SELECT userid, firstname, lastname, usertype FROM bookstore.users WHERE email = ? AND password = ?";
		PreparedStatement stmt;
		try {
			conn = DbUtils.connect();
		}
		catch (Exception e) {
			e.printStackTrace();
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
				user.setUserType(rs.getInt(4));
				user.setEmail(username);
			}
			else {
				notEmail = true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		/*
		if (notEmail) {
			String sql2 = "SELECT email, firstname, lastname, usertype FROM bookstore.users WHERE userid = ? AND password = ?";
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
					user.setUserType(rs.getInt(4));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		*/
		
		return user;
	}
}
