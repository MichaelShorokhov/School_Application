angular
    .module("SchoolApp")
    .factory("TeacherGroupService", ["$http", function ($http) {
        var BASE_URL = "http://localhost:8080/teacherGroup";
        var ALL_TEACHER_GROUPS = "http://localhost:8080/teacherGroup/findAll";
        var ADD_TEACHER_GROUP = "${this.BASE_URL}/add";
        var UPDATE_TEACHER_GROUP = "${this.BASE_URL}/update";
        var DELETE_TEACHER_GROUP = "${this.BASE_URL}/remove/";

        var service = {};


        service.getAllTeacherGroups = function getAllTeacherGroups() {
            return $http.get(ALL_TEACHER_GROUPS);
        };

        return service;
    }]);