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
       
       
       int count= new DataDao().getCalculation1();	
       double count1=(double)count;
     ArrayList<DataFormBean> vqb= new DataDao(). getCalculation();	
       
 %>

</head>
<jsp:include page="Header.jsp"></jsp:include>
<body>

<center><h3><font color="#D87093"><b><i>View Ranking</b></font></h3></center>

   </br>
    <table width="" border="2" align="center" bordercolor="green">
    
      <tr bgcolor="#50cccc">
        <td width="100"><div align="center" class="style8"><b>Rank</b></div></td>
        <td width="150"><div align="center" class="style8"><b>Data</b></div></td>
        <td width="100"><div align="center" class="style8"><b>Count</b></div></td>
        <td width="150"><div align="center" class="style8"><b>Ranking function Value</b></div></td>     
        
        
      </tr>
      
      
         <%
         int i=1;
          Iterator it = vqb.listIterator();

						while (it.hasNext()) 
						{

							DataFormBean wb = (DataFormBean) it.next();           				
							  String data=wb.getSuperdata();
							 int cnt=wb.getCount();
							 double cnt1=(double)cnt;
							  double cal=(cnt1/count1);
							  cal = Math.round( cal * 100.0 ) / 100.0;
         %>
      <tr bgcolor="#CEC9FA" >
        
         <td bgcolor="#F4F5F7"><div align="center"><span class="style7">Rank<%=i %></span></div></td>
         <td bgcolor="#F4F5F7"><div align="left"><span class="style7"><%=data %></span></div></td>
         <td bgcolor="#F4F5F7"><div align="center" class="style7"><%=cnt %></div></td>       
         <td bgcolor="#F4F5F7"><div align="center" class="style7"><%=cal %></div></td>       
        
     </tr>
  <% 
  i++;
  }
  i=1;
  %>
      
      
 </table>
 

 
 <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/> <jsp:include page="Footer.jsp"></jsp:include>
</body></html>