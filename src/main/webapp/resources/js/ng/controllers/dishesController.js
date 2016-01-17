/**
 * Created by pr on 01/17/2016.
 */
app.controller('DishesController',['$scope','requestsService',function($scope,requestsService){
    $scope.dishes  = [];
    $scope.loadDishes = function(type){
        requestsService.loadDishes({type:type})
            .success(function(data){
                $scope.dishes = data;
            })
            .error(function(){
                console.log("failed load dishes");
            })
    };
}]);