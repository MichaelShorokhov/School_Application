angular
    .module("SchoolApp")
    .config(stateConfig);

function stateConfig($stateProvider){
    $stateProvider.state("teacher", {
        url: "/client/teacher",
        templateUrl: "app/templates/teacher.html",
        controller: "TeacherController",
        controllerAs: "teacherCtrl"
    });
}