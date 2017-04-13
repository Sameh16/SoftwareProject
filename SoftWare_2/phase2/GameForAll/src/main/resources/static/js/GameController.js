var app = angular.module('Game', []);


app.controller('GameController', function($scope, $http, $location) {
	$scope.getcategory = function(){
        var url = $location.absUrl()+"/get-category";
        var config = {
                headers : {
                    'Content-Type': 'application/json;charset=utf-8;'
                }
        }
        
        $http.get(url, config).then(function (response) {
            $scope.response = response.data
            
        }, function (response) {
            $scope.getResultMessage = "Fail!";
        });
    }
	
	$scope.getcourse = function(){
        var url = $location.absUrl()+"/get-courses/"+$scope.Category+"/1";
        
        var config = {
                headers : {
                    'Content-Type': 'application/json;charset=utf-8;'
                }
        }
        $http.get(url, config).then(function (response) {
            $scope.response = response.data
        }, function (response) {
            $scope.getResultMessage = "Fail!";
        });
    }
	
	
	$scope.gettype = function(){
	        var url = $location.absUrl()+"/get-type";
	        var config = {
	                headers : {
	                    'Content-Type': 'application/json;charset=utf-8;'
	                }
	        }
	        
	        $http.get(url, config).then(function (response) {
	            $scope.response = response.data
	        }, function (response) {
	            $scope.getResultMessage = "Fail!";
	        });
	    }
	 
    $scope.submitForm = function(){
        var url = $location.absUrl() +"/create-game";
        
        var config = {
                headers : {
                    'Content-Type': 'application/json;charset=utf-8;'
                }
        }
        var data = {
        	GameName: $scope.GameName,
        	Type: $scope.Type,
        	Course: $scope.Course
        	
      
        };
        
        $http.post(url, data, config).then(function (response) {
            $scope.postResultMessage = "Sucessful!";
        }, function (response) {
            $scope.postResultMessage = "Fail!";
        });
         
        $scope.CourseName="";
    	$scope.CategoryId="";
    	$scope.TeacherID="";
    	$scope.MinimunAge="";
    }
});





app.controller('postcontroller', function($scope, $http, $location) {
    $scope.submitForm = function(){
        var url = $location.absUrl() + "addcourse/"+$scope.TeacherID+"/"+$scope.CategoryId;
        
        var config = {
                headers : {
                    'Content-Type': 'application/json;charset=utf-8;'
                }
        }
        var data = {
        	minimunAge: $scope.MinimunAge,
        	teacherID: $scope.TeacherID,
        	categoryId: $scope.CategoryId,
        	courseName: $scope.CourseName
      
        };
         document.write($scope.MinimunAge);
        $http.post(url, data, config).then(function (response) {
            $scope.postResultMessage = "Sucessful!";
        }, function (response) {
            $scope.postResultMessage = "Fail!";
        });
         
        $scope.CourseName="";
    	$scope.CategoryId="";
    	$scope.TeacherID="";
    	$scope.MinimunAge="";
    }
});
 
