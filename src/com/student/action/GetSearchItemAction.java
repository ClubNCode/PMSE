package com.student.action;

import java.io.IOException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import org.apache.commons.beanutils.BeanUtils;
import com.student.Dao.DataDao;
import com.student.FormBean.DataFormBean;
import java.util.List;

public class GetSearchItemAction extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
         doPost(request, response);
         
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		 String path="";	
			
		   DataFormBean bean=new DataFormBean();	 
			System.out.println("Serach QUEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
			
			
			
			
			List<DataFormBean> list=new DataDao().getTFvalue();
			

			System.out.println("Serach QUEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE"+list);
			
			
			if(list.size()>0)
			{
				
			request.setAttribute("list1",list);
			path="IndexSearch.jsp?status=these are details";
			}
			else
			{
			path="IndexSearch.jsp?status=No details"	;
			}
			RequestDispatcher rd=request.getRequestDispatcher(path);
			try {
				rd.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}
