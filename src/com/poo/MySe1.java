package com.poo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet(value="/MySe1")
public class MySe1 extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException
	{
		String s= request.getParameter("admin");
		String s1 = request.getParameter("pass");
				
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		
		
		if(s.equals("admin")&&s1.equals("root"))
		{
			/*out.print("<h1>WelCome!! to Admin Page</h1>");
			out.print("<p><a href=\"http://localhost:8080/PoojaServlet/add.html\">Add</a></p>");
			out.print("<p><a href=\"http://localhost:8080/PoojaServlet/delete.html\">Delete</a></p>");
			out.print("<p><a href=\"http://localhost:8080/PoojaServlet/display.html\">Display</a></p>");*/
			RequestDispatcher rd=request.getRequestDispatcher("/adminhome.html");  
	        rd.forward(request, response); 
		}
		else if((!s.equals("admin")) && (!s1.equals("root") ))
		{
			
			RequestDispatcher rd=request.getRequestDispatcher("/update.html");  
	        rd.include(request, response); 
		}else
		{
		   out.print("incorrect admin name and password");
		   RequestDispatcher rd=request.getRequestDispatcher("/login.html");  
	        rd.include(request, response); 
		   
		}
		/*if(s.equals(s) && s1.equals(s1))
		{
			RequestDispatcher rd=request.getRequestDispatcher("/add.html");  
	        rd.forward(request, response);
		}*/
	}

}
