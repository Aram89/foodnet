<%--
  Created by IntelliJ IDEA.
  User: pr
  Date: 01/12/2016
  Time: 11:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<base href="resources/site/">
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
<head>
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
    <div class="text-right" style="position:absolute; top:15px;right:45px">
      <button type="button" class="btn btn-sm btn-rj" ng-click="becomeChef()">
        Դառանալ խոհարար
      </button>
    </div>
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
  <div class="page-scroll">
    <a href="#dishes" class='icon-scroll'></a>
  </div>
  <!-- //.intro-body -->
</section>
<!-- //End Intro Section -->

<!-- Begin Navbar -->
<div ng-controller="DishesController">
<nav id="navigation" class="navbar navbar-inverse navbar-fixed-top" role="navigation">
  <div class="container">
    <div class="navbar-header page-scroll">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-rj-collapse">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
    </div>

    <div class="navbar-collapse collapse navbar-rj-collapse">
      <ul class="nav navbar-nav">
        <li class="page-scroll">
          <a href="#dishes">Ուտեստներ</a>
        </li>
        <li class="page-scroll">
          <a href="#chefs">Խոհարարներ</a>
        </li>

        <li class="page-scroll">
          <a href="#why-us">Ի՞նչու օգտվել</a>
        </li>

        <li class="page-scroll">
          <a href="#how-works">Պատրաստման տեվողությունը</a>
        </li>

        <li class="page-scroll">
          <a href="#contact-us">Կապ</a>
        </li>
      </ul>
      <ul class="nav navbar-nav navbar-right xs-left-menu">
        <li class="page-scroll">
          <a href="#"><order-box order="order"></order-box></a>
        </li>
      </ul>

    </div>
    <!-- //.navbar-collapse -->
  </div>
  <!-- //.container -->
</nav>
<!-- //End Navbar -->

<!-- Begin Dishes Section -->
<div>
  <div id="dishes" class="section">
    <div class="section-inner">

      <div class="container section-content">
        <div class="row">
          <div class="col-md-12">
            <div class="section-title text-center">
              <h2 class="main-title">Ուտեստներ</h2>

              <h3 class="sub-title" ng-click="someReq()">Ուտեստները պատրաստվում են միայն թարմ սննդամթերքից</h3>

              <span class="section-line"></span>
            </div>
            <!-- //.section-title -->
          </div>
          <!-- //.col-md-12 -->
        </div>
        <!-- //.row -->

        <div class="row">
          <div class="col-md-12">
            <div class="filter-portfolio">
              <ul class="list-unstyled">
                <li ng-repeat="category in categories">
                  <button type="button" class="btn btn-rj" ng-click="selectCategory($index)">{{category.title}}</button>
                </li>
              </ul>
              <div>
                <label for="filterByChef">Filter by chefs</label>
                <input id="filterByChef" type="checkbox" ng-model="filterByChef"/>
              </div>
            </div>
            <!-- //.filter-portfolio -->
          </div>
          <!-- //.col-md-12 -->
        </div>
        <!-- //.row -->

        <div class="row">
          <div class="col-md-12">
            <div class="row">
              <div class="col-sm-4" ng-repeat="dish in dishes |filter:categoryFilter">
                <offer-box options="dish" add-to-order="addToOrder"></offer-box>
              </div>
            </div>
          </div>
          <!-- //.popup-portfolio -->
        </div>
        <!-- //.col-md-12 -->
      </div>
      <!-- //.row -->
    </div>
    <div ng-click="loadDishes(category)" class="more"> <a href="">Ավելին</a></div>
    <!-- //.section-content -->
  </div>
  <!-- //.section-inner -->


  <!-- //End Dishes Section -->

  <!-- Begin Chefs Section -->

  <div id="chefs" class="section">
    <div class="section-inner">
      <div class="container section-content">
        <div class="row">
          <div class="col-md-12">
            <div class="section-title text-center">
              <h3 class="main-title">Խոհարարներ</h3>

              <h4 class="sub-title">Նրանք աշխատում են իրենց տանը</h4>

              <span class="section-line"></span>
            </div>
            <!-- //.section-title -->
          </div>
          <!-- //.col-md-12 -->
        </div>
        <!-- //.row -->

        <div class="row">
          <div ng-repeat="chef in chefs" class="col-sm-6 col-md-3 team-item not-right-column top-column">
            <div class="img-rounded team-element">
              <div class="team-inner">
                <div class="team-detail">
                  <div class="team-content">
                    <h4>{{chef.name}} {{chef.surName}}</h4>
                  </div>
                  <!-- //.team-content -->
                </div>
                <!-- //.team-detail -->
              </div>
              <!-- //.team-inner -->
              <div ng-class="{'selected-chef':chef.chefId==selectedCehfId}" class="chef-picture" ng-click="selectChef(chef.chefId)">
                <img src="assets/img/{{chef.files[0].path}}" alt="" class="img-responsive img-rounded"/>
              </div>
            </div>
            <!-- //.team-element -->
          </div>
        </div>
        <!-- //.row -->
      </div>
      <!-- //.section-content -->
    </div>

  </div>
