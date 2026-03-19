package jdbc;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.*;
public class EfficentWay {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","nagendra17881");
		PreparedStatement ps = con.prepareStatement("select profilepic from profile");
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			//get data from database in streams
			InputStream is = rs.getBinaryStream("profilepic");
			FileOutputStream fos = new FileOutputStream("C:\\images\\hwasaismylover.jpeg");
			//creating a buffer
			byte[] buffer = new byte[1024];
			int bufferread;
			while((bufferread=is.read(buffer))!=-1) {
				fos.write(buffer,0,bufferread);
				
			}
			System.out.println("record downloaded successfully");
			fos.close();
			is.close();
			con.close();
			
		}

	}

}
