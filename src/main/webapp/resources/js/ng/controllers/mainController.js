/**
 * Created by pr on 01/02/2016.
 */
app.controller('MainController',['$scope','translationService','ngDialog',function($scope,translationService,ngDialog){
    $scope.setLang =function(lang){
        translationService.getTranslation($scope,lang);
    };
    $scope.becomeChef = function () {
        ngDialog.open({
            template: '/resources/views/templates/becomeChief.tmpl.html',
            controller: 'BecomeChefController'
        });
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
    $scope.test="test";
    $scope.setLang('en');
    $scope.sections = [
        {title:'Home',href:'#home'},
        {title:'About_us',href:'#aboutus'},
        {title:'Shop',list:[{title:'Fish',href:'#fish'},{title:'Meat',href:'#meat'},{title:'Fruit',href:'#fruit'}]}
    ]
}]);