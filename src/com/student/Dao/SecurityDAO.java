package com.student.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.student.Db.ConnectionFactory;
import com.student.FormBean.LoginForm;





public class SecurityDAO {
	
	
	
	PreparedStatement pstmt,pstmt1;
	Statement stmt;
	ResultSet rs,rs1;
	Connection con;
	
	
	public SecurityDAO(){
		
		con=ConnectionFactory.getConnection();
		
	}

	public String loginCheck(LoginForm lf)
	 {
		 
		 String ltype="";
		 
		 try{
		 con=ConnectionFactory.getConnection();
		 
		 System.out.println("in DAo impl is..con is....."+con);
		 
		 pstmt=con.prepareStatement("select logintype ,userid from userdetails where loginid=? and password=?");
		 
		 String uname=lf.getUsername();
		 System.out.println("in Security DAO class.....uname is"+uname);
		 String pwd=lf.getPassword();
		 System.out.println("in Security DAO class.....password is"+pwd);
		 
		 pstmt.setString(1, uname);
		 pstmt.setString(2, pwd);
		 
		 rs=pstmt.executeQuery();
		 
		 
		 if(rs.next())
		 {
			 ltype=rs.getString(1);
			 System.out.println("in result set login type is........."+ltype);
			 int uid=rs.getInt(2);
			 
			 pstmt1=con.prepareStatement("insert into loginmaster (userid,logintime,logofftime) values(?,sysdate,null)");
			 pstmt1.setInt(1, uid);
			int i= pstmt1.executeUpdate();
			 
			 System.out.println("in login master rows update d======>"+i);
			 }
	
	 }
		 catch (SQLException e) {
			 
			 e.printStackTrace();
			System.out.println("Exception raised"+e);
		}
		 return ltype;
			
	
	 }

	 //Method for login audit
	    public void loginaudit(String loginid)
	    {
	        try 
	        { 
	        	
	        	 con=ConnectionFactory.getConnection();
	        	
	            CallableStatement cstmt=con.prepareCall("{call signoutprocedure(?)}");
	            cstmt.setString(1,loginid);
	            
	            System.out.println("in loginaudit");
	           cstmt.execute();
	           
	            con.close();
	        }
	        catch(Exception e)
	        {
	             
	            e.printStackTrace();
	            }
	    }
	
	
	
	
	
}
