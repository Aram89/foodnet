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
  <title>Rinjani - Multi-Purpose One Page Theme</title>
  <meta name="description" content="">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

  <!-- Google Font -->
  <link href='http://fonts.googleapis.com/css?family=Raleway:400,700' rel='stylesheet' type='text/css'>
  <link href='http://fonts.googleapis.com/css?family=Lato:300,400,700' rel='stylesheet' type='text/css'>

  <!-- Bootstrap Core CSS -->
  <link href="assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">

  <!-- Plugins CSS -->
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
  <!--<link href="assets/css/colors/blue.css" rel="stylesheet" type="text/css">-->
  <!--<link href="assets/css/component/colors/blue.css" rel="stylesheet" type="text/css">-->

  <!-- Modernizr JS for IE9 support of HTML5 elements and media queries -->
  <!--[if lt IE 9]>
  <script src="assets/plugins/modernizr.min.js"></script>
  <![endif]-->
</head>

<!-- The #page-top ID is part of the scrolling feature - the data-spy and data-target are part of the built-in Bootstrap scrollspy function -->
<body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top" data-offset="51">

<!--[if lt IE 8]>
<p class="browsehappy">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
<![endif]-->

<!-- Begin Page Loader -->
<div id="page-loader">
  <div class="preload">
    <img src="assets/img/preloader.gif" alt="Loading"/>
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
            <h1>R</h1>
          </div>
          <!-- //.logo -->

          <div class="intro-text text-center">
            <h2>Clean, Awesome and Multi-Purpose.</h2>

            <p class="lead">Responsive Multi-Purpose Theme For Running Serious Business</p>
          </div>
          <!-- //.intro-text -->

          <div class="page-scroll">
            <a href="#who-we-are" class="btn btn-lg btn-rj">Learn More</a>
          </div>
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


<!-- Begin Navbar -->
<nav id="navigation" class="navbar navbar-inverse navbar-fixed-top" role="navigation">
  <div class="container">
    <div class="navbar-header page-scroll">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-rj-collapse">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>

      <a class="navbar-brand" href="#page-top">Rinjani</a>
    </div>
    <!-- //.navbar-header -->

    <div class="navbar-collapse collapse navbar-rj-collapse">
      <ul class="nav navbar-nav navbar-right">
        <%--<li class="page-scroll">
          <a href="#who-we-are">About</a>
        </li>
--%>
<%--        <li class="page-scroll">
          <a href="#our-main-skills">Skills</a>
        </li>--%>


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
          <a href="#how-works">Ինչպե՞ս է աշխատում</a>
        </li>

        <li class="page-scroll">
          <a href="#contact-us">Կապ</a>
        </li>
      </ul>
    </div>
    <!-- //.navbar-collapse -->
  </div>
  <!-- //.container -->
</nav>
<!-- //End Navbar -->

<%--
<!-- Begin Who We Are Section -->
<section id="who-we-are" class="section">
  <div class="section-inner">
    <div class="container section-content">
      <div class="row">
        <div class="col-md-12">
          <div class="section-title text-center">
            <h2 class="main-title">Who We Are?</h2>

            <h3 class="sub-title">Some Things You Should Know About Us</h3>

            <span class="section-line"></span>
          </div>
          <!-- //.section-title -->
        </div>
        <!-- //.col-md-12 -->
      </div>
      <!-- //.row -->

      <div class="row">
        <div class="col-md-6">
          <div id="carousel-who-we-are" class="owl-carousel owl-theme">
            <div class="item">
              <img src="assets/img/who-we-are-image-1.jpg" alt="" class="img-responsive img-rounded"/>
            </div>
            <!-- //.item -->

            <div class="item">
              <img src="assets/img/who-we-are-image-2.jpg" alt="" class="img-responsive img-rounded"/>
            </div>
            <!-- //.item -->

            <div class="item">
              <img src="assets/img/who-we-are-image-3.jpg" alt="" class="img-responsive img-rounded"/>
            </div>
            <!-- //.item -->
          </div>
          <!-- //.owl-carousel -->
        </div>
        <!-- //.col-md-6 -->

        <div class="col-md-6">
          <div class="who-we-are-text">
            <h4>A Little About Our Past</h4>

            <p>Gunung Rinjani adalah gunung yang berlokasi di Pulau Lombok, Nusa Tenggara Barat. Gunung ini merupakan gunung favorit bagi pendaki Indonesia karena keindahan pemandangannya. Gunung ini merupakan bagian dari Taman Nasional Gunung Rinjani yang memiliki luas sekitar 41.330 ha dan ini akan diusulkan penambahannya sehingga menjadi 76.000 ha ke arah barat dan timur. Secara administratif gunung ini berada dalam wilayah tiga kabupaten: Lombok Timur, Lombok Tengah dan Lombok Barat. Gunung Rinjani dengan titik tertinggi 3.726 m dpl, mendominasi sebagian besar pemandangan Pulau Lombok bagian utara. Di sebelah barat kerucut Rinjani terdapat kaldera dengan luas sekitar 3.500 m x 4.800 m, memanjang kearah timur dan barat.</p>

            <div class="page-scroll">
              <a href="#" class="btn btn-lg btn-rj">Read More</a>
            </div>
            <!-- //.page-scroll -->
          </div>
          <!-- //.who-we-are-text -->
        </div>
        <!-- //.col-md-6 -->
      </div>
      <!-- //.row -->
    </div>
    <!-- //.section-content -->
  </div>
  <!-- //.section-inner -->
