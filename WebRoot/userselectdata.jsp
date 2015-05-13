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
   String totalString=null;
      String str=null;
     
        boolean b1=false;
       
     ArrayList<DataFormBean> vqb= new DataDao().getSelectDatas();		
       Iterator it = vqb.listIterator();

						while (it.hasNext()) 
						{

							DataFormBean wb = (DataFormBean) it.next();

						
                            
						
							  String data=wb.getData1();
							  
							  
			 String res[] = data.split("LOCATION:");
	          System.out.println(res.length);
	          for (int k = 0; k < res.length; k++)
	          {
	              System.out.println(res[k]);
	          }
					    String[] stopWords = new String[]{" i ", " a ", " and ", " about ", " an ", " are ", " as ", " at ", " be ", " by ", " com ", " for ", " from ", " how ", " in ", " is ", " it ", " not ", " of ", " on ", " or ", " that ", " the ", " this ", " to ", " was ", " what ", " when ", " where ", " who ", " will ", " with ", " the ", " www " , " has ", " his ", " its ", " but ", " have ", " all ", " they ", " were "," / ", " : "};;
                       for (String stopword : stopWords) {
                      data = data.replaceAll("(?i)"+stopword, " ");
                        }
							  
	   
         String text =	data;
		int unique=0;	
		int duplicate=0;			  
		List<String> list = Arrays.asList(text.split(" "));
         Set<String> uniqueWords = new HashSet<String>(list);
        for (String word : uniqueWords) 
        
        {
            
            	str=str+","+word + ": " + Collections.frequency(list, word);
            	totalString=totalString+","+word;
            	if(Collections.frequency(list, word)==1)
            	{
            	unique++;
            	}	
            	  else
            	  {
            	  duplicate++;
            	  }
	   }	
		
        str=str.substring(5);
		System.out.println("str=="+str);  
		System.out.println("unique=="+unique); 
		System.out.println("duplicate=="+duplicate);      
		str=null;
      }

 %>

</head>
<body>
   <form name='data' method='post' action="./userselectdata1.jsp"> 	
<jsp:include page="Header.jsp"></jsp:include>
                   
		
<center><h3><font color="#D87093"><b><i>View User Select Data </b></font></h3></center>
   
  
      
     
    <table width="" border="2" align="center" bordercolor="green">
    
      <tr bgcolor="#50cccc">
      <td width="50"><div align="center" class="style8"><b>UserName</b></div></td>
      <td width="50"><div align="center" class="style8"><b>Query</b></div></td>
        <td width="50"><div align="center" class="style8"><b>Doc</b></div></td>
        <td width="350"><div align="center" class="style8"><b>Content</b></div></td>
        <td width="150"><div align="center" class="style8"><b>Location</b></div></td>     
        
        
      </tr>
      
      <c:if test="${not empty DataInfo}">
      <c:forEach var="UserInfo" items="${DataInfo}">
         
      <tr bgcolor="#CEC9FA" >
         <td bgcolor="#F4F5F7"><div align="center" class="style7">${UserInfo.username }</div></td>  
         <td bgcolor="#F4F5F7"><div align="left" class="style7">${UserInfo.query }</div></td>  
         <td bgcolor="#F4F5F7" ><div align="left" class="style7"><a href="./WriteDocAction?s2=${UserInfo.data1 }">${UserInfo.doc}</a></div></td>
         <td bgcolor="#F4F5F7"><div align="left"><span class="style7">${UserInfo.content }</span></div></td>
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