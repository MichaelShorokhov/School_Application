angular
    .module("SchoolApp")
    .factory("StudentSubjectService", ["$http", function ($http) {
        var FIND_SUBJECTS = "http://localhost:8080/student/findSubjects";
        var ADD_SUBJECT = "http://localhost:8080/student/addSubject/";
        var REMOVE_SUBJECT = "http://localhost:8080/student/removeSubject/";

        var service = {};

        service.findSubjects = function findSubjects(student) {
            return $http.post(FIND_SUBJECTS, student)
        };

        service.addSubject = function addSubject(student, subject) {
            return $http.post(ADD_SUBJECT + student.id, subject)
        };

        service.removeSubject = function removeSubject(student, subject) {
            return $http.post(REMOVE_SUBJECT + student.id, subject)
        };

        return service;
    }]);