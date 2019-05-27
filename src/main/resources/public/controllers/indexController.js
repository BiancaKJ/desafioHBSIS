app.controller('indexController', function ($scope, $http, $window) {

    $scope.idCadastro = false;
    $scope.idCadastroErro = false;
    $scope.idApiErro = false;

    $window.onload = function () {
        $scope.buscarCidades();
    }

    $scope.fechar = function (id) {
        $scope.idCadastro = !id;
        $scope.idCadastroErro = !id;
        $scope.idApiErro = !id;
    }

    $scope.limpar = function () {
        document.getElementById('cids').value="";
        document.getElementById('pais').value="";
    }

    $scope.buscarCidades = function () {
        $http({
            method: 'GET',
            url: '/cidade/list'
        }).then(function success(response) {
            $scope.cadastradas = response.data;
        }, function error(error) {
            console.log(error);
        });
    }

    $scope.buscarApi = function(cidade,pais) {
        $http({
            method: 'GET',
            url: '/forecast/' + cidade + '/' + pais
        }).then(function success(response) {
            location.href="forecast.html";
        }, function error(error) {
            console.log(error);
            $scope.idApiErro = true;
            $scope.limpar();
        });
    }

    $scope.cadastrar =  function(cidade, pais){
        $http({
            method: 'POST',
            url: '/cidade/' + cidade + '/' + pais
        }).then(function success(response) {
            $scope.idCadastro = true;
            $scope.limpar();
            $scope.buscarCidades();
        }, function error(error) {
            console.log(error);
            $scope.idCadastroErro = true;
            $scope.limpar();
        });
    }

    $scope.validarCadastro = function (cidade, pais) {
        if (cidade != undefined || pais != undefined) {
            $http({
                method: 'GET',
                url: '/forecast/' + cidade + '/' + pais
            }).then(function success(response) {
                if(response.data.cod == 200){
                    $scope.cadastrar(cidade,pais);
                } else {
                    $scope.idApiErro = true;
                    $scope.limpar();
                }
            }, function error(error) {
                console.log(error);
                $scope.idApiErro = true;
                $scope.limpar();
            });
        } else {
            $scope.idCadastroErro = true;
            $scope.limpar();
        }
    }

})