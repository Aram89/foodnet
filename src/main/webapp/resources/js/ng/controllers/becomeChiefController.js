/**
 * Created by pr on 01/09/2016.
 */
app.controller('BecomeChefController',['$scope','requestsService',function($scope,requestsService){
    $scope.regChef={};
    $scope.ok = false;
    $scope.becomeChef = function(){
        $scope.ok = false;
        requestsService.becomeChef($scope.regChef)
            .success(function(data){
                console.log(data);
                $scope.ok= 1
            })
            .error(function(){
                $scope.ok=0;
                alert('something wrong')
            })
    }
}]);