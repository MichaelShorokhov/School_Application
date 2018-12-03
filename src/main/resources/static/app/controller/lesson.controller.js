angular
    .module("SchoolApp")
    .controller("LessonController", ["LessonService", "TeacherService", "GroupService",
                    "TermService", "SubjectService", function (LessonService, TeacherService, GroupService,
                    TermService, SubjectService) {
        var lessonCtrl = this;
        lessonCtrl.newLesson = {};

        init();

        function getAllLessons() {
            LessonService.getAllLessons().then(
                function (response) {
                    lessonCtrl.lessons = response.data;
                    lessonCtrl.lessons.forEach(function (lesson, lessons) {
                        lesson.date = new Date(lesson.date);
                    })
                }
            )
        }

        function getAllTeachers() {
            TeacherService.getAllTeachers().then(
                function (response) { lessonCtrl.teachers = response.data }
            )
        }

        function getAllGroups() {
            GroupService.getAllGroups().then(
                function (response) { lessonCtrl.groups = response.data }
            )
        }

        function getAllTerms() {
            TermService.getAllTerms().then(
                function (response) { lessonCtrl.terms = response.data }
            )
        }

        function getAllSubjects() {
            SubjectService.getAllSubjects().then(
                function (response) { lessonCtrl.subjects = response.data }
            )
        }

        function init(){
            getAllLessons();
            getAllTeachers();
            getAllGroups();
            getAllTerms();
            getAllSubjects();
        }

        lessonCtrl.addLesson = function addLesson(lesson) {
            LessonService.addLesson(lesson).then(
                function (response) {
                    lesson.id = response.data.id;
                    lessonCtrl.lessons.push(lesson);
                    lessonCtrl.newLesson = {};
                }
            )
        };

        lessonCtrl.updateLesson = function updateLesson(lesson) {
            LessonService.updateLesson(lesson).then()
        };

        lessonCtrl.deleteLesson = function deleteLesson(lesson) {
            LessonService.deleteLesson(lesson).then(
                function () {
                    lessonCtrl.lessons.splice(lessonCtrl.lessons.indexOf(lesson), 1)
                }
            )
        }
    }]);