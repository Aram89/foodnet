/**
 * Created by pr on 01/03/2016.
 */

app.factory('serverConnector',['$http',function($http){
    'use strict';
     var host  = '/';
    //var host='/resources/api/';
    var req = {
        method: 'POST',
        url: '/' /*,
         headers: {
         'Content-Type': undefined
         }*/
    };
    function send (request) {
        request.url = host+request.url;
        console.log(request.url)

        var promise = $http(request);
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