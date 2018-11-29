angular
    .module("SchoolApp")
    .config(stateConfig);

function stateConfig($stateProvider){
    $stateProvider.state("login", {
        url: "/client/login",
        templateUrl: "app/templates/login.html",
        controller: "LoginController",
        controllerAs: "loginCtrl"
    });
}