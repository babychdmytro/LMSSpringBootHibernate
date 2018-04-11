lmsApp.controller("authorController", function($scope, $http, $window, $location, lmsFactory){

	if($location.path().indexOf('/admin/addauthor') > -1){
	    $http.get("http://localhost:8080/lms/initAuthor").success(function(data){
	        $scope.author = data;
	    })
	}else{
		lmsFactory.readAllObjects("http://localhost:8080/lms/admin/readAuthors").then(function(data){
			$scope.authors = data;
		})
	}

	$scope.saveAuthor = function(){
		
		lmsFactory.saveObject("http://localhost:8080/lms/admin/updateAuthor", $scope.author).then(function(data){
			lmsFactory.readAllObjects("http://localhost:8080/lms/admin/readAuthors").then(function(data){
				$scope.authors = data;
				$window.location.href = "#/admin/viewauthors"
			})
		})

    }
	
	$scope.searchAuthors = function(){
		lmsFactory.readAllObjects("http://localhost:8080/lms/admin/searchAuthors/" + $scope.searchAuthorString).then(function(data){
			$scope.authors = data;
		})
	}
	
	$scope.deleteAuthor = function(authorId){
		var author = {
				'authorId' : authorId
		}
		lmsFactory.saveObject("http://localhost:8080/lms/admin/deleteAuthor", author).then(function(data){
			lmsFactory.readAllObjects("http://localhost:8080/lms/admin/readAuthors").then(function(data){
				$scope.authors = data;
				$window.location.href = "#/admin/viewauthors"
			})
            
        })
    }
	
	$scope.openModal = function(authorId){
        $http.get("http://localhost:8080/lms/admin/getAuthorByPk/" + authorId).success(function(data){
        	$scope.author = data;
        })
    }
})