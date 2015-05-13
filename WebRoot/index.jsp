<%@page import="com.student.Dao.DataDao"%>
<%@page import="java.util.List"%>
<%@page import="com.student.FormBean.DataFormBean"%>
<%@page import="com.student.Factory.*"%>
<%@page import="java.util.StringTokenizer"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="Header.jsp" %>

	<link rel="stylesheet" type="text/css" href="jquery.autocomplete.css" />
	 
	<script type="text/javascript">
	function search()
	{
	var name=document.search.country.value;
	if(name==null || name=="")
	{
	alert("enter any language");
	return false;
	}
	}
	
	</script>
	<script>  
		google.load("jquery", "1");
	</script>
	<script src="jquery.autocomplete.js"></script>  
	<style>
		input {
			font-size: 120%;
		}
	</style>
</head>
<body>
	<center><font size="5" color="#003366" >Search Engine</font></center>
	<form action="./ViewSearchDataAction" name="search" onsubmit="return search()">
	
	<center>
	</br>
	<fieldset>
	<input type="text" id="country" name="query" size="50"/>
	<br>	<br>
	<input type="image"  alt="submit"  src="images/search.png" height="60" width="150"></fieldset>
	</center>
	
	</form>
	
	
</body>

</html>