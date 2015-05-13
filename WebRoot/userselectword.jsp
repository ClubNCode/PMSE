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
       
     ArrayList<DataFormBean> vqb= new DataDao(). getServerData();	
       
 %>

</head>
<body>
   <form name='data' method='post' action="./userselectdata11.jsp"> 	
<jsp:include page="Header.jsp"></jsp:include>
                   
		

   
  
      
     </br>
    <table width="" border="2" align="center" bordercolor="green">
    
      <tr bgcolor="#50cccc">
    
        <td width="50"><div align="center" class="style8"><b>Doc</b></div></td>
        <td width="350"><div align="center" class="style8"><b>Content</b></div></td>
        <td width="150"><div align="center" class="style8"><b>Location</b></div></td>     
        
        
      </tr>
      
      
         <%
          Iterator it = vqb.listIterator();

						while (it.hasNext()) 
						{

							DataFormBean wb = (DataFormBean) it.next();           				
							  String data=wb.getData1();
							  String doc=wb.getDoc();
							  String location=wb.getLocation();
							  String content =wb.getContent();	
         %>
      <tr bgcolor="#CEC9FA" >
        
         <td bgcolor="#F4F5F7" ><div align="left" class="style7"><a href="./WriteDocAction?s2=<%=data %>}"><%=doc %></a></div></td>
         <td bgcolor="#F4F5F7"><div align="left"><span class="style7"><%=content %></span></div></td>
         <td bgcolor="#F4F5F7"><div align="left" class="style7"><%=location %></div></td>       
        
     </tr>
  <% 
  }
  %>
      
      
 </table>
 
</br><center>
 <table>
 <tr>
					<td align='center' colspan='8'>
						<input type="submit" value="Submit" />
					</td>
				</tr>
			</table></center>
  </br>
   </br>
    </br>
     </br>
      </br>
 </form>
 <br/><br/> <jsp:include page="Footer.jsp"></jsp:include>
</body></html>