var app = angular.module('notify', []);

app.controller('notificationController', function($scope, $http, $location) {

	
	$scope.username = localStorage.getItem("username");
	if (localStorage.getItem("username") == "") {

		var url = "/";
		window.open(url, '_self');
	}
	url = "/get-category";
	var config = {
		headers : {
			'Content-Type' : 'application/json;charset=utf-8;'
		}
	}
	$http.get(url, config).then(function(CategoryResponse) {
		$scope.categories = CategoryResponse.data
	}, function(CategoryResponse) {
		$scope.getResultMessage = "Fail!";
	});
	
	
	var url = "/get-student-notification/"+$scope.username;


	$http.get(url, config).then(function(response) {
		$scope.notifications = response.data
	}, function(response) {
		$scope.getResultMessage = "Fail!";
	});
	
});