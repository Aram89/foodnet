/**
 * Created by pr on 01/31/2016.
 */
app.directive('orderBox',function(){
    function controller(){}
    return{
        scope:{
            order:"=order"
        },
        controller : ['$scope','requestsService','ngDialog','$timeout',function($scope,requestsService,ngDialog,$timeout){
            $scope.chefs=[];
            $scope.datePicker={open:false};
            $scope.order.preliminary=false;
            $scope.order.price = function(){
                var price=0;
                $scope.chefs=[];
                $scope.order.dishes.forEach(function(d){
                    if($scope.chefs.indexOf(d.chef.partnerId)==-1){
                        $scope.chefs.push(d.chef.partnerId)
                    }
                    price+= parseInt(d.price)* d.count;
                });
                return price;
            };
            $scope.toggleBox = function(){
                $scope.isBoxOpen=!$scope.isBoxOpen;
            };
            $scope.removeDish =function(index){
                $scope.order.dishes.splice(index,1);
            };
            $scope.openOrderWindow = function(){
                ngDialog.open({
                        template:'/resources/views/templates/order-popup.tmpl.html',
                        className:'ngdialog-theme-default order-popup',
                        scope:$scope
                    }
                )
            };
            $scope.openDatePicker =function(){
                $scope.datePicker.open=true;
            };
            $scope.changePreliminary =function(){
                if($scope.order.preliminary){
                    $scope.order.deliveryDate = new Date();
                    var d=new Date();
                    $scope.order.deliveryTime = d;
                    $scope.order.deliveryTime.setHours(d.getHours()+2)
                }else{
                    $scope.order.deliveryTime = null;
                    $scope.order.deliveryDate = null
                }
            };
            $scope.makeOrder = function(){
                /*var comment ='';
                console.log($scope.order);
                $scope.order.comments.forEach(function(){

                });*/
                $scope.ordering = true;
                var successed=0;
                var orderDT='';
                if($scope.preliminary){
                    orderDT=$scope.order.deliveryDate.getFullYear()+'/'+($scope.order.deliveryDate.getMonth()+1)+'/'+$scope.order.deliveryDate.getDate() + '-'+$scope.order.deliveryTime.getHours()+':'+$scope.order.deliveryTime.getMinutes();
                }
                $scope.chefs.forEach(function(c){
                    var res = {
                        "phone":$scope.order.phone,
                        comment:"",
                        "price":400,
                        "dishOrders":[],
                        "deliveryDateTime":orderDT,
                        "orderDateTime":new Date(),
                        "location":$scope.order.location
                    };
                    $scope.order.dishes.forEach(function(d){
                        if(d.chef.partnerId==c){
                            res.price += d.count*d.price;
                            if($scope.order.preliminary){
                                res.price = res.price*90/100;
                            }
                            res.dishOrders.push({"count":d.count,"dish":{"name": d.name,"dishId": d.dishId}});
                            if(d.comment){res.comment+= d.name+'-'+d.comment+"  "}
                        }
                    });
                    requestsService.makeOrder(res).success(function(){
                        successed++;
                        $scope.ordering = false;
                        if(successed==$scope.chefs.length)
                        ngDialog.open({
                             controller:['$scope',function($scope){
                                 $timeout($scope.closeThisDialog,5000)
                             }],
                             plain:true,
                             template:'<div>Շնորհակալություն:Պատվերն ընդունված է</div><div>Մենք շուտով կկապվենք Ձեզ հետ</div>'
                            }
                        )
                    }).error(function(){
                        $scope.ordering = false;
                        ngDialog.open({
                                controller:['$scope',function($scope){
                                    $timeout($scope.closeThisDialog,5000)
                                }],
                                plain:true,
                                template:'<div>Ներողություն:Պատվերն ընդւոնված չէ</div><div>Խնդրում ենք փորձել նորից</div>'
                            }
                        )
                    })
                });
            };
            $scope.$watch('order.dishes.length',function(n){
                if(n){$scope.isBoxOpen = true}
            })
        }],
        templateUrl : '/resources/views/templates/orderBox.tmpl.html'
    }
});
