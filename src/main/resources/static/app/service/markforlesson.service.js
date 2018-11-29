angular
    .module("SchoolApp")
    .factory("MarkForLessonService", ["$http", function ($http) {
        var BASE_URL = "http://localhost:8080/markForLesson";
        var ALL_MARK_FOR_LESSONS = "http://localhost:8080/markForLesson/findAll";
        var ADD_MARK_FOR_LESSON = "${this.BASE_URL}/add";
        var UPDATE_MARK_FOR_LESSON = "${this.BASE_URL}/update";
        var DELETE_MARK_FOR_LESSON = "${this.BASE_URL}/remove/";

        var service = {};


        service.getAllMarkForLessons = function getAllMarkForLessons() {
            return $http.get(ALL_MARK_FOR_LESSONS);
        };

        return service;
    }]);