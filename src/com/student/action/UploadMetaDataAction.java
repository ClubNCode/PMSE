package com.student.action;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.beanutils.BeanUtils;
import org.xml.sax.SAXException;
import com.student.Dao.DataDao;
import com.student.FormBean.DataFormBean;

public class UploadMetaDataAction extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
         doPost(request, response);
         
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	int i=0;		
     String path="",token="";
	RequestDispatcher rd=null;
    boolean flag=false;
  
    DataFormBean  wf=new DataFormBean();
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
			HttpSession session=request.getSession();
			
			String login=(String)session.getAttribute("loginuser");
			
			
			
			
		flag= new DataDao().insetmeatadata(wf);
		
		if(flag){
			request.setAttribute("status", "Data Uploded  successfully");
			path="./UploadMetaData.jsp";
			
		}
		else{
			request.setAttribute("status", "data Uploading failed");
			path="./UploadMetaData.jsp";
			
		}
		}catch (NullPointerException e) {
		e.printStackTrace();
		request.setAttribute("status", "Server busy plz try After some time");
		path="./UploadWebpage.jsp";
	}
        rd=request.getRequestDispatcher(path);
        rd.forward(request, response);
		
		
	}

}
