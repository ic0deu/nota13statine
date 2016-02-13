angular.module('nota13statine', [])
    .controller('home', function($scope, $http) {
        $scope.calculateLDL = function () {
            $http.get('/ldl/', {params: {totale: $scope.totale, hdl: $scope.hdl, trigliceridi: $scope.trigliceridi}}).success(function(data) {
                $scope.result = data;
            })
        }
    })
    .controller('age', function($scope, $http) {
        $scope.calculateAge = function () {
            $http.get('/ldl/', {params: {totale: 5, hdl: 5, trigliceridi: 5}}).success(function(data) {
                $scope.result = data;
            })
        }
    })
    .controller('DateController', ['$scope', function($scope) {
        $scope.dob = {
            value: ""
        };
    }]);

