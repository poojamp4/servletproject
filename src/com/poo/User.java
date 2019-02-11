package com.poo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class User extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException
	{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		String id=req.getParameter("id");
		int EmpId=Integer.valueOf(id);
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/details","root","root");
			PreparedStatement stmt=con.prepareStatement("select * from Emp where EmpId=?");
			stmt.setInt(1, EmpId);
			ResultSet rs=stmt.executeQuery();
			
			out.print("<table border='2'>");
			out.print("<tr>");
			out.print("<th>EmpId</th>");
			out.print("<th>EmpName</th>");
			out.print("<th>City</th>");
			out.print("<th>Age</th>");
			out.print("</tr>");
			while(rs.next())
			{ 
				String i=rs.getString("EmpId");
				String n=rs.getString("EmpName");
				String c=rs.getString("City");
				String a=rs.getString("Age");
			    out.print("<tr>");
			    out.print("<th>"+i+"</th>");
				out.print("<th>"+n+"</th>");
				out.print("<th>"+c+"</th>");
				out.print("<th>"+a+"</th>");
				out.print("</tr>");
			}
			out.print("</table>");	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}