package com.student.Dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.student.Db.ConnectionFactory;
import com.student.FormBean.RegisterFormBean;
import com.student.Util.CoreList;
import com.student.Util.DateWrapper;
import com.student.Util.LoggerManager;
import com.student.Dao.RegisterDAO;

import org.apache.log4j.Logger;



public class RegisterDAO {
	
	
	PreparedStatement pstmt,pstmt1,pstmt2,pstmt3;
	Statement stmt;
	ResultSet rs,rs1;
	Connection con;
	private static Logger logger = Logger.getLogger(RegisterDAO.class);
	
	
	
	public RegisterDAO(){
		
		con=ConnectionFactory.getConnection();
		
	}
	
	public boolean insertNewUser(RegisterFormBean cp) throws FileNotFoundException
    
    {
    	boolean flag=false;
    	int insert=0;
    	int j=0;
    	try{	    		
    		
    		con.setAutoCommit(false);
	    	System.out.println("in registerDAO connection is ."+con);	
	    	
            pstmt=con.prepareStatement("insert into userdetails values((select nvl(max(userid),1000)+1 from userdetails),?,?,?,sysdate,?,?,?,?,?,?,?)");	            		    		
    		System.out.println();
    		String photo =cp.getPhoto();
    		
    		String dob=DateWrapper.parseDate(cp.getDob());
    		System.out.println(" in dao dob"+dob);
    		
    		String fname=cp.getFname();
    		String lname=cp.getLname();
    		String squestion=cp.getQuestn();
    		String ans=cp.getAnsr();
    		String email=cp.getEmail();
    		String phone=cp.getMobile();
    		
    	
    		
    		String loginid=cp.getUserid();
    		String pwd=cp.getUserpwd();	    			    		
    		String hno=cp.getHno();
    		String street=cp.getStreet();
    		String city=cp.getCity();
    		String state=cp.getState();
    		String country=cp.getCountry();
    		String pin=cp.getPin();	    		
    		System.out.println("photo="+photo);
        	File f=new File(photo);
        	FileInputStream fis=new FileInputStream(f); 
        	System.out.println("fole="+f.length());	        	
        	
        		    		        	
            pstmt.setString(1, fname);
            pstmt.setString(2, lname);
            pstmt.setString(3, dob);
            pstmt.setString(4, loginid);
            pstmt.setString(5, pwd);
            pstmt.setString(6, "user");
            pstmt.setString(7, squestion);
            pstmt.setString(8, ans);
           
          
          pstmt.setBinaryStream(9, fis,(int)f.length());
        
          pstmt.setString(10, email);
        
          int i=pstmt.executeUpdate();
          
          if(i>0)
          {	        	  
        	  pstmt1=con.prepareStatement("insert into addresses values((select max(userid) from userdetails),?,?,?,?,?,?,?)");	        	  	        	  
        	  pstmt1.setString(1, hno);
        	  pstmt1.setString(2, street);
        	  pstmt1.setString(3, city);
        	  pstmt1.setString(4, state);
        	  pstmt1.setString(5, country);
        	  pstmt1.setString(6,pin);
        	  pstmt1.setString(7, phone);
        	  
        	  insert=pstmt1.executeUpdate();
        	  }	          	          
          
          
          if(insert>0){
        	  flag=true;
	          con.commit();
	         }
	         else
	         {
	        	 flag=false;
	        	 con.rollback();
	         }
	    } 
	    catch (SQLException e) 
	    {
	        e.printStackTrace();
	        flag=false;
	        try 
	        {
	            con.rollback();
	        } 
	        catch (SQLException se) 
	        {
	            se.printStackTrace();
	        }
	    }
	    
	    finally
		{
		 try{
			 if(con!=null)
				 con.close();				 
		 }
		 catch(SQLException e){
			 
			 e.printStackTrace();
		 }
		}
	return flag;
}
	
	
	
