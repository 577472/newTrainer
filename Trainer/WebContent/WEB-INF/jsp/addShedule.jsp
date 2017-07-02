<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/foundation/6.3.1/css/foundation.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Deatils</title>
</head>


<body ng-app="myApp">
	<div ng-controller="myCntrl">
	
		
 <form:form method="POST"
 action="/TrainerManagement/mvc/applyShedule"
			modelAttribute="TrainingShedule" name="Form">


			<table>
<tr>
					<td>TrainerId :</td>
					<td><form:input path="TrainerDetails.TrainerId"
							placeholder="TrainerId" maxlength="5"
							ng-model="TrainerDetails.TrainerId" required="true"
							pattern="[0-9]{1,5}" title="Please Enter Only 5 digit number"/></td>
					
				<tr>
					<td>Trainer name :</td>
					<td><form:input path="TrainerDetails.Trianername"
							placeholder="TrainerName" maxlength="30" 
							ng-model="TrainerDetails.Trianername" required="true"
							pattern="[A-Za-z]{1,30}" title="Please Enter only Aphabets" /></td>
					
				
				</tr> 
				<tr>
					<td>College Name :</td>
					<td><form:input path="TrainerDetails.collageName"
							placeholder="CollegeName" maxlength="30"
							pattern="[A-Za-z]{1,30}" title="Please Enter only Aphabets" ng-model="TrainerDetails.collageName"
							required="true" /></td>
			
				</tr>
				
				<tr>
					<td>Domain:</td>
					<td><form:select path="TrainerDetails.Domain"
							ng-model="TrainerDetails.Domain" required="true" >
							<option value="" disabled selected>Select Domain</option>
							<option value="java">java</option>
							<option value="C#">C#</option>
							<option value="AngularJs">AngularJs</option>
							<option value="Spring And HIbernate">Spring And HIbernate</option>
							</form:select></td>
							
							
				<tr>
					<td>Start Date :</td>
					<td><form:input path="startDate" type="Date" ng-model="startDate" required="true" min="2017-07-02"  /></td>
				<tr>
					<td>Duration :</td>
					<td><form:select path="Duration" ng-model="Duration" required="true">
							<option value="" disabled selected>Select Duration in minute</option>
							<option value="120">120</option>
							<option value="180">180</option>
							<option value="240">240</option>
							<option value="300">300</option>
						</form:select></td>
				</tr>	
				
				<tr>
					<td></td>
					<td colspan="2"><button type="submit"  value="Add" >Submit</button></td>
				</tr>
			</table>
		</form:form> 
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
	<script>
		var app = angular.module('myApp', []);

		app.controller('myCntrl', function($scope) {
			
		})
	</script>
</body>
</html>