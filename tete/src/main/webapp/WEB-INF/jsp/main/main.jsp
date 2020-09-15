<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authentication var="user" property="principal" />
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Hello Kimtg</title>
<script>

</script>

</head>
<body>
	<!-- slider Area Start -->
	<div class="slider-area ">
		<div class="slider-active">
			<!-- Single Slider -->
			<div class="single-slider slider-height d-flex align-items-center">
				<div class="container">
					<div class="row">
						<div class="col-xl-6 col-lg-6 col-md-8">
							<div class="hero__caption">
								<span data-animation="fadeInUp" data-delay=".4s">Welcome.</span>
								<h1 data-animation="fadeInUp" data-delay=".6s">I'm Java Web Developer</h1>
								<P data-animation="fadeInUp" data-delay=".8s">저를 알리기 위해 이 사이트를 만들었습니다.</P>
								<div class="hero__btn">
									<a href="/about/about.do" class="btn hero-btn" data-animation="fadeInLeft" data-delay=".8s">제소개를할께요</a>
									<a href="/history/historyList.do" class="btn border-btn ml-15" data-animation="fadeInRight" data-delay="1.0s">이력보기</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- Single Slider -->
		</div>
	</div>
	<!-- slider Area End -->
	<!-- About Area start -->
	<section class="about-area section-paddingt30">
		<div class="container">
			<div class="row ">
				<div class="col-lg-5">
					<div class="about-caption mb-50">
						<h3>이 홈페이지는 저를 알리기 위한 사이트입니다.</h3>
						<p class="pera1">효과적인 이력의 홍보를 위해 저는 사이드 프로젝트로 이 사이트를 제작하였습니다.</p>
						<p>이 사이트의 소스는 공개되지 않으며 제 개인의 자산입니다. 또한 이미지와 템플릿은 모두 무료 배포용으로 받았으며 출처는 사이트프로젝트 게시판에 올려놓았습니다.</p>
					</div>
				</div>
				<div class="col-lg-5 offset-lg-1">
					<div class="about-caption2">
						<h3>
							저와 일하고 싶으시다면
						</h3>
						<p>연락주세요!</p>
						<div class="send-cv">
							<a href="mailto:ktgstar@nate.com?Subject=홈페이지보고연락드립니다." target="_top">ktgstar@nate.com</a> <i class="ti-arrow-right"></i>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- About Area End -->

</body>
</html>