</div>
</div>
<!-- //End Dishes Section -->


<!-- Begin Fun Fact Section -->
<section id="fun-fact" class="section section-bgimage-yes">
  <div class="section-inner">
    <div class="section-overlay"></div>

    <div class="container section-content">
      <div class="row">
        <div class="col-md-12">
          <div class="section-title text-center">
            <h2 class="main-title">Փաստեր</h2>

            <!--h3 class="sub-title">Some Of The Cool Facts About Us That Will Blow Your Mind</h3-->

            <span class="section-line"></span>
          </div>
          <!-- //.section-title -->
        </div>
        <!-- //.col-md-12 -->
      </div>
      <!-- //.row -->

      <div class="row">
        <div class="col-xs-6 col-sm-6 col-md-4 text-center">
          <div class="counter-item not-right-column top-column">
            <i class="flaticon-icon-dish"></i>

            <div class="inner-content">
                                <span class="number" data-from="51" data-to="142" data-refresh-interval="10">
                                    142
                                </span>
            </div>
            <!-- //.inner-content -->

            <p>Ուտեստ</p>
          </div>
          <!-- //.counter-item -->
        </div>
        <!-- //.col-xs-6 col-sm-6 col-md-3 -->

        <div class="col-xs-6 col-sm-6 col-md-4 text-center">
          <div class="counter-item not-right-column top-column">
            <i class="flaticon-icon-order"></i>

            <div class="inner-content">
                                <span class="number" data-from="650" data-to="747" data-refresh-interval="10">
                                    747
                                </span>
            </div>
            <!-- //.inner-content -->

            <p>Պատվեր</p>
          </div>
          <!-- //.counter-item -->
        </div>
        <!-- //.col-xs-6 col-sm-6 col-md-3 -->

        <div class="col-xs-6 col-sm-6 col-md-4 text-center">
          <div class="counter-item not-right-column">
            <i class="fa flaticon-chef"></i>

            <div class="inner-content">
                                <span class="number" data-from="1" data-to="27" data-refresh-interval="10">
                                    27
                                </span>
            </div>
            <!-- //.inner-content -->

            <p>Խոհարար</p>
          </div>
          <!-- //.counter-item -->
        </div>
        <!-- //.col-xs-6 col-sm-6 col-md-3 -->


        <!-- //.col-xs-6 col-sm-6 col-md-3 -->
      </div>
      <!-- //.row -->
    </div>
    <!-- //.section-content -->
  </div>
  <!-- //.section-inner -->
</section>
<!-- //End Fun Fact Section -->

<!-- Begin Why-us Section -->
<section id="why-us" class="section">
  <div class="section-inner">
    <div class="container section-content">
      <div class="row">
        <div class="col-md-12">
          <div class="section-title text-center">
            <h3 class="main-title">Ի՞նչու օգտվել</h3>

            <h4 class="sub-title">Մենք առաջարկում ենք նոր մոտեցում սննդի ոլորտում</h4>

            <span class="section-line"></span>
          </div>
          <!-- //.section-title -->
        </div>
        <!-- //.col-md-12 -->
      </div>
      <!-- //.row -->

      <div class="row">
        <div class="col-sm-4 col-md-4">
          <div class="funny-boxes float-shadow not-right-column text-center">
                            <div class="funny-boxes-icon">
                                <i class="flaticon-fruits"></i>
                            </div>

            <div class="funny-boxes-text">
              <h4>Առողջ հումք</h4>

              <p>Ոտեստները պատրաստվում են թարմ ու տեղական սննդամթերքով, մաքուր պայմաններոմ</p>
            </div>
            <!-- //.funny-boxes-text -->
          </div>
          <!-- //.funny-boxes -->
        </div>
        <!-- //.col-sm-4 col-md-4 -->

        <div class="col-sm-4 col-md-4">
          <div class="funny-boxes float-shadow not-right-column text-center">
                            <div class="funny-boxes-icon">
                                <i class="flaticon-tasty"></i>
                            </div>

            <div class="funny-boxes-text">
              <h4>ՀԱՄԵՂ</h4>

              <p>Խոհարարները պատրաստում են այնպես ինչպես իրենց ընտանիքի համար</p>
            </div>
            <!-- //.funny-boxes-text -->
          </div>
          <!-- //.funny-boxes -->
        </div>
        <!-- //.col-sm-4 col-md-4 -->

        <div class="col-sm-4 col-md-4">
          <div class="funny-boxes float-shadow text-center">
                            <div class="funny-boxes-icon">
                                <i class="fa flaticon-icon-chef-hat"></i>
                            </div>

            <div class="funny-boxes-text">
              <h4>Անմիջապես խոհարարից</h4>

              <p>Յուրաքանչյուր ոք,դառնալով խոհարար, գումար է վաստակում իր աշխատանքի շնորհիվ</p>
            </div>
            <!-- //.funny-boxes-text -->
          </div>
          <!-- //.funny-boxes -->
        </div>
        <!-- //.col-sm-4 col-md-4 -->
      </div>
      <!-- //.row -->
    </div>
    <!-- //.section-content -->
  </div>
  <!-- //.section-inner -->
