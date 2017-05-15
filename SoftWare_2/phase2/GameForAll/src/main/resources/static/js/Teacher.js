var app = angular.module('Teacher', []);

app.controller('teacherController', function($scope, $http, $location) {
	$scope.ShowGames=false;
	
	window.onload = function() {
		  document.getElementById("myDropdown").classList.toggle("show");
		};
	
		
		
		$scope.CopyGame= function() {
			alert($scope.games.gameName);
			while(true){
			$scope.NewGameName=prompt('Please Enter New Name for this game to copy it');
			if($scope.NewGameName!=""){
				break;
			}
			}
			while(true){
			$scope.NewCourseName=prompt('Please Enter New Course for this game to copy it');
			if($scope.NewCourseName!=""){
				break;
			}
			}
			
		$scope.teach = localStorage.getItem("username");
		
			var url ="/copygame/"+$scope.games.gameName+"/"+$scope.NewGameName+"/"+$scope.teach+"/"+$scope.NewCourseName; 
				alert(url);

			var config = {
				headers : {
					'Content-Type' : 'application/json;charset=utf-8;'
				}
			}
			var data = {
				};
			$http.get(url, config).then(function(GameResponse) {
			
			}, function(GameResponse) {
				$scope.getResultMessage = "Fail!";
			});

			
		}

		
		
		
	$scope.GetGames = function(){
	var url = "/get-game/" + $scope.search;
	
	if($scope.search==""){
		$scope.ShowGames=false;
	}

	$http.get(url, config).then(function(GameResponse) {
		
		$scope.SearchedGames=GameResponse.data;
		if($scope.SearchedGames!="" && $scope.search!=""){
			$scope.ShowGames=true;
		}
		else{
			$scope.ShowGames=false;
		}
	}, function(GameResponse) {
		$scope.getResultMessage = "Fail!";
	});
	
	}
	
	
	$scope.username = localStorage.getItem("username");
	if (localStorage.getItem("username") == "") {

		var url = "/";
		window.open(url, '_self');
	}

	// $scope.getcategory = function(){
	var url = "/get-category";
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
	// }

	// $scope.getCourses = function(){
	var url = "/get-Teacher-courses/" + $scope.username;

	$http.get(url, config).then(function(response) {
		$scope.Courses = response.data

	}, function(response) {
		$scope.getResultMessage = "Fail!";
	});

	// }

	// $scope.getGames = function(){
	var url = "/get-teacher-games/" + $scope.username;
	$http.get(url, config).then(function(response) {
		$scope.Games = response.data

	}, function(response) {
		$scope.getResultMessage = "Fail!";
	});

	// }

	$scope.CourseInCategory = function(Category) {
		categoryName = Category.categoryName;
		localStorage.setItem('categoryName', categoryName);
		var url = "/CourseInCategory";
		window.open(url, "_self");
	}

	$scope.playGame = function(Game) {
		gameId = Game.gameId;
		localStorage.setItem('gameId', gameId);
		var url = "/playGameQ";
		window.open(url, "_self");
	}

	$scope.GameInCourse = function(course) {
		courseName = course.courseName;
		localStorage.setItem('courseName', courseName);
		var url = "/GameInCourse";
		window.open(url, "_self");
	}

	$scope.logout = function() {
		localStorage.setItem("username", "");
		var url = "/";
		windows.open(url, "_self");
	} 

	

});
