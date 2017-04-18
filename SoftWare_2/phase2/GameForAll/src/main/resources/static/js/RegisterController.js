var app = angular.module('Login', []);

app.controller('LoginController', function($scope, $http, $location) {
	 $scope.submitForm = function(){
		 if(type == "student")
		 {
			 var url = $location.absUrl()+"/login";
		 }
		 else
		 {
			 var url = $location.absUrl()+"/";
		 }
		 
	        var config = {
	                headers : {
	                    'Content-Type': 'application/json;charset=utf-8;'
	                }
	        }
	        var data = {
	        		FirstName: $scope.firstName,
	            	LastName: $scope.lastName,
	            	username: $scope.username,
	            	password: $scope.password
	            };
	        $http.post(url, data, config).then(function (response) {
	            $scope.postResultMessage = "Registration successful!";
	            Username=$scope.username;
	        	localStorage.setItem('Username',Username);
	        }, function (response) {
	            $scope.postResultMessage = "Username is already taken!";
	        });
	        $scope.firstName="";
	    	$scope.lastName="";
	    	$scope.username="";
	    	$scope.password="";
}
});
