<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="resourcePath" value="${pageContext.request.contextPath}/resources" />

<html class="lockscreen">
    <head>
        <meta charset="UTF-8">
        <title>Chove | index</title>
        <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
        <link href="${resourcePath}/css/bootstrap/bootstrap.css" rel="stylesheet" type="text/css" />
        <link href="${resourcePath}/css/font-awesome/font-awesome.css" rel="stylesheet" type="text/css" />
        <!-- Theme style -->
        <link href="${resourcePath}/css/AdminLTE.css" rel="stylesheet" type="text/css" />

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>
    	<form action="/mps/j_spring_security_check" method="post">
	        <!-- Automatic element centering using js -->
	        <div class="center">
	            <div class="headline text-center" id="time">
	                <!-- Time auto generated by js -->
	            </div><!-- /.headline -->
	
	            
	            <!-- START LOCK SCREEN ITEM -->
	            <div class="lockscreen-item">
	                <div class="lockscreen-credentials">
	                    <div class="input-group">
	                        <input type="text" name="j_username" class="form-control" placeholder="User Id" value="user1" />
	                        <div class="input-group-btn">
	                            <button class="btn btn-flat"><i class="fa fa-arrow-right text-muted"></i></button>
	                        </div>
	                    </div>
	                </div>
	            </div>
	            
	            <div class="lockscreen-item">
	                <div class="lockscreen-credentials">
	                    <div class="input-group">
	                        <input type="password" name="j_password" class="form-control" placeholder="password" value="user1"/>
	                        <div class="input-group-btn">
	                            <button class="btn btn-flat"><i class="fa fa-arrow-right text-muted"></i></button>
	                        </div>
	                    </div>
	                </div>
	            </div>
	
	            <div style="text-align:center; margin-top:20px;">
	                <button type="submit" class="btn btn-success">Login</button>
	            </div>
	
	            <div class="lockscreen-link">
	                <a href="login.html">Or sign in as a different user</a>
	            </div>
	        </div><!-- /.center -->
        </form>
        

        <script src="${resourcePath}/js/plugins/jquery/jquery-2.1.3.min.js" type="text/javascript"></script>
        <script src="${resourcePath}/js/plugins/bootstrap/bootstrap.min.js" type="text/javascript"></script>

        <!-- page script -->
        <script type="text/javascript">
            $(function() {
                startTime();
                $(".center").center();
                $(window).resize(function() {
                    $(".center").center();
                });
            });

            /*  */
            function startTime()
            {
                var today = new Date();
                var h = today.getHours();
                var m = today.getMinutes();
                var s = today.getSeconds();

                // add a zero in front of numbers<10
                m = checkTime(m);
                s = checkTime(s);

                //Check for PM and AM
                var day_or_night = (h > 11) ? "PM" : "AM";

                //Convert to 12 hours system
                if (h > 12)
                    h -= 12;

                //Add time to the headline and update every 500 milliseconds
                $('#time').html(h + ":" + m + ":" + s + " " + day_or_night);
                setTimeout(function() {
                    startTime()
                }, 500);
            }

            function checkTime(i)
            {
                if (i < 10)
                {
                    i = "0" + i;
                }
                return i;
            }

            /* CENTER ELEMENTS IN THE SCREEN */
            jQuery.fn.center = function() {
                this.css("position", "absolute");
                this.css("top", Math.max(0, (($(window).height() - $(this).outerHeight()) / 2) +
                        $(window).scrollTop()) - 30 + "px");
                this.css("left", Math.max(0, (($(window).width() - $(this).outerWidth()) / 2) +
                        $(window).scrollLeft()) + "px");
                return this;
            }
        </script>
    </body>
</html>
