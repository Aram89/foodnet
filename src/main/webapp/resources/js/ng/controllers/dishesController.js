/**
 * Created by pr on 01/17/2016.
 */
app.controller('DishesController',['$scope','requestsService',function($scope,requestsService){
    $scope.dishes  = [];
    $scope.category="all";
    $scope.order = {dishes:[],name:'',phone:''};
    $scope.filterByChef = false;
    $scope.selectedCehfId=false;
    $scope.nextChefs = 0;
    $scope.chefs = [];
    //$scope.nextDishes = 0
    $scope.addToOrder = function (dish) {
        if($scope.order.dishes.length==0){
            dish.count=1;
            $scope.order.dishes.push(dish)
        }else{
            if($scope.order.dishes.some(function(d){
                    if(d.dishId===dish.dishId){
                        d.count++;
                    }
                    return d.dishId===dish.dishId
                })
            ){
                //console.log(dish)
            }else{
                if(!$scope.order.dishes.some(function(d){
                        return d.chef.chefId==dish.chef.chefId
                    })){alert("+400 mayet axpers/qurs")}
                dish.count=1;
                $scope.order.dishes.push(dish)
            }
        }
    };

    $scope.categories = [
        {name:"all",title:"Բոլորը",next:0},
        {name:"lunch",title:"Լանչ",next:0},
        {name:"salads",title:"Աղացններ",next:0},
        {name:"cake",title:"Թխվածք",next:0},
        {name:"soup",title:"Ապուր",next:0},
        {name:"hotDishes",title:"Տաք ուտեստներ",next:0},
        {name:"garnish",title:"Խավարտներ",next:0}
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
    };
    $scope.selectCategory = function(c){
        console.log(c);
        $scope.category = c;
//        $scope.loadDishes(c);
    };
    /******************/
    $scope.categoryFilter = function(c){
        var res=$scope.category=="all"|| c.categories.indexOf($scope.category)!=-1;
        if($scope.filterByChef && $scope.selectedCehfId){
            console.log(c);
            res = res && c.chef.chefId==$scope.selectedCehfId
        }
        return res;
    };
    $scope.selectChef = function(id){
        $scope.selectedCehfId = id
    };
    /******************/
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
    $scope.getChefs = function(){
        requestsService.getChefs($scope.nextChefs,4)
            .success(function(data){
                data.forEach(function(c){
                    $scope.chefs.push(c)
                })
            })
            .error(function(){
                alert('something wrong')
            })
    };
    $scope.getChefs();
    $scope.loadDishes("");
}]);