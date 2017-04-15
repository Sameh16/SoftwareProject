var app = angular.module('Play', []);


app.controller('PlayGameController', function($scope, $http, $location) {
	
	
	
	 
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
         
       
    }
});






 
