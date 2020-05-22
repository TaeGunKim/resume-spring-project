   $(function(){
      $.datepicker.setDefaults({
         monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
         dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
         showMonthAfterYear:true,
         dateFormat: 'yy-mm-dd'
      });

//	  $(".total").on("click",function(e){
//         e.preventDefault();
//		 $(".total_category").toggleClass("gcateActive");
//	  });

	  $(".total_category").on("mouseover",function(e){
         e.preventDefault();
		 $(".total_category").addClass("gcateActive");
	  });
	  $(".total_category").on("mouseout",function(e){
         e.preventDefault();
		 $(".total_category").removeClass("gcateActive");
	  });


	  //20180402 full1515
	  //원래 전체카테고리버튼 클릭시 하나의 jsp에서 show가 되지만 이후 추가된 스크롤내릴때 카테고리 고정때문에 두개로 나눔
	  //기본 전체 카테고리 고정된거 클릭
	  $(".sh_container .total_category .gcategory_wrap .gcategory_total").on("click",function(e){
         e.preventDefault();
		 $(".sh_container .total_category .sub_category_wrap").show();
         $.each($(".sh_container .total_category .sub_category_wrap .sub_category_group"),function(i,val){
			$(val).css("height",$(val).outerHeight());

         });
	  });

	  //스크롤내린거 전체 카테고리 고정된거 클릭
	  $(".sh_container2 .total_category .gcategory_wrap .gcategory_total").on("click",function(e){
		  e.preventDefault();
		  $(".sh_container2 .total_category .sub_category_wrap").show();
		  $.each($(".sh_container2 .total_category2 .sub_category_wrap .sub_category_group"),function(i,val){
			  $(val).css("height",$(val).outerHeight());

		  });
	  });

	  $(".sub_category_close").on("click",function(e){
		 e.preventDefault();
         $(".sub_category_wrap").hide();
	  });

	  $(".category .cate_li").on("mouseenter",function(){
         $(this).addClass("on");
         var height;
         if($(".gcategory_wrap").height() != 0){
        	 height = $(".gcategory_wrap").height()-44.8;
         }else{
        	 height = 518.8-44.8;
        	 $(this).children(".sub_category").css("top",43);
         }
         $(this).children(".sub_category").css("height",height);
      }).on("mouseleave",function(){
         $(this).removeClass("on");
      });

      $("#datepicker").datepicker({
    	  closeText:'닫기',

          onSelect: function (dateText, inst) {
             //alert(dateText);
             //$(".calendar").removeClass('dateselected');
          }
       });

      /*$("#datepicker_btn").on("click",function(e){
	     e.preventDefault();
         $(this).parent().addClass('dateselected');
	  });*/

      $('body').on('click', function (e) {
         if (!$('#datepicker').is(e.target) && $('#datepicker').has(e.target).length === 0
        		 && $('.dateselected').has(e.target).length === 0) {
            //$(".calendar").removeClass('dateselected');
         }
      });

      $(".cart_link").on("click",function(e){
         e.preventDefault();
		 if($(".cart_wrap").hasClass("cart_active")){
			  $(".cart_wrap").removeClass("cart_active");
			  TweenMax.to($(".cart_wrap .cart_link_list"), 0.8,{"height":0,ease: Power3.easeOut});
		  }else{
			  $(".cart_wrap").addClass("cart_active");
			  TweenMax.to($(".cart_wrap .cart_link_list"), 0.8,{"height":300,ease: Power3.easeOut});
		  }
      });

	  $('.top_banner_box').vTicker();

      $(".top_banner_box .arrow.up").on("click",function(e){
		e.preventDefault();
		$('.top_banner_box').vTicker('next', {animate:true});
      });

      $(".top_banner_box .arrow.down").on("click",function(e){
		e.preventDefault();
		$('.top_banner_box').vTicker('prev', {animate:true});
      });

	  $.each($("#centered>ul>li"),function(i,val){
         if($(val).hasClass("active")){
            currentGnb = i;
            return;
         }
      });

      $('#centered').sly({
         horizontal: 1,
//         itemNav: 'centered',
//         smart: 5,
         activateOn: 'click',
         mouseDragging: 1,
         touchDragging: 1,
         releaseSwing: 1,
         startAt: currentGnb,
         activateMiddle:true,
         speed: 500,
         elasticBounds: 1,
         easing: 'easeOutExpo',
         dragHandle: 1,
         dynamicHandle: 1,
         clickBar: 1,
         prev: ('.mobile_menu_wrap .grd_prev'),
			next: ('.mobile_menu_wrap .grd_next')
      });

      $(window).scroll(function(){
    	 //20180503 full1515 홍보팀에서 스크롤할 때는 무조건 카테고리 누른게 없애달라고 요청
    	 if($(".total_category").hasClass("gcateActive")){
    		 $(".total_category").removeClass("gcateActive");
    	 }

    	 var showScroll;
    	 if(document.getElementsByClassName('sh_subContent').length != 0){
    		 showScroll = $('.sh_subContent').offset().top;
    	 }else{
    		 showScroll = $('.main-visual').offset().top;
    	 }

         if($(this).scrollTop()  > showScroll){
        	//스크롤을 아래로 내려 카테고리를 고정 시키는 화면
            if($(".mobile_menu_fix").hasClass("fixed")) return;
            $(".mobile_menu_fix").addClass("fixed");
            $(".sub_location").css("display","none");

            if($(window).width() > 970){
            	$(".sub_location2").css("display","block");
            }else{
            	$(".sub_location2").css("display","none");
            }

            if($(".sh_container .total_category .sub_category_wrap").css("display") == "block"){
            	$(".sh_container2 .total_category .sub_category_wrap").show();
            	$(".sh_container .total_category .sub_category_wrap").hide();
            }

         }else{
        	//기본화면
            if(!$(".mobile_menu_fix").hasClass("fixed")) return;
            $(".mobile_menu_fix").removeClass("fixed");
            $(".sub_location").css("display","block");
            $(".sub_location2").css("display","none");
            if($(".sh_container2 .total_category .sub_category_wrap").css("display") == "block"){
            	$(".sh_container2 .total_category .sub_category_wrap").hide();
            	$(".sh_container .total_category .sub_category_wrap").show();
            }
         }
      });

      //상단 특별 배너
      topBanner();

      //상단 공지사항 리스트
      topNoticeList5();

	  $(".cart_tab>li>a").on("click",function(e){
		  e.preventDefault();
		  $(".cart_item_wrap").hide();
		  $(".pay_area_wrap").hide();
		  $(this).parent().parent().find("li").removeClass("active");
		  $(this).parent().addClass("active");
		  $("#cart_item"+$(this).parent().index()).show();
		  $("#pay_item"+$(this).parent().index()).show();


		  if($(this).parent().index() == "1"){
			  getWishList('${pageContext.request.userPrincipal != null ?"1":"0"}');
		  }else if($(this).parent().index() == "2"){
			  getTodayViewList('${pageContext.request.userPrincipal != null ?"1":"0"}');
		  }else{
			  getCartCommonList('${pageContext.request.userPrincipal != null ?"1":"0"}');
		  }
	  });

	  $(".m_category .m_cate_li .m_cate_a").on("click",function(e){
		  if($(this).parent().find(".m_sub_category").length > 0){
			  e.preventDefault();
			  $(".m_category .m_cate_li").removeClass("active");
			  $(this).parent().addClass("active");
		  }
	  });

	  $(".bottom-menu a.cate,.mobile_menu_wrap .tmenu,.sale_menu_wrap .sh_container .top_left .m_cate").on("click",function(e){
		  e.preventDefault();
		  $("body").addClass("menu-is-open");
		  $(".bottom_mobile_top").css("display","block");
	  });
	  $(".bottom-menu a.cate,.mobile_menu_wrap .tmenu").on("click",function(e){
		  e.preventDefault();
		  $("body").addClass("menu-is-open");
		  $(".bottom_mobile_top").css("display","block");
	  });
	  $(".gray_bg,.site__nav .site__nav_close").on("click",function(e){
		  e.preventDefault();
		  $("body").removeClass("menu-is-open");
		  $(".bottom_mobile_top").css("display","none");
	  });

	  //모바일일때는 관심 / 장바구니가 가격 아래에 활성화 되도록 수정한다.
	  if(isMobile() == false){
		  $(".good").on("mouseenter",function(){
			  $(this).addClass("active");
		  }).on("mouseleave",function(){
			  $(this).removeClass("active");
		  });
	  }


	//20180417 kimtg 모바일화면 카테고리에  나만의생협 세분화 작업
	$("#mcate").on("click",function(e){
		$("#mcate").addClass("active");
		$("#mmy").removeClass("active");
		$("#m_tab0").css("display","block");
		$("#m_tab1").css("display","none");
	});
	$("#mmy").on("click",function(e){
		$("#mcate").removeClass("active");
		$("#mmy").addClass("active");
		$("#m_tab0").css("display","none");
		$("#m_tab1").css("display","block");
	});


	//20180614 kimtg 연관생활재
	var relgood = $(".related_good_roll");

	relgood.owlCarousel({
       items:5,
       loop:true,
       mouseDrag: false,
       autoplay: true,
       autoplayTimeout: 3000,
       paginationSpeed : 400,
       stepOnHover:true,
       rewindNav:true,
       scrollPerPage:false
    });

    $(".related_good_roll_arrow .prev a").on("click",function(e){
       e.preventDefault();
       relgood.trigger('prev.owl.carousel');
    });

    $(".related_good_roll_arrow .next a").on("click",function(e){
       e.preventDefault();
       relgood.trigger('next.owl.carousel');
    });





  });