</section>
<!-- //End Who We Are Section -->--%>

<!-- Begin Dishes Section -->
<section id="dishes" class="section">
  <div class="section-inner">
    <div class="container section-content">
      <div class="row">
        <div class="col-md-12">
          <div class="section-title text-center">
            <h2 class="main-title">Ուտեստներ</h2>

            <h3 class="sub-title">You Can Judge Us By The Work We Have Done</h3>

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
              <li class="active">
                <a href="#" data-filter="*" class="btn btn-rj disabled">All</a>
              </li>

              <li>
                <a href="#" data-filter=".identity" class="btn btn-rj">Identity</a>
              </li>

              <li>
                <a href="#" data-filter=".logo" class="btn btn-rj">Logo</a>
              </li>

              <li>
                <a href="#" data-filter=".illustration" class="btn btn-rj">Illustration</a>
              </li>
            </ul>
          </div>
          <!-- //.filter-portfolio -->
        </div>
        <!-- //.col-md-12 -->
      </div>
      <!-- //.row -->

      <div class="row">
        <div class="col-md-12">
          <div class="popup-portfolio">
            <div class="portfolio-item grow illustration logo">
              <div class="inner-content">
                <div class="portfolio-content">
                  <div class="portfolio-detail">
                    <a href="assets/img/portfolio/portfolio-image-1.jpg" title="Project Title 1 - Lorem Ipsum">
                      <div class="portfolio-text">
                        <h4>Project Title 1</h4>

                        <p>Lorem Ipsum</p>
                      </div>
                      <!-- //.portfolio-text -->
                    </a>
                  </div>
                  <!-- //.portfolio-detail -->
                </div>
                <!-- //.portfolio-content -->

                <img src="assets/img/portfolio/portfolio-image-1.jpg" alt="" class="img-responsive"/>
              </div>
              <!-- //.inner-content -->
            </div>
            <!-- //.portfolio-item -->

            <div class="portfolio-item grow identity">
              <div class="inner-content">
                <div class="portfolio-content">
                  <div class="portfolio-detail">
                    <a href="assets/img/portfolio/portfolio-image-2.jpg" title="Project Title 2 - Lorem Ipsum">
                      <div class="portfolio-text">
                        <h4>Project Title 2</h4>

                        <p>Lorem Ipsum</p>
                      </div>
                      <!-- //.portfolio-text -->
                    </a>
                  </div>
                  <!-- //.portfolio-detail -->
                </div>
                <!-- //.portfolio-content -->

                <img src="assets/img/portfolio/portfolio-image-2.jpg" alt="" class="img-responsive"/>
              </div>
              <!-- //.inner-content -->
            </div>
            <!-- //.portfolio-item -->

            <div class="portfolio-item grow logo identity">
              <div class="inner-content">
                <div class="portfolio-content">
                  <div class="portfolio-detail">
                    <a href="assets/img/portfolio/portfolio-image-3.jpg" title="Project Title 3 - Lorem Ipsum">
                      <div class="portfolio-text">
                        <h4>Project Title 3</h4>

                        <p>Lorem Ipsum</p>
                      </div>
                      <!-- //.portfolio-text -->
                    </a>
                  </div>
                  <!-- //.portfolio-detail -->
                </div>
                <!-- //.portfolio-content -->

                <img src="assets/img/portfolio/portfolio-image-3.jpg" alt="" class="img-responsive"/>
              </div>
              <!-- //.inner-content -->
            </div>
            <!-- //.portfolio-item -->

            <div class="portfolio-item grow logo">
              <div class="inner-content">
                <div class="portfolio-content">
                  <div class="portfolio-detail">
                    <a href="assets/img/portfolio/portfolio-image-4.jpg" title="Project Title 4 - Lorem Ipsum">
                      <div class="portfolio-text">
                        <h4>Project Title 4</h4>

                        <p>Lorem Ipsum</p>
                      </div>
                      <!-- //.portfolio-text -->
                    </a>
                  </div>
                  <!-- //.portfolio-detail -->
                </div>
                <!-- //.portfolio-content -->

                <img src="assets/img/portfolio/portfolio-image-4.jpg" alt="" class="img-responsive"/>
              </div>
              <!-- //.inner-content -->
            </div>
            <!-- //.portfolio-item -->

            <div class="portfolio-item grow logo illustration">
              <div class="inner-content">
                <div class="portfolio-content">
                  <div class="portfolio-detail">
                    <a href="assets/img/portfolio/portfolio-image-5.jpg" title="Project Title 5 - Lorem Ipsum">
                      <div class="portfolio-text">
                        <h4>Project Title 5</h4>

                        <p>Lorem Ipsum</p>
                      </div>
                      <!-- //.portfolio-text -->
                    </a>
                  </div>
                  <!-- //.portfolio-detail -->
                </div>
                <!-- //.portfolio-content -->

                <img src="assets/img/portfolio/portfolio-image-5.jpg" alt="" class="img-responsive"/>
              </div>
              <!-- //.inner-content -->
            </div>
            <!-- //.portfolio-item -->

            <div class="portfolio-item grow identity">
              <div class="inner-content">
                <div class="portfolio-content">
                  <div class="portfolio-detail">
                    <a href="assets/img/portfolio/portfolio-image-6.jpg" title="Project Title 6 - Lorem Ipsum">
                      <div class="portfolio-text">
                        <h4>Project Title 6</h4>

                        <p>Lorem Ipsum</p>
                      </div>
                      <!-- //.portfolio-text -->
                    </a>
                  </div>
                  <!-- //.portfolio-detail -->
                </div>
                <!-- //.portfolio-content -->

                <img src="assets/img/portfolio/portfolio-image-6.jpg" alt="" class="img-responsive"/>
              </div>
              <!-- //.inner-content -->
            </div>
            <!-- //.portfolio-item -->

            <div class="portfolio-item grow logo">
              <div class="inner-content">
                <div class="portfolio-content">
                  <div class="portfolio-detail">
                    <a href="assets/img/portfolio/portfolio-image-7.jpg" title="Project Title 7 - Lorem Ipsum">
                      <div class="portfolio-text">
                        <h4>Project Title 7</h4>

                        <p>Lorem Ipsum</p>
                      </div>
                      <!-- //.portfolio-text -->
                    </a>
                  </div>
                  <!-- //.portfolio-detail -->
                </div>
                <!-- //.portfolio-content -->

                <img src="assets/img/portfolio/portfolio-image-7.jpg" alt="" class="img-responsive"/>
              </div>
              <!-- //.inner-content -->
            </div>
            <!-- //.portfolio-item -->

            <div class="portfolio-item grow illustration">
              <div class="inner-content">
                <div class="portfolio-content">
                  <div class="portfolio-detail">
                    <a href="assets/img/portfolio/portfolio-image-8.jpg" title="Project Title 8 - Lorem Ipsum">
                      <div class="portfolio-text">
                        <h4>Project Title 8</h4>

                        <p>Lorem Ipsum</p>
                      </div>
                      <!-- //.portfolio-text -->
                    </a>
                  </div>
                  <!-- //.portfolio-detail -->
                </div>
                <!-- //.portfolio-content -->

                <img src="assets/img/portfolio/portfolio-image-8.jpg" alt="" class="img-responsive"/>
              </div>
              <!-- //.inner-content -->
            </div>
            <!-- //.portfolio-item -->

            <div class="portfolio-item grow illustration">
              <div class="inner-content">
                <div class="portfolio-content">
                  <div class="portfolio-detail">
                    <a href="assets/img/portfolio/portfolio-image-9.jpg" title="Project Title 9 - Lorem Ipsum">
                      <div class="portfolio-text">
                        <h4>Project Title 9</h4>

                        <p>Lorem Ipsum</p>
                      </div>
                      <!-- //.portfolio-text -->
                    </a>
                  </div>
                  <!-- //.portfolio-detail -->
                </div>
                <!-- //.portfolio-content -->

                <img src="assets/img/portfolio/portfolio-image-9.jpg" alt="" class="img-responsive"/>
              </div>
              <!-- //.inner-content -->
            </div>
            <!-- //.portfolio-item -->
          </div>
          <!-- //.popup-portfolio -->
        </div>
        <!-- //.col-md-12 -->
      </div>
      <!-- //.row -->
    </div>
    <!-- //.section-content -->
  </div>
  <!-- //.section-inner -->
