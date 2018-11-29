angular
    .module("SchoolApp")
    .controller("MarkController", ["MarkService", function (MarkService) {
        var markCtrl = this;

        function getAllMarks() {
            MarkService.getAllMarks().then(
                function (response) { markCtrl.marks = response.data }
            )
        }
    }]);