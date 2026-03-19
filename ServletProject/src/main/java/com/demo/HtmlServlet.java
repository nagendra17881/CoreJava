package com.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/HtmlServlet")
public class HtmlServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setContentType("text/xml");
//		response.setContentType("application/ms-word");
		response.setContentType("application/vnd.ms-excel");
		PrintWriter pw = response.getWriter();
		 pw.println("<table border='1'>");

	        pw.println("<tr>");
	        pw.println("<th>Name</th>");
	        pw.println("</tr>");

	        pw.println("<tr>");
	        pw.println("<td>John</td>");
	        pw.println("</tr>");

	        pw.println("</table>");
	}

}
