angular
    .module("SchoolApp")
    .factory("LessonService", ["$http", function ($http) {
        var ALL_LESSONS = "http://localhost:8080/lesson/findAll";
        var ADD_LESSON = "http://localhost:8080/lesson/add";
        var UPDATE_LESSON = "http://localhost:8080/lesson/update";
        var DELETE_LESSON = "http://localhost:8080/lesson/remove/";

        var service = {};


        service.getAllLessons = function getAllLessons() {
            return $http.get(ALL_LESSONS);
        };

        service.addLesson = function addLesson(lesson) {
            return $http.post(ADD_LESSON, lesson)
        };

        service.updateLesson = function updateLesson(lesson) {
            return $http.post(UPDATE_LESSON, lesson)
        };

        service.deleteLesson = function deleteLesson(lesson) {
            return $http.delete(DELETE_LESSON + lesson.id)
        };

        return service;
    }]);