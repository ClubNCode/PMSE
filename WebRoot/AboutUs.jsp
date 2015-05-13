<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <META HTTP-EQUIV=REFRESH CONTENT=5>
    <title>My JSP 'AboutUs.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <jsp:include page="Header.jsp"></jsp:include>
  <body>
  <fieldset>
  <legend><font color="purple">About Us</font></legend>
   <table>
   <tr>
   <td>
   <img src="images/a14.jpeg">
      </td>
      
   <td><font size="5" style="italic"> 
   
   Hello This is My Application
   
   </font>
   <br></td>
   
   </tr>
   
   
   
   </table>
   
   </fieldset>
   <br/>  <br/>  <br/>
    <jsp:include page="./Footer.jsp"></jsp:include>
  </body>
</html>
