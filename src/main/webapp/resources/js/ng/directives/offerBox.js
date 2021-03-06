/**
 * Created by pr on 01/04/2016.
 */

app.directive('offerBox',[function(){
    return{
        scope:{
            opt:'=options',
            addDish:'=addToOrder'
        },
        replace: true,
        controller:['$scope','$rootScope','ngDialog','$location',function($scope,$rootScope,ngDialog,$location){
            $scope.add = function(dish,count){
                $scope.addDish(dish,count);
                ngDialog.closeAll();
            };
            $scope.viewDish = function () {
                $scope.opt.currentCount = $scope.opt.count?$scope.opt.count:1;
                ngDialog.open({
                    preCloseCallback:function(){
                        $scope.opt.currentCount = 1;
                    },
                    template: '/resources/views/templates/popupDish.tmpl.html',
                    className:"ngdialog-theme-default popup-dish",
                    scope:$scope
                });
            };
            $scope.go=function(id){
                $location.path('dishview'+id);
            };
            $scope.img='/resources/multimedia/images/1.jpg';
            $scope.belongsTo = ["logo","identity"];
            $scope.title = "dish 1";
            $scope.name = "dish 1";
            $scope.$watch(function() {
                return $rootScope.tr;
            }, function() {
                $scope.lang = $rootScope.lang;
                $scope.tr = $rootScope.tr;
                console.log(4);
            }, true);
            $scope.$watch('order.dishes.length',function(n){
                if(n){$scope.isBoxOpen = true}
            })
        }],
        link: function (scope) {
        },
        templateUrl: '/resources/views/templates/offerBox.tmpl.html'
    }
}]);