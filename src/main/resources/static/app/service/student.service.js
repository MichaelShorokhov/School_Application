angular
    .module("SchoolApp")
    .factory("StudentService", ["$http", function ($http) {
        var BASE_URL = "http://localhost:8080/student";
        var ALL_STUDENTS = "http://localhost:8080/student/findAll";
        var ADD_STUDENT = "${this.BASE_URL}/add";
        var UPDATE_STUDENT = "${this.BASE_URL}/update";
        var DELETE_STUDENT = "${this.BASE_URL}/remove/";

        var service = {};


        service.getAllStudents = function getAllStudents() {
            return $http.get(ALL_STUDENTS);
        };

        return service;
    }]);