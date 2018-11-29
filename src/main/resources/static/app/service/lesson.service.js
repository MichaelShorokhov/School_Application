angular
    .module("SchoolApp")
    .factory("LessonService", ["$http", function ($http) {
        var BASE_URL = "http://localhost:8080/lesson";
        var ALL_LESSONS = "http://localhost:8080/lesson/findAll";
        var ADD_LESSON = "${this.BASE_URL}/add";
        var UPDATE_LESSON = "${this.BASE_URL}/update";
        var DELETE_LESSON = "${this.BASE_URL}/remove/";

        var service = {};


        service.getAllLessons = function getAllLessons() {
            return $http.get(ALL_LESSONS);
        };

        return service;
    }]);