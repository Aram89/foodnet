/**
 * Created by pr on 01/04/2016.
 */

app.directive('offerBox',[function(){
    return{
        scope:{
            options:'=options'
        },
        controller:function($scope){
            $scope.img='/resources/multimedia/images/1.jpg';
        },
        link: function (scope) {
        },
        templateUrl: 'resources/views/templates/offerBox.tmpl.html'
    }
}]);