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


//@WebServlet(value="/Add")
public class Add extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException
	{
		String i=req.getParameter("id");
		String n= req.getParameter("name");
		String c = req.getParameter("city");
		String a=req.getParameter("age");
		int j=0;
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
			try{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/details","root","root");
         		PreparedStatement pstm=con.prepareStatement("insert into Emp values(?,?,?,?)");
         		pstm.setString(1, i);
         		pstm.setString(2, n);
         		pstm.setString(3, c);
         		pstm.setString(4, a);
         		
				j=pstm.executeUpdate();
				
			if(j!=0)
				{
				out.println("inserted successfully"+j+"rows effected");
				RequestDispatcher rd=req.getRequestDispatcher("/user.html");
				rd.forward(req, res);
				}
				else
				{
					out.println("see all the information");
					RequestDispatcher rd=req.getRequestDispatcher("/user.html");  
			        rd.include(req, res); 
				}
			}
			catch(Exception e)
			{
			 e.printStackTrace();
			 out.print("no values are inserted"+j+"rows effected");	
			}
			
		}
}

			