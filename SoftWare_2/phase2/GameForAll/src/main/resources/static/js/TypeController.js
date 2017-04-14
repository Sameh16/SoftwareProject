var app = angular.module('Type', []);


app.controller('TypeTemplateController', function($scope, $http, $location) {
	
	$scope.getgame = function(){
		var id=localStorage.getItem('id');
		var url = $location.absUrl()+"/get-game/"+id;
		
        var config = {
                headers : {
                    'Content-Type': 'application/json;charset=utf-8;'
                }
        }
        $http.get(url, config).then(function (GameResponse) {
            $scope.GameResponse = GameResponse.data
        }, function (GameResponse) {
            $scope.getResultMessage = "Fail!";
        });
    }
	

	
    
    $scope.AddGame = function(){
        var url = $location.absUrl() + "/create-game/"+$scope.Course.id+"/"+$scope.Type.typeId+"/1";
        
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
        	var url2= $location.absUrl() + "/get-type-template/"+$scope.Type.typeName;
  
            $http.get(url2, config).then(function (TypeTempResponse) {
                $scope.TypeTempResponse = TypeTempResponse.data
                document.write($scope.TypeTempResponse);
            }, function (TypeTempResponse) {
                $scope.getResultMessage = "Fail!";
            });
            
        }, function (GameResponse) {
            $scope.postResultMessage = "Fail!";
        });
        
        
        
       
    }


});




    