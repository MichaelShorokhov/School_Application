angular
    .module("SchoolApp")
    .factory("StudentSubjectService", ["$http", function ($http) {
        var BASE_URL = "http://localhost:8080/studentSubject";
        var ALL_STUDENT_SUBJECTS = "http://localhost:8080/studentSubject/findAll";
        var ADD_STUDENT_SUBJECT = "${this.BASE_URL}/add";
        var UPDATE_STUDENT_SUBJECT = "${this.BASE_URL}/update";
        var DELETE_STUDENT_SUBJECT = "${this.BASE_URL}/remove/";

        var service = {};


        service.getAllStudentSubjects = function getAllStudentSubjects() {
            return $http.get(ALL_STUDENT_SUBJECTS);
        };

        return service;
    }]);