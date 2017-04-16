var app = angular.module('Login', []);

app.controller('LoginController', function($scope, $http, $location) {
	 $scope.submitForm = function(){
		 var url = $location.absUrl()+"/login";
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
	            $scope.postResultMessage = "Welcome back!";
	        }, function (response) {
	            $scope.postResultMessage = "Username or Password is not correct!";
	        });
}
});
