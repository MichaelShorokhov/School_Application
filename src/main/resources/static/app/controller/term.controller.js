angular
    .module("SchoolApp")
    .controller("TermController", ["TermService", function (TermService) {
        var termCtrl = this;

        function getAllTerms() {
            TermService.getAllTerms().then(
                function (response) { termCtrl.terms = response.data }
            )
        }
    }]);