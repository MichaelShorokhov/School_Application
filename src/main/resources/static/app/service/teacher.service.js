angular
    .module("SchoolApp")
    .factory("TeacherService", ["$http", function ($http) {
        var BASE_URL = "http://localhost:8080/teacher";
        var ALL_TEACHERS = "http://localhost:8080/teacher/findAll";
        var ADD_TEACHER = "${this.BASE_URL}/add";
        var UPDATE_TEACHER = "${this.BASE_URL}/update";
        var DELETE_TEACHER = "${this.BASE_URL}/remove/";

        var service = {};


        service.getAllTeachers = function getAllTeachers() {
            return $http.get(ALL_TEACHERS);
        };

        return service;
    }]);