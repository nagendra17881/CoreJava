package com.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/PrintDate")
public class PrintDate extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		Date date = new Date();
		pw.println("<center><h1>Today date is : "+ date.toString()+"</h1></center>");
		
	}

}
