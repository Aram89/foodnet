<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
<head>
    <base href="resources/site/">
    <meta charset="utf-8">
    <title>Narinj.am</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

    <!-- Google Font -->
    <link href='http://fonts.googleapis.com/css?family=Raleway:400,700' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Lato:300,400,700' rel='stylesheet' type='text/css'>

    <!-- Bootstrap Core CSS -->
    <link href="assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">

    <!-- Plugins CSS -->
    <link href="assets/plugins/kitchen-font/kitchen-icons.css" rel="stylesheet">
    <link href="assets/plugins/dish-font/flaticon.css" rel="stylesheet">
    <link href="assets/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="assets/plugins/animate-css/animate.min.css" rel="stylesheet" type="text/css">
    <link href="assets/plugins/owl-carousel/owl.carousel.css" rel="stylesheet" type="text/css">
    <link href="assets/plugins/owl-carousel/owl.theme.css" rel="stylesheet" type="text/css">
    <link href="assets/plugins/jquery-magnificPopup/magnific-popup.css" rel="stylesheet" type="text/css">

    <!-- Component CSS -->
    <link href="assets/css/component/component.css" rel="stylesheet" type="text/css">

    <!-- Main CSS -->
    <link href="assets/css/rinjani.css" rel="stylesheet" type="text/css">

    <!-- Color CSS -->
    <link href="assets/css/colors/orange.css" rel="stylesheet" type="text/css">
    <link href="assets/css/component/colors/orange.css" rel="stylesheet" type="text/css">
    <%@include file="/WEB-INF/widgets/styles.jsp" %>
    <!-- Modernizr JS for IE9 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="assets/plugins/modernizr.min.js"></script>
    <![endif]-->

    <style>
        #orderData .glyphicon {
            cursor: pointer;
        }
    </style>
</head>

<!-- The #page-top ID is part of the scrolling feature - the data-spy and data-target are part of the built-in Bootstrap scrollspy function -->
<body ng-app="app" ng-controller="MainController" id="page-top" data-spy="scroll" data-target=".navbar-fixed-top" data-offset="51">

<!--[if lt IE 8]>
<p class="browsehappy">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
<![endif]-->

<!-- Begin Page Loader -->
<div id="page-loader">
    <div class="preload">
        <img src="assets/img/orange-preloader.gif" alt="Loading"/>
    </div>
    <!-- //.preload -->
</div>
<!-- //End Page Loader -->

