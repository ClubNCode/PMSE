package com.student.action;

import java.io.IOException;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.student.Dao.DataDao;
import com.student.FormBean.DataFormBean;

public class InsertUserAction extends HttpServlet 

{


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
         doPost(request, response);
         
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		String path="";
		RequestDispatcher rd=null;
        boolean flag=false;
        DataFormBean  wf=new DataFormBean();
        HttpSession session=request.getSession();
       String query= (String)session.getAttribute("query");
        
	    Map map=request.getParameterMap();
		
		try{
			BeanUtils.populate(wf, map);
			
		}catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try{
			
			String login=(String)session.getAttribute("loginuser");	
			String ch[] = request.getParameterValues("ch");
			try {
				for (int i = 0; i < ch.length; i++) {
					System.out.println(ch[i]);
					flag = new DataDao().insetDetails(Integer.parseInt(ch[i]),login,query);
				}
			
			
		
		
		if(flag){
			request.setAttribute("status", " Select Data  successfully Inserted");
			path="./index.jsp";
	        }
		else{
			request.setAttribute("status", "data Uploading failed");
			path="./index.jsp";
			}
		}
	    catch (NullPointerException e) 
	    {
		e.printStackTrace();
		request.setAttribute("status", "Server busy plz try After some time");
		path="./UploadWebpage.jsp";
	     }
        rd=request.getRequestDispatcher(path);
        rd.forward(request, response);
		}finally
		{
	    }
		}
}
