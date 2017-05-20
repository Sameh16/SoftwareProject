var app = angular.module('Student', []);

app.controller('studentController', function($scope, $http, $location) {
	$scope.ShowGames=false;
	$scope.ShowCategories=false;
	document.getElementById("CDropdown").classList.toggle("show");
	document.getElementById("myDropdown").classList.toggle("show");
	
	
	
		$scope.ChangeCategoryShow= function() {
			if($scope.ShowCategories==false){
			document.getElementById("cat").classList.toggle("active");
			document.getElementById("home").classList.remove("active");
			}
			else{
				document.getElementById("home").classList.toggle("active");
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
	
	//$scope.getcategory = function(){
		var url = "/get-category";
        var config = {
                headers : {
                    'Content-Type': 'application/json;charset=utf-8;'
                }
        }
        
        $http.get(url, config).then(function (CategoryResponse) {
            $scope.categories = CategoryResponse.data
        }, function (CategoryResponse) {
            $scope.getResultMessage = "Fail!";
        });
   // }
    
        
        var url = "/get-student-notification/"+$scope.username;


    	$http.get(url, config).then(function(notifications) {
    		$scope.notifications = notifications.data
    	}, function(notifications) {
    		$scope.getResultMessage = "Fail!";
    	});
    
//	$scope.getCourses = function(){
        url = "/get-Student-courses/"+$scope.username;
        
        $http.get(url, config).then(function (response) {
            $scope.Courses = response.data;
        }, function (response) {
            $scope.getResultMessage = "Fail!";
        });
        
       
   // }
        
        
       // $scope.getGames = function(){
           
        	url = "/get-student-games-score/"+$scope.username;   
            $http.get(url, config).then(function (response) {
                $scope.Games = response.data
                
            }, function (response) {
                $scope.getResultMessage = "Fail!";
            });
            
       // }
	
	
	$scope.CourseInCategory = function(Category){
		categoryName=Category.categoryName;
    	localStorage.setItem('categoryName',categoryName);
    	var url= "/CourseInCategory";
    	window.open(url,"_self");
    }
	
	

    $scope.playGame=function (Game)
    {
    	
    	gameName=Game.gameName;
    	localStorage.setItem('gameName',gameName);
    	var url= "/playGameQ";
    	window.open(url,"_self");
    }
	
	$scope.GameInCourse = function(course){
        courseName=course.courseName;
    	localStorage.setItem('courseName',courseName);
    	var url= "/GameInCourse";
    	window.open(url,"_self");
    }
	
	 $(".notificationicon").click(function () {
		    $(this).toggleClass("open");
		    $("#notificationMenu").toggleClass("open");
		  });
	
});
 
