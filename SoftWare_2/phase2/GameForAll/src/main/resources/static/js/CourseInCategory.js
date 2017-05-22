var app = angular.module('CourseInCategory', []);

app.controller('CourseInCategoryController',function($scope, $http, $location) {

	
	$scope.ShowGames=false;
	$scope.ShowCategories=false;
	document.getElementById("myDropdown").classList.toggle("show");
	 document.getElementById("CDropdown").classList.toggle("show");
	
	  $scope.ChangeCategoryShow= function() {
			if($scope.ShowCategories==false){
			document.getElementById("cat").classList.toggle("active");
			
			}
			else{
				
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
		
			var categoryName = localStorage.getItem('categoryName');
			$scope.Name=categoryName;
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
		    	$scope.path= "/CourseInCategory";
		    	window.open($scope.path,"_self");
		    }
			
			$scope.logout = function() {
				localStorage.setItem("username", "");
				var url = "/";
				windows.open(url, "_self");
			}
			
			  $scope.playGame=function (Game)
			    {
			    	localStorage.setItem('gameId',Game.gameId);
			    	localStorage.setItem('GameName',Game.gameName);
			    	var url= "/playGameQ";
			    	window.open(url,"_self");
			    }

		});
