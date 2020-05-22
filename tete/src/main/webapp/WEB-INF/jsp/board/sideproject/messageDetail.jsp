<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%
	pageContext.setAttribute("CR"  , "\r");
	pageContext.setAttribute("LF"  , "\n");
	pageContext.setAttribute("CRLF", "\r\n");
%>
<sec:authentication var="user" property="principal" />
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<script>
$(document).ready(function() {
});

//list
function onclickList() {
	$(location).attr("href", "/sideproject/messageList.do");
}

//댓글길이
function onkeyupComments() {
	$("#comment_cnt").html($("#comments").val().length);
}

//댓글등록
function onclickComment() {
	//validation
	/*
	if ("${pageContext.request.userPrincipal}" == "") {
		alert("로그인을 하세요.");
		return;
	}
	*/
	if ($("#commentCreateName").val() == "") {
		alert("작성자 이름을 입력 하세요.");
		$("#commentCreateName").focus();
		return;
	}
	if($('input:radio[name=createNickname]').is(':checked') == false){
		alert("아이콘을 선택하세요");
		$("#createName").focus();
		return;
	}

	if ($("#comments").val() == "") {
		alert("댓글을 입력 하세요.");
		$("#comments").focus();
		return;
	}
	if ($("#comments").val().length < 10) {
		alert("댓글을 10자 이상으로 입력 하세요.");
		$("#comments").focus();
		return;
	}
	if ($("#comments").val().length > 300) {
		alert("댓글을 300자 이하로 입력 하세요.");
		$("#comments").focus();
		return;
	}

	var createNickname = "";
	createNickname = $(":input:radio[name=createNickname]:checked").val();

	//parameter
	var params = {
         messageSeq 		: "${messageVO.messageSeq}"
        ,comments   		: $("#comments").val()
        ,createName   		: $("#commentCreateName").val()
        ,createNickname   	: createNickname
        ,statusType 		: "1"
    };

	//insert
	$.ajax({
         method: "POST"
        ,async: true
        ,url: "/sideproject/insertMessageComment.json"
        ,data: params
        ,success: function(result) {
        	alert("정상 처리 되었습니다.");

        	location.reload();
        }
        ,error: function(request, status, error) {
        	alert("에러가 있어요!");
        	//console.log("nowurl:"+$(location).attr('href')+"\n"+"code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
        }
    });
}

//수정
function onclickUpdate() {
	var url = "/sideproject/messageForm.do?messageSeq=${messageVO.messageSeq}";
	$(location).attr("href", url);
}

