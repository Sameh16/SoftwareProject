var app = angular.module('Register', []);

app.controller('RegisterController', function($scope, $http, $location) {
	$scope.register= function(){
	        var config = {
	                headers : {
	                    'Content-Type': 'application/json;charset=utf-8;'
	                }
	        }
	        var data = {
	        		name: $scope.firstName+" "+$scope.lastName,
	            	username: $scope.username,
	            	password: $scope.password,
	            	email: $scope.email,
	            	gender: $scope.gender,
	            	age: $scope.age
	            };
	        var url;
	        if($scope.user=="Teacher"){
	        	url="/add-teacher";
	        }
	        else{
	        	url="/add-student";
	        }
	        alert(url);
	        $http.post(url, data, config).then(function (response) {
	            $scope.postResultMessage = "Registration successful!";
	            Username=$scope.username;
	        	localStorage.setItem('Username',Username);
	        }, function (response) {
	            $scope.postResultMessage = "Username or email is already taken!";
	        });
	        $scope.firstName="";
	    	$scope.lastName="";
	    	$scope.username="";
	    	$scope.password="";
}
});
