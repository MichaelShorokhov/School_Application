angular
    .module("SchoolApp")
    .factory("MarkService", ["$http", function ($http) {
        var BASE_URL = "http://localhost:8080/mark";
        var ALL_MARKS = "http://localhost:8080/mark/findAll";
        var ADD_MARK = "${this.BASE_URL}/add";
        var UPDATE_MARK = "${this.BASE_URL}/update";
        var DELETE_MARK = "${this.BASE_URL}/remove/";

        var service = {};


        service.getAllMarks = function getAllMarks() {
            return $http.get(ALL_MARKS);
        };

        return service;
    }]);