</section>
<!-- //End Dishes Section -->

<!-- Begin Chefs Section -->
<section id="chefs" class="section">
  <div class="section-inner">
    <div class="container section-content">
      <div class="row">
        <div class="col-md-12">
          <div class="section-title text-center">
            <h3 class="main-title">Խոհարարներ</h3>

            <h4 class="sub-title">We Are Here For You</h4>

            <span class="section-line"></span>
          </div>
          <!-- //.section-title -->
        </div>
        <!-- //.col-md-12 -->
      </div>
      <!-- //.row -->

      <div class="row">
        <div class="col-sm-6 col-md-3 team-item not-right-column top-column">
          <div class="img-rounded team-element">
            <div class="team-inner">
              <div class="team-detail">
                <div class="team-content">
                  <h4>Nick Carraway</h4>

                  <p>ECD / Founder</p>
                </div>
                <!-- //.team-content -->
              </div>
              <!-- //.team-detail -->
            </div>
            <!-- //.team-inner -->

            <img src="assets/img/meet-the-team-image-1.jpg" alt="" class="img-responsive img-rounded"/>
          </div>
          <!-- //.team-element -->
        </div>
        <!-- //.team-item -->

        <div class="col-sm-6 col-md-3 team-item not-right-column top-column">
          <div class="img-rounded team-element">
            <div class="team-inner">
              <div class="team-detail">
                <div class="team-content">
                  <h4>Daisy Buchanan</h4>

                  <p>CEO / Co-Founder</p>
                </div>
                <!-- //.team-content -->
              </div>
              <!-- //.team-detail -->
            </div>
            <!-- //.team-inner -->

            <img src="assets/img/meet-the-team-image-2.jpg" alt="" class="img-responsive img-rounded"/>
          </div>
          <!-- //.team-element -->
        </div>
        <!-- //.team-item -->

        <div class="col-sm-6 col-md-3 team-item not-right-column">
          <div class="img-rounded team-element">
            <div class="team-inner">
              <div class="team-detail">
                <div class="team-content">
                  <h4>Myrtle Wilson</h4>

                  <p>Creative Director</p>
                </div>
                <!-- //.team-content -->
              </div>
              <!-- //.team-detail -->
            </div>
            <!-- //.team-inner -->

            <img src="assets/img/meet-the-team-image-3.jpg" alt="" class="img-responsive img-rounded"/>
          </div>
          <!-- //.team-element -->
        </div>
        <!-- //.team-item -->

        <div class="col-sm-6 col-md-3 team-item">
          <div class="img-rounded team-element">
            <div class="team-inner">
              <div class="team-detail">
                <div class="team-content">
                  <h4>Catherine</h4>

                  <p>Public Relation</p>
                </div>
                <!-- //.team-content -->
              </div>
              <!-- //.team-detail -->
            </div>
            <!-- //.team-inner -->

            <img src="assets/img/meet-the-team-image-4.jpg" alt="" class="img-responsive img-rounded"/>
          </div>
          <!-- //.team-element -->
        </div>
        <!-- //.team-item -->
      </div>
      <!-- //.row -->
    </div>
    <!-- //.section-content -->
  </div>
  <!-- //.section-inner -->
