var app = angular.module('Game', []);



app.controller('GameController', function($scope, $http, $location) {
	
	
	
	
	$scope.Course = localStorage.getItem('courseName');
	$scope.Category = localStorage.getItem('categoryName');
	
	$scope.ShowGames=false;
	$scope.ShowCategories=false;
	document.getElementById("myDropdown").classList.toggle("show");
	 document.getElementById("CDropdown").classList.toggle("show");
	
	 url = "/get-category";

		$http.get(url, config).then(function(CategoryResponse) {
			$scope.categories = CategoryResponse.data
		}, function(CategoryResponse) {
			$scope.getResultMessage = "Fail!";
		});
		
	 
	  $scope.ChangeCategoryShow= function() {
			if($scope.ShowCategories==false){
			document.getElementById("cat").classList.toggle("active");
			document.getElementById("create").classList.remove("active");
			
			}
			else{
				document.getElementById("create").classList.toggle("active");
				document.getElementById("cat").classList.remove("active");
			}
			
			$scope.ShowCategories=!$scope.ShowCategories;
			
			}
		
		$scope.GetGames = function(){
			var url = "/get-game/" + $scope.search;
			
			if($scope.search==""){
				$scope.ShowGames=false;
			}

			$http.get(url, config).then(function(GameResponsed) {
				
				$scope.SearchedGames=GameResponsed.data;
				if($scope.SearchedGames!="" && $scope.search!=""){
					$scope.ShowGames=true;
				}
				else{
					$scope.ShowGames=false;
				}
			}, function(GameResponsed) {
				$scope.getResultMessage = "Fail!";
			});
			
			}
	
	
	
	url = "/get-user-type/" + $scope.username;
	var config = {
		headers : {
			'Content-Type' : 'application/json;charset=utf-8;'
		}
	}

	$http.get(url, config).then(function(response2) {

		$scope.type = response2.data;
		if (response2.data == 0) {
			$scope.teacher = true;
			$scope.registered  = true;
		} else {
			$scope.teacher = false;
			/* check if Register or not */
			
			url = "/student/isregister/" + $scope.username + "/" + courseName;

			$http.get(url, config).then(function(res) {

				$scope.registered = res.data;
			}, function(res) {
				$scope.registered = res.data;
			});


			/*  */
		}

	}, function(response2) {
		$scope.type = response2.data;
	});
	
	$scope.username= localStorage.getItem('username');
	
	if (localStorage.getItem("username") == "") {

		var url = "/";
		window.open(url, '_self');
	}
	
	
	
	
	$scope.gettype = function(){
		
	        var url = "/get-type";
	        var config = {
	                headers : {
	                    'Content-Type': 'application/json;charset=utf-8;'
	                }
	        }
	        
	        $http.get(url, config).then(function (TypeResponse) {
	            $scope.TypeResponse = TypeResponse.data
	            
	        }, function (TypeResponse) {
	            $scope.getResultMessage = "Fail!";
	        });
	    }
	 
   
    
    $scope.AddGame = function(){
    	var urlg = "/verify-game-name/"+$scope.gameName;
    	 var config = {
                 headers : {
                     'Content-Type': 'application/json;charset=utf-8;'
                 }
         }
      
        $http.get(urlg, config).then(function (VerifyResponse) {
            $scope.VerifyResponse = VerifyResponse.data
            
            if($scope.VerifyResponse==false){
            	$scope.VerifyMsg="Game Name is already Taken";
            
            }
            else{
            	var url = "/create-game/"+$scope.Course+"/"+$scope.Type.typeId+"/"+$scope.username;

                 var data = {
                 	gameName: $scope.gameName,
                 	Type: $scope.Type.typeId,
                 	numOfLevels: $scope.numOfLevels,
                 	description: $scope.description,
                 	teacherId: $scope.username
               
                 };
                  
                 $http.post(url, data, config).then(function (GameResponse) {
                	 alert("hi2");
                 	$scope.GameResponse = GameResponse.data
                 	id=$scope.GameResponse;
                 	localStorage.setItem('id',id);
                 	var url2="/get-type-template/"+$scope.Type.typeName;
                 	window.open(url2,"_self");
                 }, function (GameResponse) {
                     $scope.postResultMessage = "Fail!";
                 });
                 
            }
            
        }, function (VerifyResponse) {
            $scope.VerifyResponse = "Fail!";
        });
    	 
       
    	 
        
       
    }
    
    $scope.CourseInCategory = function(Category){
		categoryName=Category.categoryName;
    	localStorage.setItem('categoryName',categoryName);
    	$scope.path= "/CourseInCategory";
    	window.open($scope.path,"_self");
    }


});





    