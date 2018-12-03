angular
    .module("SchoolApp")
    .factory("MarkForLessonService", ["$http", function ($http) {
        var ALL_MARK_FOR_LESSONS = "http://localhost:8080/marksForLesson/findAll";
        var ADD_MARK_FOR_LESSON = "http://localhost:8080/marksForLesson/add";
        var UPDATE_MARK_FOR_LESSON = "http://localhost:8080/marksForLesson/update";
        var DELETE_MARK_FOR_LESSON = "http://localhost:8080/marksForLesson/remove/";

        var service = {};


        service.getAllMarkForLessons = function getAllMarkForLessons() {
            return $http.get(ALL_MARK_FOR_LESSONS);
        };

        service.addMarkForLesson = function addMarkForLesson(markForLesson) {
            return $http.post(ADD_MARK_FOR_LESSON, markForLesson)
        };

        service.updateMarkForLesson = function updateMarkForLesson(markForLesson) {
            return $http.post(UPDATE_MARK_FOR_LESSON, markForLesson)
        };

        service.deleteMarkForLesson = function deleteMarkForLesson(markForLesson) {
            return $http.delete(DELETE_MARK_FOR_LESSON + markForLesson.id)
        };

        return service;
    }]);