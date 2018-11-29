angular
    .module("SchoolApp")
    .config(stateConfig);

function stateConfig($stateProvider){
    $stateProvider.state("subject", {
        url: "/client/subject",
        templateUrl: "app/templates/subject.html",
        controller: "SubjectController",
        controllerAs: "subjectCtrl"
    });
}