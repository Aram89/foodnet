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
        controller:['$scope','ngDialog',function($scope,ngDialog){
            $scope.viewDish = function () {
                $scope.opt.currentCount = $scope.opt.count?$scope.opt.count:1;
                ngDialog.open({
                    preCloseCallback:function(){
                        $scope.opt.currentCount = $scope.opt.count;
                    },
                    template: '/resources/views/templates/popupDish.tmpl.html',
                    className:"ngdialog-theme-default popup-dish",
                    scope:$scope
                });
            };
            $scope.img='/resources/multimedia/images/1.jpg';
            $scope.belongsTo = ["logo","identity"];
            $scope.title = "dish 1";
            $scope.name = "dish 1";
        }],
        link: function (scope) {
        },
        templateUrl: '/resources/views/templates/offerBox.tmpl.html'
    }
}]);