angular
    .module("SchoolApp")
    .factory("GroupService", ["$http", function ($http) {
        var ALL_GROUPS = "http://localhost:8080/group/findAll";
        var ADD_GROUP = "http://localhost:8080/group/add";
        var UPDATE_GROUP = "http://localhost:8080/group/update";
        var DELETE_GROUP = "http://localhost:8080/group/remove/";

        var service = {};


        service.getAllGroups = function getAllGroups() {
            return $http.get(ALL_GROUPS);
        };

        service.addGroup = function addGroup(group) {
            return $http.post(ADD_GROUP, group)
        };

        service.updateGroup = function updateGroup(group) {
            return $http.post(UPDATE_GROUP, group)
        };

        service.deleteGroup = function deleteGroup(group) {
            return $http.delete(DELETE_GROUP + group.id)
        };

        return service;
    }]);