<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html lang="en">
<head>
<title>Login V8</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="icon" type="image/png" href="images/icons/favicon.ico" />

<link rel="stylesheet" type="text/css"
	href="vendor/bootstrap/css/bootstrap.min.css">

<link rel="stylesheet" type="text/css"
	href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">

<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">

<link rel="stylesheet" type="text/css"
	href="vendor/css-hamburgers/hamburgers.min.css">

<link rel="stylesheet" type="text/css"
	href="vendor/animsition/css/animsition.min.css">

<link rel="stylesheet" type="text/css"
	href="vendor/select2/select2.min.css">

<link rel="stylesheet" type="text/css"
	href="vendor/daterangepicker/daterangepicker.css">

<link rel="stylesheet" type="text/css" href="css/util.css">
<link rel="stylesheet" type="text/css" href="css/main.css">

</head>
<body>

	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">

				<form:form id="regForm" modelAttribute="userDetails"
					action="registerUser" method="post"
					class="login100-form validate-form p-l-55 p-r-55 p-t-178">

					<span class="login100-form-title" style="font-size: 19px;">
						Welcome To Policy Management<br /> Register New User
					</span>

					<table class=".table">
						<tr class="wrap-input100">
							<td><form:label path="userId"> UserId</form:label></td>
							<td><form:input path="userId" cssClass="input100" /></td>
						</tr>

						<tr class="wrap-input100">
							<td><form:label path="password"> Password</form:label></td>
							<td><form:password path="password" cssClass="input100" /></td>
						</tr>						

						<tr class="wrap-input100">
							<td><form:label path="name"> Full Name</form:label></td>
							<td><form:input path="name" cssClass="input100" /></td>
						</tr>						
						
						<tr class="wrap-input100">
							<td><form:label path="mobileNo"> Mobile Number</form:label></td>
							<td><form:input path="mobileNo" cssClass="input100" /></td>
						</tr>

						<tr class="wrap-input100">
							<td><form:label path="address"> Address</form:label></td>
							<td><form:input path="address" cssClass="input100" /></td>
						</tr>

						<tr class="wrap-input100">
							<td><form:label path="dob"> Date Of Birth</form:label></td>
							<td><form:input path="dob" cssClass="input100" /></td>
						</tr>

						<tr class="wrap-input100">
							<td><form:label path="emailId"> Email Address</form:label></td>
							<td><form:input path="emailId" cssClass="input100" /></td>
						</tr>

						<tr class="wrap-input100">
							<td><form:label path="smoker"> Do you Smoke?
							</form:label></td>
							<td><form:input path="smoker" cssClass="input100" /></td>
						</tr>

						<tr class="wrap-input100">
							<td><form:label path="drinker"> Do you Drink?
							</form:label></td>
							<td><form:input path="drinker" cssClass="input100" /></td>
						</tr>

						<tr class="wrap-input100">
							<td><form:label path="maritalStatus"> Marital Status
							</form:label></td>
							<td><form:input path="maritalStatus" cssClass="input100" /></td>
						</tr>

					</table>
					
					<div class="container-login100-form-btn">
						<input class="login100-form-btn" type="submit"
							value="Register Now" />

						<c:if test="${message!= null}">
							<br>

							<span class="validate-input"> ${message} </span>
						</c:if>

					</div>

					<!-- <div class="flex-col-c p-t-170 p-b-40" style="padding-top:62px">
						<span class="txt1 p-b-9">
							New Users
						</span>

						<a href="#" class="txt3">
							Register here now
						</a>
					</div> -->
				</form:form>
			</div>
		</div>
	</div>



	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>

	<script src="vendor/animsition/js/animsition.min.js"></script>

	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>

	<script src="vendor/select2/select2.min.js"></script>

	<script src="vendor/daterangepicker/moment.min.js"></script>
	<script src="vendor/daterangepicker/daterangepicker.js"></script>

	<script src="vendor/countdowntime/countdowntime.js"></script>

	<script src="js/main.js"></script>

</body>
</html>