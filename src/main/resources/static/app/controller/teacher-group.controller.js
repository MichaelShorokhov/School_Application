angular
    .module("SchoolApp")
    .controller("TeacherGroupController", ["TeacherGroupService", "TeacherService", "GroupService",
        function (TeacherGroupService, TeacherService, GroupService) {
            var teacherGroupCtrl = this;
            teacherGroupCtrl.selectedTeacher = {};
            teacherGroupCtrl.selectedGroup = {};

            init();

            function getAllTeachers() {
                TeacherService.getAllTeachers().then(
                    function (response) { teacherGroupCtrl.teachers = response.data }
                )
            }

            function getAllGroups() {
                GroupService.getAllGroups().then(
                    function (response) { teacherGroupCtrl.groups = response.data }
                )
            }

            function init() {
                getAllGroups();
                getAllTeachers();
            };

            teacherGroupCtrl.getGroupsByTeacher = function getGroupsByTeacher(teacher) {
                TeacherGroupService.findGroups(teacher).then(
                    function (response) {
                        console.log(response.data);
                        teacherGroupCtrl.groupsByTeacher = response.data }
                )
            };

            teacherGroupCtrl.addGroup = function addGroup() {
                TeacherGroupService.addGroup(teacherGroupCtrl.selectedTeacher, teacherGroupCtrl.selectedGroup).then(
                    function (response) { teacherGroupCtrl.groupsByTeacher.push(teacherGroupCtrl.selectedGroup) }
                )
            };

            teacherGroupCtrl.removeGroup = function removeGroup(group) {
                TeacherGroupService.removeGroup(teacherGroupCtrl.selectedTeacher, group).then(
                    function (response) {
                        teacherGroupCtrl.groupsByTeacher.splice(teacherGroupCtrl.groupsByTeacher.indexOf(group), 1)
                    }
                )
            };


        }]);