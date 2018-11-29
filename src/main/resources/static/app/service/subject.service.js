angular
    .module("SchoolApp")
    .factory("SubjectService", ["$http", function ($http) {
        var BASE_URL = "http://localhost:8080/subject";
        var ALL_SUBJECTS = "http://localhost:8080/subject/findAll";
        var ADD_SUBJECT = "${this.BASE_URL}/add";
        var UPDATE_SUBJECT = "${this.BASE_URL}/update";
        var DELETE_SUBJECT = "${this.BASE_URL}/remove/";

        var service = {};


        service.getAllSubjects = function getAllSubjects() {
            return $http.get(ALL_SUBJECTS);
        };

        return service;
    }]);