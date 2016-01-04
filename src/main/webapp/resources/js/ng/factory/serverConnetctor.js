/**
 * Created by pr on 01/03/2016.
 */

app.factory('serverConnector',['$http',function($http){
    'use strict';

    var req = {
        method: 'POST',
        url: '/' /*,
         headers: {
         'Content-Type': undefined
         }*/
    };
    function send (request) {
        var promise = $http(angular.merge(req, request));
        promise.then(
            function() {},
            function(error) {
                if(error) console.error(error);
            }
        );
        return promise;
    }

    return {
        send : send
    };
}]);