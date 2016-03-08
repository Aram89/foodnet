/**
 * Created by pr on 01/17/2016.
 */
app.controller('DishesController',['$scope','requestsService','$interval','$timeout','ngDialog',function($scope,requestsService,$interval,$timeout,ngDialog){
    $scope.dishes  = [];

    $scope.order = {dishes:[],name:'',phone:'',comments:[]};
    $scope.filterByChef = false;
    $scope.selectedCehfId=false;
    $scope.nextChefs = 0;
    $scope.chefs = [];
    //$scope.nextDishes = 0
    $scope.showChefImages = function(chef){
        ngDialog.open({
            template: '/resources/views/templates/chefImages.tmpl.html',
            controller :["$scope","chef",function($scope,chef){
                $scope.chefCurrentImg=0;
                $scope.chef=chef;
                $scope.changeChefImg = function(t){
                    $scope.chefCurrentImg = $scope.chefCurrentImg+t;
                };
            }],
            resolve:{chef:function(){return chef}}
        })
    };
    $scope.scrollToSection = function(id){
        var scrl=$(id).position().top;
        window.scrollTo(0,scrl)
    };
    $scope.filterByChefChange = function(t){
        $scope.selectedCehfId=false;
        if(t){$scope.scrollToSection('#chefs')}
    };
    $scope.addToOrder = function (dish,count) {
        if(dish.comment){
         //   $scope.order.comments.push.({name:dish.name,comment:dish.comment})
        }
        if($scope.order.dishes.length==0){
            dish.count=count;
            $scope.order.dishes.push(dish)
        }else{
            if($scope.order.dishes.some(function(d){
                    if(d.dishId===dish.dishId){
                        d.count+=count;
                    }
                    return d.dishId===dish.dishId
                })
            ){
                //console.log(dish)
            }else{
                if(!$scope.order.dishes.some(function(d){
                        return d.chef.chefId==dish.chef.chefId
                    })){
                    ngDialog.open({
                            plain:true,
                            template:'<div>Ուշադրություն</div><div>Տարբեր խոհարարներից պատվիրելու դեպքում առաքման գումարը կավելանա՝ յուրաքանչյուրը 400 դրամ</div>'
                        }
                    )
                }
                dish.count=count;
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
    $scope.category=$scope.categories[0];
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
    $scope.selectCategory = function(index){
        $scope.category = $scope.categories[index];
//        $scope.loadDishes(c);
    };
    /******************/
    $scope.categoryFilter = function(c){
        var res=$scope.category.name=="all"|| c.categories.indexOf($scope.category.name)!=-1;
        if($scope.filterByChef && $scope.selectedCehfId){
            res = res && c.chef.chefId==$scope.selectedCehfId
        }
        return res;
    };
    $scope.selectChef = function(id){
        if($scope.selectedCehfId == id){
            $scope.selectedCehfId=false;
            $scope.filterByChef=false;
        }else{
            $scope.selectedCehfId = id;
            $scope.filterByChef=true;
        }
        $scope.scrollToSection("#dishes")
    };
    /******************/
    $scope.loadDishes = function(category){
        //var dish={category:type,start:0,count:10};
        requestsService.loadDishes({category:category.name,cate:category.next,count:9})
            .success(function(data){
                category.next++;
                data.forEach(function (r) {
                    $scope.dishes.push(r)
                });
            })
            .error(function(){
                console.log("failed load dishes");
            })
    };
    $scope.getOnlineChefs = function(category){
        requestsService.loadDishes({category:category.name,page:0,count:(category.next+1)*9})
            .success(function(data){
                $scope.dishes = data
            })
    };
    $scope.getChefs = function(){
        requestsService.getChefs({page:$scope.nextChefs,count:4})
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
    $scope.loadDishes($scope.category,10);
    //$interval(function(){$scope.getOnlineChefs($scope.category,$scope.category)},10000)
}]);