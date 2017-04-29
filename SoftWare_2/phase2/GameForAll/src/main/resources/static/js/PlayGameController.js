var app = angular.module('Play', []);
var number_of_correct_answers=0;
var number_of_wrong_answers=0;

app.controller('PlayGameController', function($scope, $http, $location) {
	

	 $scope.number_of_correct_answers=0;
	 $scope.number_of_wrong_answers=0;
	 $scope.currentQuestion=1;
	 $scope.studentName=localStorage.getItem("username");
	 $scope.gameId=localStorage.getItem("gameId");
	 
	 if (localStorage.getItem("username") == "") {

			var url = "/";
			window.open(url, '_self');
		}
	 var url ="/playgame/"+$scope.gameId;    
	    var config = {
	            headers : {
	                'Content-Type': 'application/json;charset=utf-8;'
	            }
	    }
		  $http.get(url, config).then(function (Questions1) {
		 	 $scope.questions = Questions1.data
		  }, function (Questions) {
			         $scope.getResultMessage = "Fail!";
	     });
	 
	 
	 $scope.radio=1;

	 
	 
	 
	 $scope.SaveGameData= function()
		{
			
			
			
			
			var url ="/SaveStudentGame/"+$scope.gameId+"/"+$scope.studentName;  
		        
		        var config = {
		                headers : {
		                    'Content-Type': 'application/json;charset=utf-8;'
		                }
		        }
		        var data = {
		        		
		        	student: $scope.studentName,
		        	game: $scope.game,
		        	achievement: $scope.achievements,
		        	comment: $scope.comment,
		        	rate: $scope.v,
		        	level: 1
		      
		        };
		         
		        $http.post(url, data, config).then(function (saveStudentGame) {
		        	$scope.result = saveStudentGame.data
		        	$scope.postResultMessage = "done";
		        	if ($scope.result)
		        		url="/student"
		        	else 	url="/teacher";
		        	window.open(url,"_self");
		        	
		        	
		        }, function (saveStudentGame) {
		            $scope.postResultMessage = "Fail!";
		        });
			
			
			
			
		} 
	 
	 
	 
	 
	$scope.getQuestionAtIndex= function()
	{
		
		var url ="/playgame/"+$scope.gameId+"/"+$scope.currentQuestion;  
	    var config = {
	            headers : {
	                'Content-Type': 'application/json;charset=utf-8;'
	            }
	    }
     $http.get(url, config).then(function (Question) {
    	 $scope.Quest = Question.data;
    	 if(typeof($scope.Quest.questionId) == "undefined")
    		 {
    		 $scope.achievements=($scope.number_of_correct_answers*10);
    		 	$scope.show=false;
    		 	$scope.score=true;

    		 	
    		 }
    	 else
    		 {
    		 	$scope.show=true;
    		 	$scope.score=false;
    		 }
    	 
	     }, function (Question) {
	         $scope.getResultMessage = "Fail!";
	     });
	    
	}
	
	
	
	

	$scope.checkbutton= function (ans,index)
	{
		$scope.currentQuestion++;
		$scope.getQuestionAtIndex();
		if (ans.correctAnswer==true)
			{
			$scope.number_of_correct_answers+=1;
			}
		else {
			$scope.number_of_wrong_answers+=1;
		}
	}
	
	$scope.getQuestions= function()
	{
		
		var url ="/playgame/"+id;    
	    var config = {
	            headers : {
	                'Content-Type': 'application/json;charset=utf-8;'
	            }
	    }
     $http.get(url, config).then(function (Questions) {
    	 $scope.questions = Questions.data
     }, function (Questions) {
	         $scope.getResultMessage = "Fail!";
	     });
	}
	
     

    
});






 
