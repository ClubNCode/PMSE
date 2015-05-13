
<!DOCTYPE HTML PUBLIC "-//w3c//dtd html 4.0 transitional//en">
<html>
	<head>
		<style type="text/css">
.Title {
font-family:Verdana;
font-weight:bold;
font-size:8pt
}
.Title1 {font-family:Verdana;
font-weight:bold;
font-size:8pt
}
        </style>
	</head>
	<body>
	 <jsp:include page="Header.jsp"></jsp:include>
  <br/>

                      <br>
		<FORM action="./RecoverPasswordAction" method="post" name="register">
			<TABLE border="0" align="center" bgcolor="white" width=80%>

				<TR>
					<TD>
						<TABLE border="0" align="center">
                      <center><h3><strong>ForgotPassword Form </strong></h3></center>
							<TR>
								<TD align="right"></TD>
								<TD>
									<TABLE border="0" align="center">
										<TR>
											<TD><span class=Title>
												Login Name</span>
											</TD>
											<TD>
												<INPUT type="text" name="username">
											</TD>
										</TR>
										<TR>
											<TD><span class=Title>
												Secret Question</span>
											</TD>
											<TD><span class=Title>
												<select
							name="questn">
							<option value="">--Select One---</option>
							<option value="What is your favorite pastime?">What is your favorite pastime?</option>
							<option value="Who your childhood hero?">Who your childhood hero?</option>
							<option value="What is the name of your first school?">What is the name of your first school?</option>
							<option value="Where did you meet your spouse?">Where did you meet your spouse?</option>
							<option value="What is your favorite sports team?">What is your favorite sports team?</option>
							<option value="What is your father middle name?">What is your father middle name?</option>
							<option value="What was your high school mascot?">What was your high school?</option>
							<option value="What make was your first car or bike?">What make was your first car or bike?</option>
							<option value="What is your pet name?">What is your pet name?</option>
						</select>
										</span>	</TD>
										</TR>
										
										<TR>
											<TD><span class=Title>
												Secret Answer</span>
											</TD>
											<TD>
												<INPUT name="sanswer" type="text">
											</TD>
										</TR>
										<TR>
											<TD colspan="2"><span class=Title>
												<DIV align="center">
													<INPUT name="Input" type="submit" value="Recover">
													&nbsp;
													<INPUT name="Input" type="reset" value="Clear">
												</DIV></span>
											</TD>
										</TR>
									</TABLE>
								</TD>
								<TD>&nbsp;
									
							  </TD>
							</TR>
						</TABLE>
					</TD>
				</TR>
			</TABLE>
		</FORM>
		
		 <br/><br/>
                    
                 <jsp:include page="Footer.jsp"></jsp:include>
                     
      
	</body>
</html>