var app = angular.module('Course', []);

app.controller('CourseController', function($scope, $http, $location) {

	$scope.ShowGames=false;
	$scope.ShowCategories=false;
	document.getElementById("myDropdown").classList.toggle("show");
	 document.getElementById("CDropdown").classList.toggle("show");
	
	  $scope.ChangeCategoryShow= function() {
			if($scope.ShowCategories==false){
			document.getElementById("cat").classList.toggle("active");
			document.getElementById("co").classList.remove("active");
			}
			else{
				document.getElementById("co").classList.toggle("active");
				document.getElementById("cat").classList.remove("active");
			}
			
			$scope.ShowCategories=!$scope.ShowCategories;
			
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
