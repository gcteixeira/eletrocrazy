
angular.module('eletrocrazy').controller('NewCarrinhoController', function ($scope, $location, locationParser, flash, CarrinhoResource ) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.carrinho = $scope.carrinho || {};
    

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            flash.setMessage({'type':'success','text':'The carrinho was created successfully.'});
            $location.path('/Carrinhos');
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        CarrinhoResource.save($scope.carrinho, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/Carrinhos");
    };
});