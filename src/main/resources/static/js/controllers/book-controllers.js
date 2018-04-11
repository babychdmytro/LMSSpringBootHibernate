lmsApp.controller("bookController", function($scope, $http, $window, $location, $q, $timeout, lmsFactory){
	
	if($location.path().indexOf('/admin/addbook') > -1){
	    $http.get("http://localhost:8080/lms/initBook").success(function(data){
	        $scope.book = data;
	    })
	    $http.get("http://localhost:8080/lms/initAuthor").success(function(data){
	        $scope.author = data;
	    })
	    
	    $http.get("http://localhost:8080/lms/admin/initPublisher").success(function(data){
	        $scope.publisher = data;
	    })
		lmsFactory.readAllObjects("http://localhost:8080/lms/admin/readAuthors").then(function(data){
			$scope.authors = data;
		})
		lmsFactory.readAllObjects("http://localhost:8080/lms/admin/readPublishers").then(function(data){
			$scope.publishers = data;
		})
		lmsFactory.readAllObjects("http://localhost:8080/lms/admin/readGenres").then(function(data){
			$scope.genres = data;
		})

	    
	}else{
		
		lmsFactory.readAllObjects("http://localhost:8080/lms/admin/readBooks").then(function(data){
			$scope.books = data;
		})
		lmsFactory.readAllObjects("http://localhost:8080/lms/admin/readAuthors").then(function(data){
			$scope.authors = data;
		})
	}
	
	
	
	
	$scope.saveBook = function(){
		
		var book = {
				'title' : $scope.book.title,
				'publisher' : {
					'publisherId' : $scope.publisher.publisherId
				} 
		}
		
		lmsFactory.saveObject("http://localhost:8080/lms/admin/saveBookWithPk", book).then(function(data){
			
			for(var i=0; i<$scope.chosenAuthors.authorId.length; i++){
				console.log($scope.chosenAuthors.authorId[i]);
				lmsFactory.dummy("http://localhost:8080/lms/admin/saveBookAuthors/" + data + "/" + $scope.chosenAuthors.authorId[i]).then(function(data){
					
				})
			}
			
			for(var i=0; i<$scope.chosenGenres.genre_id.length; i++){
				console.log($scope.chosenGenres.genre_id[i]);
				lmsFactory.dummy("http://localhost:8080/lms/admin/saveBookGenres/" + data + "/" + $scope.chosenGenres.genre_id[i]).then(function(data){
					
				})
			}
			
			lmsFactory.readAllObjects("http://localhost:8080/lms/admin/readBooks").then(function(data){
				$scope.book = data;
				$window.location.href = "#/admin/viewbooks"
			})
		})
		
		lmsFactory.readAllObjects("http://localhost:8080/lms/admin/readBooks").then(function(data){
			$scope.book = data;
			$window.location.href = "#/admin/viewbooks"
		})
		
		
	}
	
	
	$scope.saveEditedBook = function(){
		lmsFactory.saveObject("http://localhost:8080/lms/admin/updateBook", $scope.book).then(function(data){
			lmsFactory.readAllObjects("http://localhost:8080/lms/admin/readBooks").then(function(data){
				$scope.books = data;
				$window.location.href = "#/admin/viewbooks"
			})
		})

    }
	
	//deleting book
	$scope.deleteBook = function(bookId){
		var book = {
				'bookId' : bookId
		}
		lmsFactory.saveObject("http://localhost:8080/lms/admin/deleteBook", book).then(function(data){
			lmsFactory.readAllObjects("http://localhost:8080/lms/admin/readBooks").then(function(data){
				$scope.books = data;
				$window.location.href = "#/admin/viewbooks"
			})
            
        })
    }
	
	$scope.openModal = function(bookId){
        $http.get("http://localhost:8080/lms/admin/getBookByPk/" + bookId).success(function(data){
        	$scope.book = data;
        })
    }
	
})