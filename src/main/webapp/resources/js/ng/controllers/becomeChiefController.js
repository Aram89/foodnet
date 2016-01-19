/**
 * Created by pr on 01/09/2016.
 */
app.controller('BecomeChefController',['$scope','requestsService',function($scope,requestsService){
    $scope.regChef={};
    $scope.becomeChef = function(){
        requestsService.becomeChef($scope.regChef)
            .success(function(data){
                console.log(data)
            })
            .error(function(){
                alert('something wrong')
            })
    }
}]);