<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="resourcePath" value="${pageContext.request.contextPath}/resources" />

<html ng-app="mpsApp">
    <head>
        <meta charset="UTF-8">
        <title>MPS | Dashboard</title>
        <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
        <link href="${resourcePath}/css/bootstrap/bootstrap.css" rel="stylesheet" type="text/css" />
        <link href="${resourcePath}/css/font-awesome/font-awesome.css" rel="stylesheet" type="text/css" />
        <!-- Ionicons -->
        <link href="${resourcePath}/css/ionicons/ionicons.css" rel="stylesheet" type="text/css" />
        <!-- Morris chart -->
        <link href="${resourcePath}/css/morris/morris.css" rel="stylesheet" type="text/css" />
        <!-- jvectormap -->
        <link href="${resourcePath}/css/jvectormap/jquery-jvectormap-1.2.2.css" rel="stylesheet" type="text/css" />
        <!-- Date Picker -->
        <link href="${resourcePath}/css/datepicker/datepicker3.css" rel="stylesheet" type="text/css" />
        <!-- Daterange picker -->
        <link href="${resourcePath}/css/daterangepicker/daterangepicker-bs3.css" rel="stylesheet" type="text/css" />
        <!-- bootstrap wysihtml5 - text editor -->
        <link href="${resourcePath}/css/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css" rel="stylesheet" type="text/css" />
        <!-- Theme style -->
        <link href="${resourcePath}/css/AdminLTE.css" rel="stylesheet" type="text/css" />
        
        <!-- init Script -->
        <script type="text/javascript">
	        if (!window.mps) {
	        	window.mps = {
	        		contextPath : '${contextPath}',
	        		resourcePath : '${resourcePath}'
	        	}
	        }
        </script>
        
        <!-- add new calendar event modal -->
        <script src="${resourcePath}/js/plugins/jquery/jquery-2.1.3.min.js" type="text/javascript"></script>
        <script src="${resourcePath}/js/plugins/bootstrap/bootstrap.min.js" type="text/javascript"></script>
        <script src="${resourcePath}/js/plugins/jquery-ui/jquery-ui.min.js" type="text/javascript"></script>
        
        <!-- angular Js -->
        <script src="${resourcePath}/js/plugins/angularjs/angular.min-1.3.8.js" type="text/javascript"></script>
        <script src="${resourcePath}/js/plugins/angularjs/angular-resource.js" type="text/javascript"></script>
        <script src="${resourcePath}/js/plugins/angularjs/angular-route.js" type="text/javascript"></script>
        
        <!-- Morris.js charts -->
        <script src="${resourcePath}/js/plugins/raphael/raphael-min.js"></script>
        <script src="${resourcePath}/js/plugins/morris/morris.min.js" type="text/javascript"></script>
        <!-- Sparkline -->
        <script src="${resourcePath}/js/plugins/sparkline/jquery.sparkline.min.js" type="text/javascript"></script>
        <!-- jvectormap -->
        <script src="${resourcePath}/js/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js" type="text/javascript"></script>
        <script src="${resourcePath}/js/plugins/jvectormap/jquery-jvectormap-world-mill-en.js" type="text/javascript"></script>
        <!-- jQuery Knob Chart -->
        <script src="${resourcePath}/js/plugins/jqueryKnob/jquery.knob.js" type="text/javascript"></script>
        <!-- daterangepicker -->
        <script src="${resourcePath}/js/plugins/daterangepicker/daterangepicker.js" type="text/javascript"></script>
        <!-- datepicker -->
        <script src="${resourcePath}/js/plugins/datepicker/bootstrap-datepicker.js" type="text/javascript"></script>
        <!-- Bootstrap WYSIHTML5 -->
        <script src="${resourcePath}/js/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js" type="text/javascript"></script>
        <!-- iCheck -->
        <script src="${resourcePath}/js/plugins/iCheck/icheck.min.js" type="text/javascript"></script>
        <!-- app -->
        <script src="${resourcePath}/js/app.js" type="text/javascript"></script>
        <script src="${resourcePath}/js/album/albumController.js" type="text/javascript"></script>
        <script src="${resourcePath}/js/common/asyncHttpModule.js" type="text/javascript"></script>
        
        
    </head>
    <body class="skin-blue" ng-controller="mpsCtrl">
        <!-- header logo: style can be found in header.less -->
        <header class="header">
            <a href="index.html" class="logo">
                <!-- Add the class icon to your logo image or logo icon to add the margining -->
                AdminLTE
            </a>
            <!-- Header Navbar: style can be found in header.less -->
            <nav class="navbar navbar-static-top" role="navigation">
                <!-- Sidebar toggle button-->
                <a href="#" class="navbar-btn sidebar-toggle" data-toggle="offcanvas" role="button">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </a>
                <div class="navbar-right">
                    <ul class="nav navbar-nav">
                        <li class="dropdown messages-menu">
                        </li>
                    </ul>
                </div>
            </nav>
        </header>
        <div class="wrapper row-offcanvas row-offcanvas-left">
            <!-- Left side column. contains the logo and sidebar -->
            <aside class="left-side sidebar-offcanvas">
                <!-- sidebar: style can be found in sidebar.less -->
                <section class="sidebar">
                    <!-- Sidebar user panel -->
                    <div class="user-panel">
                        <div class="pull-left image">
                            <img src="${resourcePath}/img/avatar3.png" class="img-circle" alt="User Image" />
                        </div>
                        <div class="pull-left info">
                            <p>Hello, Jane</p>
                            <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
                        </div>
                    </div>
                    <!-- search form -->
                    <form action="#" method="get" class="sidebar-form">
                        <div class="input-group">
                            <input type="text" name="q" class="form-control" placeholder="Search..."/>
                            <span class="input-group-btn">
                                <button type='submit' name='search' id='search-btn' class="btn btn-flat"><i class="fa fa-search"></i></button>
                            </span>
                        </div>
                    </form>
                    <!-- /.search form -->
                    <!-- sidebar menu: : style can be found in sidebar.less -->
                    <ul class="sidebar-menu">
                        <li class="active">
                            <a href="${contextPath}/dashboard/main">
                                <i class="fa fa-dashboard"></i> <span>Dashboard</span>
                            </a>
                        </li>
                        <li class="active">
                            <a href="#" ng-click="moveChoutube()">
                                <i class="fa fa-laptop"></i> <span>Choutube</span>
                            </a>
                        </li>
                        <li class="active">
                            <a href="${contextPath}/album/list">
                                <i class="fa fa-laptop"></i> <span>Album</span>
                            </a>
                        </li>
                        <li>
                            <a href="pages/widgets.html">
                                <i class="fa fa-th"></i> <span>Widgets</span> <small class="badge pull-right bg-green">new</small>
                            </a>
                        </li>
                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-bar-chart-o"></i>
                                <span>Charts</span>
                                <i class="fa fa-angle-left pull-right"></i>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="pages/charts/morris.html"><i class="fa fa-angle-double-right"></i> Morris</a></li>
                                <li><a href="pages/charts/flot.html"><i class="fa fa-angle-double-right"></i> Flot</a></li>
                                <li><a href="pages/charts/inline.html"><i class="fa fa-angle-double-right"></i> Inline charts</a></li>
                            </ul>
                        </li>
                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-laptop"></i>
                                <span>UI Elements</span>
                                <i class="fa fa-angle-left pull-right"></i>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="pages/UI/general.html"><i class="fa fa-angle-double-right"></i> General</a></li>
                                <li><a href="pages/UI/icons.html"><i class="fa fa-angle-double-right"></i> Icons</a></li>
                                <li><a href="pages/UI/buttons.html"><i class="fa fa-angle-double-right"></i> Buttons</a></li>
                                <li><a href="pages/UI/sliders.html"><i class="fa fa-angle-double-right"></i> Sliders</a></li>
                                <li><a href="pages/UI/timeline.html"><i class="fa fa-angle-double-right"></i> Timeline</a></li>
                            </ul>
                        </li>
                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-edit"></i> <span>Forms</span>
                                <i class="fa fa-angle-left pull-right"></i>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="pages/forms/general.html"><i class="fa fa-angle-double-right"></i> General Elements</a></li>
                                <li><a href="pages/forms/advanced.html"><i class="fa fa-angle-double-right"></i> Advanced Elements</a></li>
                                <li><a href="pages/forms/editors.html"><i class="fa fa-angle-double-right"></i> Editors</a></li>
                            </ul>
                        </li>
                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-table"></i> <span>Tables</span>
                                <i class="fa fa-angle-left pull-right"></i>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="pages/tables/simple.html"><i class="fa fa-angle-double-right"></i> Simple tables</a></li>
                                <li><a href="pages/tables/data.html"><i class="fa fa-angle-double-right"></i> Data tables</a></li>
                            </ul>
                        </li>
                        <li>
                            <a href="pages/calendar.html">
                                <i class="fa fa-calendar"></i> <span>Calendar</span>
                                <small class="badge pull-right bg-red">3</small>
                            </a>
                        </li>
                        <li>
                            <a href="pages/mailbox.html">
                                <i class="fa fa-envelope"></i> <span>Mailbox</span>
                                <small class="badge pull-right bg-yellow">12</small>
                            </a>
                        </li>
                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-folder"></i> <span>Examples</span>
                                <i class="fa fa-angle-left pull-right"></i>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="pages/examples/invoice.html"><i class="fa fa-angle-double-right"></i> Invoice</a></li>
                                <li><a href="pages/examples/login.html"><i class="fa fa-angle-double-right"></i> Login</a></li>
                                <li><a href="pages/examples/register.html"><i class="fa fa-angle-double-right"></i> Register</a></li>
                                <li><a href="pages/examples/lockscreen.html"><i class="fa fa-angle-double-right"></i> Lockscreen</a></li>
                                <li><a href="pages/examples/404.html"><i class="fa fa-angle-double-right"></i> 404 Error</a></li>
                                <li><a href="pages/examples/500.html"><i class="fa fa-angle-double-right"></i> 500 Error</a></li>
                                <li><a href="pages/examples/blank.html"><i class="fa fa-angle-double-right"></i> Blank Page</a></li>
                            </ul>
                        </li>
                    </ul>
                </section>
                <!-- /.sidebar -->
            </aside>
            <!-- Right side column. Contains the navbar and content of the page -->
            <aside class="right-side">
	            <ng-view></ng-view>
            </aside><!-- /.right-side -->
        </div><!-- ./wrapper -->
    </body>
</html>