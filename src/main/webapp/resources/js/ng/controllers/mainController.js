/**
 * Created by pr on 01/02/2016.
 */
app.controller('MainController',['$scope','translationService',function($scope,translationService){
    $scope.setLang =function(lang){
        translationService.getTranslation($scope,lang);
    };
    $scope.setLang('en');
    $scope.sections = [
        {title:'Home',href:'#home'},
        {title:'About us',href:'#aboutus'},
        {title:'Shop',list:[{title:'Fish',href:'#fish'},{title:'Meat',href:'#meat'},{title:'Fruit',href:'#fruit'}]}
    ]
}]);