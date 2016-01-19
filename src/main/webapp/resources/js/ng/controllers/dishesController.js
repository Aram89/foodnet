/**
 * Created by pr on 01/17/2016.
 */
app.controller('DishesController',['$scope','requestsService',function($scope,requestsService){
    $scope.dishes  = [];
    $scope.category="all";
    $scope.categories = [
        {name:"all",title:"Բոլորը"},
        {name:"lunch",title:"Լանչ"},
        {name:"salads",title:"Աղացններ"},
        {name:"cake",title:"Թխվածք"},
        {name:"soup",title:"Ապուր"},
        {name:"hotDishes",title:"Տաք ուտեստներ"},
        {name:"garnish",title:"Խավարտներ"}
    ];
    $scope.selectCategory = function(c){
        console.log(c);
        $scope.category = c;
    };
    $scope.categoryFilter = function(c){
        return $scope.category=="all"||c.belongsTo.indexOf($scope.category)!=-1;
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