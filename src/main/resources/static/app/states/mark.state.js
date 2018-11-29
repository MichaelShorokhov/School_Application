angular
    .module("SchoolApp")
    .config(stateConfig);

function stateConfig($stateProvider){
    $stateProvider.state("mark", {
        url: "/client/mark",
        templateUrl: "app/templates/mark.html",
        controller: "MarkController",
        controllerAs: "markCtrl"
    });
}