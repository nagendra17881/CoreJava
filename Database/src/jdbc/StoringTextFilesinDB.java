package jdbc;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.sql.*;
public class StoringTextFilesinDB {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","nagendra17881");
		PreparedStatement ps = con.prepareStatement("insert into applicant values(?,?)");
		ps.setString(1, "nagendra");
		File file = new File("C:\\images\\Nagendra_Resume_2026.pdf");
		FileReader fr = new FileReader(file);
		ps.setCharacterStream(2, fr);
		int rows = ps.executeUpdate();
		if(rows>0)
			System.out.println("file uploaded successfully");
		else
			System.out.println("recorded not uploaded");
		fr.close();
		con.close();
	}

}
