var app = angular.module('Game', []);



app.controller('GameController', function($scope, $http, $location) {
	
	$scope.username= localStorage.getItem('username');
	
	if (localStorage.getItem("username") == "") {

		var url = "/";
		window.open(url, '_self');
	}
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
        var url = "/get-courses/"+$scope.Category.categoryName+"/"+$scope.username;
        
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
        var url = $location.absUrl() + "/create-game/"+$scope.Course.id+"/"+$scope.Type.typeId+"/"+$scope.username;
        
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
        	description: $scope.description,
        	teacherId: 1
      
        };
         
        $http.post(url, data, config).then(function (GameResponse) {
        	$scope.GameResponse = GameResponse.data
        	id=$scope.GameResponse;
        	localStorage.setItem('id',id);
        	var url2= $location.absUrl() + "/get-type-template/"+$scope.Type.typeName;
        	window.open(url2,"_self");
        }, function (GameResponse) {
            $scope.postResultMessage = "Fail!";
        });
        
        
        
       
    }


});




    