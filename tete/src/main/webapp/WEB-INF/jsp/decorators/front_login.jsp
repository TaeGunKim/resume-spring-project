<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta name="Referrer" content="origin">
<meta name="format-detection" content="telephone=no">
<title><sitemesh:write property='title'/></title>
<script src="/js/jquery-1.11.0.min.js"></script>
<script src="/js/owl.carousel.min.js"></script>
<script src="/js/bootstrap.js"></script>
<script src="/js/jquery-ui-1.9.2.custom.min.js"></script>
<script src="/js/TweenMax.min.js"></script>
<script src="/js/plugins.js"></script>
<script src="/js/sly.min.js"></script>
<script src="/js/jquery.vticker.min.js"></script>
<script src="/js/jquery.twbsPagination.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="icon" href="/img/favicon.png" type="image/png">
<title>MeetMe Personal</title>

<!-- CSS here -->
<link rel="stylesheet" href="/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/owl.carousel.min.css">
<link rel="stylesheet" href="/css/slicknav.css">
<link rel="stylesheet" href="/css/flaticon.css">
<link rel="stylesheet" href="/css/animate.min.css">
<link rel="stylesheet" href="/css/magnific-popup.css">
<link rel="stylesheet" href="/css/fontawesome-all.min.css">
<link rel="stylesheet" href="/css/themify-icons.css">
<link rel="stylesheet" href="/css/slick.css">
<link rel="stylesheet" href="/css/nice-select.css">
<link rel="stylesheet" href="/css/style.css">

<sitemesh:write property='head' />

</head>
<body>
	<jsp:include page="/WEB-INF/jsp/include/front_header.jsp" />
	<sitemesh:write property='body' />
	<jsp:include page="/WEB-INF/jsp/include/front_footer.jsp" />
	<!-- JS here -->
	<!-- All JS Custom Plugins Link Here here -->
	<script src="/js/vendor/modernizr-3.5.0.min.js"></script>
	<!-- Jquery, Popper, Bootstrap -->
	<script src="/js/popper.min.js"></script>
	<script src="/js/bootstrap.min.js"></script>
	<!-- Jquery Mobile Menu -->
	<script src="/js/jquery.slicknav.min.js"></script>

	<!-- Jquery Slick , Owl-Carousel Plugins -->
	<script src="/js/owl.carousel.min.js"></script>
	<script src="/js/slick.min.js"></script>
	<!-- One Page, Animated-HeadLin -->
	<script src="/js/wow.min.js"></script>
	<script src="/js/animated.headline.js"></script>
	<script src="/js/jquery.magnific-popup.js"></script>

	<!-- Nice-select, sticky -->
	<script src="/js/jquery.nice-select.min.js"></script>
	<script src="/js/jquery.sticky.js"></script>

	<!-- contact js -->
	<script src="/js/contact.js"></script>
	<script src="/js/jquery.form.js"></script>
	<script src="/js/jquery.validate.min.js"></script>
	<script src="/js/mail-script.js"></script>
	<script src="/js/jquery.ajaxchimp.min.js"></script>

	<!-- Jquery Plugins, main Jquery -->
	<script src="/js/plugins.js"></script>
	<script src="/js/main.js"></script>
</body>
</html>