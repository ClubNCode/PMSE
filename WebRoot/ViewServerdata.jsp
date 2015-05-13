
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%

 if(session.getAttribute("loginuser")==null){
 
   RequestDispatcher rd=request.getRequestDispatcher("./LoginForm.jsp");
   rd.forward(request,response);
   String path = request.getRealPath("/document");
   
 %>
 <%} %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 <script type = "text/javascript" >
function disableBackButton()
{
window.history.forward();
}
setTimeout("disableBackButton()", 0);
</script>
<body>
</head>
  
	  	
<jsp:include page="Header.jsp"></jsp:include>
                   
		
<center><h3><font color="#D87093"><b><i>View All Server Data Details</b></font></h3></center>
   
  
      
     
    <table width="" border="2" align="center" bordercolor="green">
    
      <tr bgcolor="#50cccc">
        <td width="50"><div align="center" class="style8"><b>Doc</b></div></td>
        <td width="150"><div align="center" class="style8"><b>URLs</b></div></td>
        <td width="350"><div align="center" class="style8"><b>Content</b></div></td>
        <td width="150"><div align="center" class="style8"><b>Location</b></div></td>     
         <td width="100"><div align="center" class="style8"><b>Action</b></div></td>
        
      </tr>
      
      <c:if test="${not empty DataInfo}">
      <c:forEach var="UserInfo" items="${DataInfo}">
         
      <tr bgcolor="#CEC9FA" >
    
         <td bgcolor="#F4F5F7" ><div align="center" class="style7"><a href="./WriteDocAction?s2=${UserInfo.data1 }">${UserInfo.doc}</a></div></td>
         <td bgcolor="#F4F5F7"><div align="left" class="style7">${UserInfo.url}</div></td>
        <td bgcolor="#F4F5F7"><div align="left"><span class="style7">${UserInfo.content }</span></div></td>
        <td bgcolor="#F4F5F7"><div align="left" class="style7">${UserInfo.location }</div></td>       
        <td bgcolor="#F4F5F7"><div align="center" class="style7"><a href="./DeleteDataAction?dataid=${UserInfo.dataid }">Delete</a></div></td>
     </tr>
      </c:forEach>
      </c:if>
      
      <c:if test="${ empty DataInfo}">
     
         <tr><td height="24" colspan="8"><div align="center" class="style3"><strong>No Records Found</strong></div></td>
         </tr>
    
         </c:if>
 </table>
 
 
 
 <br/><br/> <jsp:include page="Footer.jsp"></jsp:include>
</body></html>