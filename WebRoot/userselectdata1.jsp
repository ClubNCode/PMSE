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
      
     

 %>

</head>
<body>
  
	  <form name='data' method='post' action="./userselectdata2.jsp">  	
<jsp:include page="Header.jsp"></jsp:include>
                   
		
<center><h3><font color="#D87093"><b><i>View Data </b></font></h3></center>
   
  
      
     
    <table width="" border="2" align="center" bordercolor="green">
    
      <tr bgcolor="#50cccc">
      <td width="50"><div align="center" class="style8"><b>UserName</b></div></td>
      <td width="50"><div align="center" class="style8"><b>Query</b></div></td>
        <td width="50"><div align="center" class="style8"><b>Doc</b></div></td>
        <td width="350"><div align="center" class="style8"><b>Content</b></div></td>
        <td width="150"><div align="center" class="style8"><b>Location</b></div></td>     
        
        
      </tr>
      
     <% 
     
     
      Iterator it = vqb.listIterator();

						while (it.hasNext()) 
						{

							DataFormBean wb = (DataFormBean) it.next();					
                            String name=wb.getUsername();
                            String query=wb.getQuery();
                            String doc=wb.getDoc();
						    String data=wb.getData1();
					  
			             String data1=null;
    
     
     %>
         
      <tr bgcolor="#CEC9FA" >
         <td bgcolor="#F4F5F7"><div align="center" class="style7"><%=name %></div></td>  
         <td bgcolor="#F4F5F7"><div align="left" class="style7"><%=query %></div></td>  
         <td bgcolor="#F4F5F7" ><div align="left" class="style7"><a href="./WriteDocAction?s2=<%=data %>></a>"><%= doc %></a></div></td>
         
         <% 
          String res[] = data.split("LOCATION:");
	          System.out.println(res.length);
	          for (int k = 0; k < res.length; k++)
	          {
	              
	               data1=res[k];
	              
	           data1 = data1.replaceAll("[0-9]","");
					  String[] stopWords = new String[]{" 1 ", " 0 ", " | "," i ", " a ", " and ", " about ", " an ", " are ", " as ", " at ", " be ", " by ", " com ", " for ", " from ", " how ", " in ", " is ", " it ", " not ", " of ", " on ", " or ", " that ", " the ", " this ", " to ", " was ", " what ", " when ", " where ", " who ", " will ", " with ", " the ", " www " , " has ", " his ", " its ", " but ", " have ", " all ", " they ", " were "," / ", " : "};;
                      for (String stopword : stopWords) {
                      data1 = data1.replaceAll("(?i)"+stopword, " ");
                        }
							  
	   
       String text =	data1;
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
		
         %>
         
         <td bgcolor="#F4F5F7"><div align="left"><span class="style7"><%=str %></span></div></td>
         
         
         
             
        <%
        System.out.println("str=="+str);  
		System.out.println("unique=="+unique); 
		System.out.println("duplicate=="+duplicate);      
		str=null;
         
        }
         %>
     </tr>
     <%} %>
      
     
 </table>
 </br><br><center>
 <table>
 <tr>
					<td align='center' colspan='8'>
						<input type="submit" value="View Data Frequent" />
					</td>
				</tr>
			</table></center>
  </br>
   </br>
    </br>
     </br>
      </br>
 </form>
 <br/><br/><br/><br/>
 <br/><br/> <jsp:include page="Footer.jsp"></jsp:include>
</body></html>