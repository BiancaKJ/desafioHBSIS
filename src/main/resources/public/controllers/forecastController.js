app.controller('forecastController', function ($scope, $http, $window) {
    
    $window.onload = function () {
        $http({
            method: 'GET',
            url: '/forecast/previsoes'
        }).then(function success(response) {
            $scope.previsoes = response.data.list;
        }, function error(error) {
            console.log(error);
        });
    }
})