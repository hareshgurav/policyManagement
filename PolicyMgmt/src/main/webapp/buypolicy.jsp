
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

$(document).ready(function() {
	

                /*  $("#userPolicyTable1").dataTable({

                              "bPaginate": false,

                            "bLengthChange": false,

                            "bFilter": true,

                                   "bInfo": false,

                                   "bSort" : true

                 }); */
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

<title>Policy Management</title>
</head>


<body>

<div id='cssmenu' style="background-color:#57b846;">
<div style='padding-left:12px;padding-top:0.5px;'><h1 style="font-family: 'PT Sans', sans-serif; color:white;"> Welcome to Policy Management</h1></div>
<ul>
   <li><a href='#'><span>Policy Summary</span></a></li>
   <li class= 'active'><a href='#'><span>Buy New Policy</span></a></li>
   <li class='last'><a href='#'><span>Check Policy Status</span></a></li>
</ul>
</div>
<br>
<br>
<div id='userData'> List Of Products:
${products}

					
					
<form class="form-horizontal"  method="post">
  <fieldset>
    <div id="legend">
      <legend class="">Register</legend>
    </div>
    <div class="control-group">
      <!-- Username -->
      <label class="control-label"  for="productId">Prouct Id</label>
      <div class="controls">
        <select path="products.productId" id="productId" name="productId" placeholder="" class="input-xlarge" />
        <options  items="${products}"/>
      </div>
    </div>
 
    <div class="control-group">
      <!-- E-mail -->
      <label class="control-label" for="email">E-mail</label>
      <div class="controls">
        <input type="text" id="email" name="email" placeholder="" class="input-xlarge">
        <p class="help-block">Please provide your E-mail</p>
      </div>
    </div>
 
    <div class="control-group">
      <!-- Password-->
      <label class="control-label" for="password">Password</label>
      <div class="controls">
        <input type="password" id="password" name="password" placeholder="" class="input-xlarge">
        <p class="help-block">Password should be at least 4 characters</p>
      </div>
    </div>
 
    <div class="control-group">
      <!-- Password -->
      <label class="control-label"  for="password_confirm">Password (Confirm)</label>
      <div class="controls">
        <input type="password" id="password_confirm" name="password_confirm" placeholder="" class="input-xlarge">
        <p class="help-block">Please confirm password</p>
      </div>
    </div>
 
    <div class="control-group">
      <!-- Button -->
      <div class="controls">
        <button class="btn btn-success">Register</button>
      </div>
    </div>
  </fieldset>
</form>					



</div>
<br>
<br><br>
<br>



</body>
</html>