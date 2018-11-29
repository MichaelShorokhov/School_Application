angular
    .module("SchoolApp")
    .controller("SubjectController", ["SubjectService", function (SubjectService) {
        var subjectCtrl = this;

        function getAllSubjects() {
            SubjectService.getAllSubjects().then(
                function (response) { subjectCtrl.subjects = response.data }
            )
        }
    }]);