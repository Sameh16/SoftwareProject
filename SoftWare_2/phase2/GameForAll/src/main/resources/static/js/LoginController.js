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
				$scope.postResultMessage = "Usename or Password is not correct!!";
			}
			else
			{
				localStorage.setItem("username",$scope.username) ;
				$scope.postResultMessage = "Welcome Back!";
				  url = "/get-user-type/"+$scope.username; 
				   var config = {
			                headers : {
			                    'Content-Type': 'application/json;charset=utf-8;'
			                }
			        }
				  
				  $http.get(url, config).then(function (response2) { 
					 
					 $scope.type = response2.data; 
					 if(response2.data==0)
					 {
						  url = "/teacher";
						window.open(url, "_self");
					 }
					 else
					 {
						 var url = "/student";
						window.open(url, "_self");
					 }
						  
					  },function (response2) {
						  $scope.type= response2.data; 
					});
				  
			}
			
			alert($scope.postResultMessage + "  "+$scope.username );

		}, function(response) {
			$scope.postResultMessage = "Usename or Password is not correct!!";
		});
	}
});
