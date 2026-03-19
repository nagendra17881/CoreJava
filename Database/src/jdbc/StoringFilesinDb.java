package jdbc;
import java.io.File;
import java.io.FileInputStream;
import java.sql.*;
public class StoringFilesinDb {

	public static void main(String[] args) throws Exception {
		// using large objects(lob) we store files in db
		//blob(binary) -->to store images,audio,video
		//clob(charcater) -->text files,pdf files,xml file
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","nagendra17881");
		//converting image into binary format and storing it in db
		File file = new File("C:\\images\\k.jpeg");
		FileInputStream fis = new FileInputStream(file);
		PreparedStatement ps = con.prepareStatement("insert into profile values(?,?)");
		ps.setString(1, "hwasa");
		ps.setBinaryStream(2, fis);
		int rows = ps.executeUpdate();
		if(rows>0)
			System.out.println("record inserted successfully");
		else
			System.out.println("no record inserted in db");
		con.close();

	}

}
