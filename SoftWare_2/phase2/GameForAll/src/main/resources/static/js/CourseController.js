var app = angular.module('Course', []);

app.controller('CourseController', function($scope, $http, $location) {

	$scope.username = localStorage.getItem("username");

	if (localStorage.getItem("username") == "") {

		var url = "/";
		window.open(url, '_self');
	}

	/* get Category */
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
	/**/

	$scope.submitForm = function() {
		var url = "/addcourse/" + $scope.Category.categoryName + "/"
				+ $scope.username;

		var config = {
			headers : {
				'Content-Type' : 'application/json;charset=utf-8;'
			}
		}
		var data = {
				"minimunAge" : $scope.MinimunAge,
				"courseName" : $scope.CourseName,
				"description": $scope.description
			};
		$http.post(url, data, config).then(function(response) {
			if (response.data == true) {
				url = "/teacher";
				window.open(url, '_self');
			} else {
				$scope.postResultMessage = "Course Name In use!!!";
				$scope.CourseName = "";
				$scope.MinimunAge = "";
			}

		}, function(response) {
			$scope.postResultMessage = "Fail!";
		});

		
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
		var url = "/";
		windows.open(url, "_self");
	}
	
	$scope.CourseInCategory = function(Category){
		categoryName=Category.categoryName;
    	localStorage.setItem('categoryName',categoryName);
    	var url= "/CourseInCategory";
    	window.open(url,"_self");
    }

});
