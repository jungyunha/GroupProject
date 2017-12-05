package bookstore.persistent;

import java.sql.Connection;
import java.sql.ResultSet;

public abstract class DbAccessConfiguration {
	
	static final String DB_DRIVE_NAME = "com.mysql.jdbc.Driver";
	
	static final String DB_CONNECTION_URL = "jdbc:mysql://localhost:3306/bookstore";
	
	static final String DB_CONNECTION_USERNAME = "root";
	
	static final String DB_CONNECTION_PASSWORD = "mario55"; //your password

}