<!-- Begin  -->
<section id="admin" class="section" ng-controller="adminController">

    <div class="section-inner">
        <div class="container section-content">

            <!-- Modal -->
            <div class="modal fade" id="statusModal" tabindex="-1" role="dialog" aria-labelledby="statusModalLabel">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title" id="statusModalLabel">Change {{currentStatusField}} Status Order id: {{currentOrder.id}} </h4>
                        </div>
                        <div class="modal-body">
                            <form>
                                <div class="radio">
                                    <label>
                                        <input type="radio" name="status" value="pending" ng-model="currentStatus">
                                        <span class="label label-warning">Pending</span>
                                    </label>
                                </div>
                                <div class="radio">
                                    <label>
                                        <input type="radio" name="status" value="accepted" ng-model="currentStatus">
                                        <span class="label label-info">Accepted</span>
                                    </label>
                                </div>
                                <div class="radio">
                                    <label>
                                        <input type="radio" name="status" value="completed" ng-model="currentStatus">
                                        <span class="label label-success">Completed</span>
                                    </label>
                                </div>
                                <div class="radio">
                                    <label>
                                        <input type="radio" name="status" value="declined" ng-model="currentStatus">
                                        <span class="label label-danger">Declined</span>
                                    </label>
                                </div>

                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            <button type="button" class="btn btn-primary" ng-click="changeCurrentStatus()">Save changes</button>
                        </div>
                    </div>
                </div>
            </div>
            <!-- //end modal -->

            <div class="row" style="margin-bottom: 20px">
                <div class="col-md-12">
                    <button class="btn btn-small btn-default" ng-click="getOrderList()">
                        <span class="glyphicon glyphicon-refresh"></span>
                        Reload Order Lists
                    </button>
                </div>
            </div>


            <div class="row">
                <div class="col-md-12">

                    <table class="table table-striped table-bordered table-hover" id="orderData" ng-init="getOrderList()">
                        <thead>
                            <tr>
                                <th style="width: 5%"   > Order Id       </th>
                                <th style="width: 45%"  > Order Info     </th>
                                <th style="width: 12.5%"> Chef Status    </th>
                                <th style="width: 12.5%"> Client Status  </th>
                                <th style="width: 12.5%"> Courier Status </th>
                                <th style="width: 12.5%"> Order Status   </th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr ng-repeat="order in orderList">
                                <td>{{order.id}}</td>

                                <td>
                                    <dl class="dl-horizontal">
                                        <dt>Phone Number</dt>
                                        <dd>{{order.phoneNumber}}</dd>
                                        <dt>Location</dt>
                                        <dd>{{order.location}}</dd>
                                        <dt>Chef Location</dt>
                                        <dd>{{order.chefLocation}}</dd>
                                        <dt>Order Time</dt>
                                        <dd>{{order.orderTime}}</dd>
                                        <dt>Total Price</dt>
                                        <dd>{{order.totalPrice}}</dd>
                                        <dt>Chef Price</dt>
                                        <dd>{{order.chefPrice}}</dd>
                                        <dt>Chef Phone Number</dt>
                                        <dd>{{order.chefPhoneNumber}}</dd>
                                    </dl>
                                </td>
                                <td ng-class="statusColor(order, 'chefStatus')">
                                    <div style="float: left">
                                        {{order.chefStatus}}
                                    </div>
                                    <div style="float: right">
                                        <span ng-click="changeStatus(order, 'chefStatus')" class="glyphicon glyphicon-pencil"></span>
                                    </div>
                                </td>
                                <td ng-class="statusColor(order, 'clientStatus')">
                                    <div style="float: left">
                                        {{order.clientStatus}}
                                    </div>
                                    <div style="float: right">
                                        <span ng-click="changeStatus(order, 'clientStatus')" class="glyphicon glyphicon-pencil"></span>
                                    </div>
                                </td>
                                <td ng-class="statusColor(order, 'courierStatus')">
                                    <div style="float: left">
                                        {{order.courierStatus}}
                                    </div>
                                    <div style="float: right">
                                        <span ng-click="changeStatus(order, 'courierStatus')" class="glyphicon glyphicon-pencil"></span>
                                    </div>
                                </td>
                                <td ng-class="statusColor(order, 'orderStatus')">
                                    <div style="float: left">
                                        {{order.orderStatus}}
                                    </div>
                                    <div style="float: right">
                                        <span ng-click="changeStatus(order, 'orderStatus')" class="glyphicon glyphicon-pencil"></span>
                                    </div>
                                </td>
                            </tr>
                        </tbody>
                    </table>


                </div>
            </div>

        </div>
        <!-- //.section-content -->
    </div>
    <!-- //.section-inner -->
</section>
<!-- //End -->


<!-- Plugins JS -->
<script src="assets/plugins/jquery.min.js"></script>
<script src="assets/plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="assets/plugins/detectmobilebrowser/detectmobilebrowser.js"></script>
<script src="assets/plugins/smartresize/smartresize.js"></script>
<script src="assets/plugins/jquery-easing/jquery.easing.min.js"></script>
<script src="assets/plugins/jquery-vide/jquery.vide.js"></script>
<script src="assets/plugins/jquery-sticky/jquery.sticky.js"></script>
<script src="assets/plugins/jquery-inview/jquery.inview.min.js"></script>
<script src="assets/plugins/jquery-countTo/jquery.countTo.js"></script>
<script src="assets/plugins/jquery-easypiechart/jquery.easypiechart.min.js"></script>
<script src="assets/plugins/jquery-countdown/jquery.countdown.min.js"></script>
<script src="assets/plugins/owl-carousel/owl.carousel.min.js"></script>
<script src="assets/plugins/isotope/isotope.pkgd.min.js"></script>
<script src="assets/plugins/jquery-magnificPopup/jquery.magnific-popup.min.js"></script>
<script src="assets/plugins/jquery-validation/jquery.validate.min.js"></script>
<!-- Main JS -->
<script src="assets/js/main.js"></script>

<!-- Animation JS (Optional) -->
<script src="assets/js/animation.js"></script>

<!-- Component JS -->
<script src="assets/js/component/bar-chart.js"></script>
<script src="assets/js/component/countdown.js"></script>
<script src="assets/js/component/counters.js"></script>
<script src="assets/js/component/pie-chart.js"></script>
<script src="assets/js/component/portfolio.js"></script>
<script src="assets/js/component/animation.js"></script>


<%@include file="/WEB-INF/widgets/scripts.jsp" %></body>

<script src="/resources/js/ng/controllers/adminController.js"></script>


</html>