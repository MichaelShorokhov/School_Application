angular
    .module("SchoolApp")
    .factory("TeacherService", ["$http", function ($http) {
        var ALL_TEACHERS = "http://localhost:8080/teacher/findAll";
        var ADD_TEACHER = "http://localhost:8080/teacher/add";
        var UPDATE_TEACHER = "http://localhost:8080/teacher/update";
        var DELETE_TEACHER = "http://localhost:8080/teacher/remove/";

        var service = {};


        service.getAllTeachers = function getAllTeachers() {
            return $http.get(ALL_TEACHERS);
        };

        service.addTeacher = function addTeacher(teacher) {
            return $http.post(ADD_TEACHER, teacher)
        };

        service.updateTeacher = function updateTeacher(teacher) {
            return $http.post(UPDATE_TEACHER, teacher)
        };

        service.deleteTeacher = function deleteTeacher(teacher) {
            return $http.delete(DELETE_TEACHER + teacher.id)
        };

        return service;
    }]);