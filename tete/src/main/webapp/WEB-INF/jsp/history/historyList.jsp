<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Hello Kimtg</title>
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

	<section>
		<div class="container">
			<div class="row">
				<div class="button-group-area text-center pt-30" >
					<a href="/history/historyList.do?type=A" class="genric-btn primary" style="font-size:20px;">학력</a>
					<a href="/history/historyList.do?type=B" class="genric-btn success" style="font-size:20px;">교육</a>
					<a href="/history/historyList.do?type=C" class="genric-btn info" style="font-size:20px;">경력</a>
				</div>
			</div>
		</div>
	</section>


	<c:if test="${historySearchVO.type != null}">
	<section>
		<div class="container pt-30">
			<div class="row">
				<c:choose>
					<c:when test="${historySearchVO.type == 'A'}">
						<c:forEach items="${historyList.historyList}" var="list" varStatus="status">
							<table class="table table-striped">
								<colgroup>
									<col width="10%">
									<col width="30%">
									<col width="30%">
									<col width="30%">
								</colgroup>
								<thead class="thead-dark">
									<tr>
										<th scope="col">순번</th>
										<th scope="col">기간</th>
										<th scope="col">학교명</th>
										<th scope="col">부서명</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<th>
											${status.count}
										</th>
										<td>
											<p>${fn:substring(list.startdate,0,7)} ~ ${fn:substring(list.enddate,0,7)}</p>
											<p class="strong">${list.status}</p>
										</td>
										<td scope="row">
											${list.title}
										</td>
										<td>
											${list.description} ${list.subtitle}
											<c:if test="${list.link != ''}">
												<p><a href="${list.link}" class="genric-btn danger">상세보기</a></p>
											</c:if>
										</td>
									</tr>
								</tbody>
							</table>
						</c:forEach>
					</c:when>
					<c:when test="${historySearchVO.type == 'B'}">
						<c:forEach items="${historyList.historyList}" var="list" varStatus="status">
							<table class="table table-striped">
								<colgroup>
									<col width="10%">
									<col width="30%">
									<col width="30%">
									<col width="30%">
								</colgroup>
								<thead class="thead-dark">
									<tr>
										<th scope="col">순번</th>
										<th scope="col">기간</th>
										<th scope="col">기관명</th>
										<th scope="col">교육명</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<th>
											${status.count}
										</th>
										<td>
											<p>${fn:substring(list.startdate,0,7)} ~ ${fn:substring(list.enddate,0,7)}</p>
											<p class="strong">${list.status}</p>
										</td>
										<td scope="row">
											${list.title}
										</td>
										<td>
											${list.description} ${list.subtitle}
											<c:if test="${list.link != ''}">
												<p><a href="${list.link}" class="genric-btn danger">상세보기</a></p>
											</c:if>
										</td>
									</tr>
								</tbody>
							</table>
						</c:forEach>
					</c:when>
					<c:when test="${historySearchVO.type == 'C'}">
						<c:forEach items="${historyList.historyList}" var="list" varStatus="status">
							<table class="table table-striped">
								<colgroup>
									<col width="10%">
									<col width="30%">
									<col width="30%">
									<col width="30%">
								</colgroup>
								<thead class="thead-dark">
									<tr>
										<th scope="col">순번</th>
										<th scope="col">기간</th>
										<th scope="col">회사명</th>
										<th scope="col">주업무</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<th>
											${status.count}
										</th>
										<td>
											<p>${fn:substring(list.startdate,0,7)} ~ ${fn:substring(list.enddate,0,7)}</p>
											<p class="strong">${list.status}</p>
										</td>
										<td scope="row">
											${list.title}
										</td>
										<td>
											${list.description} ${list.subtitle}
											<c:if test="${list.link != ''}">
												<p><a href="${list.link}" class="genric-btn danger">상세보기</a></p>
											</c:if>
										</td>
									</tr>
								</tbody>
							</table>
						</c:forEach>
					</c:when>
				</c:choose>
			</div>
		</div>
	</section>
	</c:if>

</body>
</html>