var app = angular.module('Login', []);

app.controller('LoginController', function($scope, $http, $location) {
	 $scope.submitForm = function(){
		 var url ="/login";
	        var config = {
	                headers : {
	                    'Content-Type': 'application/json;charset=utf-8;'
	                }
	        }
	        var data = {
	            	username: $scope.username,
	            	password: $scope.password
	            };
	        $http.post(url, data, config).then(function (response) {


	        	
	        	/* var typeurl = "/get-user-type";  // get user type to know if student or teacher
	             var config = {
	                     headers : {
	                         'Content-Type': 'application/json;charset=utf-8;'
	                     }
	             }
	             
	             $http.get(url, config).then(function (response) {
	                 $scope.type = response.data
	                 
	             }, function (response) {
	                 $scope.getResultMessage = "Fail!";
	             });
	        	
	        	*/
	            $scope.postResultMessage = "Welcome back!";
	        }, function (response) {
	            $scope.postResultMessage = "Username or Password is not correct!";
	        });
}
});
