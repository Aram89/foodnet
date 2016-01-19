/**
 * Created by pr on 01/01/2016.
 */
var app = angular.module('app',['ngResource','ngRoute','ngDialog']);


app.config(function($routeProvider,$httpProvider){
    $routeProvider
        .when('/becomeChef',{
            templateUrl:'../resources/views/templates/becomeChief.tmpl.html',
            controller:'BecomeChiefController'
        })
        .when('/home',{
            templateUrl:'../resources/views/templates/home.tmpl.html',
            controller:'HomeController'
        })
        .otherwise({
            redirectTo:'/home'
        });
    $httpProvider.defaults.useXDomain = true;
    delete $httpProvider.defaults.headers.common['X-Requested-With'];

});
