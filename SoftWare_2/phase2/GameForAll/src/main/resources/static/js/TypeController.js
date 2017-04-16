 var app = angular.module('Type', []);


app.controller('TypeTemplateController', function($scope, $http, $location) {
	 $scope.CurrentLevel=1;
	 $scope.CurrentQuestion=1;
	 $scope.NumberOfAllQuestions=0;
	 $scope.NameOfButtonLevel="Next level";
	 $scope.temp;
	 $scope.array = [$scope.ans1,$scope.ans2,$scope.ans3,$scope.ans4];
	 
	 $scope.updatearray = function(){
		 $scope.array = [$scope.ans1,$scope.ans2,$scope.ans3,$scope.ans4];
	    }
	 $scope.correct = function(ans){
		 $scope.ans=ans;
	    }
	 
	$scope.gettemp = function(temp){
		$scope.temp=temp;
		
    }
	
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
	        	if($scope.temp=="TF"){
	        	$scope.AddAnswer("True");
	        	$scope.AddAnswer("False");
	        	$scope.ans="";
	        	}
	        	else if($scope.temp=="MCQ"){
	        		$scope.AddAnswer($scope.ans1);
		        	$scope.AddAnswer($scope.ans2);
		        	$scope.AddAnswer($scope.ans3);
		        	$scope.AddAnswer($scope.ans4);
	        	}
	        	$scope.Question="";
	        	$scope.ans1="";
	        	$scope.ans2="";
	        	$scope.ans3="";
	        	$scope.ans4="";
	        }, function (AddResponse) {
	            $scope.postResultMessage = "Fail!";
	        });
	        
	        
	        
	    }

	 $scope.AddAnswer = function(AnsName){
	        var url ="/create-answer/"+$scope.AddResponse;
	        var config = {
	                headers : {
	                    'Content-Type': 'application/json;charset=utf-8;'
	                }
	        }
	        
	        var data = {
	        		answer:AnsName,
	        		questionId: $scope.AddResponse,
	        		correctAnswer: 0
		        };
	        
	        if(data.answer==$scope.ans){
	        	data.correctAnswer=1;
	        }
	        $http.post(url, data, config).then(function (AddAns) {
	        	$scope.AddAns = AddAns.data
	        }, function (AddAns) {
	            $scope.postResultMessage = "Fail!";
	        });
	        	
	    }
	 
	

});




    