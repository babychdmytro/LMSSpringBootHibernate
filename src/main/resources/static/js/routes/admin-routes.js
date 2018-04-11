lmsApp.config(["$routeProvider", function($routeProvider){
    return $routeProvider.when("/",{
        redirectTo: "/home"
    }).when("/home",{
        templateUrl: "home.html"
    }).when("/admin",{
        templateUrl: "view/admin/admin.html"
    }).when("/admin/addbook",{
        templateUrl: "view/admin/addbook.html"
    }).when("/admin/viewbooks",{
        templateUrl: "view/admin/viewbooks.html"
    }).when("/admin/addauthor",{
        templateUrl: "view/admin/addauthor.html"
    }).when("/admin/viewauthors",{
        templateUrl: "view/admin/viewauthors.html"
    }).when("/admin/addpublisher",{
        templateUrl: "view/admin/addpublisher.html"
    }).when("/admin/viewpublishers",{
        templateUrl: "view/admin/viewpublishers.html"
    }).when("/admin/addborrower",{
        templateUrl: "view/admin/addborrower.html"
    }).when("/admin/viewborrowers",{
        templateUrl: "view/admin/viewborrowers.html"
    }).when("/admin/addbranch",{
        templateUrl: "view/admin/addbranch.html"
    }).when("/admin/viewbranches",{
        templateUrl: "view/admin/viewbranches.html"
    }).when("/admin/addgenre",{
        templateUrl: "view/admin/addgenre.html"
    }).when("/admin/viewgenres",{
        templateUrl: "view/admin/viewgenres.html"
    }).when("/admin/manageduedate",{
        templateUrl: "view/admin/manageduedate.html"
    })
}])