/**
 * 상단 특별 배너
 */
function topBanner() {
	$.ajax({
		 method: "GET"
		,async: true
		,url: "/banner/bannerEtcOne.json"
		,success: function(data) {
			if (data.bannerEtcOne == undefined){
				$("#top_popup").css("display","none");
			}else{
				var bnUrl = encodeURI(data.bannerEtcOne.bnUrl);
				var bnId = data.bannerEtcOne.bnId;
				var bnSubject = data.bannerEtcOne.bnSubject;
				var bnTarget = data.bannerEtcOne.bnTarget;
				if(bnTarget == "1"){
					bnTarget = "target='_blank'"
				}
				var bnBackFileName = data.bannerEtcOne.bnBackFileName;
				var bnBtnFileName = data.bannerEtcOne.bnBtnFileName;
				var bnDescFileName = data.bannerEtcOne.bnDescFileName;
				var topBannerHtml = "";
				if(bnId == null){
					return;
				}else{
					topBannerHtml+="<div class=\"top_popup_open\">";
					topBannerHtml+="<div class=\"top_popup_container clearfix\">";
					topBannerHtml+="<a href=\""+bnUrl+"\" "+bnTarget+">";
					topBannerHtml+="<img src=\"http://shop.happycoop.or.kr/media/"+bnDescFileName+".image\" style=\"cursor:pointer;\">";
					topBannerHtml+="</a>";
					topBannerHtml+="</div>";
					topBannerHtml+="</div>";
					topBannerHtml+="<a href=\"#\" class=\"open\" onClick=\"openTopBanner()\"><img src=\"http://shop.happycoop.or.kr/media/"+bnBtnFileName+".image\"></a>";

					$("#top_popup").css({"background":"url('http://shop.happycoop.or.kr/media/"+bnBackFileName+".image')"});

					$("#top_popup").html(topBannerHtml);
					if(getCookie("top_popup") == ""){
						topPopup();
					}else{
						$(".top_popup").addClass("pop_close");
					}
				}
			}
		}
		,error: function(request, status, error) {
			console.log("nowurl:"+$(location).attr('href')+"\n"+"code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		}
	});
}

function openTopBanner(){
	if($(".top_popup").hasClass("pop_close") == true){
		$(".top_popup").removeClass("pop_close");
		TweenMax.to($(".top_popup .top_popup_open"), 0.8,{"height":100,ease: Power3.easeOut});
		deleteCookie("top_popup");
	}else{
		$(".top_popup").addClass("pop_close");
		TweenMax.to($(".top_popup .top_popup_open"), 0.8,{"height":0,ease: Power3.easeOut});
		setCookie("top_popup", "top_popup", 1);
	}
}

/**
 * 상단 공지사항
 */
function topNoticeList5() {
	$.ajax({
		 method: "GET"
		,async: true
		,url: "/noticelist/messageList5.json"
		,success: function(data) {
			if (data.messageList == undefined){
				return;
			}else{
				$.each(data.messageList.messageList, function(i){
					var title = data.messageList.messageList[i].title;
					var messageSeq = data.messageList.messageList[i].messageSeq;
					var boardSeq = data.messageList.messageList[i].boardSeq;
					if(title != null){
						if (title.length > 20){
							title = title.substring(0, 19)+"..";
						}
					}
					$("#notice_roll").css("height","23px");
					//20190129 kimtg boardSeq가 없는 경우는 생활재변동사항의 글임
					if(boardSeq == null){
						$("#notice5List").add("<li class='nri' ><a href='/minwooboard/goodsMemo.do?uid="+messageSeq+"'>"+title+"</a></li>").appendTo($("#notice5List"));
					}else{
						$("#notice5List").add("<li class='nri' ><a href='/noticelist/messageDetail.do?messageSeq="+messageSeq+"'>"+title+"</a></li>").appendTo($("#notice5List"));
					}
				})

			}

			$('#notice_roll').vTicker();

			$(".notice_arrow .up").on("click",function(e){
				e.preventDefault();
				$('#notice_roll').vTicker('next', {animate:true});
			});

			$(".notice_arrow .down").on("click",function(e){
				e.preventDefault();
				$('#notice_roll').vTicker('prev', {animate:true});
			});
		}
		,error: function(request, status, error) {
			console.log("nowurl:"+$(location).attr('href')+"\n"+"code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		}
	});
}

function topPopup(){
	TweenMax.to($(".top_popup .top_popup_open"), 0.8,{"height":100,ease: Power3.easeOut});
}

function setCookie(cName, cValue, cDay){
  var expire = new Date();
  expire.setDate(expire.getDate() + cDay);
  cookies = cName + '=' + escape(cValue) + '; path=/ ';
  if(typeof cDay != 'undefined') cookies += ';expires=' + expire.toGMTString() + ';';
  document.cookie = cookies;
}

function getCookie(cName) {
   cName = cName + '=';
   var cookieData = document.cookie;
   var start = cookieData.indexOf(cName);
   var cValue = '';
   if(start != -1){
		start += cName.length;
		var end = cookieData.indexOf(';', start);
		if(end == -1)end = cookieData.length;
		cValue = cookieData.substring(start, end);
   }
   return unescape(cValue);
}

function deleteCookie( cookieName ){
  var expireDate = new Date();

  //어제 날짜를 쿠키 소멸 날짜로 설정한다.
  expireDate.setDate( expireDate.getDate() - 1 );
  document.cookie = cookieName + "= " + "; expires=" + expireDate.toGMTString() + "; path=/";
}

function cartAddAfterDisplayWindowOpenCancel(){
	$("#cartAddAfterDisplayWindow").css({
	   "display" :  "none"
	});

	//20180510 kimtg
	//만약 현재 url이 productdetail 일경우에 history.back을 한다.
	var chkUrl ="productDetail.do";
	var nowUrl =$(location).attr('href');
	if(nowUrl.indexOf(chkUrl) != -1){
		window.history.back();
	}
}

function cartAddAfterDisplayWindow(){
	getMobileCartCnt('${pageContext.request.userPrincipal != null ?"1":"0"}');

	var top = ( $(window).scrollTop() + ( $(window).height() - 400) / 2 );
  	var left = ( $(window).scrollLeft() + ( $(window).width() - 300) / 2 );


	$("#cartAddBeforeDisplayWindow").css({
	   "position" : "absolute",
	   "top" : top,
	   "left" : left,
	   "z-index" : "99999",
	   "display" :  "block"
	});
	setTimeout(function() {
		$("#cartAddBeforeDisplayWindow").css({
		   "display" :  "none"
		});

		$("#cartAddAfterDisplayWindow").css({
		   "position" : "absolute",
		   "top" : top,
		   "left" : left,
		   "z-index" : "99999",
		   "display" :  "block"
		});
		setTimeout(function() {
			$("#cartAddAfterDisplayWindow").css({
			   "display" :  "none"
			});
		}, 4000);
	}, 1000);
}

function cartAddAfterDisplayQuick(){
	if($(window).width() > 1020){
		$(".cart_wrap").addClass("cart_active");
	  	TweenMax.to($(".cart_wrap .cart_link_list"), 0.8,{"height":300,ease: Power3.easeOut});
	  	setTimeout(function() {
	  		TweenMax.to($(".cart_wrap .cart_link_list"), 0.8,{"height":0,ease: Power3.easeOut});
	   	}, 2000);
	}
}


//마우스 클릭 위치
var documentOfMouseClickPositionX = 0;
var documentOfMouseClickPositionY = 0;
jQuery(document).ready(function(){
   $("body").click(function(e){
	   documentOfMouseClickPositionX = e.pageX;
	   documentOfMouseClickPositionY = e.pageY;
   });
})
//객체 위치
var documentOfObjectPositionX = 0;
var documentOfObjectPositionY = 0;
function objectReletivePosition(id){
	var position = jQuery("#"+id).offset();
	documentOfObjectPositionX = position.left;
	documentOfObjectPositionY = position.top;
}

//객체 위치
var documentOfObjectContentW = 0;
var documentOfObjectContentH = 0;
function documentOfObjectContent(id){
	var obj = jQuery("#"+id);
	documentOfObjectContentW = obj.width();
	documentOfObjectContentH = obj.height();
}

function isMobile(){
	var UserAgent = navigator.userAgent;

	if (UserAgent.match(/iPhone|iPod|Android|Windows CE|BlackBerry|Symbian|Windows Phone|webOS|Opera Mini|Opera Mobi|POLARIS|IEMobile|lgtelecom|nokia|SonyEricsson/i) != null || UserAgent.match(/LG|SAMSUNG|Samsung/) != null)
	{
		return true;
	}else{
		return false;
	}
}

//모바일 장바구니 담겨있는 갯수
function getMobileCartCnt(num) {
	if(num=="0"){
		return false;
	}
	$.ajax({
        async: false,
        cache: false,
        type: "GET",
        url: "/cart/getMobileCartCnt.json",
        data: "",
        success: function(result, textStatus) {
        	if (result.cartTotalCount == undefined || result.cartTotalCount == "") {
        		html="0";
        	}else{
        		html = result.cartTotalCount;
        	}
        	$("#m_cart_cnt").html(html);
        	$("#m_cart_cnt2").html(html);
//        	return;
        }
		,error : function(request, status, error ) {   // 오류가 발생했을 때 호출된다.
    		return;
			//console.log("---------------------------");
			//console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			//console.log("---------------------------");

		}
    });
}
function getLoginUrl(actionUrl){
	var retUrl = $("#getUrl").val();

	if(retUrl == null || retUrl == ""){
		retUrl = "/login/loginForm.do";
	}else{
		if(actionUrl != null && actionUrl != "" && actionUrl != undefined){
			retUrl = "/login/loginForm.do?retUrl="+retUrl+actionUrl;
		}else{
			retUrl = "/login/loginForm.do?retUrl="+retUrl;
		}
	}
	location.href=retUrl;
}

$.urlParam = function(name){
	var results = new RegExp('[\?&]' + name + '=([^&#]*)').exec(window.location.href);
	if (results==null){
		return null;
	}else{
		return results[1] || 0;
	}
}

