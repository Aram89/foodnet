/**
 * Created by pr on 01/17/2016.
 */
app.controller('DishesController',['$scope','$rootScope','requestsService','$interval','$timeout','ngDialog',function($scope,$rootScope,requestsService,$interval,$timeout,ngDialog){
    $rootScope.$on("$routeChangeSuccess", function(e, c,p) {
        console.log(e,c,p);
        function openPopup(dish){
            $scope.opt=dish;
            ngDialog.open({
                preCloseCallback:function(){
                    $scope.opt.currentCount = 1;
                },
                template: '/resources/views/templates/popupDish.tmpl.html',
                className:"ngdialog-theme-default popup-dish",
                scope:$scope
            });
        }
        if($location.$$url.indexOf('dishview')!=-1){
            requestsService.getDish({dishId:c.params.id}).success(openPopup).error(function(){alert('error')});
        }
    });


    $scope.dishes  = [];
    $scope.order = {dishes:[],name:'',phone:'',comments:[]};
    $scope.filterByChef = false;
    $scope.selectedCehfId=false;
    $scope.showOnlines = true;
    $scope.nextChefs = 0;
    $scope.chefs = [];
    //$scope.nextDishes = 0
    $scope.showChefImages = function(chef){
        ngDialog.open({
            template: '/resources/views/templates/chefImages.tmpl.html',
            className: 'chef-view ngdialog-theme-default',
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
                        return d.chef.partnerId==dish.chef.partnerId
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
        {name:"all",title:"Բոլորը",next:0,dishes:[]},
        {name:"lunch",title:"Լանչ",next:0,dishes:[]},
        {name:"salads",title:"Աղցաններ",next:0,dishes:[]},
        {name:"cake",title:"Թխվածք",next:0,dishes:[]},
        {name:"soup",title:"Ապուր",next:0,dishes:[]},
        {name:"hotDishes",title:"Տաք ուտեստներ",next:0,dishes:[]},
        {name:"garnish",title:"Խավարտներ",next:0,dishes:[]}
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
        //console.log($scope.categories[index].next);
        $scope.dishes = $scope.categories[index].dishes;
        if(!$scope.categories[index].next){
            $scope.loadDishes($scope.category);
        }
//        $scope.loadDishes(c);
    };
    /******************/
    $scope.categoryFilter = function(c){
        //var res=$scope.category.name=="all"|| c.categories.indexOf($scope.category.name)!=-1;
        var res=true;
        if($scope.filterByChef && $scope.selectedCehfId){
            res = res && c.chef.partnerId==$scope.selectedCehfId;
        }
        if($scope.showOnlines){
            res = res && c.prepareTime<60;
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
        requestsService.loadDishes({category:category.name,page:category.next,count:9})
            .success(function(data){
                category.next++;
                data.forEach(function (r) {
                    category.dishes.push(r)
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
    $scope.getChefs = function(count){
        requestsService.getChefs({page:$scope.nextChefs,count:count})
            .success(function(data){
                data.forEach(function(c){
                    $scope.chefs.push(c)
                });
                $scope.nextChefs = $scope.nextChefs + count/4;
            })
            .error(function(){
                alert('something wrong')
            })
    };
    $scope.getChefs(8);
    //$scope.loadDishes($scope.category,9);
    $scope.selectCategory(0);
    //$interval(function(){$scope.getOnlineChefs($scope.category,$scope.category)},10000)
}]);