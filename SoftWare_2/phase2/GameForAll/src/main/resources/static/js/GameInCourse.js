var app = angular.module('GameInCourse', []);

app.controller('GameInCourseController', function($scope, $http, $location) {

	$scope.username = localStorage.getItem('username');
	var courseName = localStorage.getItem('courseName');

	if (localStorage.getItem("username") == "") {

		var url = "/";
		window.open(url, '_self');
	}

	url = "/get-user-type/" + $scope.username;
	var config = {
		headers : {
			'Content-Type' : 'application/json;charset=utf-8;'
		}
	}

	$http.get(url, config).then(function(response2) {

		$scope.type = response2.data;
		if (response2.data == 0) {
			$scope.teacher = true;
			$scope.registered  = true;
		} else {
			$scope.teacher = false;
			/* check if Register or not */
			
			url = "/student/isregister/" + $scope.username + "/" + courseName;

			$http.get(url, config).then(function(res) {

				$scope.registered = res.data;
			}, function(res) {
				$scope.registered = res.data;
			});


			/*  */
		}

	}, function(response2) {
		$scope.type = response2.data;
	});

	

	url = $location.absUrl() + "/show-Course-games/" + courseName;

	$http.get(url, config).then(function(response) {
		$scope.Games = response.data

	}, function(response) {
		$scope.getResultMessage = "Fail!";
	});

	url = "/get-category";

	$http.get(url, config).then(function(CategoryResponse) {
		$scope.categories = CategoryResponse.data
	}, function(CategoryResponse) {
		$scope.getResultMessage = "Fail!";
	});

	$scope.playGame = function(Game) {

		gameId = Game.gameId;
		localStorage.setItem('gameId', gameId);
		var url = "/playGameQ";
		window.open(url, "_self");
	}
	
	$scope.CommentGame = function(Game) {

		gameId = Game.gameId;
		localStorage.setItem('gameId', gameId);
		localStorage.setItem('username', $scope.username);
		
		var url = "/comment";
		window.open(url, "_self");
	}

	$scope.logout = function() {
		localStorage.setItem("username", "");
		var url = "/";
		windows.open(url, "_self");
	}

	$scope.RegisterStudnet = function() {
		var url = "/student/add-course/" + $scope.username + "/" + courseName;

		$http.get(url, config).then(function(response) {

		}, function(response) {
			$scope.getResultMessage = "Fail!";
		});

	}
});
