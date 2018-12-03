angular
    .module("SchoolApp")
    .controller("TeacherSubjectController", ["TeacherSubjectService", "TeacherService", "SubjectService",
        function (TeacherSubjectService, TeacherService, SubjectService) {
            var teacherSubjectCtrl = this;
            teacherSubjectCtrl.selectedTeacher = {};
            teacherSubjectCtrl.selectedSubject = {};

            init();

            function getAllTeachers() {
                TeacherService.getAllTeachers().then(
                    function (response) { teacherSubjectCtrl.teachers = response.data }
                )
            }

            function getAllSubjects() {
                SubjectService.getAllSubjects().then(
                    function (response) { teacherSubjectCtrl.subjects = response.data }
                )
            }

            function init() {
                getAllSubjects();
                getAllTeachers();
            };

            teacherSubjectCtrl.getSubjectsByTeacher = function getSubjectsByTeacher(teacher) {
                TeacherSubjectService.findSubjects(teacher).then(
                    function (response) {
                        console.log(response.data);
                        teacherSubjectCtrl.subjectsByTeacher = response.data }
                )
            };

            teacherSubjectCtrl.addSubject = function addSubject() {
                TeacherSubjectService.addSubject(teacherSubjectCtrl.selectedTeacher, teacherSubjectCtrl.selectedSubject).then(
                    function (response) { teacherSubjectCtrl.subjectsByTeacher.push(teacherSubjectCtrl.selectedSubject) }
                )
            };

            teacherSubjectCtrl.removeSubject = function removeSubject(subject) {
                TeacherSubjectService.removeSubject(teacherSubjectCtrl.selectedTeacher, subject).then(
                    function (response) {
                        teacherSubjectCtrl.subjectsByTeacher.splice(teacherSubjectCtrl.subjectsByTeacher.indexOf(subject), 1)
                    }
                )
            };


        }]);