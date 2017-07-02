<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/foundation/6.3.1/css/foundation.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
h3 {
	color: red;
	font-style: italic;
}

h2 {
	padding-top: 30px;
	font-style: italic;
}

table, td, th {
	border: 1px solid black;
}

table {
	border-collapse: collapse;
	width: 80%;
	align: center;
}

th {
	height: 50px;
	background-color: #4CAF50;
	color: white;
}

tr:hover {
	background-color: lightgray;
}

tr:nth-child(even) {
	background-color: #f2f2f2
}
</style>
<title>Insert title here</title>
</head>
<center>
	<h2>Training Schedule</h2>
</center>
<body ng-app="myApp">
	<div ng-controller="EmpCtrl">
		<center>
			<div class="input">
				<input placeholder="Please Enter Date in format yyyy-MM-DD"
					path="schedule.startDate" name="date" ng-model="startDate"
					required="true">
				<button ng-click="getschedule(startDate)">Search</button>
				<td><errors path="startDate" cssClass="error" /></td>
				<center>
					<hr />
					<input type="text" ng-model="search.$" placeholder="Search By any" />
					<hr />
					<center>
						<table>
							<tr>
								<th>Trainer</th>
								<th>collage</th>
								<th>Domain</th>
								<th>startDate</th>
								<th>Duration</th>


							</tr>
							<tr
								ng-repeat="trainingShedule in trainingShedules | filter: search">

								<td>{{trainingShedule.trainerDetails.trianername}}</td>
								<td>{{trainingShedule.trainerDetails.collageName}}</td>
								<td>{{trainingShedule.trainerDetails.domain}}</td>
								<td>{{trainingShedule.startDate}}</td>
								<td>{{trainingShedule.duration}}</td>
							</tr>
						</table>
					</center>
					<div ng-show="noData">
						<h3>No Data found</h3>
					</div>
			</div>
			<script
				src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
			<script>
        var app = angular.module('myApp', []);
        app.controller('EmpCtrl', function($scope, $http){
        	
            $scope.noData = false
        	$scope.getschedule=function(startDate){
        		
            $http({
              method: 'GET',
              url: 'http://localhost:8080/TrainerManagement/mvc/viewSchedule1',
            	  params:{"startDate":startDate}
            }).then(res=>res.data)
            .then(data => {
            	console.log(data);
            	if(data.length!=0){
            	$scope.trainingShedules = data;
            	 $scope.noData = false}
            	else{
                    $scope.noData = true
                }
             	
            })
            
        	}
        })
    </script>
</body>
</html>