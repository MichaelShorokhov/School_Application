angular
    .module("SchoolApp")
    .controller("LessonController", ["LessonService", function (LessonService) {
        var lessonCtrl = this;

        function getAllLessons() {
            LessonService.getAllLessons().then(
                function (response) { lessonCtrl.lessons = response.data }
            )
        }
    }]);