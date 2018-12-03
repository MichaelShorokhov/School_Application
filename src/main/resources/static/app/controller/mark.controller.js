angular
    .module("SchoolApp")
    .controller("MarkController", ["MarkService", function (MarkService) {
        var markCtrl = this;
        markCtrl.newMark = {};

        init();

        function getAllMarks() {
            MarkService.getAllMarks().then(
                function (response) { markCtrl.marks = response.data }
            )
        }

        function init() {
            getAllMarks();
        }

        markCtrl.addMark = function addMark(mark) {
            MarkService.addMark(mark).then(
                function (response) {
                    mark.id = response.data.id;
                    markCtrl.marks.push(mark);
                    markCtrl.newMark = {}
                }
            )
        };

        markCtrl.updateMark = function updateMark(mark) {
            MarkService.updateMark(mark).then()
        };

        markCtrl.deleteMark = function deleteMark(mark) {
            MarkService.deleteMark(mark).then(
                function () {
                    markCtrl.marks.splice(markCtrl.marks.indexOf(mark), 1)
                }
            )
        }
    }]);