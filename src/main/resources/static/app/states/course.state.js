angular
    .module("SchoolApp")
    .config(stateConfig);

function stateConfig($stateProvider){
    $stateProvider.state("course", {
        url: "/client/course",
        templateUrl: "app/templates/course.html",
        controller: "CourseController",
        controllerAs: "courseCtrl"
    });
}