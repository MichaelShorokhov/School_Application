angular
    .module("SchoolApp")
    .factory("CourseService", ["$http", function ($http) {
        var ALL_COURSES = "http://localhost:8080/course/findAll";
        var ADD_COURSE = "http://localhost:8080/course/add";
        var UPDATE_COURSE = "http://localhost:8080/course/update";
        var DELETE_COURSE = "http://localhost:8080/course/remove/";

        var service = {};


        service.getAllCourses = function getAllCourses() {
            return $http.get(ALL_COURSES);
        };

        service.addCourse = function addCourse(course) {
            return $http.post(ADD_COURSE, course)
        };

        service.updateCourse = function updateCourse(course) {
            return $http.post(UPDATE_COURSE, course)
        };

        service.deleteCourse = function deleteCourse(course) {
            return $http.delete(DELETE_COURSE + course.id)
        };

        return service;
    }]);