
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

function add_months(dt, n) 
{
	var month = dt.getMonth();
	var newmonth = +month + +n;

  return new Date(dt.setMonth(newmonth));      
}

function enableDataDiv(){
	if($('#policylist').val() != '-1'){
		$('#userdata').show();		
	} else{
		$('#userdata').hide();
	}
	document.forms[0].tenure.value='';
	document.forms[0].maturityDate.value='';
	document.forms[0].sumAssured.value='';
}

function calculateMaturityDate(){
	
	var tenure = $('#tenure').val();
	var maturitydate= add_months(new Date(), tenure);
	var dd = maturitydate.getDate();
	var mm = maturitydate.getMonth()+1; 
	var yyyy = maturitydate.getFullYear();
	if(dd<10){
	    dd='0'+dd;
	} 
	if(mm<10){
	    mm='0'+mm;
	} 
	var maturitydate = dd+'/'+mm+'/'+yyyy;
	document.forms[0].maturityDate.value = maturitydate;
	calculateSumAssured();
}

function calculateSumAssured(){
	var tenure = $('#tenure').val();
	var policyId= $('#policylist').val();
	var sumAssured;
	if(policyId =='1'){
		sumAssured = 1000*tenure;
		document.forms[0].sumAssured.value = sumAssured
	}
	if(policyId =='2'){
		sumAssured = 2000*tenure;
		document.forms[0].sumAssured.value = sumAssured
	}
	if(policyId =='3'){
		sumAssured = 3000*tenure;
		document.forms[0].sumAssured.value = sumAssured
	}
	if(policyId =='4'){
		sumAssured = 1000*tenure;
		document.forms[0].sumAssured.value = sumAssured
	}
	if(policyId =='5'){
		sumAssured = 2000*tenure;
		document.forms[0].sumAssured.value = sumAssured
	}
	if(policyId =='6'){
		sumAssured = 3000*tenure;
		document.forms[0].sumAssured.value = sumAssured
	}
	
	
}
	$(document).ready(function() {
		$('#userdata').hide();

	});
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

		<form class="form-horizontal" method="post" action="buypolicy" method="POST">
			<fieldset>
				<div class="control-group">

					<label class="control-label" for="productId">Product Id* :</label>
					<div class="controls">

						<select id="policylist" onchange="enableDataDiv()" name="policylist">
							<option value="-1">Please select policy</option>
							<c:forEach var="productlist" items="${products}">
								<option value="${productlist.productid}"><c:out
										value="${productlist.productname}" /></option>
							</c:forEach>
						</select>						
					</div>
				</div>
				<br>

				<div class="control-group" id="userdata">
				
					<label class="control-label" for="productId">Policy tenure(in months)* :</label>
					<div class="controls">
						<input type="text" id="tenure" name="tenure"
							 class="input-xlarge" maxlength="3" onchange="calculateMaturityDate()">
					</div>
					<br>
					
					<label class="control-label" for="policyterm">Policy payment term* :</label>
					<div class="controls">
						<select id="policytem" name="policyterm">
							<option value="Monthly">Monthly</option>
							<option value="Quarterly">Quarterly</option>
							<option value="Half-Yearly">Half-Yearly</option>
							<option value="Yearly" selected="selected">Yearly</option>
						</select>
					</div>
					<br>

					<label class="control-label" for="sumAssured">Sum Assured*
						:</label>
					<div class="controls">
						<input type="text" id="sumAssured" name="sumAssured"
							placeholder="" class="input-xlarge" maxlength="10">
					</div>
					<br>

					<label class="control-label" for="premiumAmt">Premium
						Amount* : </label>
					<div class="controls">
						<input type="text" id="premiumAmt" name="premiumAmt"
							placeholder="" class="input-xlarge" maxlength="10">
					</div>
					<br>

					<label class="control-label" for="maturityDate">Maturity
						Date : </label>
					<div class="controls">
						<input type="text" id="maturityDate" name="maturityDate"
							placeholder="" class="input-xlarge" maxlength="10"
							readonly="readonly">
					</div>
					<br>

					<div class="controls">
						<button class="btn btn-success">Buy Policy</button>
					</div>
				</div>
			</fieldset>
		</form>



	</div>



</body>
</html>