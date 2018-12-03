angular
    .module("SchoolApp")
    .controller("StudentSubjectController", ["StudentSubjectService", "StudentService", "SubjectService",
                function (StudentSubjectService, StudentService, SubjectService) {
        var studentSubjectCtrl = this;
        studentSubjectCtrl.selectedStudent = {};
        studentSubjectCtrl.selectedSubject = {};

        init();

        function getAllStudents() {
            StudentService.getAllStudents().then(
                function (response) { studentSubjectCtrl.students = response.data }
            )
        }

        function getAllSubjects() {
            SubjectService.getAllSubjects().then(
                function (response) { studentSubjectCtrl.subjects = response.data }
            )
        }

        function init() {
            getAllSubjects();
            getAllStudents();
            console.log(studentSubjectCtrl.subjectsByStudent)
        };

        studentSubjectCtrl.getSubjectsByStudent = function getSubjectsByStudent(student) {
            StudentSubjectService.findSubjects(student).then(
                function (response) {
                    console.log(response.data);
                    studentSubjectCtrl.subjectsByStudent = response.data }
            )
        };

        studentSubjectCtrl.addSubject = function addSubject() {
            StudentSubjectService.addSubject(studentSubjectCtrl.selectedStudent, studentSubjectCtrl.selectedSubject).then(
                function (response) { studentSubjectCtrl.subjectsByStudent.push(studentSubjectCtrl.selectedSubject) }
            )
        };

        studentSubjectCtrl.removeSubject = function removeSubject(subject) {
            StudentSubjectService.removeSubject(studentSubjectCtrl.selectedStudent, subject).then(
                function (response) {
                    studentSubjectCtrl.subjectsByStudent.splice(studentSubjectCtrl.subjectsByStudent.indexOf(subject), 1)
                }
            )
        };


    }]);