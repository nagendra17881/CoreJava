package jdbc;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.*;
public class RetrieveTextFileFromDB {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","nagendra17881");
		PreparedStatement ps = con.prepareStatement("select resume from applicant where name=?");
		ps.setString(1, "nagendra");
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			InputStream is = rs.getBinaryStream("resume");
			FileOutputStream fos = new FileOutputStream("C:\\images\\resume.pdf");
			byte[] buffer = new byte[1024];
			int bytereader;
			while((bytereader=is.read(buffer))!=-1) {
				fos.write(buffer, 0, bytereader);
			}
		}else {
			System.out.println("record not in db");
		}
		con.close();
	}

}
