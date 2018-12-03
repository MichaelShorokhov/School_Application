angular
    .module("SchoolApp")
    .controller("MarkForLessonController", ["MarkForLessonService", "MarkService", "StudentService",
                "LessonService", function (MarkForLessonService, MarkService, StudentService, LessonService) {
        var markForLessonCtrl = this;
        markForLessonCtrl.newMarkForLesson = {};

        init();

        function getAllMarkForLessons() {
            MarkForLessonService.getAllMarkForLessons().then(
                function (response) { markForLessonCtrl.markForLessons = response.data }
            )
        };

        function getAllMarks() {
            MarkService.getAllMarks().then(
                function (response) { markForLessonCtrl.marks = response.data }
            )
        };

        function getAllStudents() {
            StudentService.getAllStudents().then(
                function(response) { markForLessonCtrl.students = response.data }
            )
        };

        function getAllLessons() {
            LessonService.getAllLessons().then(
                function (response) { markForLessonCtrl.lessons = response.data }
            )
        };

        function init(){
            getAllMarkForLessons();
            getAllMarks();
            getAllStudents();
            getAllLessons();
        };

        markForLessonCtrl.addMarkForLesson = function addMarkForLesson(markForLesson) {
            MarkForLessonService.addMarkForLesson(markForLesson).then(
                function (response) {
                    markForLesson.id = response.data.id;
                    markForLessonCtrl.markForLessons.push(markForLesson);
                    markForLessonCtrl.newMarkForLesson = {}
                }
            )
        };

        markForLessonCtrl.updateMarkForLesson = function updateMarkForLesson(markForLesson) {
            MarkForLessonService.updateMarkForLesson(markForLesson).then()
        };

        markForLessonCtrl.deleteMarkForLesson = function deleteMarkForLesson(markForLesson) {
            MarkForLessonService.deleteMarkForLesson(markForLesson).then(
                function () {
                    markForLessonCtrl.markForLessons.splice(markForLessonCtrl.markForLessons.indexOf(markForLesson), 1)
                }
            )
        }
    }]);