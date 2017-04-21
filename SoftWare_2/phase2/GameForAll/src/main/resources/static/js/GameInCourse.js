var app = angular.module('GameInCourse', []);

app.controller('GameInCourseController', function($scope, $http, $location) {
    
    
    
		var courseName = localStorage.getItem('courseName');
        var url = $location.absUrl()+"/show-Course-games/"+courseName;
        var config = {
                headers : {
                    'Content-Type': 'application/json;charset=utf-8;'
                }
        }
        
        $http.get(url, config).then(function (response) {
            $scope.Games = response.data
            
        }, function (response) {
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
 
