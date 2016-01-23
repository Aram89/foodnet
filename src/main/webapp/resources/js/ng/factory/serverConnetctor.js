/**
 * Created by pr on 01/03/2016.
 */

app.factory('serverConnector',['$http',function($http){
    'use strict';

    var host='/resources/api/';
    //var host='http://192.168.0.101:8084/';
    var req = {
        method: 'POST',
        url: '/' /*,
         headers: {
         'Content-Type': undefined
         }*/
    };
    function send (request) {
        request.url = host+request.url;
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