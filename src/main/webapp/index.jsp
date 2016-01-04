<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>FoodNET</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <%@include file="WEB-INF/widgets/styles.jsp" %>
</head>
<body ng-app="app">
<div class="main" ng-controller="MainController">
    <nav class="navbar navbar-default navbar-fixed-top">
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
    <div class="header">
        <div class="col-sm-3">
            <h3>{{tr.food}}</h3>
        </div>
        <div class="col-sm-4">Email: info@foodenet.am</div>
        <div class="col-sm-3">Address: Yerevan Armenia</div>
        <div class="col-sm-1"><a href="#becomeChief">Become Chief</a></div>
        <div class="col-sm-1"><button ng-click="setLang('hy')">AM</button><button ng-click="setLang('en')">EN</button></div>
    </div>
    <div class="mid">
        <div class="text-center"><h2>{{tr.todays_offer}}</h2></div>
    </div>
    <div style="min-height: 1000px">
        <div class="popular">
            <h1 class="text-center text-danger">{{tr.popular_products}}</h1>
            <div class="boxes row"><div ng-repeat="a in popular track by $index" class="col-sm-4"><offer-box></offer-box></div></div>
            <div ng-click="showMore('popular')" class="text-center"><span>{{tr.show_more}}</span><span class="caret"></span></div>
        </div>
        <div class="nweFood">
            <h1 class="text-center text-warning">{{tr.new_arrivals}}</h1>
            <div class="boxes row"><div ng-repeat="a in popular track by $index" class="col-sm-4"><offer-box></offer-box></div></div>
            <div ng-click="showMore('arrivals')" class="text-center"><span>{{tr.show_more}}</span><span class="caret"></span></div>
        </div>
    </div>
</div>
<%@include file="WEB-INF/widgets/scripts.jsp" %>
</body>
</html>
