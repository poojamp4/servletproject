package com.poo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Delete extends HttpServlet {
	
	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException
	{
	int j=0;
	String i=req.getParameter("id");
	res.setContentType("text/html");
	PrintWriter out = res.getWriter();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/details","root","root");
			//PreparedStatement pstm=con.prepareStatement("insert into Emp values('"+i+"','"+n+"''"+c+"',"+a+"')");
     		PreparedStatement pstm=con.prepareStatement("delete from Emp where EmpId=?");
     		pstm.setString(1, i);
     		j=pstm.executeUpdate();
			
			if(j!=0)
				{
				out.println("deleted successfully"+j+"rows effected");
				out.println("<p><a href=\"http://localhost:8080/PoojaServlet/display.html\">Display</a></p>");
					
				
				}
				else
				{
					out.println("enter correctly!!");
					RequestDispatcher rd=req.getRequestDispatcher("/delete.html");  
			        rd.include(req, res); 
				}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		}

}
