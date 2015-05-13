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

public class UploadDataAction extends HttpServlet {

	
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
    String upfile=request.getParameter("upfile");
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
			
			 String rupfile = new StringBuffer(upfile).reverse().toString();
			 System.out.println(" reverse path is "+rupfile);
			  
			  StringTokenizer str1= new StringTokenizer(rupfile,"\\");
	           String tk1="";
	           System.out.println(" total tokens are "+str1.countTokens());
	        
	           while(str1.hasMoreElements())
	           {
	        	   i++;
	        	   
	        	   
	        	   tk1=str1.nextToken();
	        	   if(i==1)
	        	   {
	        	 token=tk1;
	        	 System.out.println(" retreved token "+token);
	        	   }
	        	  
	        	   
	           }
			  String filename=new StringBuffer(token).reverse().toString();
			  System.out.println(" file name in action class is"+filename);
	          wf.setFilename(filename);
	          
	          
	          
	          StringTokenizer st5=new StringTokenizer(upfile,".");
			  String type="";
			  String data="";
			  
		      while(st5.hasMoreElements())
		        {
		        
		         type =st5.nextToken();
		         System.out.println(" File type is +++++++++++++++"+type);
		        }
		       
	          
	          
	         
	          
	        
	            
	          if("docx".equalsIgnoreCase(type))
		        {
	        	try {
					data=new DataDao().getWordData(wf);
				} catch (SAXException e) {
					
					e.printStackTrace();
				} catch (ParserConfigurationException e) {
					
					e.printStackTrace();
				}
		        	 
	        	}
		        	 
		        	 
			  else
			       {
			 
		           BufferedReader br = new BufferedReader(new FileReader(upfile));
			
		           String line = br.readLine();
		         
			           while(line != null){
		                           
		                  // System.out.println(line);
		                   data = data+"\n"+line;
				   
				
		                   line = br.readLine();
		           }

		           br.close();


		           //System.out.println(data);   
		           
		           
		           
		           
			       }
		         
	          
	          
	          wf.setData(data);
                  System.out.println(" file pathi is"+upfile);
			       
			  wf.setFilepath(upfile);
			       
		          
		           
		//System.out.println(" Total number of blocks are "+i);
		
		
			
			
			
			
			
		flag= new DataDao().UploadData(wf);
		
		if(flag){
			request.setAttribute("status", "Data Uploded  successfully");
			path="./UploadWebpage.jsp";
			
		}
		else{
			request.setAttribute("status", "data Uploading failed");
			path="./UploadWebpage.jsp";
			
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
