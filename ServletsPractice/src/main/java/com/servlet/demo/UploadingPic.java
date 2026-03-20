package com.servlet.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/UploadingPic")
@MultipartConfig(maxFileSize = 40960)
public class UploadingPic extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		//part interface and use getPart method for a single file
		Part filePath = request.getPart("photo");
		InputStream is = filePath.getInputStream();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","nagendra17881");
			PreparedStatement ps = con.prepareStatement("insert into details values(?,?)");
			ps.setString(1, username);
			ps.setBinaryStream(2, is);
			int rows = ps.executeUpdate();
			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();
			if(rows>0) {
				pw.println("file uploaded successfully");
			}else {
				pw.println("file not uploaded");
			}
			pw.close();
			con.close();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
