/*
function greet(name) {
    alert("hello");
    var output = '';
    var am = angular.module("push_value", []);
    am.controller('push_value', ['$scope', '$http',
        function ($scope, $http) {
            $http.get('http://localhost:8080/aa?aa=1').success(function (status) {
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
*/
var am = angular.module("push_value", []);
am.controller('push_value', ['$scope', '$http',
    function ($scope, $http) {
        $scope.isrun = 0;
        $scope.click = function () {
            $http.get('http://localhost:8080/aa?aa=1').then(function successCallback(response) {
                $scope.info = response.data;
            }, function errorCallback(response) {
                $scope.info = response;
            });
            $scope.isrun = 1;
        }
    }]);