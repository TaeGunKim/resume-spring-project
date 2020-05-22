var shift = false;
var bigImg;

$(function(){
    $(".left_list.notice .tab li").on("click",function(e){
      e.preventDefault();
      $(".left_list .tab li").removeClass("active");
      $(this).addClass("active");

      $(".left_swaplist").hide();
      $("#left_list"+$(this).index()).show();
    });

    $(".login_box_tab>li").on("click",function(e){
      e.preventDefault();
      $(".login_box_tab>li").removeClass("active");
      $(this).addClass("active");

      $(".pw_search").hide();
      $("#pw_search"+$(this).index()).show();
    });


	$(".board_box_list .faqli .q").on("click",function(e){
		if($(this).parent().find(".a").css("display") == "block"){
			$(this).parent().find(".a").css("display","none");
		}else{
			$(this).parent().find(".a").css("display","block");
		}
		return false;
	});


	$(".board_box_list_sm .smfaqli .q").on("click",function(e){
		if($(this).parent().find(".a").css("display") == "block"){
			$(this).parent().find(".a").css("display","none");
		}else{
			$(this).parent().find(".a").css("display","block");
		}
		return false;
	});

	goodDetailThumb();

	$(".good_img .wide").on("click",function(e){
      e.preventDefault();
      var src = bigImg;

	  $("html").css("overflow","hidden");
      $("body").append('<div class="img_pop"><a href="javascript:imgPopClose()" class="img_pop_close"><img src="../img/sub/x_2X.png"></a><div class="pop_back"></div><div class="pop_in"><div class="pop_content"><a href="javascript:imgPopClose()"><img src="../img/sub/ajax-loader.svg"></a></div></div><a href="javascript:imgPopPrev();" class="img_pop_prev">prev</a><a href="javascript:imgPopNext();" class="img_pop_next">next</a></div>');
      setTimeout(function(){
        $(".img_pop .pop_in img").attr("src", src).load(function() {
		  var curwidth = this.width;
		  var curHeight = this.height;

		  if(curwidth > 600){
		  	var fixH = (600 * curHeight) / curwidth;
			fixH = -1 * (fixH/2);
		  }else{
			fixH = -1 * (curHeight/2);
		  }
		  $(".img_pop .pop_in").css("margin-top",fixH+"px");
	    });
      }, 1000);
    });

	$(".product_stab>li>a").on("click",function(e){
		e.preventDefault();
		$(this).parent().parent().find("li").removeClass("active");
		$(this).parent().addClass("active");

		$(".product_scont").hide();
		$("#product_scont"+$(this).parent().index()).show();
	});

//	$(".event_banner").owlCarousel({
//         items:1,
//         loop:true,
//         mouseDrag: false,
//         autoplay: true,
//         autoplayTimeout: 5000,
//         dotsContainer: '.event_nav'
//    });

	$(".mobile_detail .mobile_detail_link").on("click",function(e){
		e.preventDefault();
		var obj = $(this);
		var id = $(this).attr("data-id");
		obj.parent().parent().find("li").removeClass("selected");
		obj.parent().addClass("selected");

		if($("#"+id).css("display") == "none"){
			$(".product_tab").hide();
			$("#"+id).show();
			$(this).addClass("active");

			setTimeout(function(){
				var ss = obj.offset().top;
				$("html, body").animate({scrollTop: ss - 50}, 500);
			}, 500);
		}else{
			$(".product_tab").hide();
		}
	});

	$(".plantAb .plantAb_link").on("click",function(e){
		e.preventDefault();
		var obj = $(this);
		var id = $(this).attr("data-id");
		obj.parent().parent().find("li").removeClass("selected");
		obj.parent().addClass("selected");

		if($("#"+id).css("display") == "none"){
			$(".plant_tab").hide();
			$("#"+id).show();
			$(this).addClass("active");
		}else{
			$(".plant_tab").hide();
		}
	});

	$(".pop_wrap .pop_content .pop_close").on("click",function(){
		$(".pop_wrap").fadeOut();
	});

	selectbox_AC($(window).width());

});

//20180417 kimtg 모바일화면 구매하기
function detailBuyBtn(){
	$("#m_buy_area").fadeIn();
	$("#m_buy_area_close").fadeIn();
	$("#m_buy_btn_area").css("display","none");
}
function detailBuyBtnClose(){
	$("#m_buy_area_close").fadeOut();
	$("#m_buy_area").fadeOut();
	$("#m_buy_btn_area").css("display","block");
}

var sliderImg = [];
var sliderNum = 1,sliderLen;

function goodDetailThumb(){
	$(".img_roll").owlCarousel({
		items:1,
		loop:false,
		mouseDrag: true,
		autoplay: false
	});

	$(".good_detail_thumb>li").on("click",function(){
		$(".img_roll").trigger("to.owl.carousel", $(this).index())
	});

	bigImg = $(".img_roll").find(".owl-item").eq(0).find("img").attr('data-ori');

	$(".img_roll").on('changed.owl.carousel',function(property){
		var current = property.item.index;
		sliderNum = property.item.index;
		var src = $(property.target).find(".owl-item").eq(current).find("img").attr('data-ori');
		bigImg = src;
	});

	$.each($(".img_roll").find(".owl-item"),function(i,val){
		sliderImg.push($(val).find("img").attr("data-ori"));
	});

	sliderLen = sliderImg.length;
}

