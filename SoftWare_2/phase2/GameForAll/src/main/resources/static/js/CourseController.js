var app = angular.module('Course', []);

app.controller('CourseController', function($scope, $http, $location) {
    $scope.submitForm = function(){
        var url = $location.absUrl() +"/addcourse/"+$scope.Category.categoryName+"/"+$scope.TeacherID;
        
        var config = {
                headers : {
                    'Content-Type': 'application/json;charset=utf-8;'
                }
        }
        var data = {
        	minimunAge: $scope.MinimunAge,
        	courseName: $scope.CourseName
      
        };
        $http.post(url, data, config).then(function (response) {
            $scope.postResultMessage = "Sucessful!";
        }, function (response) {
            $scope.postResultMessage = "Fail!";
        });
         
        $scope.CourseName="";
    	$scope.CategoryId="";
    	$scope.TeacherID="";
    	$scope.MinimunAge="";
    }
    
	$scope.getcategory = function(){
		var url = $location.absUrl()+"/get-category";
        var config = {
                headers : {
                    'Content-Type': 'application/json;charset=utf-8;'
                }
        }
        
        $http.get(url, config).then(function (CategoryResponse) {
            $scope.CategoryResponse = CategoryResponse.data
        }, function (CategoryResponse) {
            $scope.getResultMessage = "Fail!";
        });
    }
    
    
	$scope.getCourses = function(){
        var url = $location.absUrl()+"/show-courses/"+$scope.CategoryName.categoryName;
        var config = {
                headers : {
                    'Content-Type': 'application/json;charset=utf-8;'
                }
        }
        
        $http.get(url, config).then(function (response) {
            $scope.Coursee = response.data
            
        }, function (response) {
            $scope.getResultMessage = "Fail!";
        });
    }
	
	
	$scope.GameInCourse = function(courses){
        courseName=courses.courseName;
    	localStorage.setItem('courseName',courseName);
    	var url= "/GameInCourse";
    	window.open(url,"_self");
    }
	
});
 
