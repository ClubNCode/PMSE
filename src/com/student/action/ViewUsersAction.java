package com.student.action;

import java.io.IOException;
import java.util.ArrayList;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.Dao.RegisterDAO;
import com.student.FormBean.RegisterFormBean;
import com.student.Util.CoreList;



public class ViewUsersAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {


doPost(request, response);



}


public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

String path="";

  try{
	  
	 
	    String path1=request.getRealPath("/userimages");
	  
	 
	  
	    ArrayList<RegisterFormBean> vqb= new RegisterDAO().getUserInfo(path1);				  								 
	  
	 
	  System.out.println("in Action class vcb userinfo..........."+vqb);
	  
	  
	  if(!vqb.isEmpty())
	  {
		  request.setAttribute("UserInfo", vqb);
		  path="ViewCustomers.jsp";
		  request.setAttribute("status","Here Is The Users Info");
		  if(request.getParameter("page")!=null)
		  {
			  request.setAttribute("status","User Deleted Success");
				 
		  }
		  
		 }
	  else {
		  
		  path="userhome.jsp";
		  request.setAttribute("status","No Users  Available ");
		
	}
	  
}
  catch (Exception e) {
	e.printStackTrace();
	path="userhome.jsp";
	request.setAttribute("status","No Users Available");
}


  RequestDispatcher rd=request.getRequestDispatcher(path);
	rd.forward(request,response);


}
}