function imgPopPrev(){
	if(sliderNum == 0) return;
	sliderNum -=1;

	$(".img_pop .pop_in img").attr("src",'../img/sub/ajax-loader.svg');

	setTimeout(function(){
		$(".img_pop .pop_in img").attr("src", sliderImg[sliderNum]).load(function() {
			var curwidth = this.width;
			var curHeight = this.height;

			if(curwidth > 600){
				var fixH = (600 * curHeight) / curwidth;
				fixH = -1 * (fixH/2);
			}else{
				fixH = -1 * (curHeight/2);
			}
			$(".img_pop .pop_in").css("margin-top",fixH+"px");
		});
	}, 1000);
}

function imgPopNext(){
	if(sliderNum == sliderLen-1) return;
	sliderNum +=1;

	$(".img_pop .pop_in img").attr("src",'../img/sub/ajax-loader.svg');

	setTimeout(function(){
		$(".img_pop .pop_in img").attr("src", sliderImg[sliderNum]).load(function() {
			var curwidth = this.width;
			var curHeight = this.height;

			if(curwidth > 600){
				var fixH = (600 * curHeight) / curwidth;
				fixH = -1 * (fixH/2);
			}else{
				fixH = -1 * (curHeight/2);
			}
			$(".img_pop .pop_in").css("margin-top",fixH+"px");
		});
	}, 1000);
}

function imgPopClose(){
	$(".img_pop").remove();
	$("html").css("overflow","auto");
}

function selectbox_AC(w){
	if(w <= 1128) {
		$(document).on("keydown",function(event){
			if(event.keyCode == 16 && shift != true) shift = true;
		});

		$(document).on("keyup",function(event){
			if(event.keyCode == 16) shift = false;
		});

		var sb = $(".selectbox");
		sb.ul = sb.find(">ul");
		sb.ul.li = sb.ul.find(">li");
		sb.ul.li.a = sb.ul.li.find(" a");
		sb.ul.li.inputs = sb.ul.li.find(" input");
		sb.shift = false;

		for(var i=0; i<sb.size(); i++ ){
			if(sb.eq(i).hasClass("selectbox_top")){
				sb.eq(i).find(">ul").css({"position":"absolute","left":"0","bottom":"0"});
			} else {
				sb.eq(i).find(">ul").css({"position":"absolute","left":"0","top":"0"});
			}
		}

		sb.ul.li.hide();
		sb.ul.find(".active").show().addClass("on")


		//���콺�� ��Ŀ���� �ش� selectbox����Ʈ
		$(".selectbox a, .selectbox input, .selectbox>ul").on("mouseover focus",function(){
			$(this).parents(".selectbox").addClass("on");
		});
		$(".selectbox a, .selectbox input, .selectbox>ul").on("mouseout blur",function(){
			$(this).parents(".selectbox").removeClass("on");
		});

		//��ũ�̺�Ʈ
		sb.ul.li.a.click(function(e){
			var obj = $(this).parents(".selectbox");
			if(obj.find(">ul>li:hidden").size() != 0){
				e.preventDefault();
				obj.find(">ul>li").show();
				obj.css("z-index","100");
			} else {
				obj.find(">ul>li").hide();
				obj.find(">ul>li.on").removeClass();
				$(this).parent().show().addClass("on");
				obj.css("z-index","0");
			}
		});

		sb.ul.on("mouseleave blur",function(){
			var obj = $(this).parents(".selectbox");
			obj.find(">ul>li").hide();
			obj.find(">ul>li.on").show();
			obj.css("z-index","0");
		});

		$(".selectbox > ul > li > a, .selectbox > ul > li > input").on("keypress",function(e){
			if(e.keyCode == 27){
				var obj = $(this).parents(".selectbox");
				obj.find(">ul>li").hide();
				obj.find(">ul>li.on").show();
				obj.css("z-index","0");
			}
		});

		sb.ul.find(">li:last>a").keypress(function(e){
			if(shift == false && e.keyCode == 9){
				var obj = $(this).parents(".selectbox");
				obj.find(">ul>li").hide();
				obj.find(">ul>li.on").show();
			}
		});

		sb.ul.find(">li:first>a").keypress(function(e){
			if(shift == true && e.keyCode == 9){
				var obj = $(this).parents(".selectbox");
				obj.find(">ul>li").hide();
				obj.find(">ul>li.on").show();
			}
		});

		//form select
		sb.ul.li.click(function(e){
			var obj = $(this).parents(".selectbox");

			if(obj.find(" input").size() != 0){
				if(obj.find(">ul>li:hidden").size() != 0){
					e.preventDefault();
					obj.find(">ul>li").show();
					obj.css("z-index","100");
				} else {
					e.preventDefault();
					obj.find(">ul>li.on").removeClass("on");
					$(this).show().addClass("on")

					//����Ͽ����� �۵�
					$(document).on("touchstart",function(){
						obj.find(">ul>li:not('.on')").hide();
					});
				}
			}
		});

		$(".selectbox > ul > li > input").keypress(function(e){
			if(e.keyCode == 13){
				var obj = $(this).parents(".selectbox");

				if(obj.find(">ul>li:hidden").size() != 0){
					e.preventDefault();
					obj.find(">ul>li").show();
					obj.css("z-index","100");
				} else {
					obj.find(">ul>li").hide();
					$(this).parent().show();
				}
			} else if(e.keyCode == 9){
				var obj = $(this).parents(".selectbox");
				obj.find(">ul>li").hide();
				$(this).parent().show();
			}
		});
	}
}

