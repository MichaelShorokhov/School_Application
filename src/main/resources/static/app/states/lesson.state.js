angular
    .module("SchoolApp")
    .config(stateConfig);

function stateConfig($stateProvider){
    $stateProvider.state("lesson", {
        url: "/client/lesson",
        templateUrl: "app/templates/lesson.html",
        controller: "LessonController",
        controllerAs: "lessonCtrl"
    });
}