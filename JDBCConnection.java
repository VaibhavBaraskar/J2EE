/*1.How to create JDBC connection.*/

package ClassWork;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {

	public static void main(String[] args) throws ClassNotFoundException,SQLException {

		Connection con=null;
		// Register JDBC Drivers
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//Establish Connection
		
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system","ram7pute");
		
		if(con==null) {
			System.out.println("Connection Establish failed");
			}
		else {
			System.out.println("Connection Establish");
		}
		
	}

}
