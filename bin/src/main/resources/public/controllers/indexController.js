angular.module("PrevisaoTempo").controller('indexController', function ($scope, $http, $window) {

    $scope.idCadastro = false;
    $scope.idCadastroErro = false;

    $window.onload = function () {
        $scope.buscar();
    }

    $scope.close = function (id) {
        $scope.idCadastro = !id;
        $scope.idCadastroErro = !id;        
    }

    $scope.buscar = function () {
        $http({
            method: 'GET',
            url: '/cidade/list'
        }).then(function success(response) {
            console.log(response);
            $scope.cadastradas = response.data;
        }, function error(error) {
            console.log(error);
        });
    }

    $scope.cadastrar = function (cidade, pais) {
        if (cidade != undefined || pais != undefined) {
            $http({
                method: 'POST',
                url: '/cidade/' + cidade + '/' + pais
            }).then(function success(response) {
                $scope.idCadastro = true;
                console.log("Cadastro realizado com sucesso" + response);
            }, function error(error) {
                $scope.idCadastroErro = true;
                console.log(error);
            });
        } else {
            $scope.idCadastroErro = true;
        }

    }

})