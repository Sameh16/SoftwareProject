	


var app = angular.module('Register', []);

app.controller('RegisterController', function($scope, $http, $location) {
	$scope.gender='M';
	$scope.user='Student';

	$scope.SetUser = function($res) {
		$scope.user=$res;
	}
		$scope.SetGender = function($res) {
			$scope.gender=$res;
	}
		
		$scope.GenderClass= function($res){
			if($res=="male"){
				document.getElementById("female").className = "tab";
			}
			else{
				document.getElementById("male").className = "tab";
			}
			document.getElementById($res).className = "tab active";
	}
		
		$scope.UserClass= function($res){
			if($res=="teacher"){
				document.getElementById("student").className = "tab";
			}
			else{
				document.getElementById("teacher").className = "tab";
			}
			document.getElementById($res).className = "tab active";
	}

	
	
	
	
	$scope.register= function(){
	        var config = {
	                headers : {
	                    'Content-Type': 'application/json;charset=utf-8;'
	                }
	        }
	       
	        
	        var url;
	        if($scope.lastName==null){
	        	$scope.lastName="";
	        }
	        
	        
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
	 	        	localStorage.setItem('username',$scope.username);
	        		if($scope.user=="Teacher")
	        		 {
						  url = "/teacher";
						window.open(url, "_self");
					 }
					 else
					 {
						 alert("hi");
						 var url = "/student";
						window.open(url, "_self");
					 }
	        	}else
	        	{
	        		$scope.postResultMessage = "Username or email is already taken!";
	        	}
	           
	           
	        }, function (response) {
	            $scope.postResultMessage = "Username or email is already taken!";
	        });
	    	
}
});
