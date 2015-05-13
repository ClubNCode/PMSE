package com.student.action;

import java.io.IOException;


import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import com.student.Dao.RegisterDAO;
import com.student.FormBean.RegisterFormBean;

public class DeleteUserAction extends HttpServlet {

	private static Logger logger = Logger.getLogger(DeleteUserAction.class);
	
	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

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
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path="";
		boolean flag=false;
		RequestDispatcher rd=null;
		try{
		int userid=Integer.parseInt(request.getParameter("userid"));
			 flag=new RegisterDAO().deleteUser(userid);
			 if(flag){
				 request.setAttribute("status", "User Information deteletd  successfully");
				 path="./ViewUsersAction?page=ViewCustomers.jsp";
			 }else{
				 request.setAttribute("status", "User Info deletion Failed");
				 path="./userhome.jsp";
			 }
		}catch (Exception e) {
			logger.info(e);
			logger.error(e);
			 request.setAttribute("status", "Category Detetion Failed plz try again");
			 path="./userhome.jsp";
		}
		rd=request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}
