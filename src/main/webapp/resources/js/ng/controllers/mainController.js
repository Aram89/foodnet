/**
 * Created by pr on 01/02/2016.
 */
app.controller('MainController',['$scope','translationService',function($scope,translationService){
    $scope.setLang =function(lang){
        translationService.getTranslation($scope,lang);
    };
    $scope.navTop=false;
    angular.element(window).bind('scroll',function(evt){
        if(window.scrollY>65){
            $scope.navTop=true;
            $scope.$apply();
        }else{
            $scope.navTop = false;
            $scope.$apply();
        }
    });
    $scope.setLang('en');
    $scope.sections = [
        {title:'Home',href:'#home'},
        {title:'About_us',href:'#aboutus'},
        {title:'Shop',list:[{title:'Fish',href:'#fish'},{title:'Meat',href:'#meat'},{title:'Fruit',href:'#fruit'}]}
    ]
}]);