
angular.module('eletrocrazy').controller('NewUsusarioController', function ($scope, $location, locationParser, flash, UsusarioResource ) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.ususario = $scope.ususario || {};
    

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            flash.setMessage({'type':'success','text':'The ususario was created successfully.'});
            $location.path('/Ususarios');
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        UsusarioResource.save($scope.ususario, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/Ususarios");
    };
});