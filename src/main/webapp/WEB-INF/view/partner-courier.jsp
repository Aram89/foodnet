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


<!-- Begin Why Us Section -->
<section id="why-us" class="section">
  <div class="section-inner">
    <div class="container section-content">
      <div class="row">
        <div class="col-md-12">
          <div class="section-title text-center">
            <h2 class="main-title">Ինչու՞ դառնալ խոհարար</h2>

            <span class="section-line"></span>
          </div>
          <!-- //.section-title -->
        </div>
        <!-- //.col-md-12 -->
      </div>
      <!-- //.row -->

      <!-- Begin Content Boxes -->
      <div class="row">

        <div class="col-sm-7">
          <div class="row">
            <div class="col-sm-12">
              <div class="content-boxes style-two top-column clearfix">
                <span class="content-boxes-icon">
                    <i class="fa fa-clock-o"></i>
                </span>

                <div class="content-boxes-text">
                  <h4>Ազատ գրաֆիկ</h4>

                  <p>
                    Խոհարարն ինքն է որոշում իր աշխատանքային ժամերը և պատվերներ է ընդունում միայն այդ ժամերին։
                  </p>
                </div>
                <!-- //.content-boxes-text -->
              </div>
              <!-- //.content-boxes -->
            </div>
            <!-- //.col-sm-4 col-md-4 -->

            <div class="col-sm-12">
              <div class="content-boxes style-two top-column clearfix">
                <span class="content-boxes-icon">
                    <i class="fa fa-usd"></i>
                </span>

                <div class="content-boxes-text">
                  <h4>Եկամտի աղբյուր</h4>

                  <p>
                    Խոհարարը գումար է վաստակում պատրաստելով ուտեստներ իր տանը
                    և ինքն է սահմանում ուտեստների գները:
                  </p>
                </div>
                <!-- //.content-boxes-text -->
              </div>
              <!-- //.content-boxes -->
            </div>
            <!-- //.col-sm-4 col-md-4 -->

            <div class="col-sm-12">
              <div class="content-boxes style-two top-column clearfix">
                <span class="content-boxes-icon">
                    <i class="fa fa-star"></i>
                </span>

                <div class="content-boxes-text">
                  <h4>Հարմարավետություն</h4>

                  <p>
                    Խոհարարը կարող է պատվերներ ընդունել մեր տրամադրած հեռախոսային հավելվածի
                    կամ sms հաղորդագրությունների միջոցով։ Մեր առաքիչները կառաքեն պատվերները հենց խոհարարի տնից։
                  </p>
                </div>
                <!-- //.content-boxes-text -->
              </div>
              <!-- //.content-boxes -->
            </div>
            <!-- //.col-sm-4 col-md-4 -->
          </div>
        </div>

        <div class="col-sm-5">
          <!-- Begin Become Chef Form -->
          <div class="content-boxes style-two top-column clearfix"  ng-controller="BecomeChefController">

            <div class="section-title text-center">
              <h3 class="sub-title">Դառնալ խոհարար</h3>

              <span class="section-line"></span>
            </div>

            <div ng-hide="ok" class="regForm">
              <form class="form-horizontal" name="registerForm" ng-submit="becomeChef()" novalidate>

                <div class="form-group" ng-class="{'has-error':!registerForm.name.$valid && registerForm.name.$touched}">
                  <label for="reg_chef_name" class="col-sm-3 control-label">Անուն</label>
                  <div class="col-sm-9">
                    <input id="reg_chef_name" class="form-control" required name="name" type="text" ng-model="regChef.name"/>
                    <span class="help-block" ng-show="registerForm.name.$touched && !registerForm.name.$valid">Գրեք անունը</span>
                  </div>
                </div>

                <div class="form-group" ng-class="{'has-error':!registerForm.surname.$valid && registerForm.surname.$touched}">
                  <label for="reg_chef_surname" class="col-sm-3 control-label" required>Ազգանուն</label>
                  <div class="col-sm-9">
                    <input id="reg_chef_surname" class="form-control" required name="surname" type="text" ng-model="regChef.surName">
                    <span class="help-block has-error" ng-show="registerForm.surname.$touched && !registerForm.surname.$valid">Գրեք ազգանունը</span>
                  </div>
                </div>

                <div class="form-group" ng-class="{'has-error':!registerForm.phone.$valid && registerForm.phone.$touched}">
                  <label for="reg_chef_phone" class="col-sm-3 control-label">Հեռ.</label>
                  <div class="col-sm-9">
                    <input id="reg_chef_phone" class="form-control" required ng-remote-check="check-phone" name="phone" type="tel" ng-model="regChef.phone"/>
                    <span class="help-block has-error" ng-show="registerForm.phone.$touched && registerForm.phone.$error.required">Գրեք Հեռ.-ը</span>
                    <span class="help-block has-error" ng-show="regChef.phone.length && registerForm.phone.$touched && registerForm.phone.$error.remote">Հեռը կա</span>
                  </div>
                </div>

                <div style="text-align: right">
                  <button ng-disabled="registerForm.$invalid" class="btn btn-rj"> Դիմել </button>
                </div>
              </form>
            </div>
            <div ng-show="ok==1">
              <span>Շնոհակալություն</span>
            </div>
            <div ng-show="ok===0">
              <span>Ներողություն</span>
            </div>

          </div>
          <!-- //End Become Chef Form -->
        </div>

      </div>
      <!-- //.row -->


    </div>
    <!-- //.section-content -->
  </div>
  <!-- //.section-inner -->
</section>
<!-- //End Why Us Section -->


<!-- Begin Footer -->
<%@include file="../../resources/site/footer.jsp" %>
<!-- //End Footer -->


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

<!-- Map JS -->
<script src="https://maps.googleapis.com/maps/api/js"></script>
<script src="assets/js/component/map.js"></script>

<%@include file="/WEB-INF/widgets/scripts.jsp" %></body>

</html>