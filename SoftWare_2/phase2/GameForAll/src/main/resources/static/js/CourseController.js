var app = angular.module('Course', []);

app.controller('CourseController', function($scope, $http, $location) {
    $scope.submitForm = function(){
        var url = $location.absUrl() +"/addcourse/"+$scope.CategoryId+"/"+$scope.TeacherID;
        
        var config = {
                headers : {
                    'Content-Type': 'application/json;charset=utf-8;'
                }
        }
        var data = {
        	minimunAge: $scope.MinimunAge,
        	teacherID: $scope.TeacherID,
        	categoryId: $scope.CategoryId,
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
});
 
