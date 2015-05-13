
<%@ page import="java.util.*" %>
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


</head>
<body>
  <form name='data' method='post' action="./InsertUserAction">
	  	
<jsp:include page="Header.jsp"></jsp:include>
                   
		
<center><h3><font color="#D87093"><b><i>View Search Data</b></font></h3></center>
   
  
      
     
    <table width="900" border="2" align="center" bordercolor="green">
    
      <tr bgcolor="#50cccc">
       <td width="50"><div align="center" class="style8"><b>Select</b></div></td>
        <td width="50"><div align="center" class="style8"><b>Doc</b></div></td>
        <td width="150"><div align="center" class="style8"><b>URLs</b></div></td>
        <td width="350"><div align="center" class="style8"><b>Content</b></div></td>
        <td width="150"><div align="center" class="style8"><b>Location</b></div></td>     
      
        
      </tr>
      
      <c:if test="${not empty DataInfo}">
      <c:forEach var="UserInfo" items="${DataInfo}">
         
      <tr bgcolor="#F4F5F7" >
          <td><div align="center" class="style7"><input name="ch" type="checkbox" id="checkbox2" onClick="check1()" value="${UserInfo.dataid }" /></div></td>
         <td bgcolor="#F4F5F7" ><div align="center" class="style7"><a href="./WriteDocAction?s2=${UserInfo.data1 }">${UserInfo.doc}</a></div></td>
         <td bgcolor="#F4F5F7"><div align="left" class="style7">${UserInfo.url}</div></td>
        <td bgcolor="#F4F5F7" width="350"><div align="left"><span class="style7">${UserInfo.content }</span></div></td>
        <td bgcolor="#F4F5F7"><div align="left" class="style7">${UserInfo.location }</div></td>       
       
     </tr>
      </c:forEach>
      </c:if>
      
      <c:if test="${ empty DataInfo}">
     
         <tr><td height="24" colspan="8"><div align="center" class="style3"><strong>No Records Found</strong></div></td>
         </tr>
    
         </c:if>
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