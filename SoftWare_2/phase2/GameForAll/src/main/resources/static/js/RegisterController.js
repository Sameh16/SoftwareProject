var app = angular.module('Register', []);

app.controller('RegisterController', function($scope, $http, $location) {
	$scope.register= function(){
	        var config = {
	                headers : {
	                    'Content-Type': 'application/json;charset=utf-8;'
	                }
	        }
	       
	        
	        var url;
	        if($scope.user=="Teacher"){
	        	url="/add-teacher";
	        	 var data = {
	 	        		name: $scope.firstName+" "+$scope.lastName,
	 	            	username: $scope.username,
	 	            	password: $scope.password,
	 	            	acadmicMail: $scope.email,
	 	            	gender: $scope.gender,
	 	            	age: $scope.age
	 	            };
	        }
	        else{
	        	url="/add-student";
	        	 var data = {
	 	        		name: $scope.firstName+" "+$scope.lastName,
	 	            	username: $scope.username,
	 	            	password: $scope.password,
	 	            	email: $scope.email,
	 	            	gender: $scope.gender,
	 	            	age: $scope.age
	 	            };
	        }
	        $http.post(url, data, config).then(function (response) {
	        	if(response.data)
	        	{
	        		$scope.postResultMessage = "Registration successful!";
	        		if($scope.user=="Teacher")
	        		 {
						  url = "/teacher";
						window.open(url, "_self");
					 }
					 else
					 {
						 var url = "/student";
						window.open(url, "_self");
					 }
	        	}else
	        	{
	        		$scope.postResultMessage = "Username or email is already taken!";
	        		alert($scope.postResultMessage);
	        	}
	           
	            Username=$scope.username;
	        	localStorage.setItem('Username',Username);
	        }, function (response) {
	            $scope.postResultMessage = "Username or email is already taken!";
	        });
	    	$scope.username="";
	    	$scope.password="";
}
});
