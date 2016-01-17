/**
 * Created by pr on 01/04/2016.
 */

app.directive('offerBox',[function(){
    return{
        scope:{
            opt:'=options'
        },
        replace: true,
        controller:function($scope){

            $scope.img='/resources/multimedia/images/1.jpg';
            $scope.belongsTo = ["logo","identity"];
            $scope.title = "dish 1";
        },
        link: function (scope) {
        },
        templateUrl: '/resources/views/templates/offerBox.tmpl.html'
    }
}]);