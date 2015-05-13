package com.student.action;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.student.Dao.SecurityDAO;
import com.student.FormBean.LoginForm;







public class LoginAction extends HttpServlet {

	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		   String role="";
		
		String target ="";
		
		HttpSession session=request.getSession();
		
		LoginForm lf=new LoginForm();
		
		String username = request.getParameter("username");
		lf.setUsername(username);
		String pass=request.getParameter("password");
		lf.setPassword(pass);
		try{
			
		
             
		     role = new SecurityDAO().loginCheck(lf);
		
		
			System.out.println("in LoginAction Role is.........."+role);

			if (role.equalsIgnoreCase("admin"))
			{
				
				request.setAttribute("status","Welcome "+ username);
				
				target = "./userhome.jsp";
				
				session.setAttribute("loginuser", username );
				session.setAttribute("role", role);
				session.setAttribute("password",pass);
				
			}
			else if (role.equalsIgnoreCase("user"))
			{
				
                request.setAttribute("status","Welcome " + username );
				 target = "./userhome.jsp";
				session.setAttribute("loginuser", username );
				session.setAttribute("role", role);
				session.setAttribute("password",pass);
				
			}
			
			else
			{
				request.setAttribute("status", "Invalid username&password");
				target = "./LoginForm.jsp";
			}
		}catch (Exception e) {
		
			e.printStackTrace();
			
		}
		
			RequestDispatcher rd = request.getRequestDispatcher(target);
			rd.forward(request, response);
				
	  }

}
