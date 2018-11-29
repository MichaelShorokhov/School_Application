angular
    .module("SchoolApp")
    .config(stateConfig);

function stateConfig($stateProvider){
    $stateProvider.state("studentSubject", {
        url: "/client/studentSubject",
        templateUrl: "app/templates/student-subject.html",
        controller: "StudentSubjectController",
        controllerAs: "studentSubjectCtrl"
    });
}