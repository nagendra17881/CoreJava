package jdbc;
import java.io.FileOutputStream;
import java.sql.*;
public class RetrieveImgfromDB {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","nagendra17881");
		PreparedStatement ps = con.prepareStatement("select profilepic from profile where name=?");
		ps.setString(1, "hwasa");
		
		FileOutputStream fos = new FileOutputStream("C:\\images\\hwasa.jpeg");
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			fos.write(rs.getBytes("profilepic"));
			System.out.println("file downloaded successfully");
		}
		else {
			System.out.println("file not found");
		}
		fos.close();
		con.close();
		
	}

}
