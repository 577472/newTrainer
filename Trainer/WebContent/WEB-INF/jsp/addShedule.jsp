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
					<td>Trainer name :</td>
					<td><form:input path="TrainerDetails.Trianername"
							placeholder="TrainerName" maxlength="30"
							ng-model="TrainerDetails.Trianername" required="true"
							ng-pattern="/^[A-Za-z\b \b]{1,30}$/" /></td>
					<td><form:errors path="TrainerDetails.Trianername"
							cssClass="error" /></td>
					<td><span
						ng-show="Form.TrainerName.$error.required && !Form.TrainerDetails.Trianername.$pristine">Trainer
							name is required</span></td>

					<td><span
						ng-show="Form.TrainerDetails.Trianername.$error.pattern && !Form.TrainerDetails.Trianername.$pristine">Only
							Alphabets are required</span></td>
				</tr> 

				<tr>
					<td>Duration :</td>
					<td><form:select path="Duration" ng-model="Duration">
							<option value="" disabled selected>Select Duration</option>
							<option value="120">120</option>
							<option value="180">180</option>
							<option value="240">240</option>
						</form:select></td>
					<td><form:errors path="Duration" cssClass="error" /></td>

				</tr>

				<tr>
					<td>College Name :</td>
					<td><form:input path="TrainerDetails.collageName"
							placeholder="CollegeName" maxlength="20"
							ng-pattern="/^[0-9\b.\b]{1,10}$/" ng-model="TrainerDetails.collageName"
							required="true" /></td>
					<td><form:errors path="TrainerDetails.collageName" cssClass="error" /></td>
					<td><span
						ng-show="Form.TrainerDetails.collageName.$error.required && !Form.TrainerDetails.collageName.$pristine">Transaction
							amount is required</span></td>
					<td><span
						ng-show="Form.collageName.$error.pattern && !Form.collageName.$pristine">Only
							Numbers are required</span></td>

				</tr>
				
				<tr>
					<td>TrainerId :</td>
					<td><form:input path="TrainerDetails.TrainerId"
							placeholder="TrainerId" maxlength="30"
							ng-model="TrainerDetails.TrainerId" required="true"
							ng-pattern="/^[A-Za-z\b \b]{1,30}$/" /></td>
					<td><form:errors path="TrainerDetails.TrainerId"
							cssClass="error" /></td>
					<td><span
						ng-show="Form.TrainerDetails.TrainerId.$error.required && !Form.TrainerDetails.TrainerId.$pristine">Transaction
							description is required</span></td>
				
				
				<tr>
					<td>Domain:</td>
					<td><form:input path="TrainerDetails.Domain"
							placeholder="TrainerDetails.Domain" maxlength="30"
							ng-model="TrainerDetails.Domain" required="true"
							ng-pattern="/^[A-Za-z\b \b]{1,30}$/" /></td>
					<td><form:errors path="TrainerDetails.Domain"
							cssClass="error" /></td>
					<td><span
						ng-show="Form.TrainerDetails.Domain.$error.required && !Form.TrainerDetails.Domain.$pristine">Transaction
							description is required</span></td>
	
				<tr>
					<td>Start Date :</td>
					<td><form:input path="startDate" type="Date" ng-model="startDate" required="true" /></td>
					<td><form:errors path="startDate" cssClass="error" /></td>
							
					
				
				<tr>
					<td></td>
					<td colspan="2"><button type="submit" value="Add">Submit</button></td>
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