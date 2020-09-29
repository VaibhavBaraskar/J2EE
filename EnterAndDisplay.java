/*2.WAP to enter and display data of students using database connections.*/

package ClassWork;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EnterAndDisplay {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		// register jdbc driver
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// establish the Connection
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "system", "ram7pute");

		if (con == null) {
			System.out.println("Connection Establish failed");

		} else {
			System.out.println("Connection Established\n");
		}
		// Create Statement object
		st = con.createStatement();

		// CREATE TABLE STUDENT(SNO NUMBER(10),SNAME VARCHAR2(20),ADDRESS VARCHAR2(20))
		String s = "CREATE TABLE STUDENT(SNO NUMBER(10),SNAME VARCHAR2(20),ADDRESS VARCHAR2(20))";
		st.executeUpdate(s);
		System.out.println("Table Created Successfully\n");

		// INSERT INTO STUDENT VALUES(1,'RAM','NANDED')
		String s1 = "INSERT INTO STUDENT VALUES(1,'RAM','NANDED')";
		st.executeUpdate(s1);

		// Select * from Student(sno sname address)
		String s2 = "SELECT * FROM STUDENT";
		rs = st.executeQuery(s2);

		while (rs.next() != false) {
			System.out.println(rs.getInt("sno") + " " + rs.getString("sname") + " " + rs.getString("address"));
		}

		System.out.println("\nNow Table Dropping in Process....");

		// drop table student
		String s3 = "DROP TABLE STUDENT";
		st.executeUpdate(s3);
		System.out.println("\nTable Dropped Successfully");

		rs.close();
		st.close();
		con.close();

	}

}
