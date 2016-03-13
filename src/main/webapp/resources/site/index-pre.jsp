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


  <!-- Begin Intro Section -->
  <section id="intro">
    <div class="intro-body text-center">

      <div class="container">
        <div class="row">
          <div class="col-md-12 intro-content">
            <div class="logo">
              <h1>N</h1>
            </div>
          <!-- //.logo -->
            <div class="intro-text text-center">
              <h2>Նոր մոտեցում սննդի ոլորտում</h2>
              <p class="lead">Համեղ ուտեստներ անմիջապես խոհարարից</p>

              <div class="row" style="margin: 0 32%;">
                <div class="col-sm-6 text-center">
                  <a type="button" class="btn btn-sm btn-rj" href="/partner-chef" target="_blank">
                    Դառանալ խոհարար
                  </a>
                </div>
                <div class="col-sm-6 text-center">
                  <a type="button" class="btn btn-sm btn-rj" href="/partner-courier" target="_blank">
                    Դառանալ առաքիչ
                  </a>
                </div>
              </div>

            </div>
          <!-- //.intro-text -->
          <!-- //.page-scroll -->
          </div>
        <!-- //.intro-content -->
      </div>
      <!-- //.row -->
    </div>
    <!-- //.container -->
  </div>

  <!-- //.intro-body -->
</section>
<!-- //End Intro Section -->



<!-- Begin Contact Us Section -->
<section id="contact-us" class="section section-bgimage-yes">
  <div class="section-inner">
    <div class="section-overlay"></div>

    <div class="container section-content">
      <div class="row">
        <div class="col-md-12">
          <div class="section-title text-center">
            <h3 class="main-title">Կապ</h3>

            <h4 class="sub-title">Կիսվեք Ձեր կարծիքներով,առաջարկներով</h4>

            <span class="section-line"></span>
          </div>
          <!-- //.section-title -->
        </div>
        <!-- //.col-md-12 -->
      </div>
      <!-- //.row -->

      <div class="row">
        <div class="col-md-12">
          <div class="form-respond text-center"></div>
        </div>
        <!-- //.col-md-12 -->
      </div>
      <!-- //.row -->

      <div class="row">
        <form action="contact/send_mail.php" method="post" name="contact-us-form" id="contact-us-form" class="element-line validate contact-us-form" role="form">
          <div class="col-md-5 col-md-offset-1">
            <div class="form-group">
              <label for="name">Name*</label>

              <div class="input-group input-group-lg">
                <input type="text" name="name" id="name" class="form-control required" placeholder="Enter name">
              </div>
              <!-- //.input-group -->
            </div>
            <!-- //.form-group -->

            <div class="form-group">
              <label for="email">Email*</label>

              <div class="input-group input-group-lg">
                <input type="email" name="email" id="email" class="form-control required email" placeholder="Enter email">
              </div>
              <!-- //.input-group -->
            </div>
            <!-- //.form-group -->

            <div class="form-group form-group-bottom">
              <label for="subject">Subject*</label>

              <div class="input-group input-group-lg">
                <input type="text" name="subject" id="subject" class="form-control required" placeholder="Enter subject">
              </div>
              <!-- //.input-group -->
            </div>
            <!-- //.form-group -->
          </div>
          <!-- //.col-md-5 col-md-offset-1 -->

          <div class="col-md-5">
            <div class="form-group">
              <label for="message">Message*</label>

              <div class="input-group input-group-lg">
                <textarea name="message" id="message" class="form-control required"></textarea>
              </div>
              <!-- //.input-group -->
            </div>
            <!-- //.form-group -->

            <div class="form-group form-group-bottom">
              <button id="submit" type="submit" class="btn btn-lg btn-rj">
                Ուղարկեել
              </button>
            </div>
            <!-- //.form-group -->
          </div>
          <!-- //.col-md-5 -->
        </form>
      </div>
      <!-- //.row -->

      <div class="row">
        <div class="col-md-10 col-md-offset-1">
          <div class="social-icon-text text-center">
            <h2>ԿԱՄ</h2>

            <h4>Գտեք սոցցանցերում!</h4>

            <ul class="social-icon-list list-unstyled list-inline text-center">
              <li>
                <a href="https://www.facebook.com/Narinj-201737816853861"><i class="fa fa-facebook"></i></a>
              </li>

              <li>
                <a href=""><i class="fa fa-twitter"></i></a>
              </li>

              <li>
                <a href=""><i class="fa fa-youtube"></i></a>
              </li>

              <li class="hidden-xs">
                <a href="#"><i class="fa fa-instagram"></i></a>
              </li>
            </ul>
          </div>
          <!-- //.social-icon-text -->
        </div>
        <!-- //.col-md-10 col-md-offset-1 -->
      </div>
      <!-- //.row -->
    </div>
    <!-- //.section-content -->
  </div>
  <!-- //.section-inner -->
</section>
<!-- //End Contact Us Section -->


<!-- Begin Footer -->
<%@include file="./footer.jsp" %>
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