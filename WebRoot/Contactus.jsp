<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    

  </head>
   <jsp:include page="Header.jsp"></jsp:include>
  <body background="images/c.gif">
   
   <fieldset><legend>Contact Details</legend>
   <table >
   <tr>
   <td><img src="images/cu3.jpeg">  </td>
   <td><font ><b>&nbsp;  
    
       Give U&nbsp; R Contact Details Here 
   </b>
   </font>
   </td>
   
   
   
   </tr>
   
   
   </table>
   </fieldset>  <br/>  <br/>
   <jsp:include page="./Footer.jsp"></jsp:include>
  </body>
</html>