</section>
<!-- //End Dishes Section -->


<!-- Begin Fun Fact Section -->
<section id="fun-fact" class="section section-bgimage-yes">
  <div class="section-inner">
    <div class="section-overlay"></div>

    <div class="container section-content">
      <div class="row">
        <div class="col-md-12">
          <div class="section-title text-center">
            <h2 class="main-title">Fun Facts</h2>

            <h3 class="sub-title">Some Of The Cool Facts About Us That Will Blow Your Mind</h3>

            <span class="section-line"></span>
          </div>
          <!-- //.section-title -->
        </div>
        <!-- //.col-md-12 -->
      </div>
      <!-- //.row -->

      <div class="row">
        <div class="col-xs-6 col-sm-6 col-md-3 text-center">
          <div class="counter-item not-right-column top-column">
            <i class="fa fa-thumbs-o-up"></i>

            <div class="inner-content">
                                <span class="number" data-from="2200" data-to="2780" data-refresh-interval="10">
                                    2200
                                </span>
            </div>
            <!-- //.inner-content -->

            <p>Projects</p>
          </div>
          <!-- //.counter-item -->
        </div>
        <!-- //.col-xs-6 col-sm-6 col-md-3 -->

        <div class="col-xs-6 col-sm-6 col-md-3 text-center">
          <div class="counter-item not-right-column top-column">
            <i class="fa fa-smile-o"></i>

            <div class="inner-content">
                                <span class="number" data-from="330" data-to="487" data-refresh-interval="10">
                                    330
                                </span>
            </div>
            <!-- //.inner-content -->

            <p>Clients</p>
          </div>
          <!-- //.counter-item -->
        </div>
        <!-- //.col-xs-6 col-sm-6 col-md-3 -->

        <div class="col-xs-6 col-sm-6 col-md-3 text-center">
          <div class="counter-item not-right-column">
            <i class="fa fa-coffee"></i>

            <div class="inner-content">
                                <span class="number" data-from="13300" data-to="13730" data-refresh-interval="10">
                                    13300
                                </span>
            </div>
            <!-- //.inner-content -->

            <p>Coffee</p>
          </div>
          <!-- //.counter-item -->
        </div>
        <!-- //.col-xs-6 col-sm-6 col-md-3 -->

        <div class="col-xs-6 col-sm-6 col-md-3 text-center">
          <div class="counter-item">
            <i class="fa fa-gift"></i>

            <div class="inner-content">
                                <span class="number" data-from="10" data-to="154" data-refresh-interval="10">
                                    23
                                </span>
            </div>
            <!-- //.inner-content -->

            <p>Awards</p>
          </div>
          <!-- //.counter-item -->
        </div>
        <!-- //.col-xs-6 col-sm-6 col-md-3 -->
      </div>
      <!-- //.row -->
    </div>
    <!-- //.section-content -->
  </div>
  <!-- //.section-inner -->
