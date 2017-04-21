var app = angular.module('Login', []);

app.controller('LoginController', function($scope, $http, $location) {
	
	
	$scope.Login = function() {
		
		
		var url = "/login";
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
			
			if(response.data==false)
			{
				$scope.postResultMessage = "Usename or Password is not correct!!";
			}
			else
			{
				$scope.postResultMessage = "Welcome Back!";
			}
			
			alert($scope.postResultMessage + "  "+$scope.username );
			
			   var typeurl = "/get-user-type/"+$scope.username; 
			   var config = {
		                headers : {
		                    'Content-Type': 'application/json;charset=utf-8;'
		                }
		        }
			  
			  $http.get(typeurl, config).then(function (response2) { 
				 
				  $scope.type = response2.data; 
				  },function (response2) {
					  alert(response2);
					  alert(response2.data);
					  $scope.type= response2.data; 
				});
			  localStorage.setItem("username",$scope.username) ;
			 
			

		}, function(response) {
			$scope.postResultMessage = "Usename or Password is not correct!!";
		});
	}
});
