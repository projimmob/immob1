'use strict';
  
angular.module('Authentication')
.controller('LoginController',
    ['$scope', '$rootScope', '$location', 'AuthenticationService',
    function ($scope, $rootScope, $location, AuthenticationService) {
        // reset login status
        AuthenticationService.ClearCredentials();
 
        $scope.login = function () {
            $scope.dataLoading = true;
            AuthenticationService.Login($scope.mail, $scope.psw, function(response) {
                if(typeof response == "object") {
                    AuthenticationService.SetCredentials($scope.mail, $scope.psw);
                    $location.path('/tabordAll');
                } else {
                    $scope.error = response.message;
                    $scope.dataLoading = false;
                }
            });
        };
    }]);
    
