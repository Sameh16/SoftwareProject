var app = angular.module('Student', []);

app.controller('studentController', function($scope, $http, $location) {
	
	
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
	
});
 
