package com.student.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserSearchInfoAction extends HttpServlet {

	
	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

doPost(request, response);
}


public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
	Database db= new Database();
	   System.out.println("in servlet");
	     try
	    {
	    	 HttpSession session = request.getSession();
	    	 
	 		 System.out.println("in login user="+session.getAttribute("loginuser"));
	         String query = request.getParameter("query");
	         System.out.println("query:" + query);
	         PrintWriter pw = response.getWriter();

	      
	                  Connection con=null;
	                  con=db.getConnection();
	                 
	 
	         Statement st = con.createStatement();
	 
	        ResultSet rs = st.executeQuery("select doc,url,content,location from serverdata where UPPER(url) LIKE UPPER('%"+query+"%') order by docid asc");
	      
	       while (rs.next())
	     {
		              String doc = rs.getString(1);
		              String url = rs.getString(2);
		              String content = rs.getString(3);
		              String location = rs.getString(4);
	                  
		               pw.println(doc);
		               pw.println(url);
	                   pw.println(content);
	                   pw.println(location);
	       } 
	    
	                
	    }
	     catch (Exception e)
	     {
	       System.out.println(e);
	     }
	   }
	 }

