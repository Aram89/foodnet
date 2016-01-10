<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>FoodNET</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <%@include file="WEB-INF/widgets/styles.jsp" %>
</head>
<body ng-app="app">
<div class="main" ng-controller="MainController">
    <div class="header">
        <div class="col-sm-3">
            <h3>{{tr.food}}</h3>
        </div>
        <div class="col-sm-4">Email: info@foodenet.am</div>
        <div class="col-sm-3">Address: Yerevan Armenia</div>
        <div class="col-sm-1"><a href="#becomeChef">{{tr.become_chef}}</a></div>
        <div class="col-sm-1"><button ng-click="setLang('hy')">AM</button><button ng-click="setLang('en')">EN</button></div>
    </div>
    <nav class="navbar navbar-default" ng-class="{'navbar-fixed-top':navTop}">
        <div class="container">
            <div class="col-sm-8">
                <div class="col-sm-2" ng-repeat="s in sections">
                    <div ng-if="s.href">
                        <a href="{{s.href}}">{{tr[s.title]}}</a>
                    </div>
                    <div ng-if='s.list' class="dropdown">
                            <span class="dropdown-toggle" data-toggle="dropdown">{{tr[s.title]}}
                                <span ng-show="s.list.length" class="caret"></span>
                            </span>
                        <ul ng-show="s.list.length" class="dropdown-menu">
                            <li ng-repeat="l in s.list"><a href="{{l.href}}">{{tr[l.title]}}</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="right-inner-addon">
                    <i class="glyphicon glyphicon-search"></i>
                    <input type="search"
                           class="form-control"
                           placeholder="Search"/>
                </div>
            </div>
        </div>
    </nav>
    <div ng-view></div>
</div>
<%@include file="WEB-INF/widgets/scripts.jsp" %>
</body>
</html>
