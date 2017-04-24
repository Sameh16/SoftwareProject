var app = angular.module('CourseInCategory', []);

app.controller('CourseInCategoryController',function($scope, $http, $location) {

			var categoryName = localStorage.getItem('categoryName');
			$scope.username =  localStorage.getItem('username');
			
			if (localStorage.getItem("username") == "") {

				var url = "/";
				window.open(url, '_self');
			}
			
			  url = "/get-user-type/"+$scope.username; 
			   var config = {
		                headers : {
		                    'Content-Type': 'application/json;charset=utf-8;'
		                }
		        }
			  
			  $http.get(url, config).then(function (response2) { 
				 
				 $scope.type = response2.data; 
				 if(response2.data==0)
				 {
					  $scope.teacher = true;
				 }
				 else
				 {
					 $scope.teacher = false;
				 }
					  
				  },function (response2) {
					  $scope.type= response2.data; 
				});
			
			url = "/get-category";
	        
	        $http.get(url, config).then(function (CategoryResponse) {
	            $scope.categories = CategoryResponse.data
	        }, function (CategoryResponse) {
	            $scope.getResultMessage = "Fail!";
	        });
			

			url = "/show-courses/" +categoryName;

			$http.get(url, config).then(function(response) {
				$scope.Courses = response.data

			}, function(response) {
				$scope.getResultMessage = "Fail!";
			});

			$scope.GameInCourse = function(course){
		        courseName=course.courseName;
		    	localStorage.setItem('courseName',courseName);
		    	url= "/GameInCourse";
		    	/*if($scope.teacher==false)
		    	{
		    		student register
		    	}*/
		    	
		    	window.open(url,"_self");
		    }
			
			$scope.CourseInCategory = function(Category){
				categoryName=Category.categoryName;
		    	localStorage.setItem('categoryName',categoryName);
		    	var url= "/CourseInCategory";
		    	window.open(url,"_self");
		    }

		});