</section>
<!-- //End Fun Fact Section -->

<%--

<!-- Begin Why Us Section -->
<section id="why-us" class="section">
  <div class="section-inner">
    <div class="container section-content">
      <div class="row">
        <div class="col-md-12">
          <div class="section-title text-center">
            <h2 class="main-title">Why Choose Us?</h2>

            <h3 class="sub-title">6 Reasons Why We Are The Best</h3>

            <span class="section-line"></span>
          </div>
          <!-- //.section-title -->
        </div>
        <!-- //.col-md-12 -->
      </div>
      <!-- //.row -->

      <!-- Begin Content Boxes -->
      <div class="row">
        <div class="col-sm-4 col-md-4">
          <div class="content-boxes style-two top-column clearfix">
                            <span class="content-boxes-icon">
                                <i class="fa fa-rocket"></i>
                            </span>

            <div class="content-boxes-text">
              <h4>Speed</h4>

              <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
            </div>
            <!-- //.content-boxes-text -->
          </div>
          <!-- //.content-boxes -->
        </div>
        <!-- //.col-sm-4 col-md-4 -->

        <div class="col-sm-4 col-md-4">
          <div class="content-boxes style-two top-column clearfix">
                            <span class="content-boxes-icon">
                                <i class="fa fa-thumbs-o-up"></i>
                            </span>

            <div class="content-boxes-text">
              <h4>Quality</h4>

              <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
            </div>
            <!-- //.content-boxes-text -->
          </div>
          <!-- //.content-boxes -->
        </div>
        <!-- //.col-sm-4 col-md-4 -->

        <div class="col-sm-4 col-md-4">
          <div class="content-boxes style-two top-column clearfix">
                            <span class="content-boxes-icon">
                                <i class="fa fa-star-o"></i>
                            </span>

            <div class="content-boxes-text">
              <h4>Expertise</h4>

              <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
            </div>
            <!-- //.content-boxes-text -->
          </div>
          <!-- //.content-boxes -->
        </div>
        <!-- //.col-sm-4 col-md-4 -->
      </div>
      <!-- //.row -->

      <div class="row">
        <div class="col-sm-4 col-md-4">
          <div class="content-boxes style-two bottom-column not-right-column clearfix">
                            <span class="content-boxes-icon">
                                <i class="fa fa-shield"></i>
                            </span>
            <div class="content-boxes-text">
              <h4>Security</h4>

              <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
            </div>
            <!-- //.content-boxes-text -->
          </div>
          <!-- //.content-boxes -->
        </div>
        <!-- //.col-sm-4 col-md-4 -->

        <div class="col-sm-4 col-md-4">
          <div class="content-boxes style-two bottom-column not-right-column clearfix">
                            <span class="content-boxes-icon">
                                <i class="fa fa-send-o"></i>
                            </span>
            <div class="content-boxes-text">
              <h4>Reliability</h4>

              <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
            </div>
            <!-- //.content-boxes-text -->
          </div>
          <!-- //.content-boxes -->
        </div>
        <!-- //.col-sm-4 col-md-4 -->

        <div class="col-sm-4 col-md-4">
          <div class="content-boxes style-two bottom-column clearfix">
                            <span class="content-boxes-icon">
                                <i class="fa fa-support"></i>
                            </span>

            <div class="content-boxes-text">
              <h4>Price</h4>

              <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
            </div>
            <!-- //.content-boxes-text -->
          </div>
          <!-- //.content-boxes -->
        </div>
        <!-- //.col-sm-4 col-md-4 -->
      </div>
      <!-- //End Content Boxes -->
    </div>
    <!-- //.section-content -->
  </div>
  <!-- //.section-inner -->
</section>
<!-- //End Why Us Section -->
--%>


