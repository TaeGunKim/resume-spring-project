<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
<link rel="stylesheet" href="/css/swiper.min.css">
<!-- Demo styles -->
  <style>
    .swiper-container {
      width: 100%;
      height: 100%;
      margin-left: auto;
      margin-right: auto;
    }
    .swiper-slide {
      text-align: center;
      font-size: 18px;
      background: #fff;

      /* Center slide text vertically */
      display: -webkit-box;
      display: -ms-flexbox;
      display: -webkit-flex;
      display: flex;
      -webkit-box-pack: center;
      -ms-flex-pack: center;
      -webkit-justify-content: center;
      justify-content: center;
      -webkit-box-align: center;
      -ms-flex-align: center;
      -webkit-align-items: center;
      align-items: center;
    }
    .swiper-slide img{
      width:500px;
    }
  </style>
</head>
<body>
	<!-- Hero Start -->
	<div class="slider-area ">
		<div class="slider-height2 d-flex align-items-center">
			<div class="container">
				<div class="row">
					<div class="col-xl-12">
						<div class="hero-cap pt-30">
							<h2>History</h2>
							<nav aria-label="breadcrumb ">
								<ol class="breadcrumb">
									<li class="breadcrumb-item"><a href="/main.do">Home</a></li>
									<li class="breadcrumb-item"><a href="#">History</a></li>
								</ol>
							</nav>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Hero End -->

	<c:if test="${history != null}">
	<section>
		<div class="center">
			<h4 class="mt-30 mb-30">
				${fn:substring(history.startdate,0,7)} ~ ${fn:substring(history.enddate,0,7)}
			</h4>
			<h3 class="mb-30">
				${history.title}
			</h3>
		</div>
	</section>
	</c:if>

	<c:if test="${history != null}">
	<section>
		<div class="container pt-30">
			<div class="row">
				<c:forEach items="${historyDetailList.historyDetailList}" var="list" varStatus="status">
					<div class="typography" style="width:100%;">
						<h1 style="width:50px;height:50px;background-color:lightsteelblue;text-align:center;border-radius:50px;float:left;">${status.count}</h1>
						<h4 style="margin:10px;">${list.project_nm}</h4>
					</div>
					<c:if test="${list.site_img_1 != null && list.site_img_2 != null}">
					<div class="pb-30" style="display:block;width:100%;height:500px;">
						<div class="swiper-container">
							<div class="swiper-wrapper">
								<c:if test="${list.site_img_1 != null}">
									<div class="swiper-slide">
										<a href="/img/history/work/${list.site_img_1}" class="img-pop-up">
											<img src="/img/history/work/${list.site_img_1}" style="width:100%;"/>
										</a>
									</div>
								</c:if>
								<c:if test="${list.site_img_2 != null}">
									<div class="swiper-slide">
										<a href="/img/history/work/${list.site_img_2}" class="img-pop-up">
											<img src="/img/history/work/${list.site_img_2}" style="width:100%;"/>
										</a>
									</div>
								</c:if>
								<c:if test="${list.site_img_3 != null}">
									<div class="swiper-slide">
										<a href="/img/history/work/${list.site_img_3}" class="img-pop-up">
											<img src="/img/history/work/${list.site_img_3}" style="width:100%;"/>
										</a>
									</div>
								</c:if>
								<c:if test="${list.site_img_4 != null}">
									<div class="swiper-slide">
										<a href="/img/history/work/${list.site_img_4}" class="img-pop-up">
											<img src="/img/history/work/${list.site_img_4}" style="width:100%;"/>
										</a>
									</div>
								</c:if>
							</div>
							<!-- Add Pagination -->
							<div class="swiper-pagination"></div>
							<!-- Add Arrows -->
							<div class="swiper-button-next"></div>
							<div class="swiper-button-prev"></div>
						</div>
					</div>
					</c:if>
					<table class="table table-striped">
						<colgroup>
							<col width="30%">
							<col width="70%">
						</colgroup>
						<thead class="thead-dark">
							<tr>
								<th scope="col">제목</th>
								<th scope="col">내용</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<th>수주자</th>
								<td>${list.company}</td>
							</tr>
							<tr>
								<th>발주자</th>
								<td>${list.orderer}</td>
							</tr>
							<tr>
								<th>프로젝트명</th>
								<td>${list.project_nm}</td>
							</tr>
							<c:if test="${list.site_nm != null}">
							<tr>
								<th>사이트명</th>
								<td>${list.site_nm}</td>
							</tr>
							</c:if>
							<tr>
								<th>프로젝트기간</th>
								<td>${fn:substring(list.startdate,0,7)} ~ ${fn:substring(list.enddate,0,7)} (${list.status})</td>
							</tr>
							<tr>
								<th>투입인원</th>
								<td>${list.worker_cnt} 명</td>
							</tr>
							<tr>
								<th>개발언어</th>
								<td>${list.language}</td>
							</tr>
							<tr>
								<th>개발툴</th>
								<td>${list.tool}</td>
							</tr>
							<tr>
								<th>역할</th>
								<td>${list.part}</td>
							</tr>
							<if test="${list.historySiteList != null}">
							<tr>
								<td colspan="2">
									<c:forEach items="${list.historySiteList}" var="listSite" varStatus="status">
										<c:if test="${listSite.site_img_1 != null && listSite.site_img_2 != null}">
										<div class="pb-30" style="display:block;width:400px;height:500px;margin:0 auto;">
											<div class="swiper-container">
												<div class="swiper-wrapper">
													<c:if test="${listSite.site_img_1 != null}">
														<div class="swiper-slide">
															<a href="/img/history/work/${listSite.site_img_1}" class="img-pop-up">
																<img src="/img/history/work/${listSite.site_img_1}" style="width:100%;"/>
															</a>
														</div>
													</c:if>
													<c:if test="${listSite.site_img_2 != null}">
														<div class="swiper-slide">
															<a href="/img/history/work/${listSite.site_img_2}" class="img-pop-up">
																<img src="/img/history/work/${listSite.site_img_2}" style="width:100%;"/>
															</a>
														</div>
													</c:if>
													<c:if test="${listSite.site_img_3 != null}">
														<div class="swiper-slide">
															<a href="/img/history/work/${listSite.site_img_3}" class="img-pop-up">
																<img src="/img/history/work/${listSite.site_img_3}" style="width:100%;"/>
															</a>
														</div>
													</c:if>
													<c:if test="${listSite.site_img_4 != null}">
														<div class="swiper-slide">
															<a href="/img/history/work/${listSite.site_img_4}" class="img-pop-up">
																<img src="/img/history/work/${listSite.site_img_4}" style="width:100%;"/>
															</a>
														</div>
													</c:if>
												</div>
												<!-- Add Pagination -->
												<div class="swiper-pagination"></div>
												<!-- Add Arrows -->
												<div class="swiper-button-next"></div>
												<div class="swiper-button-prev"></div>
											</div>
										</div>
										</c:if>
										<p class="strong">${listSite.site_nm}</p>
										<p>${listSite.site_part}</p>
									</c:forEach>
								</td>
							</tr>
							</if>
						</tbody>
					</table>
				</c:forEach>
			</div>
		</div>
	</section>
	</c:if>
	<!-- Initialize Swiper -->
	<script src="/js/swiper/swiper.min.js"></script>
	  <script>
	    var swiper = new Swiper('.swiper-container', {
	      slidesPerView: 1,
	      spaceBetween: 30,
	      loop: true,
	      pagination: {
	        el: '.swiper-pagination',
	        clickable: true,
	      },
	      navigation: {
	        nextEl: '.swiper-button-next',
	        prevEl: '.swiper-button-prev',
	      },
	    });
	  </script>

</body>
</html>