var app = angular.module('Play', []);
var id=1;
var number_of_correct_answers=0;
var number_of_wrong_answers=0;

app.controller('PlayGameController', function($scope, $http, $location) {
	

	 $scope.number_of_correct_answers=0;
	 $scope.number_of_wrong_answers=0;
	 $scope.currentQuestion=1;
	
	$scope.getQuestionAtIndex= function()
	{
		
		var url ="/playgame/"+id+"/"+$scope.currentQuestion;  
	    var config = {
	            headers : {
	                'Content-Type': 'application/json;charset=utf-8;'
	            }
	    }
     $http.get(url, config).then(function (Question) {
    	 $scope.Quest = Question.data
    	 
	     }, function (Question) {
	         $scope.getResultMessage = "Fail!";
	     });
	    
	}
	
	
	
	
	$scope.GameName='staaaart';
	//$scope.Quest=$scope.questions.getValue(currentQuestion);
	//alert($scope.Quest.question);
	
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
	
     
     
//	$scope.answer2=;
//	$scope.answer3=;
//	$scope.answer4=;
	
	 
//    $scope.submitForm = function(){
//        var url = $location.absUrl() +"/create-game";
//        
//        var config = {
//                headers : {
//                    'Content-Type': 'application/json;charset=utf-8;'
//                }
//        }
//        var data = {
//        	GameName: $scope.GameName,
//        	Type: $scope.Type,
//        	Course: $scope.Course
//        	
//      
//        };
//        
//        $http.post(url, data, config).then(function (response) {
//            $scope.postResultMessage = "Sucessful!";
//        }, function (response) {
//            $scope.postResultMessage = "Fail!";
//        }); }
//         
       
    
});






 
