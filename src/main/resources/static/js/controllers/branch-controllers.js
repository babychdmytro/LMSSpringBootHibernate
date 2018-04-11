lmsApp.controller("branchController", function($scope, $http, $window, $location, lmsFactory){

	if($location.path().indexOf('/librarian/librarian') > -1){
	    $http.get("http://localhost:8080/lms/initBranch").success(function(data){
	        $scope.branch = data;
	    })
	    
	    $http.get("http://localhost:8080/lms/initBook").success(function(data){
	        $scope.book = data;
	    })
	    
  	    $http.get("http://localhost:8080/lms/librarian/initBookCopies").success(function(data){
	        $scope.bookcopies = data;
	    })
		
		lmsFactory.readAllObjects("http://localhost:8080/lms/admin/readBranches").then(function(data){
			$scope.branches = data;
		})
		
		lmsFactory.readAllObjects("http://localhost:8080/lms/admin/readBooks").then(function(data){
			$scope.books = data;
		})
		
	}else{
	}
	
	
	$scope.processBranch = function(){
		
		console.log($scope.branch);
       $http.get("http://localhost:8080/lms/librarian/getBranchByPk/" + $scope.branch.branchId).success(function(data){
        	$scope.branch = data;
        	//$window.location.href = "#/librarian/managebranch"
        })
        
    }
	
	$scope.saveBranch = function(){
		
		var updateBranch = {
				'branchId' : $scope.branch.branchId,
				'branchName' : $scope.branch.branchName,
				'branchAddress' : $scope.branch.branchAddress
		}
		
		lmsFactory.saveObject("http://localhost:8080/lms/librarian/updateBranch", updateBranch).then(function(data){
			lmsFactory.readAllObjects("http://localhost:8080/lms/admin/readBranches").then(function(data){
				$scope.branches = data;
			})
			
		})

    }
	
	$scope.getBookCopies = function(){
		
		
		console.log($scope.branch.branchId);
		console.log($scope.book.bookId);
       $http.get("http://localhost:8080/lms/librarian/getBookCopiesByBookIdAndBranch/" + $scope.book.bookId + "/" + $scope.branch.branchId).success(function(data){
    	   if(data == null){
    		   $scope.noOfCopies = 0;
    		   $scope.bookcopies.noOfCopies = 0;
    		   $scope.bookcopies.bookId = $scope.book.bookId;
    		   $scope.bookcopies.branchId = $scope.branch.branchId;
    	   }else{
    		   
    		   $scope.bookcopies = data;
    		   $scope.noOfCopies = $scope.bookcopies.noOfCopies;
    	   }
        	
        	//$window.location.href = "#/librarian/managebranch"
        })
        
    }
	
	$scope.saveBookCopies = function(){
		
		console.log($scope.bookcopies);
		lmsFactory.saveObject("http://localhost:8080/lms/librarian/updateBookCopies", $scope.bookcopies).then(function(data){
			
		})
  
		$scope.noOfCopies = 0;
    }
	
	
})