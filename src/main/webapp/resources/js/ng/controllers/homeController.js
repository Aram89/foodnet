/**
 * Created by pr on 01/09/2016.
 */
app.controller('HomeController',['$scope',function($scope){
    $scope.popular = [1,2,3];
    $scope.arrivals = [1,2,3];
    $scope.showMore = function(param){
        $scope[param].push(1,3,5);
    };
}]);