<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<sec:authentication var="user" property="principal" />
<c:set var="serverName" value="${pageContext.request.serverName}" />
<c:set var="ccode" value="${pageContext.request.userPrincipal != null ?user.ccode:'0'}" />
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<script>
function login(){

	var frm = document.frmLogin;
	frmLoginSubmit = true;
	//로그인
	frm.action="/login";
	frm.submit;
}

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
					<form method="POST" id="frmLogin" name="frmLogin" action="" onsubmit="login()">
						<div class="login_div">
							<div class="login_info">
								<p>
									<input type="text" id="username" name="username" required placeholder="아이디를 입력해 주세요.">
								</p>
								<p>
									<input type="password" id="password" name="password" required placeholder="비밀번호를 입력해 주세요.">
								</p>
							</div>
							<div class="login_btn">
								<button type="submit" id="btn_login" class="button button-contactForm btn_1 boxed-btn" onclick="onclickSave();" style="height:88px;">로그인</button>
							</div>
						</div>
					</form>
				</div>
			</div>
        </div>
    </section>
    <!--================End login form Area =================-->
</body>
</html>