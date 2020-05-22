<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authentication var="user" property="principal" />
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<script type="text/javascript">
 </script>
</head>
<body>
	<!-- Hero Start -->
	<div class="slider-area ">
		<div class="slider-height2 d-flex align-items-center">
			<div class="container">
				<div class="row">
					<div class="col-xl-12">
						<div class="hero-cap">
							<h2>LoginForm</h2>
							<nav aria-label="breadcrumb ">
								<ol class="breadcrumb">
									<li class="breadcrumb-item"><a href="/main.do">Home</a></li>
									<li class="breadcrumb-item"><a href="#">LoginForm</a></li>
								</ol>
							</nav>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Hero End -->
	<section class="login_area">
       	<div class="container">
       		<div class="row section-padding">
       			<div class="login_form">
       				${user.name}</span>님 환영합니다!
       			</div>
       		</div>
       	</div>
	</section>
</body>
</html>