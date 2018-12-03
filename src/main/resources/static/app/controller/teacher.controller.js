angular
    .module("SchoolApp")
    .controller("TeacherController", ["TeacherService", function (TeacherService) {
        var teacherCtrl = this;
        teacherCtrl.newTeacher = {};
        
        init();

        function getAllTeachers() {
            TeacherService.getAllTeachers().then(
                function (response) { teacherCtrl.teachers = response.data }
            )
        }
        
        function init() {
            getAllTeachers();
        }

        teacherCtrl.addTeacher = function addTeacher(teacher) {
            TeacherService.addTeacher(teacher).then(
                function (response) {
                    teacher.id = response.data.id;
                    teacherCtrl.teachers.push(teacher);
                    teacherCtrl.newTeacher = {}
                }
            )
        };

        teacherCtrl.updateTeacher = function updateTeacher(teacher) {
            TeacherService.updateTeacher(teacher).then()
        };

        teacherCtrl.deleteTeacher = function deleteTeacher(teacher) {
            TeacherService.deleteTeacher(teacher).then(
                function () {
                    teacherCtrl.teachers.splice(teacherCtrl.teachers.indexOf(teacher), 1)
                }
            )
        };
    }]);