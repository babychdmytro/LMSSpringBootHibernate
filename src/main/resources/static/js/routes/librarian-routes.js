lmsApp.config(["$routeProvider", function($routeProvider){
    return $routeProvider.when("/",{
        redirectTo: "/home"
    }).when("/home",{
        templateUrl: "home.html"
    }).when("/librarian/librarian",{
        templateUrl: "view/librarian/librarian.html"
    })
}])