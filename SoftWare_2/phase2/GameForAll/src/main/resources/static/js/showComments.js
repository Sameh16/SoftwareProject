var app = angular.module('ShowComment', []);



app.controller('ShowCommentController', function($scope, $http, $location) {
	$scope.gameID=localStorage.getItem("username");

			var url ="/GetComments/"+$scope.userName;  
		        var config = {
		                headers : {
		                    'Content-Type': 'application/json;charset=utf-8;'
		                }
		        }
		        $http.get(url, config).then(function (GetComments) {
		        	$scope.comments = GetComments.data
		        	$scope.postResultMessage = "done";
		        }, function (saveStudentGame) {
		            $scope.postResultMessage = "Fail!";
		        });
	
	

});




    