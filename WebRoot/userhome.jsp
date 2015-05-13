    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%

 if(session.getAttribute("loginuser")==null){
 
   RequestDispatcher rd=request.getRequestDispatcher("./LoginForm.jsp");
  rd.forward(request,response);
   
 %>
 <%} %>
    
    <html>
    <head>
    
    <script type = "text/javascript" >
function disableBackButton()
{
window.history.forward();
}
setTimeout("disableBackButton()", 0);
</script>
 </head>
    <body onload="javascript:disableBackButton()">
    
    <jsp:include page="Header.jsp"></jsp:include>
    <br/>
    
    <center>
    <table>
    
    <c:if test="${sessionScope.role!='null'}">
		
   				<c:choose>
   				<c:when test="${sessionScope.role=='admin'}">
             
             <h2><font color="watblue">Welcome To Admin Home</font></h2>
              <table bgcolor="#D3D3D3" align="center">
   <tr>
   <td colspan="1" align="right" valign="top"><img src="<%=request.getContextPath()+"/images/aa.jpeg"%>" align="top" /></td>
   
   <td>
  <label >
  <fieldset>
         <legend><b><font color="purple">This Is Administrator</font></b></legend>
<br />
  
 <p>Welcome to Admin.. </p>
  <div align="center"><span class="style2"><br />
  </span></div>
  </fieldset>
  
  </label>
  </td>
  </tr>
  </table>
   				
   				</c:when>
   		        
   				
   				
   				
			    			
				
   				<c:when test="${sessionScope.role=='user'}">
   				<h2><font color="watblue">Welcome To User Home</font></h2>
   				 <table bgcolor="#B0E0E6" align="center">
   <tr>
   <td colspan="1" align="right" valign="top"><img src="<%=request.getContextPath()+"/images/u4.jpeg"%>" align="top"  height="175"/></td>
   
   <td>
  <label >
  <fieldset>
         <legend><b><font color="hblue">This Is User World</font></b></legend>
  Welcome to User..
  <div align="center"><span class="style2"><br />
  </span></div>
  </fieldset>
  
  </label>
  </td>
  </tr>
  </table>
   				</c:when>
   
					</c:choose>
					</c:if>
		</table>
    
    
    
    </center>
    
		<br/>
		
		<jsp:include page="Footer.jsp"></jsp:include>
		</body>
		</html>
		