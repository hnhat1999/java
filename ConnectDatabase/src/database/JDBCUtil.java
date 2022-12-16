package database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

public class JDBCUtil {
	public static Connection getConnection() {
		Connection c = null;
		try {
			// cac thong so
			var server = "DESKTOP-IE5QF5N\\SQLEXPRESS";
			var user = "sa";
			var password = "1";
			var db = "nhasach";
			var port = 1433;
			com.microsoft.sqlserver.jdbc.SQLServerDataSource ds = new com.microsoft.sqlserver.jdbc.SQLServerDataSource();
			ds.setServerName(server);
			ds.setUser(user);
			ds.setPassword(password);
			ds.setDatabaseName(db);
			ds.setPortNumber(port);
			c = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		try {
//			DriverManager.registerDriver(new SQLServerDriver());
//			String url = "jdbc:mySQL://DESKTOP-IE5QF5N\\SQLEXPRESS:1433/abcd";
//			String username = "sa";
//			String password = "1";
//			c = DriverManager.getConnection(url, username, password);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		return c;
	}
	public static void closeConnection(Connection c) {
		try {
			if(c != null) {
				c.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    public static void printInfo(Connection c) {
    	try {
			if(c != null) {
				DatabaseMetaData mtdt = c.getMetaData();
				System.out.println(mtdt.getDatabaseProductName());
				System.out.println(mtdt.getDatabaseProductName());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
}
