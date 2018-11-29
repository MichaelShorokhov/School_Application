angular
    .module("SchoolApp")
    .controller("StudentSubjectController", ["StudentSubjectService", function (StudentSubjectService) {
        var studentSubjectCtrl = this;

        function getAllStudentSubjects() {
            StudentSubjectService.getAllStudentSubjects().then(
                function (response) { studentSubjectCtrl.studentSubjects = response.data }
            )
        }
    }]);