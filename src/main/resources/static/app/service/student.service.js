angular
    .module("SchoolApp")
    .factory("StudentService", ["$http", function ($http) {
        var ALL_STUDENTS = "http://localhost:8080/student/findAll";
        var ADD_STUDENT = "http://localhost:8080/student/add";
        var UPDATE_STUDENT = "http://localhost:8080/student/update";
        var DELETE_STUDENT = "http://localhost:8080/student/remove/";

        var service = {};


        service.getAllStudents = function getAllStudents() {
            return $http.get(ALL_STUDENTS);
        };

        service.addStudent = function addStudent(student) {
            return $http.post(ADD_STUDENT, student)
        };

        service.updateStudent = function updateStudent(student) {
            return $http.post(UPDATE_STUDENT, student)
        };

        service.deleteStudent = function deleteStudent(student) {
            return $http.delete(DELETE_STUDENT + student.id)
        };

        return service;
    }]);