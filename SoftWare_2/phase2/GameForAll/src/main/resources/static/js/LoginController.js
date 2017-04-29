var app = angular.module('Login', []);

app.controller('LoginController', function($scope, $http, $location) {
	
	
	$scope.Login = function() {
		
		
		var url = "/user-login";
		var config = {
			headers : {
				'Content-Type' : 'application/json;charset=utf-8;'
			}
		}
		var data = {
			username : $scope.username,
			password : $scope.password
		};

		$http.post(url, data, config).then(function(response) {
			
			if(response.data==0)
			{
				$scope.postResultMessage = "User Name or Password is not correct!!";
			}
			else
			{
				localStorage.setItem("username",$scope.username) ;
				  url = "/get-user-type/"+$scope.username; 
		
				  $http.get(url, config).then(function (response2) {
					 if(response2.data==0)
					 {
						 var url = "/teacher";
						 window.open(url, "_self");
					 }
					 else
					 {
						 var url = "/student";
						 window.open(url, "_self");
					 }
						  
					  },function (response2) {
					});
				  
			}

		}, function(response) {
			$scope.postResultMessage = "User Name or Password is not correct!!";
		});
	}
});
