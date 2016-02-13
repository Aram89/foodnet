/**
 * Created by pr on 01/31/2016.
 */
app.directive('orderBox',function(){
    function controller(){}
    return{
        scope:{
            order:"=order"
        },
        controller : ['$scope','requestsService',function($scope,requestsService){
            $scope.chefs=[];
            console.log($scope.order);
            $scope.order.price = function(){
                var price=0;
                $scope.order.dishes.forEach(function(d){
                    if($scope.chefs.indexOf(d.chef.chefId)==-1){
                        $scope.chefs.push(d.chef.chefId)
                    }
                    price+= parseInt(d.price)* d.count;
                });
                console.log($scope.chefs.length);
                return price+$scope.chefs.length*400;
            };
            $scope.toggleBox = function(){
                $scope.isBoxOpen=!$scope.isBoxOpen;
            };
            $scope.removeDish =function(index){
                console.log(index);
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
                        "name":$scope.order.name,
                        "dishOrders":[]
                    };
                    $scope.order.dishes.forEach(function(d){
                        if(d.chef.chefId==c){
                            res.dishOrders.push({"count":d.count,"dish":{"dishId": d.dishId}})
                        }
                    });
                    console.log(res);
                    requestsService.makeOrder(res).success(function(){

                    }).error(function(){

                    })
                });
            }
        }],
        templateUrl : '/resources/views/templates/orderBox.tmpl.html'
    }
});
