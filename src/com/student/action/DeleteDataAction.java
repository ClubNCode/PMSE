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

import com.student.Dao.DataDao;
import com.student.Dao.RegisterDAO;
import com.student.FormBean.RegisterFormBean;

public class DeleteDataAction extends HttpServlet {

	private static Logger logger = Logger.getLogger(DeleteUserAction.class);
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path="";
		boolean flag=false;
		RequestDispatcher rd=null;
		try{
		int dataid=Integer.parseInt(request.getParameter("dataid"));
			 flag=new DataDao().deleteData(dataid);
			 if(flag){
				 request.setAttribute("status", "Data Information deteletd  successfully");
				 path="./ViewServerDataAction?page=ViewServerdata.jsp";
			 }else{
				 request.setAttribute("status", "Data Info deletion Failed");
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
