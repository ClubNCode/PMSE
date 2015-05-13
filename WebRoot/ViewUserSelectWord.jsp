<%@page import="com.student.FormBean.DataFormBean"%>
<%@page import="com.student.Dao.DataDao"%>
<%@ page import="java.util.*" %>
<%@ page import="java.util.Enumeration" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%

 if(session.getAttribute("loginuser")==null){
 
   RequestDispatcher rd=request.getRequestDispatcher("./LoginForm.jsp");
  rd.forward(request,response);
   
 %>
 <%} %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 <%
        boolean b1=false;
       
     ArrayList<DataFormBean> vqb= new DataDao().collectData3();	
       
 %>

</head>
<body>
  
<jsp:include page="Header.jsp"></jsp:include>
                   
		

   <center><h3><font color="#D87093"><b><i>View User Select Word </b></font></h3></center>
  
      
     </br>
    <table width="" border="2" align="center" bordercolor="green">
    
      <tr bgcolor="#50cccc">
    
        <td width="100"><div align="center" class="style8"><b>S.No</b></div></td>
        <td width="200"><div align="center" class="style8"><b>UserName</b></div></td>
        <td width="200"><div align="center" class="style8"><b>Word</b></div></td>
         <td width="100"><div align="center" class="style8"><b>count</b></div></td>     
        
        
      </tr>
      
      
         <%
         int i=1;
          Iterator it = vqb.listIterator();

						while (it.hasNext()) 
						{

							DataFormBean wb = (DataFormBean) it.next();           				
							  String name=wb.getUsername();
							  String word=wb.getSubdata();
							  int count=wb.getCount();
         %>
      <tr bgcolor="#CEC9FA" >
        
         <td bgcolor="#F4F5F7" ><div align="center" class="style7"><%=i %></div></td>
         <td bgcolor="#F4F5F7"><div align="center"><span class="style7"><%=name %></span></div></td>
         <td bgcolor="#F4F5F7"><div align="center" class="style7"><%=word %></div></td> 
         <td bgcolor="#F4F5F7"><div align="center" class="style7"><%=count %></div></td>          
        
     </tr>
  <%
  i++; 
  }
  i=0;
  %>
      
      
 </table>
 

   </br>
    </br>
     </br>
      </br>
 </form>
 <br/><br/> <jsp:include page="Footer.jsp"></jsp:include>
</body></html>