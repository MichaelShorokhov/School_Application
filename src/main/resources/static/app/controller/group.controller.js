angular
    .module("SchoolApp")
    .controller("GroupController", ["GroupService", "CourseService", function (GroupService, CourseService) {
        var groupCtrl = this;
        groupCtrl.newGroup = {};

        init();

        function init() {
            getAllGroups();
            getAllCourses();
        };

        function getAllCourses() {
            CourseService.getAllCourses().then(
                function (response) { groupCtrl.courses = response.data }
            )
        };

        function getAllGroups() {
            GroupService.getAllGroups().then(

                function (response) {
                    console.log(response);
                    groupCtrl.groups = response.data }
            )
        };

        groupCtrl.addGroup = function addGroup(group) {
            GroupService.addGroup(group).then(
                function (response) {
                    group.id = response.data.id;
                    groupCtrl.groups.push(group);
                    groupCtrl.newGroup = {}
                }
            )
        };

        groupCtrl.updateGroup = function updateGroup(group) {
            GroupService.updateGroup(group).then()
        };

        groupCtrl.deleteGroup = function deleteGroup(group) {
            GroupService.deleteGroup(group).then(
                function () {
                    groupCtrl.groups.splice(groupCtrl.groups.indexOf(group), 1) }

            )
        };

    }]);