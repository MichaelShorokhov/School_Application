angular
    .module("SchoolApp")
    .controller("SubjectController", ["SubjectService", function (SubjectService) {
        var subjectCtrl = this;
        subjectCtrl.newSubject = {};
        
        init();

        function getAllSubjects() {
            SubjectService.getAllSubjects().then(
                function (response) { subjectCtrl.subjects = response.data }
            )
        };
        
        function init() {
            getAllSubjects();
        }

        subjectCtrl.addSubject = function addSubject(subject) {
            SubjectService.addSubject(subject).then(
                function (response) {
                    subject.id = response.data.id;
                    subjectCtrl.subjects.push(subject);
                    subjectCtrl.newSubject = {}
                }
            )
        };

        subjectCtrl.updateSubject = function updateSubject(subject) {
            SubjectService.updateSubject(subject).then()
        };

        subjectCtrl.deleteSubject = function deleteSubject(subject) {
            SubjectService.deleteSubject(subject).then(
                function () {
                    subjectCtrl.subjects.splice(subjectCtrl.subjects.indexOf(subject), 1)
                }
            )
        };
    }]);