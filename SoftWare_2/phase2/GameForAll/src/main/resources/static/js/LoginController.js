var app = angular.module('Login', []);

app.controller('LoginController', function($scope, $http, $location) {
	 $scope.login=function(){
		 	var url;
	        var config = {
	                headers : {
	                    'Content-Type': 'application/json;charset=utf-8;'
	                }
	        }
	        var data = {
	            	username: $scope.username,
	            	password: $scope.password,
	            	name: "",
	            	email: "",
	            	gender: "",
	            	age: 0
	            };
	        url ="/user-login";
	        $http.post(url, data, config).then(function (LoginResponse) {
	        	$scope.LoginResponse=LoginResponse.data;
	             alert($scope.LoginResponse);
	             localStorage.setItem('UserId',$scope.LoginResponse);
	             if($scope.LoginResponse==0){
	            	 $scope.postResultMessage = "User name or Password is not correct!!";
	             }
	             else{
	            $scope.postResultMessage ="Welcome Back!";
	             }
	            
	        }, function (LoginResponse) {
	            $scope.postResultMessage = "Usename oor Password is not correct!!";
	        });
}
});
