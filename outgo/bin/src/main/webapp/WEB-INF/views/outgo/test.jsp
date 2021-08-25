<html>
<head>
    <title>A Simple example of Get, Set and Clear Cookie in AngularJS</title>
</head>
<body>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.6.1/angular.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.6.1/angular-cookies.js"></script>
    <script type="text/javascript">
        var app = angular.module('MyApp', ['ngCookies']);
        app.controller('CookiesController', function ($scope, $window, $cookies) {
            $scope.SetCookies = function () {
                $cookies.put("username", $scope.username);
            };
            $scope.GetCookies = function () {
                $window.alert($cookies.get('username'));
            };
            $scope.ClearCookies = function () {
                $cookies.remove('username');
            };
        });
    </script>
    <div ng-app="MyApp" ng-controller="CookiesController">
        Username:
        <input type="text" ng-model="username" />
        <br />
        <br />
        <input type="button" value="Set Cookies" ng-click="SetCookies()" />
        <input type="button" value="Get Cookies" ng-click="GetCookies()" />
        <input type="button" value="Clear Cookies" ng-click="ClearCookies()" />
    </div>
</body>
</html>