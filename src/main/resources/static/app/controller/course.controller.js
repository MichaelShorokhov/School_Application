angular
    .module("SchoolApp")
    .controller("CourseController", ["CourseService", function (CourseService) {
        var courseCtrl = this;
        var course;

        init();

        function init() {
            getAllCourses();
        };

        function getAllCourses() {
            CourseService.getAllCourses().then(
                function (response) { courseCtrl.courses = response.data }
            )
        };

        courseCtrl.addCourse = function addCourse(course) {
            CourseService.addCourse(course).then(
                function (response) {
                    course.id = response.data.id;
                    courseCtrl.push(course);
                    course = {};
                }
            )
        };

        courseCtrl.updateCourse = function updateCourse(course) {
            CourseService.updateCourse(course).then()
        };

        courseCtrl.deleteCourse = function deleteCourse(course) {
            CourseService.deleteCourse(course).then(
                function () {
                    courseCtrl.courses.splice(courseCtrl.courses.indexOf(course), 1) }

            )
        };
    }]);