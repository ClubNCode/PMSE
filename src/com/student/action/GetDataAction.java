package com.student.action;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Vector;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.student.Dao.RegisterDAO;
import com.student.Dao.DataDao;
import com.student.FormBean.DataFormBean;


public class GetDataAction extends HttpServlet {

	
	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		String path="";
		
		 
		HttpSession session=request.getSession();
		DataFormBean dataFormBean=new DataFormBean();
		double count1=0.0;
		
		
		
		try
		{
			

			int count=(Integer)session.getAttribute("countdata");
			System.out.println("Count======="+count);
			int dataid=(Integer)session.getAttribute("dataid");
			System.out.println("Dataid======="+dataid);
			 dataFormBean.setDataid(dataid);
			 dataFormBean.setCountdata(count);
			 if(count>=5)
			 {
				 count1=count/2;
			 }
			 else 
			 {
		          count1=count+1;
			 }
			 System.out.println("count======="+count1);
			 double val=(10/count1);
			 System.out.println("val======="+val);
			 double idf=java.lang.Math.log(val);
			 System.out.println("Idf1======="+idf);
			 double tf=java.lang.Math.sqrt(val);
			 System.out.println("TF======="+tf);
			 double total=tf-idf;
			 System.out.println("Total======="+total);
			 dataFormBean.setIdf(idf);
			 dataFormBean.setTf(tf);
			 dataFormBean.setTotal(total);
			 
			 
			 
				boolean vqb=	new DataDao().CountData(dataFormBean);  								 
			
			  
			  if(vqb)
			  {
				  
				  path="./Frequent.jsp";
					request.setAttribute("UserInfo", vqb);
					
					
			  }
			  else {
				  
				  path="userhome.jsp";
				  request.setAttribute("status","Data Is Not Insert succesfully");
				
			}
		    }
			  
		  catch (Exception e) {
			e.printStackTrace();
			path="userhome.jsp";
			request.setAttribute("status","ata Is Not Insert succesfully");
		}

		  RequestDispatcher rd=request.getRequestDispatcher(path);
			rd.forward(request,response);	
	}
}
