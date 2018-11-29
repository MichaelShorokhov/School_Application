angular
    .module("SchoolApp")
    .config(stateConfig);

    function stateConfig($stateProvider){
        $stateProvider.state("app", {
            abstract: true,
            template: "<ui-view/>"
        });
    }