<%--
<!-- Begin Our Main Skills Section -->
<section id="our-main-skills" class="section section-bgimage-yes">
  <div class="section-inner">
    <div class="section-overlay"></div>

    <div class="container section-content">
      <div class="row">
        <div class="col-md-12">
          <div class="section-title text-center">
            <h3 class="main-title">Our Main Skills</h3>

            <h3 class="sub-title">We Have Creativity And Knowledge To Development</h3>

            <span class="section-line"></span>
          </div>
          <!-- //.section-title -->
        </div>
        <!-- //.col-md-12 -->
      </div>
      <!-- //.row -->

      <div class="row">
        <div class="col-md-5">
          <div class="bar-chart-text">
            <p class="lead">
              Gunung Rinjani merupakan gunung favorit bagi pendaki Indonesia karena keindahan pemandangannya. Gunung ini merupakan bagian dari Taman Nasional Gunung Rinjani yang memiliki luas sekitar 41.330 ha dan ini akan diusulkan penambahannya sehingga menjadi 76.000 ha ke arah barat.
            </p>

            <p>
              Secara administratif gunung ini berada dalam wilayah 3 kabupaten: Lombok Timur, Lombok Tengah dan Lombok Barat. Gunung Rinjani dengan titik tertinggi 3.726 m dpl, mendominasi sebagian besar pemandangan Pulau Lombok bagian utara.
            </p>
          </div>
          <!-- //.bar-chart-text -->
        </div>
        <!-- //.col-md-5 -->

        <div class="col-md-7">

          <!-- Begin Bar Chart -->
          <div class="bar-chart">
            <div class="bar-chart-item" data-percent="85">
              <p>User Experience</p>
            </div>
            <!-- //.bar-chart-item -->

            <div class="bar-chart-item" data-percent="75">
              <p>Web & Mobile Design</p>
            </div>
            <!-- //.bar-chart-item -->

            <div class="bar-chart-item" data-percent="100">
              <p>Graphic Design</p>
            </div>
            <!-- //.bar-chart-item -->

            <div class="bar-chart-item" data-percent="90">
              <p>Identity & Branding</p>
            </div>
            <!-- //.bar-chart-item -->

            <div class="bar-chart-item" data-percent="60">
              <p>3D Design</p>
            </div>
            <!-- //.bar-chart-item -->

            <div class="bar-chart-item" data-percent="75">
              <p>Icon & Illustrations</p>
            </div>
            <!-- //.bar-chart-item -->

            <div class="bar-chart-legend clearfix">
              <div class="legend legend-left">
                <p>Newbie</p>
              </div>
              <!-- //.legend -->

              <div class="legend legend-left">
                <p>Decent</p>
              </div>
              <!-- //.legend -->

              <div class="legend legend-right">
                <p>Pretty Good</p>
              </div>
              <!-- //.legend -->

              <div class="legend legend-right">
                <p>Super Hero</p>
              </div>
              <!-- //.legend -->
            </div>
            <!-- //.bar-chart-legend -->
          </div>
          <!-- //End Bar Chart -->
        </div>
        <!-- //.col-md-7 -->
      </div>
      <!-- //.row -->
    </div>
    <!-- //.section-content -->
  </div>
  <!-- //.section-inner -->
</section>
<!-- //End Our Main Skills Section -->
--%>


<!-- Begin Why-us Section -->
<section id="why-us" class="section">
  <div class="section-inner">
    <div class="container section-content">
      <div class="row">
        <div class="col-md-12">
          <div class="section-title text-center">
            <h3 class="main-title">Ի՞նչու օգտվել</h3>

            <h4 class="sub-title">We Are Experts In Developing Your Business</h4>

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
                            <span class="funny-boxes-icon">
                                <i class="fa fa-lightbulb-o"></i>
                            </span>

            <div class="funny-boxes-text">
              <h4>Web Design</h4>

              <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
            </div>
            <!-- //.funny-boxes-text -->
          </div>
          <!-- //.funny-boxes -->
        </div>
        <!-- //.col-sm-4 col-md-4 -->

        <div class="col-sm-4 col-md-4">
          <div class="funny-boxes float-shadow not-right-column text-center">
                            <span class="funny-boxes-icon">
                                <i class="fa fa-heart-o"></i>
                            </span>

            <div class="funny-boxes-text">
              <h4>Graphic Design</h4>

              <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
            </div>
            <!-- //.funny-boxes-text -->
          </div>
          <!-- //.funny-boxes -->
        </div>
        <!-- //.col-sm-4 col-md-4 -->

        <div class="col-sm-4 col-md-4">
          <div class="funny-boxes float-shadow text-center">
                            <span class="funny-boxes-icon">
                                <i class="fa fa-flask"></i>
                            </span>

            <div class="funny-boxes-text">
              <h4>Branding</h4>

              <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
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



