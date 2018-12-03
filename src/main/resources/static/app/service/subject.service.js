angular
    .module("SchoolApp")
    .factory("SubjectService", ["$http", function ($http) {
        var ALL_SUBJECTS = "http://localhost:8080/subject/findAll";
        var ADD_SUBJECT = "http://localhost:8080/subject/add";
        var UPDATE_SUBJECT = "http://localhost:8080/subject/update";
        var DELETE_SUBJECT = "http://localhost:8080/subject/remove/";

        var service = {};


        service.getAllSubjects = function getAllSubjects() {
            return $http.get(ALL_SUBJECTS);
        };

        service.addSubject = function addSubject(subject) {
            return $http.post(ADD_SUBJECT, subject)
        };

        service.updateSubject = function updateSubject(subject) {
            return $http.post(UPDATE_SUBJECT, subject)
        };

        service.deleteSubject = function deleteSubject(subject) {
            return $http.delete(DELETE_SUBJECT + subject.id)
        };

        return service;
    }]);