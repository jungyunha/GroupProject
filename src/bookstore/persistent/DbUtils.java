package bookstore.persistent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbUtils {

    // private static Logger log = SessionManager.getLog();
    

    /**
     * Disables the auto commit for the current connection  
     * @param conn  the open connection
     */
    public static void disableAutoCommit( Connection conn ) 
            throws Exception 
    {
        try {
            conn.setAutoCommit(false);
        } 
        catch( SQLException ex ) {
            // log.error( "DbUtils.disableAutoCommit: SQLException on setting auto-commit false ", ex );
            throw new Exception( "DbUtils.disableAutoCommit: Transaction error. " + ex.getMessage() );
        }
    }

    /**
     * Enable the auto commit for the current connection  
     * @param conn  the open connection
     */
    public static void enableAutoCommit( Connection conn ) 
            throws Exception 
    {
        try {
            conn.setAutoCommit(true);
        } 
        catch( SQLException ex ) {
            // log.error( "DbUtils.enableAutoCommit: SQLException on setting auto-commit true ", ex );
            throw new Exception( "DbUtils.enableAutoCommit: Transaction error. " + ex.getMessage() );
        }
    }

    /**
     * Commit the transactions for the current connection  
     * @param conn  the open connection
     */
    public static void commit(Connection conn) 
            throws Exception 
    {
        try {
            conn.commit();
        } catch (SQLException ex) {
            // log.error("DbUtils.commit: SQLException on commit ", ex);
            throw new Exception( "DbUtils.commit: SQLException on commit " + ex.getMessage() );
        }
    }

    /**
     * rollback the transactions for the current connection  
     * @param conn  the open connection
     */
    public static void rollback(Connection conn) 
            throws Exception 
    {
        try {
            conn.rollback();
        } catch (SQLException ex) {
            // log.error( "DbUtils.rollback: SQLException on rollback ", ex );
            throw new Exception( "DbUtils.rollback: Unable to rollback transaction. " + ex.getMessage() );
        }
    }

    /**
     * Establish a JDBC connection to the database.
     * @return  a database connection object
     * @throws  GVException
     */
    public static Connection connect() 
            throws Exception 
    {
        try {
            Class.forName(DbAccessConfiguration.DB_DRIVE_NAME);
        } 
        catch (ClassNotFoundException ex) {
            // log.error( "DbUtils.connect:  unable to find JDBC Driver", ex );
            throw new Exception( "DbUtils.connect: Unable to find Driver" );
        }
        try {
            return DriverManager.getConnection( DbAccessConfiguration.DB_CONNECTION_URL,
                                                DbAccessConfiguration.DB_CONNECTION_USERNAME,
                                                DbAccessConfiguration.DB_CONNECTION_PASSWORD);
        } 
        catch (SQLException ex) {
            // log.error( "DbUtils.connect: Unable to connect to database", ex );
            throw new Exception( "DbUtils.connect: Unable to connect to database " + ex.getMessage() );
        }
    }
    public static ResultSet retrieve(Connection conn, String query)
    {
      ResultSet rset = null;
      try
      {
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(query);
      }
      catch (SQLException e)
      {
        e.printStackTrace();
      }
      return rset;
    }
    
    public static int create(String sql) throws Exception
    {
     Connection c = connect();
     int r = 0;
     try{
  	   Statement s = c.createStatement();
  	   r = s.executeUpdate(sql);
     }catch(SQLException e){
  	   e.printStackTrace();
     }finally{
  	   closeConnection(c);
     }
     return r;
    }

	public static int update(String sql) throws Exception
    {
  	   Connection c = connect();
  	   int r = 0;
  	   try{
  		   Statement s = c.createStatement();
  		   r = s.executeUpdate(sql);
  	   }catch(SQLException e){
  		   e.printStackTrace();
  	   }finally{
  		   closeConnection(c);
  	   }
  	   return r;
  	  }

    public static int delete(String sql) throws Exception
    {
  	   Connection c = connect();
  	   int r = 0;
  	   try{
  		   Statement s = c.createStatement();
  		   r = s.executeUpdate(sql);
  	   }catch(SQLException e){
  		   e.printStackTrace();
  	   }finally{
  		   closeConnection(c);
  	   }
  	   return r;
  	  }
    public static void closeConnection(Connection con)
    {
      try
      {
        if (con != null) {
          con.close();
        }
      }
      catch (SQLException e)
      {
        e.printStackTrace();
      }
    }
  }

