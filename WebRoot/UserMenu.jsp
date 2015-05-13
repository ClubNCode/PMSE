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
			<li><a href="#">Search Data</a>
				<ul>
					<li><a href="./index.jsp">Normal Search </a></li>
					
					</ul>
		    </li>
		    <li><a href="#">Select Word</a>
				<ul>
					<li><a href="./userselectword.jsp">Select Word</a></li>
					
					</ul>
		    </li>
		   
		   <li><a href="#"> Personalized Search</a>
				<ul>
					<li><a href="./Psearch.jsp">Personalized Search</a></li>
					
					</ul>
		    </li>
			
			<li><a href="./#">Profile</a>
			<ul>
                
                <li><a href="./ViewProfile.jsp">ViewProfile</a></li>
                
               </ul>
			
			</li>
			
			
			
			<li><a href="#">Security</a>
			<ul>
                <li><a href="./Changepassword.jsp">ChangePassword</a></li>
                
               </ul>
			
			</li>
			<li><a href="./LogoutAction">Logout</a>
			
			
			</li>
		</ul>
	</div>

</body>
</html>
