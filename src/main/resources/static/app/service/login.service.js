angular
    .module("SchoolApp")
    .factory("LoginService", ["$http", function ($http) {
        var BASE_URL = "http://localhost:8080/login";
        var ALL_LOGINS = "http://localhost:8080/login/findAll";
        var ADD_LOGIN = "${this.BASE_URL}/add";
        var UPDATE_LOGIN = "${this.BASE_URL}/update";
        var DELETE_LOGIN = "${this.BASE_URL}/remove/";

        var service = {};


        service.getAllLogins = function getAllLogins() {
            return $http.get(ALL_LOGINS);
        };

        return service;
    }]);