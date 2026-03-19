package jdbc;
import java.sql.*;
import java.sql.DriverManager;

public class RetrieveData {

	public static void main(String[] args) throws Exception {
		String driver = "com.mysql.cj.jdbc.Driver";
		String db = "jdbc:mysql://localhost:3306/demo";
		String username = "root";
		String password = "nagendra17881";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(db,username,password);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from employee");
		System.out.println("EmpId EmpName Salary Team");
		while(rs.next()) {
			int empId = rs.getInt(1);
			String empName = rs.getString(2);
			int salary = rs.getInt(3);
			String team = rs.getString(4);
			System.out.println(empId + " " + empName + " " + salary + " "+ team);
		}

	}

}
