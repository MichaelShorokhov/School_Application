angular
    .module("SchoolApp")
    .controller("GroupController", ["GroupService", function (GroupService) {
        var groupCtrl = this;

        function getAllGroups() {
            GroupService.getAllGroups().then(
                function (response) { groupCtrl.groups = response.data }
            )
        }
    }]);