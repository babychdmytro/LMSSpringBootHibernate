lmsApp.controller("borrowerController", function($scope, $http, $window, $location, lmsFactory){
	
	
	if($location.path().indexOf('/borrower/borrower') > -1){
		
		$scope.error = false;
		
	    $http.get("http://localhost:8080/lms/borrower/initBorrower").success(function(data){
	        $scope.borrower = data;
	    })
		
		lmsFactory.readAllObjects("http://localhost:8080/lms/borrower/readBorrowers").then(function(data){
			$scope.borrowers = data;
		})
		
		$scope.$watch.cardNo = null;

		
	}else if($location.path().indexOf('/borrower/checkoutbook') > -1){
		
		lmsFactory.readAllObjects("http://localhost:8080/lms/admin/readBranches").then(function(data){
			$scope.branches = data;
		})
		
	    $http.get("http://localhost:8080/lms/initBranch").success(function(data){
	        $scope.branch = data;
	    })
	    
	    $http.get("http://localhost:8080/lms/borrower/initBookLoan").success(function(data){
	        $scope.bookloan = data;
	    })
		
	}else if($location.path().indexOf('/borrower/returnbook') > -1){
		
		
		lmsFactory.readAllObjects("http://localhost:8080/lms/borrower/readBorrowedBookLoansByCardNo/" + $scope.$watch.cardNo).then(function(data){
			
			$scope.bookloans = data;
			
		})
		
	}
	
	
	$scope.verifyCardNo = function(){
		
		$scope.access = false;
		$scope.error = true;
		
		console.log($scope.cardNoInput);
        
			for (var i = 0; i < $scope.borrowers.length; i++) {
				if($scope.cardNoInput == $scope.borrowers[i].cardNo){
					$scope.access = true;
					$scope.error = false;
					$scope.$watch.cardNo = $scope.borrowers[i].cardNo;
					
					lmsFactory.readAllObjects("http://localhost:8080/lms/borrower/readBorrowerByCardNo/" + $scope.borrowers[i].cardNo).then(function(data){
						$scope.borrower = data;
					})
					
				}
			};
		
    }
	
	$scope.checkoutBook = function(bookId){
		
		var dateOut = new Date();
		var dateOutTemp = new Date();
		var dueDate = dateOutTemp.setDate(dateOutTemp.getDate() + 7);
		
		var bookloan = {
				'branch' : {
					'branchId' : $scope.branch.branchId
				},
				'cardNo' : $scope.$watch.cardNo,
				'book' : {
					'bookId' : bookId
				} ,
				'dateOut' : dateOut,
				'dueDate' : dueDate
		}
//		$scope.bookloan.branch.branchId = $scope.branch.branchId;
//		$scope.bookloan.cardNo = $scope.$watch.cardNo;
//		$scope.bookloan.book.bookId = bookId;
//
//		$scope.bookloan.dateOut = dateOut;
//		$scope.bookloan.dueDate = dueDate;
		
		
		$http.get("http://localhost:8080/lms/librarian/getBookCopiesByBookIdAndBranch/" + bookloan.book.bookId +"/" + $scope.branch.branchId).success(function(data){
			$scope.bookcopies = data;
			$scope.bookcopies.noOfCopies -=1;
			
			lmsFactory.saveObject("http://localhost:8080/lms/librarian/updateBookCopies", $scope.bookcopies).then(function(data){
				
			})
			
		})
		
		lmsFactory.saveObject("http://localhost:8080/lms/borrower/updateBookLoan", bookloan).then(function(data){
			$scope.access = true;
			$window.location.href = "#/borrower/borrower"
		})
		
	}
	
	$scope.returnBook = function(bookloan){
		
		console.log(bookloan);
		
		var dateIn = new Date();
//		var returnbookloan = {
//				'branchId' : bookloan.branch.branchId,
//				'cardNo' :  bookloan.cardNo,
//				'bookId' : bookloan.book.bookId,
//				'dateOut' : bookloan.dateOut,
//				'dueDate' : bookloan.dueDate,
//				'dateIn' : dateIn
//		}
		bookloan.dateIn = dateIn;
		
		$http.get("http://localhost:8080/lms/librarian/getBookCopiesByBookIdAndBranch/" + bookloan.book.bookId +"/" + bookloan.branch.branchId).success(function(data){
			$scope.bookcopies = data;
			$scope.bookcopies.noOfCopies +=1;
			
			lmsFactory.saveObject("http://localhost:8080/lms/librarian/updateBookCopies", $scope.bookcopies).then(function(data){
				
			})
			
		})
		
		lmsFactory.saveObject("http://localhost:8080/lms/borrower/updateBookLoan", bookloan).then(function(data){

		})
		
		$scope.access = true;
		$window.location.href = "#/borrower/borrower"
		
		
	}
	
	
})