lmsApp.controller("adminController", function($scope, $http, $window, $location, lmsFactory){
	
	if($location.path().indexOf('/admin/viewpublishers') > -1){
		
	    $http.get("http://localhost:8080/lms/admin/initPublisher").success(function(data){
	        $scope.publisher = data;
	    })
		
		lmsFactory.readAllObjects("http://localhost:8080/lms/admin/readPublishers").then(function(data){
			$scope.publishers = data;
		})
		
	}else if ($location.path().indexOf('/admin/viewborrowers') > -1){
		
	    $http.get("http://localhost:8080/lms/initBorrower").success(function(data){
	        $scope.borrower = data;
	    })
	    
		lmsFactory.readAllObjects("http://localhost:8080/lms/admin/readBorrowers").then(function(data){
			$scope.borrowers = data;
		})
		
	}else if ($location.path().indexOf('/admin/viewbranches') > -1){
		
	    $http.get("http://localhost:8080/lms/initBranch").success(function(data){
	        $scope.branch = data;
	    })
	    
		lmsFactory.readAllObjects("http://localhost:8080/lms/admin/readBranches").then(function(data){
			$scope.branches = data;
		})
		
	}else if ($location.path().indexOf('/admin/viewgenres') > -1){
		
	    $http.get("http://localhost:8080/lms/initBranch").success(function(data){
	        $scope.branch = data;
	    })
	    
		lmsFactory.readAllObjects("http://localhost:8080/lms/admin/readBranches").then(function(data){
			$scope.branches = data;
		})
		
	}else if ($location.path().indexOf('/admin/manageduedate') > -1){
		
	    $http.get("http://localhost:8080/lms/borrower/initBookLoan").success(function(data){
	        $scope.bookloan = data;
	    })
		
		lmsFactory.readAllObjects("http://localhost:8080/lms/borrower/readNotReturnedBookLoans").then(function(data){
			
			$scope.bookloans = data;
			
		})
		
	}else{
		
	    $http.get("http://localhost:8080/lms/admin/initPublisher").success(function(data){
	        $scope.publisher = data;
	    })
		
		
	    $http.get("http://localhost:8080/lms/initBorrower").success(function(data){
	        $scope.borrower = data;
	    })
	    
		
	    $http.get("http://localhost:8080/lms/initBranch").success(function(data){
	        $scope.branch = data;
	    })
	    
	}
	
	
	//Publisher
	$scope.savePublisher = function(){
		
		lmsFactory.saveObject("http://localhost:8080/lms/admin/updatePublisher", $scope.publisher).then(function(data){
			lmsFactory.readAllObjects("http://localhost:8080/lms/admin/readPublishers").then(function(data){
				$scope.publishers = data;
				$window.location.href = "#/admin/viewpublishers"
			})
		})

    }
	
	$scope.deletePublisher = function(publisherId){
		var publisher = {
				'publisherId' : publisherId
		}
		lmsFactory.saveObject("http://localhost:8080/lms/admin/deletePublisher", publisher).then(function(data){
			lmsFactory.readAllObjects("http://localhost:8080/lms/admin/readPublishers").then(function(data){
				$scope.publishers = data;
				$window.location.href = "#/admin/viewpublishers"
			})
            
        })
    }
	
	$scope.openPublisherModal = function(publisherId){
        $http.get("http://localhost:8080/lms/admin/getPublisherByPk/" + publisherId).success(function(data){
        	$scope.publisher = data;
        })
    }
	
	
	//Borrower
	$scope.saveBorrower = function(){
		
		lmsFactory.saveObject("http://localhost:8080/lms/admin/updateBorrower", $scope.borrower).then(function(data){
			lmsFactory.readAllObjects("http://localhost:8080/lms/admin/readBorrowers").then(function(data){
				$scope.borrowers = data;
				$window.location.href = "#/admin/viewborrowers"
			})
		})

    }
	
	$scope.deleteBorrower = function(cardNo){
		var borrower = {
				'cardNo' : cardNo
		}
		lmsFactory.saveObject("http://localhost:8080/lms/admin/deleteBorrower", borrower).then(function(data){
			lmsFactory.readAllObjects("http://localhost:8080/lms/admin/readBorrowers").then(function(data){
				$scope.borrowers = data;
				$window.location.href = "#/admin/viewborrowers"
			})
            
        })
    }
	
	$scope.openBorrowerModal = function(cardNo){
        $http.get("http://localhost:8080/lms/borrower/readBorrowerByCardNo/" + cardNo).success(function(data){
        	$scope.borrower = data;
        })
    }
	
	
	
	//Branch
	
	$scope.saveBranch = function(){
		
		lmsFactory.saveObject("http://localhost:8080/lms/admin/updateBranch", $scope.branch).then(function(data){
			lmsFactory.readAllObjects("http://localhost:8080/lms/admin/readBranches").then(function(data){
				$scope.branches = data;
				$window.location.href = "#/admin/viewbranches"
			})
		})

    }
	
	$scope.deleteBranch = function(branchId){
		var branch = {
				'branchId' : branchId
		}
		lmsFactory.saveObject("http://localhost:8080/lms/admin/deleteBranch", branch).then(function(data){
			lmsFactory.readAllObjects("http://localhost:8080/lms/admin/readBranches").then(function(data){
				$scope.branches = data;
				$window.location.href = "#/admin/viewbranches"
			})
            
        })
    }
	
	$scope.openBranchModal = function(branchId){
        $http.get("http://localhost:8080/lms/librarian/getBranchByPk/" + branchId).success(function(data){
        	$scope.branch = data;
        })
    }
	
	
	//Genre
	
	$scope.saveGenre = function(){
		
		lmsFactory.saveObject("http://localhost:8080/lms/admin/updateGenre", $scope.genre).then(function(data){
			lmsFactory.readAllObjects("http://localhost:8080/lms/admin/readGenres").then(function(data){
				$scope.genres = data;
				$window.location.href = "#/admin/viewgenres"
			})
		})

    }
	
	$scope.deleteGenre = function(genre_id){
		var genre = {
				'genre_id' : genre_id
		}
		lmsFactory.saveObject("http://localhost:8080/lms/admin/deleteGenre", genre).then(function(data){
			lmsFactory.readAllObjects("http://localhost:8080/lms/admin/readGenres").then(function(data){
				$scope.genres = data;
				$window.location.href = "#/admin/viewgenres"
			})
            
        })
    }
	
	$scope.openGenrehModal = function(genre_id){
        $http.get("http://localhost:8080/lms/admin/getGenreByPk/" + genre_id).success(function(data){
        	$scope.genre = data;
        })
    }
	
	$scope.openBookLoanModal = function(bookloan){
		
//		var dateFormat = require('dateformat');
//		var now = new Date();
//		dateFormat(now, "dddd, mmmm dS, yyyy, h:MM:ss TT");
		

		lmsFactory.saveObject("http://localhost:8080/lms/borrower/readBookLoansByDetails", bookloan).then(function(data){
			$scope.bookloan = data;
		})

//        $http.get("http://localhost:8080/lms/borrower/readBookLoansByDetails/"+bookloan.branch.branchId+"/"+bookloan.cardNo+"/"+bookloan.book.bookId+"/"+bookloan.dateOut).success(function(data){
//        	$scope.bookloan = data;
//        })
    }
	
	
	$scope.saveDueDate = function(){
		
		lmsFactory.saveObject("http://localhost:8080/lms/borrower/updateBookLoan", $scope.bookloan).then(function(data){
			lmsFactory.readAllObjects("http://localhost:8080/lms/borrower/readNotReturnedBookLoans").then(function(data){
				$scope.bookloans = data;
			})
			$window.location.href = "#/admin/manageduedate"
		})
		
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
})