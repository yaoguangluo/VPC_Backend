/*
angular.module("push_value", []).controller("push_value", function ($scope, $http, $location) {
    $scope.click = function () {
        //  $http.post('http://localhost:8080/bb?bb=1', angular.toJson($scope.loginInfo)).
        $http.get('http://localhost:8080/bb?bb=1').success(function (status) {
            console.log(status);
            $scope.info = status;
        }).error(function () {
            $scope.error = 'auth failed';
        });
    }
});

*/
function greet(name) {
    var output = '';
    var am = angular.module("push_value", []);
    am.controller('push_value', ['$scope', '$http',
        function ($scope, $http) {
            $http.get('http://localhost:8080/bb?bb=1').success(function (status) {
                console.log(status);
                $scope.info = status;
                output = $scope.info;
                //  document.getElementById("push_value").innerHTML="<div id='push_value' ng-controller='push_value' ng-click='click()'>{{info}}</div>"
            }).error(function () {
                $scope.info = 'auth failed';
                output = $scope.info;
            });

            $scope.click = function () {
                "use strict";
                output = 'win';
            }
        }]);
    return 'Hello, ' + output + '!';
}