</section>
<!-- //End Our Services Section -->


<!-- Begin how-works Section -->
<section id="how-works" class="section">
  <div class="section-inner">
    <div class="container section-content">
      <div class="row">
        <div class="col-md-12">
          <div class="section-title text-center">
            <h2 class="main-title">Պատրաստման տեվողությունը</h2>
            <span class="section-line"></span>
          </div>
          <!-- //.section-title -->
        </div>
        <!-- //.col-md-12 -->
      </div>
      <!-- //.row -->

      <div class="row">
        <div class="col-md-12">

          <!-- Begin Timeline -->
          <ul class="timeline">
            <li>
              <div class="timeline-badge">
                <i class="fa fa-dot-circle-o"></i>
              </div>
              <!-- //.timeline-badge -->

              <div class="timeline-panel">
                <div class="timeline-heading">
                  <h4 class="timeline-title">Մինչեւ 1 ժամ</h4>

                  <img src="assets/img/timeline-image-1.jpg" alt="" class="img-responsive">
                </div>
                <!-- //.timeline-heading -->

                <div class="timeline-body"><p>Աղցանները,խավարտները,լանչերը հիմնականում պատարստվում են  1 ժամվա ընթացքում</p>
                </div>
                <!-- //.timeline-body -->
              </div>
              <!-- //.timeline-panel -->
            </li>

            <li class="timeline-inverted">
              <div class="timeline-badge">
                <i class="fa fa-dot-circle-o"></i>
              </div>
              <!-- //.timeline-badge -->

              <div class="timeline-panel">
                <div class="timeline-heading">
                  <h4 class="timeline-title">4-5 ժամ</h4>

                  <img src="assets/img/timeline-image-2.jpg" alt="" class="img-responsive">
                </div>
                <!-- //.timeline-heading -->

                <div class="timeline-body">
                  <p>Այնպիսի ուտեստները,ինչպիսիք են տոլման,քյուֆթան պատրաստ կլինեն 4-5 ժամից</p>
                </div>
                <!-- //.timeline-body -->
              </div>
              <!-- //.timeline-panel -->
            </li>

            <li>
              <div class="timeline-badge">
                <i class="fa fa-dot-circle-o"></i>
              </div>
              <!-- //.timeline-badge -->

              <div class="timeline-panel">
                <div class="timeline-heading">
                  <h4 class="timeline-title">1 օր</h4>

                  <img src="assets/img/timeline-image-3.jpg" alt="" class="img-responsive">
                </div>
                <!-- //.timeline-heading -->

                <div class="timeline-body">
                  <p>Թխվածքներն ու  անուշեղենները պատվիրեք 1 օր առաջ</p>
                </div>
                <!-- //.timeline-body -->
              </div>
              <!-- //.timeline-panel -->
            </li>

            <li class="timeline-inverted">
              <div class="timeline-badge">
                <i class="fa fa-dot-circle-o"></i>
              </div>
              <!-- //.timeline-badge -->

              <div class="timeline-panel">
                <div class="timeline-heading">
                  <h4 class="timeline-title">1-2 օր</h4>

                  <img src="assets/img/timeline-image-4.jpg" alt="" class="img-responsive">
                </div>
                <!-- //.timeline-heading -->

                <div class="timeline-body">
                  <p>Խոհարարները կպատրաստեն ձեր միջոցառումնների ուտեստները 1-2 օրվա ընթացքում</p>
                </div>
                <!-- //.timeline-body -->
              </div>
              <!-- //.timeline-panel -->
            </li>
          </ul>
          <!-- //End Timeline -->
        </div>
        <!-- //.col-md-12 -->
      </div>
      <!-- //.row -->
    </div>
    <!-- //.section-content -->
  </div>
  <!-- //.section-inner -->
