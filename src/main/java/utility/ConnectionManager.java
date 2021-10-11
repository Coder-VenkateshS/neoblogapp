package utility;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {
 
	public final static Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con=null;
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/mydb","SYSTEM","Root@123");
		if(con!=null) {
			System.out.println("Connection Established to database");
			return con;
		}
		else {
			System.out.println("Check your connection");
			return null;
		}
	}
}