angular
    .module("SchoolApp")
    .config(stateConfig);

function stateConfig($stateProvider){
    $stateProvider.state("group", {
        url: "/client/group",
        templateUrl: "app/templates/group.html",
        controller: "GroupController",
        controllerAs: "groupCtrl"
    });
}