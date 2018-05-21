
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="styles.css">
<link type="text/css" rel="stylesheet" href="jsgrid.min.css" />
<link type="text/css" rel="stylesheet" href="jsgrid-theme.min.css" />
<link rel="stylesheet" type="text/css"
	href="vendor/bootstrap/css/bootstrap.min.css">

<script src="jquery-3.3.1.min.js" type="text/javascript"></script>

<script src="dataTables.bootstrap.min.js" type="text/javascript"></script>
<script src="jquery.dataTables.min.js" type="text/javascript"></script>
<script type="text/javascript" src="jsgrid.min.js"></script>
<script src="script.js"></script>
<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<script>

</script>

<style>
.table>thead>tr>th {
	background-color:;
	color: white !important;
	background-color: rgb(1, 25, 66)
}

.table {
	overflow-x: hidden !important;
}
</style>

<title>Policy Management</title>
</head>


<body>

	<div id='cssmenu' style="background-color: #57b846;">
		<div style='padding-left: 12px; padding-top: 0.5px;'>
			<h1 style="font-family: 'PT Sans', sans-serif; color: white;">
				Welcome to Policy Management</h1>
		</div>
		<ul>
			<li><a href='http://localhost:8093/policyMgmt/showuserpolicies'><span>Policy Summary</span></a></li>
			<li class='active'><a href='#'><span>Buy New Policy</span></a></li>
			
		</ul>
	</div>
	<br>
	<br>
	<div id='userData' style="padding-left: 20px;">
		
		Please enter payment Details :

		<form class="form-horizontal" method="post" action="payPolicy" method="POST">
			<fieldset>
				

				<div class="control-group" id="userdata">
				
					<label class="control-label" for="userpolicyid">User Policy Id :</label>
					<div class="controls">
						<input type="text" id="userpolicyid" name="userpolicyid"
							 class="input-xlarge" maxlength="20" >
					</div>
					<br>
					
					<label class="control-label" for="accountno">Account No :</label>
					<div class="controls">
						<input type="text" id="accountno" name="accountno"
							 class="input-xlarge" maxlength="20" >
					</div>
					<br>
					
					<label class="control-label" for="amount">Amount :</label>
					<div class="controls">
						<input type="text" id="amount" name="amount"
							 class="input-xlarge" maxlength="20" >
					</div>
					<br>
					
					<label class="control-label" for="bankname">Bank Name :</label>
					<div class="controls">
						<input type="text" id="bankname" name="bankname"
							 class="input-xlarge" maxlength="50" >
					</div>
					<br>

					<div class="controls">
						<button class="btn btn-success">Pay</button>
					</div>
				</div>
				<p><input type="hidden" name="userid" id="userid" value="${userid}"></p>				
			</fieldset>
		</form>



	</div>



</body>
</html>