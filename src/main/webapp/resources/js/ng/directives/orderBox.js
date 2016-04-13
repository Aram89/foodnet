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
            console.log($scope.order);
            $scope.chefs=[];
            $scope.order.price = function(){
                var price=0;
                $scope.chefs=[];
                $scope.order.dishes.forEach(function(d){
                    if($scope.chefs.indexOf(d.chef.partnerId)==-1){
                        $scope.chefs.push(d.chef.partnerId)
                    }
                    price+= parseInt(d.price)* d.count;
                });
                return price+$scope.chefs.length*400;
            };
            $scope.toggleBox = function(){
                $scope.isBoxOpen=!$scope.isBoxOpen;
            };
            $scope.removeDish =function(index){
                $scope.order.dishes.splice(index,1);
            };

            $scope.makeOrder = function(){
                /*var comment ='';
                console.log($scope.order);
                $scope.order.comments.forEach(function(){

                });*/
                $scope.chefs.forEach(function(c){
                    var res = {
                        "phone":$scope.order.phone,
                        comment:"",
                        "price":400,
                        "dishOrders":[]
                    };
                    $scope.order.dishes.forEach(function(d){
                        if(d.chef.partnerId==c){
                            res.price += d.count*d.price;
                            res.dishOrders.push({"count":d.count,"dish":{"name": d.name,"dishId": d.dishId}});
                            if(d.comment){res.comment+= d.name+'-'+d.comment+"  "}
                        }
                    });
                    console.log(res);
                    requestsService.makeOrder(res).success(function(){
                        ngDialog.open({
                             controller:['$scope',function($scope){
                                 $timeout($scope.closeThisDialog,2000)
                             }]
                            }
                        )
                    }).error(function(){
                        ngDialog.open({
                                controller:['$scope',function($scope){
                                    $timeout($scope.closeThisDialog,5000)
                                }],
                                plain:true,
                                template:'<div>Շնորհակալություն,պատվերն ընդունված է</div><div>Մենք կկապվենք Ձեր հետ</div>'
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
