angular
    .module("SchoolApp")
    .factory("GroupService", ["$http", function ($http) {
        var BASE_URL = "http://localhost:8080/group";
        var ALL_GROUPS = "http://localhost:8080/group/findAll";
        var ADD_GROUP = "${this.BASE_URL}/add";
        var UPDATE_GROUP = "${this.BASE_URL}/update";
        var DELETE_GROUP = "${this.BASE_URL}/remove/";

        var service = {};


        service.getAllGroups = function getAllGroups() {
            return $http.get(ALL_GROUPS);
        };

        return service;
    }]);