//삭제
function onclickDelete() {
	if (!confirm("삭제 하시겠습니까?")) {
		return;
	}

	$.ajax({
         method: "POST"
        ,async: true
        ,url: "/sideproject/messageRemoveProc.json"
        ,data: {messageSeq : "${messageVO.messageSeq}"}
        ,success: function(result) {
        	alert("정상 처리 되었습니다.");
        	$(location).attr("href", "/sideproject/messageList.do");
        }
        ,error: function(request, status, error) {
        	console.log("nowurl:"+$(location).attr('href')+"\n"+"code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
        }
    });
}

</script>
</head>
<body>






	      <!-- Hero Start -->
		<div class="slider-area">
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
      <section class="blog_area single-post-area section-padding">
         <div class="container">
            <div class="row">
               <div class="col-lg-8 posts-list">
                  <div class="single-post">
                     <div class="feature-img">
                     	<c:choose>
							<c:when test="${messageVO.thumbnailUrl == '1' }">
								<img class="img-fluid" src="/img/blog/list_1.png" alt="">
							</c:when>
							<c:when test="${messageVO.thumbnailUrl == '2' }">
								<img class="img-fluid" src="/img/blog/list_2.png" alt="">
							</c:when>
							<c:when test="${messageVO.thumbnailUrl == '3' }">
								<img class="img-fluid" src="/img/blog/list_3.png" alt="">
							</c:when>
							<c:when test="${messageVO.thumbnailUrl == '4' }">
								<img class="img-fluid" src="/img/blog/list_4.png" alt="">
							</c:when>
							<c:otherwise>
								<img class="img-fluid" src="/img/blog/list_1.png" alt="">
							</c:otherwise>
						</c:choose>
                     </div>
                     <div class="blog_details">
                        <h2>
                        	<c:out value="${messageVO.title}" />
                        </h2>
                        <ul class="blog-info-link mt-3 mb-4">
                        	<li><i class="fa fa-archive"></i> ${messageVO.subTitle}</li>
							<li><i class="fa fa-eye"></i> ${messageVO.viewCount}</li>
                            <li><i class="fa fa-comments"></i> ${messageVO.commentCount} Comments</li>
                        	<li><i class="fa fa-calendar"></i><c:out value="${messageVO.createDate}" /></li>
                        	<li><i class="fa fa-user"></i><c:out value="${messageVO.createName}" /></li>
                        </ul>
                        <div class="section-padding">
                        	<c:set var="contents" value="${messageVO.contents}" />
							<c:out value="${contents}" escapeXml="false" />
                        </div>
                     </div>
                  </div>
                  <div class="navigation-top">
                  	<!--
                     <div class="d-sm-flex justify-content-between text-center">
                        <ul class="social-icons">
                           <li><a href="#"><i class="fab fa-facebook-f"></i></a></li>
                           <li><a href="#"><i class="fab fa-twitter"></i></a></li>
                        </ul>
                     </div>
                     -->
                     <div class="navigation-area">
                        <div class="row">
                           <div class="col-lg-6 col-md-6 col-12 nav-left flex-row d-flex justify-content-start align-items-center">
                           		<c:choose>
								<c:when test="${prevMessageVO.title eq null || prevMessageVO.title eq ''}">
								</c:when>
								<c:otherwise>
	                              <div class="thumb">
	                                 <a href="/sideproject/messageDetail.do?messageSeq=${prevMessageVO.messageSeq}&sortTree=${prevMessageVO.sortTree}&messageCategorySeq=${messageSearchVO.messageCategorySeq}&searchColumn=${messageSearchVO.searchColumn}&searchValue=${messageSearchVO.searchValue}">
	                                    <img class="img-fluid" src="/img/common/left.png" alt="">
	                                 </a>
	                              </div>
	                              <div class="arrow">
	                                 <a href="/sideproject/messageDetail.do?messageSeq=${prevMessageVO.messageSeq}&sortTree=${prevMessageVO.sortTree}&messageCategorySeq=${messageSearchVO.messageCategorySeq}&searchColumn=${messageSearchVO.searchColumn}&searchValue=${messageSearchVO.searchValue}">
	                                    <span class="lnr text-white ti-arrow-left"></span>
	                                 </a>
	                              </div>
								</c:otherwise>
								</c:choose>
                              <div class="detials">
                                 <p>이전글</p>
									<c:choose>
										<c:when test="${prevMessageVO.title eq null || prevMessageVO.title eq ''}">
											<a href="#">
												<h4>
													이전글이 없습니다.
												</h4>
											</a>
										</c:when>
										<c:otherwise>
											<a href="/sideproject/messageDetail.do?messageSeq=${prevMessageVO.messageSeq}&sortTree=${prevMessageVO.sortTree}&messageCategorySeq=${messageSearchVO.messageCategorySeq}&searchColumn=${messageSearchVO.searchColumn}&searchValue=${messageSearchVO.searchValue}">
												<h4>
													<c:out value="${prevMessageVO.title}" />
												</h4>
											</a>
										</c:otherwise>
									</c:choose>
                                 </a>
                              </div>
                           </div>
                           <div
                              class="col-lg-6 col-md-6 col-12 nav-right flex-row d-flex justify-content-end align-items-center">
                              <div class="detials">
                                 <p>다음글</p>
                                 	<c:choose>
										<c:when test="${nextMessageVO.title eq null || nextMessageVO.title eq ''}">
											<a href="#">
												<h4>
													다음글이 없습니다.
												</h4>
											</a>
										</c:when>
										<c:otherwise>
											<a href="/sideproject/messageDetail.do?messageSeq=${nextMessageVO.messageSeq}&sortTree=${nextMessageVO.sortTree}&messageCategorySeq=${messageSearchVO.messageCategorySeq}&searchColumn=${messageSearchVO.searchColumn}&searchValue=${messageSearchVO.searchValue}">
												<h4>
													<c:out value="${nextMessageVO.title}" />
												</h4>
											</a>
										</c:otherwise>
									</c:choose>
                                 </a>
                              </div>
                              	<c:choose>
								<c:when test="${nextMessageVO.title eq null || nextMessageVO.title eq ''}">
								</c:when>
								<c:otherwise>
	                              <div class="arrow">
	                                 <a href="/sideproject/messageDetail.do?messageSeq=${nextMessageVO.messageSeq}&sortTree=${nextMessageVO.sortTree}&messageCategorySeq=${messageSearchVO.messageCategorySeq}&searchColumn=${messageSearchVO.searchColumn}&searchValue=${messageSearchVO.searchValue}">
	                                    <span class="lnr text-white ti-arrow-right"></span>
	                                 </a>
	                              </div>
	                              <div class="thumb">
	                                 <a href="/sideproject/messageDetail.do?messageSeq=${nextMessageVO.messageSeq}&sortTree=${nextMessageVO.sortTree}&messageCategorySeq=${messageSearchVO.messageCategorySeq}&searchColumn=${messageSearchVO.searchColumn}&searchValue=${messageSearchVO.searchValue}">
	                                    <img class="img-fluid" src="/img/common/right.png" alt="">
	                                 </a>
	                              </div>
								</c:otherwise>
								</c:choose>
                           </div>
                        </div>
                     </div>
	                  <div class="button-group-area text-right mt-40">
						<div class="form-group">
                        	<button class="button button-contactForm btn_1 boxed-btn" onclick="onclickList();">목록</button>
                        	<c:if test="${messageVO.createId eq userId}">
                        	<button class="button button-contactForm btn_1 boxed-btn" onclick="onclickUpdate();">수정</button>
                        	<button class="button button-contactForm btn_1 boxed-btn" onclick="onclickDelete();">삭제</button>
                        	</c:if>
						</div>
	                  </div>
                  </div>
                  <div class="comments-area">
                     <h4>${messageVO.commentCount} Comments</h4>
                     <c:forEach items="${messageCommentList}" var="list" varStatus="status">
                     <div class="comment-list">
                        <div class="single-comment justify-content-between d-flex">
                           <div class="user justify-content-between d-flex">
                              <div class="thumb">
                              	<c:choose>
                              		<c:when test="${list.createNickname == '1'}">
                              			<img src="/img/comment/reply-1.png" alt="" class="reply_icon">
                              		</c:when>
                              		<c:when test="${list.createNickname == '2'}">
                              			<img src="/img/comment/reply-2.png" alt="" class="reply_icon">
                              		</c:when>
                              		<c:when test="${list.createNickname == '3'}">
                              			<img src="/img/comment/reply-3.png" alt="" class="reply_icon">
                              		</c:when>
                              		<c:when test="${list.createNickname == '4'}">
                              			<img src="/img/comment/reply-4.png" alt="" class="reply_icon">
                              		</c:when>
                              		<c:when test="${list.createNickname == '5'}">
                              			<img src="/img/comment/reply-5.png" alt="" class="reply_icon">
                              		</c:when>
                              		<c:when test="${list.createNickname == '6'}">
                              			<img src="/img/comment/reply-6.png" alt="" class="reply_icon">
                              		</c:when>
                              		<c:otherwise>
                              			<img src="/img/comment/reply-1.png" alt="" class="reply_icon">
                              		</c:otherwise>

                              	</c:choose>

                              </div>
                              <div class="desc">
                                 <p class="comment">
                                 	<!-- 개행문자 및 스페이스바 처리 -->
                                    <c:set var="comments" value="${list.comments}" />
                                    <c:set var="comments" value="${fn:replace(comments, CRLF, '<br/>')}"  />
									<c:set var="comments" value="${fn:replace(comments, CR  , '<br/>')}"  />
									<c:set var="comments" value="${fn:replace(comments, LF  , '<br/>')}"  />
									<c:set var="comments" value="${fn:replace(comments, ' ' , '&nbsp;')}" />
                                    <c:out value="${comments}" escapeXml="false" />
                                 </p>
                                 <div class="d-flex justify-content-between">
                                    <div class="d-flex align-items-center">
                                       <h5>
                                          <a href="#"><c:out value="${list.createName}" /></a>
                                       </h5>
                                       <p class="date"><c:out value="${list.createDate}" /></p>
                                    </div>
                                    <!--
                                    <div class="reply-btn">
                                       <a href="#" class="btn-reply text-uppercase">reply</a>
                                    </div>
                                    -->
                                 </div>
                              </div>
                           </div>
                        </div>
                     </div>
                     </c:forEach>
                  </div>
                  <div class="comment-form">
                     <h4>Leave a Reply</h4>
                     <form class="form-contact comment_form" action="#" id="commentForm">
                        <div class="row">
                           <div class="col-sm-6">
                              <div class="form-group">
                                 <input class="form-control" name="commentCreateName" id="commentCreateName" type="text" placeholder="댓글 작성자이름" max-length="30">
                              </div>
                           </div>
                           <div class="col-12">
                           		<div class="form-group">
                           			<label for="createNickname1"><img class="reply_icon" src="/img/comment/reply-1.png"></label><input type="radio" id="createNickname1" name="createNickname" value="1" checked>
                           			<label for="createNickname2"><img class="reply_icon" src="/img/comment/reply-2.png"></label><input type="radio" id="createNickname2" name="createNickname" value="2">
                           			<label for="createNickname3"><img class="reply_icon" src="/img/comment/reply-3.png"></label><input type="radio" id="createNickname3" name="createNickname" value="3">
                           			<label for="createNickname4"><img class="reply_icon" src="/img/comment/reply-4.png"></label><input type="radio" id="createNickname4" name="createNickname" value="4">
                           			<label for="createNickname5"><img class="reply_icon" src="/img/comment/reply-5.png"></label><input type="radio" id="createNickname5" name="createNickname" value="5">
                           			<label for="createNickname6"><img class="reply_icon" src="/img/comment/reply-6.png"></label><input type="radio" id="createNickname6" name="createNickname" value="6">
                           		</div>
                           </div>
                           <div class="col-12">
                              <div class="form-group">
                                 <textarea class="form-control w-100" name="comments" id="comments" cols="20" rows="9" placeholder="댓글을 입력하세요"></textarea>
                              </div>
                           </div>
                        </div>
                        <div class="form-group">
                           <button type="button" class="button button-contactForm btn_1 boxed-btn" onClick="onclickComment();">댓글달기</button>
                        </div>
                     </form>
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
      <!--================ Blog Area end =================-->
</body>
</html>