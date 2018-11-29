angular
    .module("SchoolApp")
    .controller("MarkForLessonController", ["MarkForLessonService", function (MarkForLessonService) {
        var markForLessonCtrl = this;

        function getAllMarkForLessons() {
            MarkForLessonService.getAllMarkForLessons().then(
                function (response) { markForLessonCtrl.markForLessons = response.data }
            )
        }
    }]);