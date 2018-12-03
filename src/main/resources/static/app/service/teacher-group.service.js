angular
    .module("SchoolApp")
    .factory("TeacherGroupService", ["$http", function ($http) {
        var FIND_GROUPS = "http://localhost:8080/teacher/findGroups";
        var ADD_GROUP = "http://localhost:8080/teacher/addGroup/";
        var REMOVE_GROUP = "http://localhost:8080/teacher/removeGroup/";

        var service = {};

        service.findGroups = function findGroups(teacher) {
            return $http.post(FIND_GROUPS, teacher)
        };

        service.addGroup = function addGroup(teacher, group) {
            return $http.post(ADD_GROUP + teacher.id, group)
        };

        service.removeGroup = function removeGroup(teacher, group) {
            return $http.post(REMOVE_GROUP + teacher.id, group)
        };

        return service;
    }]);