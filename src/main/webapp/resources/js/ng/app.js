/**
 * Created by pr on 01/01/2016.
 */
var app = angular.module('app',['ngResource','ngRoute','ngDialog']);


app.config(function($routeProvider,$httpProvider){
    $routeProvider
        .when('/',{})
        .when('/dishview:id',{})
        .otherwise({redirectTo:'/'})

    ;
    $httpProvider.defaults.useXDomain = true;
    delete $httpProvider.defaults.headers.common['X-Requested-With'];

}).run(function($route) {});
