angular
    .module("SchoolApp")
    .controller("TeacherSubjectController", ["TeacherSubjectService", function (TeacherSubjectService) {
        var teacherSubjectCtrl = this;

        function getAllTeacherSubjects() {
            TeacherSubjectService.getAllTeacherSubjects().then(
                function (response) { teacherSubjectCtrl.teacherSubjects = response.data }
            )
        }
    }]);