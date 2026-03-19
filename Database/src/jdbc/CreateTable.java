package jdbc;
import java.sql.*;
public class CreateTable {

	public static void main(String[] args) throws Exception {
		//connecting to db using java programs through jdbc api
		String driver = "com.mysql.cj.jdbc.Driver";
		String db = "jdbc:mysql://localhost:3306/demo";
		String username = "root";
		String password = "nagendra17881";
		//Register the driver
		Class.forName(driver);
		//create a connection
		Connection con = DriverManager.getConnection(db,username,password);
		//create a statement
		Statement st = con.createStatement();
		//execute queries
		String qry = "create table employee(empId int,empName varchar(45),salary int,team varchar(45))";
		st.executeUpdate(qry);
		System.out.println("Table created successfully");
		//closing the connection
		con.close();
	}

}
