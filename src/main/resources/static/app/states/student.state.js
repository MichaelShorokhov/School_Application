angular
    .module("SchoolApp")
    .config(stateConfig);

function stateConfig($stateProvider){
    $stateProvider.state("student", {
        url: "/client/student",
        templateUrl: "app/templates/student.html",
        controller: "StudentController",
        controllerAs: "studentCtrl"
    });
}