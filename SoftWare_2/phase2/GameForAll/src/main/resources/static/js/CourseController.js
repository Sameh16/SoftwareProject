var app = angular.module('Course', []);

app.controller('CourseController', function($scope, $http, $location) {

	$scope.username = localStorage.getItem("username");

	if (localStorage.getItem("username") == "") {

		var url = "/login";
		$window.open(url, '_self');
	}

	$scope.submitForm = function() {
		var url = "/addcourse/" + $scope.Category.categoryName + "/"
				+ $scope.username;

		var config = {
			headers : {
				'Content-Type' : 'application/json;charset=utf-8;'
			}
		}
		var data = {
			minimunAge : $scope.MinimunAge,
			courseName : $scope.CourseName

		};
		$http.post(url, data, config).then(function(response) {
			if (response.data == true) {
				url="/teacher";
				$window.open(url,'_self');
				$scope.postResultMessage = "Sucessful!";
			} else {
				alert("Course Name In use!!");
				$scope.postResultMessage = "Fail!";
			}
			
		}, function(response) {
			$scope.postResultMessage = "Fail!";
		});

		$scope.CourseName = "";
		$scope.MinimunAge = "";
	}

	$scope.getcategory = function() {
		var url = "/get-category";
		var config = {
			headers : {
				'Content-Type' : 'application/json;charset=utf-8;'
			}
		}

		$http.get(url, config).then(function(CategoryResponse) {
			$scope.CategoryResponse = CategoryResponse.data
		}, function(CategoryResponse) {
			$scope.getResultMessage = "Fail!";
		});
	}

	$scope.logout = function() {
		localStorage.setItem("username", "");
		var url = "/login";
		windows.open(url, "_self");
	}

});
