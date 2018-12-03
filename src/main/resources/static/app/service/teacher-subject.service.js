angular
    .module("SchoolApp")
    .factory("TeacherSubjectService", ["$http", function ($http) {
        var FIND_SUBJECTS = "http://localhost:8080/teacher/findSubjects";
        var ADD_SUBJECT = "http://localhost:8080/teacher/addSubject/";
        var REMOVE_SUBJECT = "http://localhost:8080/teacher/removeSubject/";

        var service = {};

        service.findSubjects = function findSubjects(teacher) {
            return $http.post(FIND_SUBJECTS, teacher)
        };

        service.addSubject = function addSubject(teacher, subject) {
            return $http.post(ADD_SUBJECT + teacher.id, subject)
        };

        service.removeSubject = function removeSubject(teacher, subject) {
            return $http.post(REMOVE_SUBJECT + teacher.id, subject)
        };

        return service;
    }]);