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
    var categories = {name:"lunch",description:"desc"};
    //    {name:"salads",description:"dsc"},
    //    {name:"cake",description:"dedsc"},
    //    {name:"soup",description:"desc"},
    //    {name:"hotDishes",description:"desc"},
    //    {name:"garnish",description:"desc"}
    //;
    $scope.someReq =function(){
        requestsService.addCategories(categories).success(function(){
            alert("exav")
        })
    }
    $scope.selectCategory = function(c){
        console.log(c);
        $scope.category = c;
        $scope.loadDishes(c);
    };
    $scope.categoryFilter = function(c){
        return $scope.category=="all"||c.categories.indexOf($scope.category)!=-1;
    };
    $scope.loadDishes = function(type){
        var dish={category:type,start:0,count:10};
        requestsService.loadDishes(dish)
            .success(function(data){
                console.log(data);
               // var result = JSON.parse(data);
                ///$scope.dishes.push(data);
                data.forEach(function (r) {
                    $scope.dishes.push(r)
                });
            })
            .error(function(){
                console.log("failed load dishes");
            })
    };

    $scope.loadDishes("");
}]);