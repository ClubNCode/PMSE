<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<title></title>
	<link rel="stylesheet" href="menu_style1.css" type="text/css" />
	 <script type="text/javascript" src="<%=request.getContextPath()+"/scripts/jquery.js"%>">
       </script>
	 <script type="text/javascript">
		$(document).ready(function () {
		$('.menu li').hover(
		function () {
		//show its submenu
		$('ul', this).slideDown(350);
		},
		function () {
		//hide its submenu
		$('ul', this).slideUp(350);
		}
		);
		});
    </script>
</head>
<body>
	
	<div class="menu" >
		<ul>
			<li><a href="./userhome.jsp" >Home</a></li>
			<li><a href="#">Upload Server Data</a>
				<ul>
					<li><a href="./UploadWebpage.jsp">UploadData</a></li>
					<li><a href="./ViewServerDataAction">View Server Data</a></li>
					<li><a href="./UploadMetaData.jsp">Upload Meta Data</a></li>
					
					</ul>
		  </li>
		  <li><a href="#">Select User Data</a>
				<ul>
					
					<li><a href="./UserSelectDataAction">Select User Data</a></li>
					</ul>
		  </li>
		   <li><a href="#">User select Word</a>
				<ul>
					
					<li><a href="./ViewUserSelectWord.jsp">Select User Word</a></li>
					</ul>
		  </li>
			
			
			<!--<li><a href="./#">Graph</a>
			<ul>
                
                <li><a href="./TreeGraph.jsp">View Graph</a></li>
                
               </ul>
			
			</li>
			-->
			<li><a href="./#">Ontology</a>
			<ul>
                
                <li><a href="./dynamicTree.iface">Combination of Content and Location Ontology</a></li>
                
               </ul>
			
			</li>
			
			
			
			<li><a href="#">Calculation</a>
			<ul>
                <li><a href="./calculation.jsp">Calculation</a></li>
                
               </ul>
			<li><a href="./#">UsersInfo</a>
			<ul>
                
                <li><a href="./ViewUsersAction">ViewCustomers</a></li>
                
               </ul>
			
			</li>
			
			
			
			<!--<li><a href="#">Security</a>
			<ul>
                <li><a href="./Changepassword.jsp">ChangePassword</a></li>
                
               </ul>
			
			--></li>
			<li><a href="./LogoutAction">Logout</a>
			
			
			</li>
		</ul>
	</div>

</body>
</html>
