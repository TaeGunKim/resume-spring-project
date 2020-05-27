<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
</script>
<link rel="stylesheet" href="/css/about.css">
</head>
<body>
	<!-- Hero Start -->
	<div class="slider-area ">
		<div class="slider-height2 d-flex align-items-center">
			<div class="container">
				<div class="row">
					<div class="col-xl-12">
						<div class="hero-cap pt-30">
							<h2>About me</h2>
							<nav aria-label="breadcrumb ">
							<ol class="breadcrumb">
								<li class="breadcrumb-item"><a href="/main.do">Home</a></li>
								<li class="breadcrumb-item"><a href="#">About me</a></li>
							</ol>
							</nav>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Hero End -->
	<!-- About Me Start -->
	<div class="about-me pb-top section-padding">
		<div class="container">
			<div class="row justify-content-between align-items-center">
				<div class="col-lg-6 col-md-6">
					<div class="about-me-img mb-30">
						<img src="/img/common/pk-2.png" alt="">
					</div>
				</div>
				<div class="col-lg-5 col-md-6">
					<div class="about-me-caption">
						<h2>My name Is<br/>${about.name}</h2>
						<h4>${about.job}</h4>
						<p class="pb-30">${about.intro}</p>
						<p>${about.birth}</p>
						<p>${about.mtel}</p>
						<p>${about.email}</p>
						<p>${about.residence}</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- About Me End -->
	<!-- About Area start -->
	<section class="about-area section-paddingt30">
	<div class="container">
		<div class="row ">
			<div class="col-lg-5">
				<div class="about-caption mb-50">
					<h3>Programming With Passion While Exploring The World.</h3>
					<p class="pera1">${about.about}</p>
				</div>
			</div>
			<div class="col-lg-5 offset-lg-1">
				<div class="about-caption2">
					<h3>
						If you want to hire your Company.
					</h3>
					<p>Contact to me, I am Hardworking person.</p>
					<div class="send-cv">
						<a href="mailto:${about.email}" target="_top">${about.email} <i class="ti-arrow-right"></i></a>
					</div>
				</div>
			</div>
		</div>
	</div>
	</section>
	<!-- About Area End -->
	<!-- Want To Work Start -->
	<section class="wantToWork-area w-padding2">
	<div class="container">
		<div class="row align-items-center justify-content-between">
			<div class="col-xl-6 col-lg-8 col-md-8">
				<div class="wantToWork-caption wantToWork-caption2">
					<h2>Do you want to see my work ?</h2>
				</div>
			</div>
			<div class="col-xl-2 col-lg-2 col-md-3">
				<a href="/history/historyList.do" class="btn btn-black f-right">My work</a>
			</div>
		</div>
	</div>
	</section>
</body>
</html>