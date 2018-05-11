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

$(document).ready(function() {
	

                 $("#userPolicyTable1").dataTable({

                              "bPaginate": false,

                            "bLengthChange": false,

                            "bFilter": true,

                                   "bInfo": false,

                                   "bSort" : true

                 });
});

                

</script>

<style>

.table > thead > tr > th{

background-color: ;

color: white !important;

background-color: rgb(1, 25, 66) 

}

.table {

overflow-x:hidden !important;

}

</style>

<title>Policy Management1</title>
</head>

<body>

<div id='cssmenu' style="background-color:#57b846;">
<div style='padding-left:12px;padding-top:0.5px;'><h1 style="font-family: 'PT Sans', sans-serif; color:white;"> Welcome to Policy Management</h1></div>
<ul>
   <li class='active'><a href='#'><span>Policy Summary</span></a></li>
   <li><a href='#'><span>Buy New Policy</span></a></li>
   <li class='last'><a href='#'><span>Check Policy Status</span></a></li>
</ul>
</div>
<br>
<br>
<div id='userData'> User policy details as follows:
${userpolicy}
</div>
<br>
<br><br>
<br>
<div id="jsGrid" >
<table id="userPolicyTable1"  class=".table table striped" >
<thead style="background-color:#57b846";>
<tr>
<th>userId</th>
<th>sumAssured</th>
<th>premiumAmt</th>
<th>productId</th>
<th>maturityDate</th>
<th>purchaseDate</th>
<th>policyStatus</th>
<th>user_Policy_Id</th>
<th>premiumFrequency</th>
</tr>
</thead>
<tbody>


<c:forEach items="${userpolicy}" var="val">
	<tr>
	<td><c:out value="${val.userId}"></c:out> </td>
	<td><c:out value="${val.sumAssured}"></c:out> </td>
	<td><c:out value="${val.premiumAmt}"></c:out> </td>
	<td><c:out value="${val.productId}"></c:out> </td> 
	<td><c:out value="${val.maturityDate}"></c:out> </td> 
	<td><c:out value="${val.purchaseDate}"></c:out> </td> 
	<td><c:out value="${val.policyStatus}"></c:out> </td> 
	<td><c:out value="${val.user_Policy_Id}"></c:out> </td> 
	<td><c:out value="${val.premiumFrequency}"></c:out> </td> 
	 
	
	
	</tr>
</c:forEach>


</tbody>
</table>
</div>


</body>
</html>