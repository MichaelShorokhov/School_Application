angular
    .module("SchoolApp")
    .controller("StudentController", ["StudentService", "GroupService", function (StudentService, GroupService) {
        var studentCtrl = this;
        studentCtrl.newStudent = {};

        init();

        function getAllStudents() {
            StudentService.getAllStudents().then(
                function (response) { studentCtrl.students = response.data }
            )
        }

        function getAllGroups() {
            GroupService.getAllGroups().then(
                function (response) { studentCtrl.groups = response.data }
            )
        };

        function init() {
            getAllStudents();
            getAllGroups();
        };

        studentCtrl.addStudent = function addStudent(student) {
            StudentService.addStudent(student).then(
                function (response) {
                    student.id = response.data.id;
                    studentCtrl.students.push(student);
                    studentCtrl.newStudent = {}
                }
            )
        }

        studentCtrl.updateStudent = function updateStudent(student) {
            StudentService.updateStudent(student).then()
        }

        studentCtrl.deleteStudent = function deleteStudent(student) {
            StudentService.deleteStudent(student).then(
                function () {
                    studentCtrl.students.splice(studentCtrl.students.indexOf(student), 1)
                }
            )
        }
    }]);