package jdbc;
import java.sql.*;
public class InsertDataUsingProcedures {

	public static void main(String[] args) throws Exception {
		//to execute stored procedures we use callable statement
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","nagendra17881");
		CallableStatement cs = con.prepareCall("call addEmployees(?,?,?,?)");
		cs.setInt(1, 505);
		cs.setString(2, "rock");
		cs.setInt(3, 40000);
		cs.setString(4, "white devil");
		int rows = cs.executeUpdate();
		if(rows>0)
			System.out.println("inserted record successfully");
		else
			System.out.println("no record inserted");
		con.close();
	}

}
