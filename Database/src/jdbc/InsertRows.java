package jdbc;
import java.sql.*;
public class InsertRows {

	public static void main(String[] args) throws Exception {
		String driver = "com.mysql.cj.jdbc.Driver";
		String db = "jdbc:mysql://localhost:3306/demo";
		String username = "root";
		String password = "nagendra17881";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(db,username,password);
		Statement st = con.createStatement();
		int rows = st.executeUpdate("insert into employee values(501,'john',23000,'black rock'),(502,'joe',53000,'cts')");
		if(rows>0)
			System.out.println("record inserted successfully");
		else
			System.out.println("no records inserted");
		con.close();
	}

}
