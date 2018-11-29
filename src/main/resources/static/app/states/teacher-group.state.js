angular
    .module("SchoolApp")
    .config(stateConfig);

function stateConfig($stateProvider){
    $stateProvider.state("teacherGroup", {
        url: "/client/teacherGroup",
        templateUrl: "app/templates/teacher-group.html",
        controller: "TeacherGroupController",
        controllerAs: "teacherGroupCtrl"
    });
}