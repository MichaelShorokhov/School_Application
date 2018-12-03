angular
    .module("SchoolApp")
    .factory("MarkService", ["$http", function ($http) {
        var ALL_MARKS = "http://localhost:8080/mark/findAll";
        var ADD_MARK = "http://localhost:8080/mark/add";
        var UPDATE_MARK = "http://localhost:8080/mark/update";
        var DELETE_MARK = "http://localhost:8080/mark/remove/";

        var service = {};


        service.getAllMarks = function getAllMarks() {
            return $http.get(ALL_MARKS);
        };

        service.addMark = function addMark(mark) {
            return $http.post(ADD_MARK, mark)
        };

        service.updateMark = function updateMark(mark) {
            return $http.post(UPDATE_MARK, mark)
        };

        service.deleteMark = function deleteMark(mark) {
            return $http.delete(DELETE_MARK + mark.id)
        };

        return service;
    }]);