<%--
<!-- Begin Our Pricing Section -->
<section id="our-pricing" class="section">
  <div class="section-inner">
    <div class="container section-content">
      <div class="row">
        <div class="col-md-12">
          <div class="section-title text-center">
            <h3 class="main-title">Our Pricing</h3>

            <h3 class="sub-title">What We Can Offer For Our Customers</h3>

            <span class="section-line"></span>
          </div>
          <!-- //.section-title -->
        </div>
        <!-- //.col-md-12 -->
      </div>
      <!-- //.row -->

      <!-- Begin Pricing Tables -->
      <div class="pricing-table style-six">
        <div class="row">
          <div class="col-md-3 pricing-wrapper text-center not-right-column">
            <div class="pricing-column">
              <div class="plan-title">
                <h2>Starter</h2>

                <div class="pricing-box">
                                        <span class="price">
                                            <span class="symbol">$</span>18
                                        </span>

                  <span class="month">/ Month</span>

                  <div class="price-info">
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit.
                  </div>
                  <!-- //.price-info -->
                </div>
                <!-- //.pricing-box -->
              </div>
              <!-- //.plan-title -->

              <ul class="item-list">
                <li>4 Core Processor</li>
                <li>100GB Storage</li>
                <li>24/7 Free Support</li>
                <li>Weekly  Backups</li>
              </ul>

              <div class="plan-footer">
                <a class="btn btn-lg btn-rj" href="#">Get Started</a>
              </div>
              <!-- //.plan-footer -->
            </div>
            <!-- //.pricing-column -->
          </div>
          <!-- //.pricing-wrapper -->

          <div class="col-md-3 pricing-wrapper text-center not-right-column">
            <div class="pricing-column">
              <div class="plan-title">
                <h2>Basic</h2>

                <div class="pricing-box">
                                        <span class="price">
                                            <span class="symbol">$</span>29
                                        </span>

                  <span class="month">/ Month</span>

                  <div class="price-info">
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit.
                  </div>
                  <!-- //.price-info -->
                </div>
                <!-- //.pricing-box -->
              </div>
              <!-- //.plan-title -->

              <ul class="item-list">
                <li>4 Core Processor</li>
                <li>300GB Storage</li>
                <li>24/7 Free Support</li>
                <li>Daily  Backups</li>
              </ul>

              <div class="plan-footer">
                <a class="btn btn-lg btn-rj" href="#">Get Started</a>
              </div>
              <!-- //.plan-footer -->
            </div>
            <!-- //.pricing-column -->
          </div>
          <!-- //.pricing-wrapper -->

          <div class="col-md-3 pricing-wrapper text-center not-right-column">
            <div class="pricing-column">
              <div class="plan-title">
                <h2>Pro</h2>

                <div class="pricing-box">
                                        <span class="price">
                                            <span class="symbol">$</span>50
                                        </span>

                  <span class="month">/ Month</span>

                  <div class="price-info">
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit.
                  </div>
                  <!-- //.price-info -->
                </div>
                <!-- //.pricing-box -->
              </div>
              <!-- //.plan-title -->

              <ul class="item-list">
                <li>4 Core Processor</li>
                <li>1TB Storage</li>
                <li>24/7 Free Support</li>
                <li>Hourly  Backups</li>
              </ul>

              <div class="plan-footer">
                <a class="btn btn-lg btn-rj" href="#">Get Started</a>
              </div>
              <!-- //.plan-footer -->
            </div>
            <!-- //.pricing-column -->
          </div>
          <!-- //.pricing-wrapper -->

          <div class="col-md-3 pricing-wrapper text-center">
            <div class="pricing-column">
              <div class="plan-title">
                <h2>Ultra</h2>

                <div class="pricing-box">
                                        <span class="price">
                                            <span class="symbol">$</span>99
                                        </span>

                  <span class="month">/ Month</span>

                  <div class="price-info">
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit.
                  </div>
                  <!-- //.price-info -->
                </div>
                <!-- //.pricing-box -->
              </div>
              <!-- //.plan-title -->

              <ul class="item-list">
                <li>4 Core Processor</li>
                <li>3TB Storage</li>
                <li>24/7 Free Support</li>
                <li>Hourly  Backups</li>
              </ul>

              <div class="plan-footer">
                <a class="btn btn-lg btn-rj" href="#">Get Started</a>
              </div>
              <!-- //.plan-footer -->
            </div>
            <!-- //.pricing-column -->
          </div>
          <!-- //.pricing-wrapper -->
        </div>
        <!-- //.row -->
      </div>
      <!-- //End Pricing Tables -->
    </div>
    <!-- //.section-content -->
  </div>
  <!-- //.section-inner -->
</section>
<!-- //End Our Pricing Section -->
--%>

