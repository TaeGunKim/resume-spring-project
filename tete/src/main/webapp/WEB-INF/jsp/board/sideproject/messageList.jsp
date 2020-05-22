<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authentication var="user" property="principal" />
<c:set var="serverName" value="${pageContext.request.serverName}" />
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<script>
$(document).ready(function() {
	//page info
    var startPage = ${messageList.messageSearchVO.pageNo};
    var totalPages = ${messageList.messageSearchVO.totalPages};

    //pagination_web
	$('#pagination').twbsPagination({
         totalPages: totalPages
        ,startPage: startPage
        ,visiblePages: 10
        ,initiateStartPageClick: false
        ,onPageClick: function(event, page) {
            $("#pageNo").val(page);
        	$("#search_form").submit();
        }
    });
});


//글쓰기
function onclickWrite() {
	var url = "/sideproject/messageForm.do";
	$(location).attr("href", url);
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
                                <h2>SideProject</h2>
                                <nav aria-label="breadcrumb ">
                                    <ol class="breadcrumb">
                                    <li class="breadcrumb-item"><a href="/main.do">Home</a></li>
                                    <li class="breadcrumb-item"><a href="#">SideProject</a></li>
                                    </ol>
                                </nav>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Hero End -->
        <!--================Blog Area =================-->
        <section class="blog_area section-padding">
            <div class="container">
                <div class="row">


					<div class="col-lg-12">
						Total <strong>
							<fmt:formatNumber value="${messageList.messageSearchVO.totalCount}" type="number" />
						</strong> posts.
					</div>
                    <div class="col-lg-8 mb-5 mb-lg-0">
                        <div class="blog_left_sidebar">
                        	<c:forEach items="${messageList.messageList}" var="list" varStatus="status">
                            <article class="blog_item">
                                <div class="blog_item_img">
                                	<a class="d-inline-block" href="/sideproject/messageDetail.do?messageSeq=${list.messageSeq}&sortTree=${list.sortTree}&messageCategorySeq=${messageList.messageSearchVO.messageCategorySeq}&searchColumn=${messageList.messageSearchVO.searchColumn}&searchValue=${messageList.messageSearchVO.searchValue}">
	                                 	<c:choose>
											<c:when test="${list.thumbnailUrl == '1' }">
												<img class="card-img rounded-0" src="/img/blog/list_1.png" alt="">
											</c:when>
											<c:when test="${list.thumbnailUrl == '2' }">
												<img class="card-img rounded-0" src="/img/blog/list_2.png" alt="">
											</c:when>
											<c:when test="${list.thumbnailUrl == '3' }">
												<img class="card-img rounded-0" src="/img/blog/list_3.png" alt="">
											</c:when>
											<c:when test="${list.thumbnailUrl == '4' }">
												<img class="card-img rounded-0" src="/img/blog/list_4.png" alt="">
											</c:when>
											<c:otherwise>
												<img class="card-img rounded-0" src="/img/blog/list_1.png" alt="">
											</c:otherwise>
										</c:choose>
									</a>

                                    <!--
                                    <c:choose>
										<c:when
											test="${fn:trim(list.thumbnailUrl) != '' && fn:trim(list.firstAttachment.fileName) == ''}">
											<img alt="" src="${list.thumbnailUrl}" />
										</c:when>
										<c:when test="${fn:trim(list.firstAttachment.fileName) != '' }">
											<img alt="" src="/media/${list.firstAttachment.fileName}.image" />
										</c:when>
										<c:otherwise>
											<img alt="" src="../img/common/no-image-180.gif" />
										</c:otherwise>
									</c:choose>
                                     -->
                                    <!--
                                    <a href="#" class="blog_item_date">
                                        <h3>15</h3>
                                        <p>Jan</p>
                                    </a>
                                     -->
                                </div>

                                <div class="blog_details">
                                    <a class="d-inline-block" href="/sideproject/messageDetail.do?messageSeq=${list.messageSeq}&sortTree=${list.sortTree}&messageCategorySeq=${messageList.messageSearchVO.messageCategorySeq}&searchColumn=${messageList.messageSearchVO.searchColumn}&searchValue=${messageList.messageSearchVO.searchValue}">
                                        <h2><c:out value="${fn:substring(list.title,0,100)}" /></h2>
                                    </a>
                                    <p>
                                    	<c:out value="${fn:substring(list.summaryContents,0,100)}" escapeXml="false" />..
                                    	<!--<c:out value="${list.createDate}" />-->
                                    </p>
                                    <ul class="blog-info-link">
                                        <li><i class="fa fa-archive"></i> ${list.subTitle}</li>
                                        <li><i class="fa fa-eye"></i> ${list.viewCount}</li>
                                        <li><i class="fa fa-comments"></i> ${list.commentCount} Comments</li>
                                    </ul>
                                </div>
                            </article>
                            </c:forEach>

                            <div class="text-center hidden-sm hidden-xs">
		                      <ul id="pagination_web" class="pagination-md"></ul>
		                  </div>

                            <nav class="blog-pagination justify-content-center d-flex">
                                <ul class="pagination" id="pagination">
<!--                                     <li class="page-item"> -->
<!--                                         <a href="#" class="page-link" aria-label="Previous"> -->
<!--                                             <i class="ti-angle-left"></i> -->
<!--                                         </a> -->
<!--                                     </li> -->
<!--                                     <li class="page-item"> -->
<!--                                         <a href="#" class="page-link">1</a> -->
<!--                                     </li> -->
<!--                                     <li class="page-item active"> -->
<!--                                         <a href="#" class="page-link">2</a> -->
<!--                                     </li> -->
<!--                                     <li class="page-item"> -->
<!--                                         <a href="#" class="page-link" aria-label="Next"> -->
<!--                                             <i class="ti-angle-right"></i> -->
<!--                                         </a> -->
<!--                                     </li> -->
                                </ul>
                            </nav>
                        </div>

						<div class="form-group">
                        	<button class="button button-contactForm btn_1 boxed-btn" onclick="onclickWrite();">글쓰기</button>
						</div>
                    </div>
                    <div class="col-lg-4">
                        <div class="blog_right_sidebar">
                            <aside class="single_sidebar_widget search_widget">
                                <form name="search_form" id="search_form" action="/sideproject/messageList.do" method="get">
									<input type="hidden" id="pageNo" name="pageNo" value="${messageList.messageSearchVO.pageNo}" />
									<input type="hidden" id="messageCategorySeq" name="messageCategorySeq" value="${messageList.messageSearchVO.messageCategorySeq}" />
									<input type="hidden" id="searchColumn" name="searchColumn" value="title_contents" />
                                    <div class="form-group">
                                        <div class="input-group mb-3">
                                            <input type="text"
                                            	id="searchValue"
                                            	class="form-control" placeholder='Search Keyword'
                                                onfocus="this.placeholder = ''"
                                                onblur="this.placeholder = 'Search Keyword'"
                                                name="searchValue" >
                                            <div class="input-group-append">
                                                <button class="btns" type="submit"><i class="ti-search"></i></button>
                                            </div>
                                        </div>
                                    </div>
                                    <button class="button rounded-0 primary-bg text-white w-100 btn_1 boxed-btn"
                                        type="submit">검색하기</button>
								</form>
                            </aside>

                            <aside class="single_sidebar_widget post_category_widget">
                                <h4 class="widget_title">Category</h4>
                                <ul class="list cat-list">
                                	<c:forEach items="${messageSubTitleCnt.messageList}" var="subtitleList" varStatus="status">
                                    <li>
                                        <a href="/sideproject/messageList.do?subTitle=${subtitleList.subTitle}" class="d-flex">
                                            <p>${subtitleList.subTitle}</p>
                                            <p>(${subtitleList.subTitleCnt})</p>
                                        </a>
                                    </li>
                                	</c:forEach>
                                </ul>
                            </aside>

                            <aside class="single_sidebar_widget popular_post_widget">
                                <h3 class="widget_title">Recent Post</h3>
                                <c:forEach items="${messageListRecent4.messageList}" var="recentList" varStatus="status">
                                <div class="media post_item">
                                    <img src="/img/post/post_1.png" alt="post">
                                    <div class="media-body">
                                        <a href="/sideproject/messageDetail.do?messageSeq=${recentList.messageSeq}&sortTree=${recentList.sortTree}">
                                            <h3>${fn:substring(recentList.title,0,20)}...</h3>
                                        </a>
                                        <p>${recentList.createDateDiff}</p>
                                    </div>
                                </div>
                                </c:forEach>
                            </aside>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!--================Blog Area =================-->

</body>
</html>