angular
    .module("SchoolApp")
    .controller("TermController", ["TermService", function (TermService) {
        var termCtrl = this;
        termCtrl.newTerm = {};
        
        init();

        function getAllTerms() {
            TermService.getAllTerms().then(
                function (response) {
                    termCtrl.terms = response.data;
                    termCtrl.terms.forEach(function(term, terms){
                        term.startDate = new Date(term.startDate);
                        term.endDate = new Date(term.endDate);
                    });
                }
            )
        }
        
        function init() {
            getAllTerms();
        }

        termCtrl.addTerm = function addTerm(term) {
            TermService.addTerm(term).then(
                function (response) {
                    term.id = response.data.id;
                    termCtrl.terms.push(term);
                    termCtrl.newTerm = {}
                }
            )
        };

        termCtrl.updateTerm = function updateTerm(term) {
            TermService.updateTerm(term).then()
        };

        termCtrl.deleteTerm = function deleteTerm(term) {
            TermService.deleteTerm(term).then(
                function () {
                    termCtrl.terms.splice(termCtrl.terms.indexOf(term), 1)
                }
            )
        };
    }]);