/**
 * Created by pr on 01/04/2016.
 */

app.directive('offerBox',[function(){
    return{
        scope:{
            opt:'=options'
        },
        replace: true,
        controller:['$scope','ngDialog',function($scope,ngDialog){
            $scope.viewDish = function () {
                ngDialog.open({
                    template: '/resources/views/templates/popupDish.tmpl.html',
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