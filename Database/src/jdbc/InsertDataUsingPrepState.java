package jdbc;
import java.sql.*;
public class InsertDataUsingPrepState {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","nagendra17881");
		PreparedStatement ps = con.prepareStatement("insert into employee values(?,?,?,?)");
		ps.setInt(1, 503);
		ps.setString(2, "jennifer");
		ps.setInt(3, 50000);
		ps.setString(4, "black angel");
		int rows = ps.executeUpdate();
		if(rows>0)
			System.out.println("Record inserted successfully");
		else
			System.out.println("No record inserted");
		con.close();
	}

}
