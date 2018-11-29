angular
    .module("SchoolApp")
    .controller("StudentController", ["StudentService", function (StudentService) {
        var studentCtrl = this;

        function getAllStudents() {
            StudentService.getAllStudents().then(
                function (response) { studentCtrl.students = response.data }
            )
        }
    }]);