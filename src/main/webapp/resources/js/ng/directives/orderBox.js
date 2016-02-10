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
            $scope.removeDish =function(index){
                console.log(index);
                $scope.order.dishes.splice(index,1);
            };
            $scope.makeOrder = function(){
                console.log($scope.order);
                var res = {
                    "phone":$scope.order.phone,
                    "name":$scope.order.name,
                    "dishOrders":[]
                };
                $scope.order.dishes.forEach(function(d){
                    res.dishOrders.push({"count":d.count,"dish":{"dishId": d.dishId}})
                });
                console.log(res);
                requestsService.makeOrder($scope.order).success(function(){

                    }).error(function(){

                    })
            }
        }],
        templateUrl : '/resources/views/templates/orderBox.tmpl.html'
    }
});
