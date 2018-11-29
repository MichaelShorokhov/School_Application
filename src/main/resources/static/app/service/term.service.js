angular
    .module("SchoolApp")
    .factory("TermService", ["$http", function ($http) {
        var BASE_URL = "http://localhost:8080/term";
        var ALL_TERMS = "http://localhost:8080/term/findAll";
        var ADD_TERM = "${this.BASE_URL}/add";
        var UPDATE_TERM = "${this.BASE_URL}/update";
        var DELETE_TERM = "${this.BASE_URL}/remove/";

        var service = {};


        service.getAllTerms = function getAllTerms() {
            return $http.get(ALL_TERMS);
        };

        return service;
    }]);