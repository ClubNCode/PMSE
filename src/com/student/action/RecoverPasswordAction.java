package com.student.action;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import com.student.Dao.SecurityDAO;
import com.student.Dao.RegisterDAO;
import com.student.FormBean.LoginForm;
import com.student.Util.LoggerManager;
import com.student.FormBean.RegisterFormBean;


public class RecoverPasswordAction extends HttpServlet {

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	private static Logger logger = Logger.getLogger(RecoverPasswordAction.class);
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String target = "Recoverpasswordfprm.jsp?status=<font color=red>Entries not Matched... Try Again</font>";;
	      try{
	    	  String password;
	    	  RegisterFormBean rb=new RegisterFormBean();
	          String loginid=request.getParameter("username");
	         String sanswer=request.getParameter("sanswer");
	          rb.setUserid(loginid);
	          rb.setSanswer(sanswer);
	          
	         String  squestid=request.getParameter("questn");
	          
	          
	          rb.setSquest(squestid);    
	              password=new RegisterDAO().passwordRecovery(rb);
	          if(password.equals("") || password==null){
	              target="./Recoverpassword.jsp";
	            	  request.setAttribute("status","Entries not Matched... Try Again");
	      }
	      else{
	             target="./LoginForm.jsp";
	             request.setAttribute("status","Password is----->"+password);
	        }
	}
	        catch(Exception e)
	        {
	           logger.error(e);
	        }
	        RequestDispatcher rd = request.getRequestDispatcher(target);
	        rd.forward(request,response);
	  
	}

}
