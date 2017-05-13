var app = angular.module('Comment', []);



app.controller('CommentController', function($scope, $http, $location) {
	$scope.gameID=localStorage.getItem("gameId");
	$scope.userName= localStorage.getItem('username');;
	
	$scope.GameName= "er";
	$scope.saveComment= function() {
	
		
	        
	        

			var url ="/WriteComment/"+$scope.gameID+"/"+$scope.userName;  
		        
		        var config = {
		                headers : {
		                    'Content-Type': 'application/json;charset=utf-8;'
		                }
		        }
		        var data = {
		        		
		        		comment:$scope.comment,

		        };
		         
		        $http.post(url, data, config).then(function (saveComment) {
		        	$scope.result = saveComment.data
		        	$scope.postResultMessage = "done";
//		        	if ($scope.result)
//		        		url="/student"
//		        	else 	url="/teacher";
//		        	window.open(url,"_self");
		        	
		        	
		        }, function (saveStudentGame) {
		            $scope.postResultMessage = "Fail!";
		        });
	}
	

});




    