angular
    .module("SchoolApp")
    .config(stateConfig);

function stateConfig($stateProvider){
    $stateProvider.state("term", {
        url: "/client/term",
        templateUrl: "app/templates/term.html",
        controller: "TermController",
        controllerAs: "termCtrl"
    });
}