var app = angular.module('Game', []);


app.controller('GameController', function($scope, $http, $location) {
	
	$scope.getcategory = function(){
        var url = $location.absUrl()+"/get-category";
        var config = {
                headers : {
                    'Content-Type': 'application/json;charset=utf-8;'
                }
        }
        
        $http.get(url, config).then(function (CategoryResponse) {
            $scope.CategoryResponse = CategoryResponse.data
            
        }, function (CategoryResponse) {
            $scope.getResultMessage = "Fail!";
        });
    }
	
	$scope.getcourse = function(){
        var url = $location.absUrl()+"/get-courses/"+$scope.Category.categoryName+"/1";
        
        var config = {
                headers : {
                    'Content-Type': 'application/json;charset=utf-8;'
                }
        }
        $http.get(url, config).then(function (CourseResponse) {
            $scope.CourseResponse = CourseResponse.data
        }, function (CourseResponse) {
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
	        
	        $http.get(url, config).then(function (TypeResponse) {
	            $scope.TypeResponse = TypeResponse.data
	        }, function (TypeResponse) {
	            $scope.getResultMessage = "Fail!";
	        });
	    }
	 
   
    
    $scope.AddGame = function(){
        var url = $location.absUrl() + "/create-game/"+$scope.Course.id+"/"+$scope.Type.typeId;
       
        var config = {
                headers : {
                    'Content-Type': 'application/json;charset=utf-8;'
                }
        }
        var data = {
        	gameName: $scope.gameName,
        	Course: $scope.Course.id,
        	Type: $scope.Type.typeId,
        	numOfLevels: $scope.numOfLevels,
        	description: $scope.description
      
        };
         
        $http.post(url, data, config).then(function (GameResponse) {
            $scope.postResultMessage = "Sucessful!";
        }, function (GameResponse) {
            $scope.postResultMessage = "Fail!";
        });
         
       
    }


});




    