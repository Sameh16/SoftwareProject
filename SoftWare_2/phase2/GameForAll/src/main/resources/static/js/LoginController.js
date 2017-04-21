var app = angular.module('Login', []);

app.controller('LoginController', function($scope, $http, $location) {
	 $scope.login=function(){
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
	        	
	        	var typeurl = "/get-user-type";
	             var config = {
	                     headers : {
	                         'Content-Type': 'application/json;charset=utf-8;'
	                     }
	             }
	             
	             $http.get(url, config).then(function (response) {
	                 $scope.type = response.data;
	             }, function (response) {
	                 $scope.type= "Fail!";
	             });
	             localStorage.username =$scope.username;
	            $scope.postResultMessage ="Welcome Back!";
	            
	        }, function (response) {
	            $scope.postResultMessage = "Usename oor Password is not correct!!";
	        });
}
});