	public ArrayList<RegisterFormBean> getUserInfo(String path)
    {
		ArrayList<RegisterFormBean> arb =null;
     
    	
    	
		String userid="";
		
		
		
		try {
			
			pstmt = con.prepareStatement("select u.userid,u.logintype,u.loginid,u.password,u.firstname,u.lastname,TO_CHAR(u.dob,'DD-MM-YYYY'),u.emailid,u.photo,a.phone from userdetails u ,addresses a where u.logintype ='user' and u.userid=a.userid");
			
			//pstmt.setString(1,"user");
  		     rs = pstmt.executeQuery();
		   
		     arb=new ArrayList<RegisterFormBean>();
			
			
	while(rs.next())
			{
				
		RegisterFormBean	rb=new RegisterFormBean();
		
				userid=rs.getString(1);
				
              		
				rb.setUserid(userid);
				rb.setLogintype(rs.getString(2));
				rb.setLogin(rs.getString(3));
				rb.setUserpwd(rs.getString(4));
				
				rb.setFname(rs.getString(5));
				rb.setLname(rs.getString(6));
				rb.setDob(rs.getString(7));
				rb.setEmail(rs.getString(8));
			
				Blob b=rs.getBlob(9);
				if(b!=null){
				byte b1[]=b.getBytes(1,(int)b.length());//new byte[(int)b.length()];
				//InputStream in=photo.getBinaryStream();
				OutputStream fout=new FileOutputStream(path+"/"+ userid+".jpg");
				fout.write(b1);
			
				rb.setPhoto(userid+".jpg");
				}
				rb.setMobile(rs.getString(10));
				
				arb.add(rb);
				}
				
				
				
			
    	}
    	catch(Exception se)
    	{
    		se.printStackTrace();
    	}
    	
    	return arb;
    }  
	
	
	
	
	public RegisterFormBean getprofile(String name,String path)
    {
		CoreList aCoreList = new CoreList();
     
    	
    	
    	RegisterFormBean rb=null;
		aCoreList.clear();
		
		String userid="";
		String ltype="";
		
		
		try {
			
			pstmt1=con.prepareStatement("select logintype from userdetails where loginid=?");
			pstmt1.setString(1, name);
			
			rs1=pstmt1.executeQuery();
			
			while(rs1.next()){
				
				ltype=rs1.getString(1);
				
			}
			
			pstmt = con.prepareStatement("select u.userid,u.logintype,u.firstname,u.lastname,TO_CHAR(u.dob,'DD-MM-YYYY'),u.emailid,u.photo,a.phone,a.houseno,a.street,a.city,a.state,a.country,a.pincode from userdetails u ,addresses a where u.logintype =? and u.userid=a.userid and u.loginid=?");
			
			pstmt.setString(1,ltype);
			pstmt.setString(2, name);
		     rs = pstmt.executeQuery();
			while(rs.next())
			{
				
				rb=new RegisterFormBean();
				userid=rs.getString(1);
			
				rb.setUserid(userid);
				rb.setLogintype(rs.getString(2));
				rb.setFname(rs.getString(3));
				rb.setLname(rs.getString(4));
				rb.setDob(rs.getString(5));
				rb.setEmail(rs.getString(6));
			
				Blob b=rs.getBlob(7);
				if(b!=null){
				byte b1[]=b.getBytes(1,(int)b.length());//new byte[(int)b.length()];
				//InputStream in=photo.getBinaryStream();
				OutputStream fout=new FileOutputStream(path+"/"+ userid+".jpg");
				fout.write(b1);
			
				rb.setPhoto(userid+".jpg");
				
				rb.setMobile(rs.getString(8));
				
				rb.setHno(rs.getString(9));
				rb.setStreet(rs.getString(10));
				rb.setCity(rs.getString(11));
				rb.setState(rs.getString(12));
				rb.setCountry(rs.getString(13));
				rb.setPin(rs.getString(14));
				
				}
				
			}	
    	}
    	catch(SQLException se)
    	{
    		LoggerManager.writeLogWarning(se);
    	}
    	catch(Exception e)
    	{
    		LoggerManager.writeLogWarning(e);
    	}
    	finally
    	{
    		try
    		{
    			con.close();
    		}
    		catch(SQLException se)
    		{
    			LoggerManager.writeLogWarning(se);
    		}
    	}
    	return rb;
    }  
	
	
	public String passwordRecovery(RegisterFormBean rto){
    	String password="";
        try{
        	
        	 String question=rto.getSquest();
			 String ans=rto.getSanswer();
			 String loginid=rto.getUserid();
			
			 
			 System.out.println(question);
			 System.out.println(ans);
			 System.out.println(loginid);
        	pstmt=con.prepareStatement("select password from userdetails where loginid=? and forgotpwquestion=? and forgotpwanswer=?");
        	pstmt.setString(1, loginid);
        	pstmt.setString(2, question);
        	pstmt.setString(3, ans);
        	rs=pstmt.executeQuery();
        	if(rs.next()){
        		password=rs.getString(1);
        	}
        }catch(SQLException e){
        	e.printStackTrace();
        }
    	return password;
    }
 
 
 public boolean checkAvailability(String userid){
    	boolean flag=false;
    	try{
    		pstmt=con.prepareStatement("select userid from userdetails where loginid=?");
    		pstmt.setString(1, userid);
    		rs=pstmt.executeQuery();
    		if(rs.next()){
    			flag=true;
    		}
    	}catch(SQLException e){
    		e.printStackTrace();
    	}
    	return flag;
    }
    
 
 public boolean deleteUser(int userid){
	   
	   
	   boolean flag=false;
	   
	   try{
		   
		   pstmt=con.prepareStatement("delete from userdetails where userid=?");
		   
		   pstmt.setInt(1, userid);
		   
		   
		   int delete=pstmt.executeUpdate();
		   
		   if(delete>0)
	         {
    	  flag=true;
	          con.commit();
	         }
	         else
	         {
	        	 flag=false;
	        	 con.rollback();
	         }
	    } 
	    catch (SQLException e) 
	    {
	    	logger.error(e);
	        flag=false;
	        try 
	        {
	            con.rollback();
	        } 
	        catch (SQLException se) 
	        {
	        	logger.error(e);
	        }
	    }
	    
	    finally
		{
		 try{
			 if(con!=null)
				 con.close();				 
		 }
		 catch(SQLException e){
			 
			 logger.error(e);
		 }
		}
	return flag;
 
 
 
 }
 
 
 
 public boolean changePass(RegisterFormBean rto){
    	boolean flag=false;
    	try{
    		
    
    		
    		String newpass=rto.getNewpassword();
    		System.out.println("in DAO class//////////////////"+newpass);
    		String user=rto.getUsername();
    		System.out.println("in DAo ............login .is........."+user);
    		String oldpass=rto.getOldpassword();
    		
    		pstmt=con.prepareStatement("update userdetails set password=? where loginid=? and password=?");
    		pstmt.setString(1, newpass);
    		pstmt.setString(2, user);
    		pstmt.setString(3, oldpass);
    		int c=pstmt.executeUpdate();
    		if(c>0){
    			flag=true;
    			con.commit();
    		}
    	}catch(SQLException e){
    		e.printStackTrace();
    	}
    	return flag;
    }
 
 
 
 
 
 
 
 

}
