<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authentication var="user" property="principal" />
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<script src="/js/ckeditor/ckeditor.js"></script>
<script src="/js/ckeditor/adapters/jquery.js"></script>
<script>
$(document).ready(function() {
	CKEDITOR.replace( 'contents' );
});

//목록
function onclickList() {
	var url = "/sideproject/messageList.do";
	$(location).attr("href", url);
}

//글쓰기
function onclickSave() {
	//validation
	if ($("#title").val() == "") {
		alert("제목을 입력 하세요.");
		return;
	}

	var desc = CKEDITOR.instances['contents'].getData();
	$("#contents").val(desc);

	if ($("#contents").val() == "") {
		alert("내용을 입력 하세요.");
		return;
	}

	//답글일때 message level + 1
	if ($("#messageLevel").val() != "") {
		var messageLevel = parseInt($("#messageLevel").val()) + 1;
		$("#messageLevel").val(messageLevel);
	}

	//url
	if ($("#messageSeq").val() == "") {
		url = "/sideproject/messageRegister.json";
	} else {
		url = "/sideproject/messageModify.json";
	}

	//parameter
	var form = $("#form1")[0];
    var formData = new FormData(form);

    formData.append("varFiled1", "안녕하세요~");

    for(var pair of formData.entries()) {
   	   console.log(pair[0]+ ', '+ pair[1]);
   	}

    //insert
    $.ajax({
    	url: url
        ,processData: false
        ,contentType: false
        ,async: false
        ,data: formData
        ,type: 'POST'
        ,success: function(result){
        	alert("정상 처리 되었습니다.");

        	if ($("#messageSeq").val() == "") {
	        	$(location).attr("href", "/sideproject/messageList.do");
        	} else {
				location.reload();
        	}
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
								<h2>SideProject Write</h2>
								<nav aria-label="breadcrumb ">
									<ol class="breadcrumb">
									<li class="breadcrumb-item"><a href="/main.do">Home</a></li>
									<li class="breadcrumb-item"><a href="#">SideProject Write</a></li>
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
	            	<div class="col-lg-12">
						<form id="form1" name="form1" method="post">
							<input type="hidden" id="boardSeq" name="boardSeq" value="${boardVO.boardSeq}" />
							<input type="hidden" id="messageSeq" name="messageSeq" value="${messageVO.messageSeq}" />
							<input type="hidden" id="topFlag" name="topFlag" value="${messageVO.topFlag}" />
							<input type="hidden" id="messageLevel" name="messageLevel" value="${messageSearchVO.messageLevel}" />
							<input type="hidden" id="sortTree" name="sortTree" value="${messageSearchVO.sortTree}" />
							<input type="hidden" id="parentMessageSeq" name="parentMessageSeq" value="${messageSearchVO.parentMessageSeq}" />
							<div class="input-group-icon mt-10">
								<div class="form-select" id="default-select"">
									<select id="subTitle" name="subTitle">
										<option value="sideProject">sideProject</option>
										<option value="techStudy">techStudy</option>
										<option value="readBook">readBook</option>
										<option value="etc">etc</option>
									</select>
								</div>
							</div>
							<div class="mt-10">
								<input type="text" id="title" name="title" placeholder="title" onfocus="this.placeholder = ''" onblur="this.placeholder = 'title'" required class="single-input" value="${messageVO.title}">
							</div>
							<div class="mt-10">
								<input type="text" id="homeUrl" name="homeUrl" placeholder="github url" onfocus="this.placeholder = ''" onblur="this.placeholder = 'homeUrl'" required class="single-input" value="${messageVO.homeUrl}">
							</div>
							<div class="mt-10">
								<div class="switch-wrap d-flex justify-content-between">

									<label for="thumbnailUrl-1">썸네일 1</label>
									<input type="radio" id="thumbnailUrl-1" name="thumbnailUrl" value="1">
									<label for="thumbnailUrl-2">썸네일 2</label>
									<input type="radio" id="thumbnailUrl-2" name="thumbnailUrl" value="2" >
									<label for="thumbnailUrl-3">썸네일 3</label>
									<input type="radio" id="thumbnailUrl-3" name="thumbnailUrl" value="3" >
									<label for="thumbnailUrl-4">썸네일 4</label>
									<input type="radio" id="thumbnailUrl-4" name="thumbnailUrl" value="4" >
								</div>
							</div>
							<div class="mt-10">
								<textarea id="contents" name="contents">${messageVO.contents}</textarea>
							</div>
							<div class="mt-10">
								<input type="file" id="file" name="file">
							</div>
						</form>
						<div class="form-group mt-40 text-cener">
                        	<button class="button button-contactForm btn_1 boxed-btn" onclick="onclickList();">목록</button>
                        	<button class="button button-contactForm btn_1 boxed-btn" onclick="onclickSave();">글쓰기</button>
                        </div>
					</div>
				</div>
			</div>
	  	</section>

</body>
</html>