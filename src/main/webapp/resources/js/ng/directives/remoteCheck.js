/**
 * Created by pr on 01/10/2016.
 */
app.directive('ngRemoteCheck',['serverConnector', function(serverConnector) {
    return {
        restrict: "A",
        require: "ngModel",
        link: function (scope, elem, attr, ctrl) {
            var checkUrl = attr['ngRemoteCheck'],
                propName = 'name', params = {}, timeoutID;
            if (attr['id']) propName = attr['id'];
            if (attr['name']) propName = attr['name'];
            function validate() {
                ctrl.$setValidity('remote', true);
                if (timeoutID) clearTimeout(timeoutID);
                timeoutID = setTimeout(function () {
                    params[propName] = ctrl.$modelValue;
                    serverConnector.send({
                        method: "get",
                        url: checkUrl,
                        params: params
                    }).success(function (data) {
                        ctrl.$setValidity('remote', true);
                    })
                        .error(function (data) {
                            ctrl.$setValidity('remote', false);
                        })
                }, 300)
            }
            scope.$watch(attr.ngModel, function (n) {
                if(n){
                    validate();
                }
            })
        }
    }
}]);
