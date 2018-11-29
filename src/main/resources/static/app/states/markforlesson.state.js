angular
    .module("SchoolApp")
    .config(stateConfig);

function stateConfig($stateProvider){
    $stateProvider.state("markForLesson", {
        url: "/client/markForLesson",
        templateUrl: "app/templates/markForLesson.html",
        controller: "MarkForLessonController",
        controllerAs: "markForLessonCtrl"
    });
}