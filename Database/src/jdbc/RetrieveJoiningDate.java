package jdbc;
import java.sql.*;
import java.util.Scanner;
public class RetrieveJoiningDate {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the empId: ");
		int id = sc.nextInt();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","nagendra17881");
		PreparedStatement ps = con.prepareStatement("select joiningDate from employees where empId=?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			Date JoiningDate = rs.getDate(1);
			System.out.println("joining date of employee with id " + id +" is "+JoiningDate);
		}
		else {
			System.out.println("no such record found in db");
		}
		con.close();
		sc.close();

	}

}
