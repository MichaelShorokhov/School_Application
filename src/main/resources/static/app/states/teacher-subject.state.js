angular
    .module("SchoolApp")
    .config(stateConfig);

function stateConfig($stateProvider){
    $stateProvider.state("teacherSubject", {
        url: "/client/teacherSubject",
        templateUrl: "app/templates/teacher-subject.html",
        controller: "TeacherSubjectController",
        controllerAs: "teacherSubjectCtrl"
    });
}