</section>
<!-- //End Our History Section -->

<!-- Begin Testimonials Section -->
<%--<section id="testimonials" class="section section-bgimage-yes">
  <div class="section-inner">
    <div class="section-overlay"></div>

    <div class="container section-content">
      <div class="row">
        <div class="col-md-12">
          <div class="section-title text-center">
            <h2 class="main-title">Կարծիքներ</h2>

            <h3 class="sub-title">We Make Our Customers Happy</h3>

            <span class="section-line"></span>
          </div>
          <!-- //.section-title -->
        </div>
        <!-- //.col-md-12 -->
      </div>
      <!-- //.row -->

      <div class="row">
        <div class="col-md-4">
          <div class="testimonial-item not-right-column not-bottom-column">
            <div class="testimonial-content">
              <p class="testimonial-title">Lorem Ipsum Title</p>

              <blockquote>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation.</p>
              </blockquote>
            </div>
            <!-- //.testimonial-content -->

            <div class="testimonial-info clearfix">
              <img width="100" src="assets/img/testimonial-image-1.jpg" alt="" class="img-circle img-thumbnail"/>

              <p class="testimonial-author">
                @Jane Doe, Jakarta
                <br>
                <em>Co-Founder at Cisco</em>
              </p>
            </div>
            <!-- //.testimonial-info -->
          </div>
          <!-- //.testimonial-item -->
        </div>
        <!-- //.col-md-4 -->

        <div class="col-md-4">
          <div class="testimonial-item not-right-column not-bottom-column">
            <div class="testimonial-content">
              <p class="testimonial-title">Lorem Ipsum Title</p>

              <blockquote>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation.</p>
              </blockquote>
            </div>
            <!-- //.testimonial-content -->

            <div class="testimonial-info clearfix">
              <img width="100" src="assets/img/testimonial-image-2.jpg" alt="" class="img-circle img-thumbnail"/>

              <p class="testimonial-author">
                @John Doe, Jakarta
                <br>
                <em>Creative Director at Apple</em>
              </p>
            </div>
            <!-- //.testimonial-info -->
          </div>
          <!-- //.testimonial-item -->
        </div>
        <!-- //.col-md-4 -->

        <div class="col-md-4">
          <div class="testimonial-item not-bottom-column">
            <div class="testimonial-content">
              <p class="testimonial-title">Lorem Ipsum Title</p>

              <blockquote>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation.</p>
              </blockquote>
            </div>
            <!-- //.testimonial-content -->

            <div class="testimonial-info clearfix">
              <img width="100" src="assets/img/testimonial-image-3.jpg" alt="" class="img-circle img-thumbnail"/>

              <p class="testimonial-author">
                @John Doe, Jakarta
                <br>
                <em>Managet at Microsoft</em>
              </p>
            </div>
            <!-- //.testimonial-info -->
          </div>
          <!-- //.testimonial-item -->
        </div>
        <!-- //.col-md-4 -->
      </div>
      <!-- //.row -->

      <div class="row">
        <div class="col-md-4">
          <div class="testimonial-item not-right-column">
            <div class="testimonial-content">
              <p class="testimonial-title">Lorem Ipsum Title</p>

              <blockquote>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation.</p>
              </blockquote>
            </div>
            <!-- //.testimonial-content -->

            <div class="testimonial-info clearfix">
              <img width="100" src="assets/img/testimonial-image-4.jpg" alt="" class="img-circle img-thumbnail"/>

              <p class="testimonial-author">
                @John Doe, Jakarta
                <br>
                <em>Co-Founder at Cisco</em>
              </p>
            </div>
            <!-- //.testimonial-info -->
          </div>
          <!-- //.testimonial-item -->
        </div>
        <!-- //.col-md-4 -->

        <div class="col-md-4">
          <div class="testimonial-item not-right-column">
            <div class="testimonial-content">
              <p class="testimonial-title">Lorem Ipsum Title</p>

              <blockquote>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation.</p>
              </blockquote>
            </div>
            <!-- //.testimonial-content -->

            <div class="testimonial-info clearfix">
              <img width="100" src="assets/img/testimonial-image-5.jpg" alt="" class="img-circle img-thumbnail"/>

              <p class="testimonial-author">
                @Jane Doe, Jakarta
                <br>
                <em>Creative Director at Apple</em>
              </p>
            </div>
            <!-- //.testimonial-info -->
          </div>
          <!-- //.testimonial-item -->
        </div>
        <!-- //.col-md-4 -->

        <div class="col-md-4">
          <div class="testimonial-item">
            <div class="testimonial-content">
              <p class="testimonial-title">Lorem Ipsum Title</p>

              <blockquote>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation.</p>
              </blockquote>
            </div>
            <!-- //.testimonial-content -->

            <div class="testimonial-info clearfix">
              <img width="100" src="assets/img/testimonial-image-6.jpg" alt="" class="img-circle img-thumbnail"/>

              <p class="testimonial-author">
                @Jane Doe, Jakarta
                <br>
                <em>Managet at Microsoft</em>
              </p>
            </div>
            <!-- //.testimonial-info -->
          </div>
          <!-- //.testimonial-item -->
        </div>
        <!-- //.col-md-4 -->
      </div>
      <!-- //.row -->
    </div>
    <!-- //.section-container -->
  </div>
  <!-- //.section-inner -->
