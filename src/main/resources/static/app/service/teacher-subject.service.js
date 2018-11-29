angular
    .module("SchoolApp")
    .factory("TeacherSubjectService", ["$http", function ($http) {
        var BASE_URL = "http://localhost:8080/teacherSubject";
        var ALL_TEACHER_SUBJECTS = "http://localhost:8080/teacherSubject/findAll";
        var ADD_TEACHER_SUBJECT = "${this.BASE_URL}/add";
        var UPDATE_TEACHER_SUBJECT = "${this.BASE_URL}/update";
        var DELETE_TEACHER_SUBJECT = "${this.BASE_URL}/remove/";

        var service = {};


        service.getAllTeacherSubjects = function getAllTeacherSubjects() {
            return $http.get(ALL_TEACHER_SUBJECTS);
        };

        return service;
    }]);