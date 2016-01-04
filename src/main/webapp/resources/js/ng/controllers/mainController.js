/**
 * Created by pr on 01/02/2016.
 */
app.controller('MainController',['$scope','translationService',function($scope,translationService){
    $scope.setLang =function(lang){
        translationService.getTranslation($scope,lang);
    };
    $scope.setLang('en');
    $scope.popular = [1,2,3];
    $scope.arrivals = [1,2,3];
    $scope.showMore = function(param){
        $scope[param].push(1,3,5);
    };
    $scope.becomeChief = function(){};
    $scope.sections = [
        {title:'Home',href:'#home'},
        {title:'About_us',href:'#aboutus'},
        {title:'Shop',list:[{title:'Fish',href:'#fish'},{title:'Meat',href:'#meat'},{title:'Fruit',href:'#fruit'}]}
    ]
}]);