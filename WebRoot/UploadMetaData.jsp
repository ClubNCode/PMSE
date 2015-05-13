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
    
                 <caption><font color="#708090"><i><b>Upload Content Here</b></i> </font></caption>
		<form action="./UploadMetaDataAction" name="content"><center>
		
    <table border="2" width="360" height="200" style="width: 360px; height: 200px;">
    
  <tr>
       
    <td width="58"><span class="style17"><font color="higblue" size="4"><b>SuperData</b></font> </span></td>
    <td width="258">
    
    <textarea rows="1" cols="50"  name="superdata" style="width:100%;text-align:"></textarea>
     </td>
     </tr>
     <tr>
       
    <td width="58"><span class="style17"><font color="higblue" size="4"><b>SubData:</b></font> </span></td>
    <td width="258">
    
    <textarea rows="1" cols="50"  name="subdata" style="width:100%;text-align:"></textarea>
     </td>
     </tr>
     
     
       
    
    
    
  
        </table></br>
        </center>                   
                             
            <center>   <table>              
     <tr>  <td> </td><td align="left"><input type="image"  alt="submit" value="UpLoad" src="images/upl.png" height="60" width="150" onclick="javascript:validate();"></td>
                  
                  
                             
                              </tr>
    </table></center>
    
    
    
<br/>
			
                 
    </form>
    
    
     
         
  </body>
</html>
