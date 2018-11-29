angular
    .module("SchoolApp")
    .controller("TeacherGroupController", ["TeacherGroupService", function (TeacherGroupService) {
        var teacherGroupCtrl = this;

        function getAllTeacherGroups() {
            TeacherGroupService.getAllTeacherGroups().then(
                function (response) { teacherGroupCtrl.teacherGroups = response.data }
            )
        }
    }]);