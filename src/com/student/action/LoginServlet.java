package com.student.action;
 import java.io.IOException;
 import java.io.PrintStream;
import java.io.PrintWriter;
 import java.sql.Connection;
 import java.sql.DriverManager;
 import java.sql.ResultSet;
 import java.sql.Statement;
 import javax.servlet.ServletException;
 import javax.servlet.http.HttpServlet;
 import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
 public class LoginServlet extends HttpServlet
 {
   public void doGet(HttpServletRequest req, HttpServletResponse res)
     throws ServletException, IOException
   {
	                Database db= new Database();
   System.out.println("in servlet");
     try
    {
    	 HttpSession session = req.getSession();
    	 //String username=(String)session.getAttribute("loginuser");
    	// System.out.println("username:" + username);
         String username = req.getParameter("username");
         String password = req.getParameter("password");
         System.out.println("username:" + username);
         System.out.println("password:" + username);
         PrintWriter pw = res.getWriter();

      
                  Connection con=null;
                  con=db.getConnection();
                 
 
         Statement st = con.createStatement();
 
        ResultSet rs = st.executeQuery("select logintype from userdetails where loginid='"+username+"' and password='"+password+"'");
       
       while (rs.next())
     {
	              String logintype = rs.getString(1);
	            
	             
                  
	               pw.println(logintype);
	             
                 
       } 
    
                
    }
     catch (Exception e)
     {
       System.out.println(e);
     }
   }
 }