<!-- Begin how-works Section -->
<section id="how-works" class="section">
  <div class="section-inner">
    <div class="container section-content">
      <div class="row">
        <div class="col-md-12">
          <div class="section-title text-center">
            <h2 class="main-title">Ինչպե՞ս է աշխատում</h2>

            <h3 class="sub-title">Travel Through Time With Us!</h3>

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
                  <h4 class="timeline-title">Timeline Event</h4>

                  <img src="assets/img/timeline-image-1.jpg" alt="" class="img-responsive">
                </div>
                <!-- //.timeline-heading -->

                <div class="timeline-body">
                  <p>Gunung Rinjani adalah gunung yang berlokasi di Pulau Lombok, Nusa Tenggara Barat. Gunung ini merupakan bagian dari Taman Nasional Gunung Rinjani yang memiliki luas sekitar 41.330 ha.</p>
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
                  <h4 class="timeline-title">Timeline Event</h4>

                  <img src="assets/img/timeline-image-2.jpg" alt="" class="img-responsive">
                </div>
                <!-- //.timeline-heading -->

                <div class="timeline-body">
                  <p>Gunung ini merupakan gunung favorit bagi pendaki Indonesia karena keindahan pemandangannya. Gunung ini merupakan bagian dari Taman Nasional Gunung Rinjani yang memiliki luas sekitar 41.330 ha.</p>
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
                  <h4 class="timeline-title">Timeline Event</h4>

                  <img src="assets/img/timeline-image-3.jpg" alt="" class="img-responsive">
                </div>
                <!-- //.timeline-heading -->

                <div class="timeline-body">
                  <p>Dan akan diusulkan penambahannya sehingga menjadi 76.000 ha ke arah barat dan timur. Secara administratif gunung ini berada dalam wilayah tiga kabupaten: Lombok Timur, Lombok Tengah dan Lombok Barat.</p>
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
                  <h4 class="timeline-title">Timeline Event</h4>

                  <img src="assets/img/timeline-image-4.jpg" alt="" class="img-responsive">
                </div>
                <!-- //.timeline-heading -->

                <div class="timeline-body">
                  <p>Gunung Rinjani adalah gunung yang berlokasi di Pulau Lombok, Nusa Tenggara Barat. Gunung ini merupakan bagian dari Taman Nasional Gunung Rinjani yang memiliki luas sekitar 41.330 ha.</p>
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
<section id="testimonials" class="section section-bgimage-yes">
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
</section>
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

            <h4 class="sub-title">dont hasitate contact us</h4>

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
                <textarea name="message" id="message" class="form-control required" placeholder="Enter Message"></textarea>
              </div>
              <!-- //.input-group -->
            </div>
            <!-- //.form-group -->

            <div class="form-group form-group-bottom">
              <button id="submit" type="submit" class="btn btn-lg btn-rj">
                Send Message
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
            <h2>OR</h2>

            <h4>Find Us On Social Media!</h4>

            <ul class="social-icon-list list-unstyled list-inline text-center">
              <li>
                <a href="#"><i class="fa fa-facebook"></i></a>
              </li>

              <li>
                <a href="#"><i class="fa fa-twitter"></i></a>
              </li>

              <li>
                <a href="#"><i class="fa fa-google-plus"></i></a>
              </li>

              <li>
                <a href="#"><i class="fa fa-youtube"></i></a>
              </li>

              <li>
                <a href="#"><i class="fa fa-pinterest"></i></a>
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


<!-- Begin Map -->
<div id="map">
  <div id="cd-google-map">
    <div id="google-container"></div>
  </div>
  <!-- //.cd-google-map -->
</div>
<!-- //End Map -->


<!-- Begin Footer -->
<footer class="footer">

  <!-- Begin Footer Section -->
  <section id="footer">
    <div class="container">
      <div class="row">
        <div class="col-sm-4 col-md-4 footer-column not-right-column">
          <div class="footer-text">
            <h4>Get In Touch</h4>

            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce elementum, nulla rebds vel pellentesqu</p>

            <ul class="icon-list list-unstyled">
              <li>
                <i class="fa fa-phone"></i> +622176811
              </li>

              <li>
                <i class="fa fa-envelope-o"></i> no-reply@rinjani.com
              </li>

              <li>
                <i class="fa fa-map-marker"></i> 14374 Salemba Raya, Central Jakarta
              </li>

              <li>
                <i class="fa fa-clock-o"></i> Monday to Friday - 8.30 PM to 17 PM
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
                <a href="#"><i class="fa fa-google-plus"></i></a>
              </li>

              <li>
                <a href="#"><i class="fa fa-youtube"></i></a>
              </li>

              <li>
                <a href="#"><i class="fa fa-pinterest"></i></a>
              </li>

              <li class="hidden-xs">
                <a href="#"><i class="fa fa-instagram"></i></a>
              </li>
            </ul>
          </div>
          <!-- //.footer-text -->
        </div>
        <!-- //.footer-column -->

        <div class="col-sm-4 col-md-4 footer-column not-right-column">
          <div class="footer-text">
            <h4>About Us</h4>

            <p>Gunung Rinjani adalah gunung yang berlokasi di Pulau Lombok, Nusa Tenggara Barat. Gunung ini merupakan gunung favorit bagi pendaki Indonesia karena keindahan pemandangannya. Gunung ini merupakan bagian dari Taman Nasional Gunung Rinjani yang memiliki luas sekitar 41.330 ha dan ini akan diusulkan penambahannya sehingga menjadi 76.000 ha ke arah barat dan timur. Secara administratif gunung ini berada dalam wilayah tiga kabupaten: Lombok Timur, Lombok Tengah dan Lombok Barat.</p>
          </div>
          <!-- //.footer-text -->
        </div>
        <!-- //.footer-column -->

        <div class="col-sm-4 col-md-4 footer-column">
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
        </div>
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
          <p>Copyright &copy; 2014 <a href="#">Rinjani.</a></p>
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

</body>

</html>