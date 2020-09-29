/*3.WAP using JDBC to select and print employee names along with their manager names.*/

package ClassWork;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PrintEmpNames {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// register driver
		Class.forName("com.mysql.jdbc.Driver");

		// establish connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hefshine", "root", "root");

		if (con == null) {
			System.out.println("Connection Establish failed");

		} else {
			System.out.println("Connection Established\n");
		}

		// create Statement object
		Statement st = con.createStatement();

		System.out.println("FIRST_NAME  LAST_NAME MANAGER_NAME");
		String S1 = "SELECT first_name,last_name,manager_id FROM EMPLOYEES";

		// create resultSet object
		ResultSet rs = st.executeQuery(S1);

		System.out.println();
		//System.out.println("_ _ _ _ _ _ _ _");
		while (rs.next() != false) {
			System.out.println(
					rs.getString("FIRST_NAME") + "         " + rs.getString("LAST_NAME") + "          " + rs.getString("MANAGER_ID"));

		}

		rs.close();
		st.close();
		con.close();

	}
}
