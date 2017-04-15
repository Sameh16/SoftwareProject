 var app = angular.module('Type', []);


app.controller('TypeTemplateController', function($scope, $http, $location) {
	 $scope.CurrentLevel=1;
	 $scope.CurrentQuestion=1;
	 $scope.NumberOfAllQuestions=0;
	 $scope.NameOfButtonLevel="Next level";
	 var id;	
	 
	$scope.UpdateQuestion = function(){
		$scope.CurrentQuestion=$scope.CurrentQuestion+1;
		$scope.NumberOfAllQuestions=$scope.NumberOfAllQuestions+1;
		if($scope.CurrentLevel==$scope.GameResponse.numOfLevels){
			$scope.NameOfButtonLevel="Finish Game";
		}
    }
	
	
	
	$scope.UpdateLevel = function(){
		if($scope.CurrentLevel==$scope.GameResponse.numOfLevels){
			document.write("bravo");
		}
		$scope.CurrentQuestion=1;
		$scope.CurrentLevel=$scope.CurrentLevel+1;
		
    }
	
	
	$scope.getgame = function(){
		 id=localStorage.getItem('id');
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
	

	
    
	 $scope.AddQuestion = function(){
	        var url ="/create-question/"+id;
	        var config = {
	                headers : {
	                    'Content-Type': 'application/json;charset=utf-8;'
	                }
	        }
	        var data = {
	        	question: $scope.Question,
	        	gameId: id,
	        	level: $scope.CurrentLevel
	        };
	        
	        $http.post(url, data, config).then(function (AddResponse) {
	        	$scope.AddResponse = AddResponse.data
	        	
	        	$scope.Question="";
	        }, function (AddResponse) {
	            $scope.postResultMessage = "Fail!";
	        });
	        
	    }

});




    