</section>--%>
<!-- //End Testimonials Section -->

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
                <a href=""><i class="fa fa-facebook"></i></a>
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


<%--<!-- Begin Map -->--%>
<%--<div id="map">--%>
  <%--<div id="cd-google-map">--%>
    <%--<div id="google-container"></div>--%>
  <%--</div>--%>
  <%--<!-- //.cd-google-map -->--%>
<%--</div>--%>
<%--<!-- //End Map -->--%>


<!-- Begin Footer -->
<footer class="footer">

  <!-- Begin Footer Section -->
  <section id="footer">
    <div class="container">
      <div class="row">
        <div class="col-sm-6 col-md-6 footer-column not-right-column">
          <div class="footer-text">
            <h4>Եղեք կապի մեջ</h4>

            <p>Մեր թիմի  համար  կարեւոր է ցանկացած կարծիք: Օգնեեք համակարգը դարձնելավելի լավը:</p>

            <ul class="icon-list list-unstyled">
              <li>
                <i class="fa fa-phone"></i> +622176811
              </li>

              <li>
                <i class="fa fa-envelope-o"></i> support@narinj.am
              </li>
            </ul>

            <ul class="social-icon-list list-unstyled list-inline">
              <li>
                <a href="#"><i class="fa fa-facebook"></i></a>
              </li>

              <li>
                <a href="#"><i class="fa fa-twitter"></i></a>
              </li>

              <li>
                <a href="#"><i class="fa fa-youtube"></i></a>
              </li>
              <li class="hidden-xs">
                <a href="#"><i class="fa fa-instagram"></i></a>
              </li>
            </ul>
          </div>
          <!-- //.footer-text -->
        </div>
        <!-- //.footer-column -->

        <div class="col-sm-6 col-md-6 footer-column not-right-column">
          <div class="footer-text">
            <h4>About Us</h4>

            <p>Gunung Rinjani adalah gunung yang berlokasi di Pulau Lombok, Nusa Tenggara Barat. Gunung ini merupakan gunung favorit bagi pendaki Indonesia karena keindahan pemandangannya. Gunung ini merupakan bagian dari Taman Nasional Gunung Rinjani yang memiliki luas sekitar 41.330 ha dan ini akan diusulkan penambahannya sehingga menjadi 76.000 ha ke arah barat dan timur. Secara administratif gunung ini berada dalam wilayah tiga kabupaten: Lombok Timur, Lombok Tengah dan Lombok Barat.</p>
          </div>
          <!-- //.footer-text -->
        </div>
        <!-- //.footer-column -->

        <%--<div class="col-sm-4 col-md-4 footer-column">
          <div class="footer-text">
            <h4>Newsletter</h4>

            <p>Keep yourself up to date!</p>

            <form role="form" class="newsletter-form">
              <div class="form-group">
                <label for="email_address">Email Address*</label>
                <input type="email" id="email_address" class="form-control">
              </div>

              <div class="form-group">
                <label for="first_name">First Name</label>
                <input type="text" id="first_name" class="form-control">
              </div>

              <button type="submit" class="btn btn-rj">Subscribe</button>
            </form>
          </div>
          <!-- //.footer-text -->
        </div>--%>
        <!-- //.footer-column -->
      </div>
      <!-- //.row -->
    </div>
    <!-- //.container -->
  </section>
  <!-- //End Footer Section -->

  <!-- Begin Copyright -->
  <div id="copyright">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <p> Copyright &copy; 2016  <a href="">www.narinj.am</a></p>
        </div>
        <!-- //.col-md-12 -->
      </div>
      <!-- //.row -->
    </div>
    <!-- //.container -->
  </div>
  <!-- //End Copyright -->
</footer>
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