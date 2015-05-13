<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>




<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  
  <body>
   
   <table align="center">
			
			
			<tr>
				<td colspan="1" width="900" height="120" valign="top"><img src="<%=request.getContextPath()+"/images/mobile-seo.jpg" %>" align="top" height="120" width="900"/></td>
			</tr>
			<tr>
				<td align="center"><marquee  behavior="alternate" scrollamount="2"><font color="seaw" size="5"><b><i>PMSE :</i></b></font>  <font color="#blue" size="5"> <b><i>A Personalized </i></b></font><font color="#003366" size="5"><b><i>Mobile Search Engine</i></b></font></marquee></td>
			</tr>
	<tr>
		 
		  <td>
		<c:choose>
   				<c:when test="${sessionScope.role eq 'admin'}">
   				<jsp:include page="./AdminMenu.jsp"></jsp:include>
   				</c:when>
   		        
   				
   				<c:when test="${sessionScope.role eq 'user'}">
   				<jsp:include page="./UserMenu.jsp"></jsp:include>
   				
   				</c:when>
                 
                 
								<c:otherwise>
								<jsp:include page="./Menu.jsp"></jsp:include>
								</c:otherwise>
						
					</c:choose>
					
		</table>
		
		
		
		 <center>
   <font color="red"><b>
		 <c:if test="${requestScope.status!='null'}">
					 
                          <c:out value="${requestScope.status}"></c:out> 
                          </c:if>
                          
                          </font>
                         
                           </center>
		
   
   
  </body>
</html>
