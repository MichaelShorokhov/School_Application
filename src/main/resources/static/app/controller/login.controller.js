angular
    .module("SchoolApp")
    .controller("LoginController", ["LoginService", function (LoginService) {
        var loginCtrl = this;

        function getAllLogins() {
            LoginService.getAllLogins().then(
                function (response) { loginCtrl.logins = response.data }
            )
        }
    }]);