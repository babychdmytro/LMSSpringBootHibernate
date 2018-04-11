lmsApp.config(["$routeProvider", function($routeProvider){
    return $routeProvider.when("/",{
        redirectTo: "/home"
    }).when("/home",{
        templateUrl: "home.html"
    }).when("/borrower/borrower",{
        templateUrl: "view/borrower/borrower.html"
    }).when("/borrower/checkoutbook",{
        templateUrl: "view/borrower/checkoutbook.html"
    }).when("/borrower/returnbook",{
        templateUrl: "view/borrower/returnbook.html"
    })
}])