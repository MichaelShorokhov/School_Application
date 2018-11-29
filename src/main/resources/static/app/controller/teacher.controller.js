angular
    .module("SchoolApp")
    .controller("TeacherController", ["TeacherService", function (TeacherService) {
        var teacherCtrl = this;

        function getAllTeachers() {
            TeacherService.getAllTeachers().then(
                function (response) { teacherCtrl.teachers = response.data }
            )
        }
    }]);