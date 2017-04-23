var app = angular.module('GameInCourse', []);

app.controller('GameInCourseController', function($scope, $http, $location) {
    
    

		$scope.username =  localStorage.getItem('username');
		var courseName = localStorage.getItem('courseName');
		
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
				  $scope.teacher = true;
			 }
			 else
			 {
				 $scope.teacher = false;
			 }
				  
			  },function (response2) {
				  $scope.type= response2.data; 
			});
		
		
		
		url = $location.absUrl()+"/show-Course-games/"+courseName;
        
        $http.get(url, config).then(function (response) {
            $scope.Games = response.data
            
        }, function (response) {
            $scope.getResultMessage = "Fail!";
        });
        
        
    	url = "/get-category";
        
        $http.get(url, config).then(function (CategoryResponse) {
            $scope.categories = CategoryResponse.data
        }, function (CategoryResponse) {
            $scope.getResultMessage = "Fail!";
        });
		
        
        
        $scope.playGame=function (Game)
        {
        	
        	gameName=Game.gameName;
        	localStorage.setItem('gameName',gameName);
        	var url= "/playGameQ";
        	window.open(url,"_self");
        }
	
});
 
