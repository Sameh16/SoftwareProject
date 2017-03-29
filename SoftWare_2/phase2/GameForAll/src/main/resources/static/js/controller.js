var app = angular.module('app', []);
app.controller('postcontroller', function($scope, $http, $location) {
    $scope.submitForm = function(){
        var url = $location.absUrl() + "addcourse";
         
        var config = {
                headers : {
                    'Content-Type': 'application/json;charset=utf-8;'
                }
        }
        var data = {
        	minimunAge: $scope.MinimunAge,
        	teacherID: $scope.TeacherID,
        	courseId: $scope.CourseId,
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
    	$scope.CourseId="";
    	$scope.MinimunAge="";
    }
});
 
app.controller('getcontroller', function($scope, $http, $location) {
    $scope.getfunction = function(){
        var url = $location.absUrl() + "1";
         
        var config = {
                headers : {
                    'Content-Type': 'application/json;charset=utf-8;'
                }
        }
         
        $http.get(url, config).then(function (response) {
            $scope.response = response.data
        }, function (response) {
            $scope.getResultMessage = "Fail!";
        });
    }
});