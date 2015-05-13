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
		<form action="./UploadDataAction" name="content"><center>
		
    <table border="2" width="360" height="200" style="width: 360px; height: 200px;">
    
  <tr>
       
    <td width="58"><span class="style17"><font color="higblue" size="4"><b>Doc:</b></font> </span></td>
    <td width="258">
    
    <textarea rows="2" cols="50"  name="doc" style="width:100%;text-align:"></textarea>
     </td>
     </tr>
     
      <tr>
       
    <td width="58"><span class="style17"><font color="higblue" size="4"><b>URLs:</b></font> </span></td>
     <td width="258">
    
    <textarea rows="2" cols="50"  name="url" style="width:100%;text-align:"></textarea>
     </td>
     </tr>
     
    <tr>
 <td width="58"><span class="style17"><font color="higblue" size="4"><b>Content:</b></font> </span></td>
 <td width="258">

<textarea rows="3" cols="50"  name="content" style="width:100%;text-align:">
</textarea>
</td>
</tr>
 <tr>
       
    <td width="58"><span class="style17"><font color="higblue" size="4"><b>Location:</b></font> </span></td>
   <td width="258">
    
    <textarea rows="2" cols="10"  name="location" style="width:100%;text-align:"></textarea>
     </td>
     </tr>
     <tr>
                                 <td width="258"><span class="style17"><font color="higblue" ><b>Upload File</b></font></span></td>
                                <td>
                                 
                         
                               <input type="file" name="upfile"/>
                                     
                                    
                                    
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
