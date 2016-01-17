/**
 * Created by pr on 01/17/2016.
 */
app.controller('DishesController',['$scope','requestsService',function($scope,requestsService){
    $scope.dishes  = [];
    $scope.category="logo";
    $scope.categories = [
        {name:"lunch",title:"????"},
        {name:"salads",title:"????????"},
        {name:"cake",title:"?????????"},
        {name:"soup",title:"????????"},
        {name:"hotDishes",title:"????????????"},
        {name:"garnish",title:"??????"}
    ];
    $scope.selectCategory = function(c){
        console.log(c);
        $scope.category = c;
    };
    $scope.categoryFilter = function(c){
        console.log(c);
        return c.indexOf($scope.category)!=-1;
    };
    $scope.loadDishes = function(type){
        requestsService.loadDishes({type:type})
            .success(function(data){
                console.log(data);
                ///$scope.dishes.push(data);
                data.forEach(function (d) {
                    $scope.dishes.push(d)
                });
            })
            .error(function(){
                console.log("failed load dishes");
            })
    };

    $scope.loadDishes("");
}]);