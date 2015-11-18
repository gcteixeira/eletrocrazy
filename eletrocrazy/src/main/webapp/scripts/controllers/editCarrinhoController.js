

angular.module('eletrocrazy').controller('EditCarrinhoController', function($scope, $routeParams, $location, flash, CarrinhoResource ) {
    var self = this;
    $scope.disabled = false;
    $scope.$location = $location;
    
    $scope.get = function() {
        var successCallback = function(data){
            self.original = data;
            $scope.carrinho = new CarrinhoResource(self.original);
        };
        var errorCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The carrinho could not be found.'});
            $location.path("/Carrinhos");
        };
        CarrinhoResource.get({CarrinhoId:$routeParams.CarrinhoId}, successCallback, errorCallback);
    };

    $scope.isClean = function() {
        return angular.equals(self.original, $scope.carrinho);
    };

    $scope.save = function() {
        var successCallback = function(){
            flash.setMessage({'type':'success','text':'The carrinho was updated successfully.'}, true);
            $scope.get();
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        $scope.carrinho.$update(successCallback, errorCallback);
    };

    $scope.cancel = function() {
        $location.path("/Carrinhos");
    };

    $scope.remove = function() {
        var successCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The carrinho was deleted.'});
            $location.path("/Carrinhos");
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        }; 
        $scope.carrinho.$remove(successCallback, errorCallback);
    };
    
    
    $scope.get();
});