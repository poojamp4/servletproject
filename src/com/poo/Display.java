package com.poo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//@WebServlet(value="/Display")
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//@WebServlet(value="/Display")
public class Display extends HttpServlet {
	
	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException
	{
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/details","root","root");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from Emp");
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