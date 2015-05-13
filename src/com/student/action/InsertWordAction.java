package com.student.action;

import java.io.IOException;


import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import com.student.Dao.DataDao;
import com.student.Dao.RegisterDAO;
import com.student.FormBean.RegisterFormBean;

public class InsertWordAction extends HttpServlet {

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
		HttpSession session=request.getSession();
		String login=(String)session.getAttribute("loginuser");	
		try{
		String word=request.getParameter("word");
		Random random = new Random();
		
		
		int randomInteger = random.nextInt(3);
		String subdata="Facilities";
		if(randomInteger==0)
		{
			subdata="Facilities";
		}
		if(randomInteger==1)
		{
			subdata="Hotel Locator";
		}
		if(randomInteger==2)
		{
			subdata="Reservation";
		}
		if(randomInteger==3)
		{
			subdata="Restaurant";
		}
			 flag=new DataDao().insetWord(login,word,subdata);
			 if(flag){
				 request.setAttribute("status", "word select  successfully");
				 path="./userselectdata11.jsp";
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
