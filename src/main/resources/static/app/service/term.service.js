angular
    .module("SchoolApp")
    .factory("TermService", ["$http", function ($http) {
        var ALL_TERMS = "http://localhost:8080/term/findAll";
        var ADD_TERM = "http://localhost:8080/term/add";
        var UPDATE_TERM = "http://localhost:8080/term/update";
        var DELETE_TERM = "http://localhost:8080/term/remove/";

        var service = {};


        service.getAllTerms = function getAllTerms() {
            return $http.get(ALL_TERMS);
        };
        service.addTerm = function addTerm(term) {
            return $http.post(ADD_TERM, term)
        };

        service.updateTerm = function updateTerm(term) {
            return $http.post(UPDATE_TERM, term)
        };

        service.deleteTerm = function deleteTerm(term) {
            return $http.delete(DELETE_TERM + term.id)
        };

        return service;
    }]);