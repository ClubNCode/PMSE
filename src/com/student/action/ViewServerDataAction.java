package com.student.action;

import java.io.IOException;
import java.util.ArrayList;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.Dao.DataDao;
import com.student.FormBean.DataFormBean;
import com.student.Util.CoreList;



public class ViewServerDataAction extends HttpServlet {

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
	  
	 
	   
	  
	 
	  
	    ArrayList<DataFormBean> vqb= new DataDao().getServerData();				  								 
	  
	 
	  System.out.println("in Action class vcb userinfo..........."+vqb);
	  
	  
	  if(!vqb.isEmpty())
	  {
		  request.setAttribute("DataInfo", vqb);
		  path="ViewServerdata.jsp";
		  request.setAttribute("status","Server Data Information");
		  
		  
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
