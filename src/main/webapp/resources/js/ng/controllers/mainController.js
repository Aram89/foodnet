/**
 * Created by pr on 01/02/2016.
 */
app.controller('MainController',['$scope','ngDialog','translationService','$rootScope','$location','requestsService',function($scope,ngDialog,translationService,$rootScope,$location,requestsService){
    $scope.setLang =function(lang){
        translationService.getTranslation($rootScope,lang);
    };
    $rootScope.test1='ttest1';
    $scope.mail={};
    $scope.sendMail = function(){
        requestsService.sendMail($scope.mail).success(function(){
            console.log('sent')
        })
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
    $scope.setLang('hy');
    $scope.sections = [
        {title:'Home',href:'#home'},
        {title:'About_us',href:'#aboutus'},
        {title:'Shop',list:[{title:'Fish',href:'#fish'},{title:'Meat',href:'#meat'},{title:'Fruit',href:'#fruit'}]}
    ]
}]);