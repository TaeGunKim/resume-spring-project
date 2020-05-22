$.ajax({
    async: false,
    cache: false,
    type: "GET",
    url: "/wishlist/getWishlist.json",
    data: "",
    success: function(result, textStatus) {
    	if (result.wishList == undefined) {
    		html="등록된 관심 생활재가 없습니다.";
    		$("#cart_item1").html(html);
    		return;
    	};
    	var prodImagesDomain = "/media/";
    	var Bhtml = "";
    	$.each(result.wishList, function(i){
    		var gcode = result.wishList[i].gcode;
    		var imglist = result.wishList[i].imglist;
    		var gname = result.wishList[i].gname;
    		var price = result.wishList[i].price;
    		var cartmode = result.wishList[i].cartmode;
    		Bhtml+="<div class=\"cart_item\">";
    		Bhtml+="	<input type=\"hidden\" name=\"prodWish_"+gcode+"\" id=\"prodWish_"+gcode+"\" value=\""+gcode+":"+cartmode+"\"/>";
    		Bhtml+=" <input type=\"hidden\" name=\"prodWishPrice_"+gcode+"\" id=\"prodWishPrice_"+gcode+"\" value=\""+price+"\"/>";
    		Bhtml+="	<div class=\"cart_img\"><img style=\"width:98px;height:98px;\" src=\""+prodImagesDomain+imglist+".image\"></div>";
    		Bhtml+="	<div class=\"cart_nm\">"+gname+"</div>";
    		Bhtml+="	<div class=\"cart_price\">"+comma(price)+"원</div>";
    		Bhtml+="	<div class=\"cart_chk\">";
    		Bhtml+="		<label for=\"checkbox"+gcode+"\">선택</label><input type=\"checkbox\" class=\"cart_chk_input\" name=\"checkbox2\" id=\"checkbox"+gcode+"\" value=\""+gcode+"\" onClick=\"sumProdCheck('wish')\"/>";
    		Bhtml+="	</div>";
    		Bhtml+="	<div class=\"cart_num_wrap\">";
    		Bhtml+="  	<div class=\"cart_num\">";
    		Bhtml+="      	<a href=\"#\" onclick=\"return prodCountSet('${pageContext.request.userPrincipal != null ?'1':'0'}','"+gcode+"','down','wish')\" class=\"down\">down</a>";
    		Bhtml+="      	<input type=\"text\" name=\"prodWishCount_"+gcode+"\" id=\"prodWishCount_"+gcode+"\" class=\"num\" value=\"1\">";
    		Bhtml+="      	<a href=\"#\" onclick=\"return prodCountSet('${pageContext.request.userPrincipal != null ?'1':'0'}','"+gcode+"','up','wish')\" class=\"up\">up</a>";
    		Bhtml+="	  	</div>";
    		Bhtml+="	</div>";
    		Bhtml+="</div>";
    	})
    	$("#cart_item1").html(Bhtml);
    	//console.log(result);
    }
	,error : function(request, status, error ) {   // 오류가 발생했을 때 호출된다.
		html="관심생활재에 에러가 있습니다. 새로고침후 다시 이용바랍니다.";
		$("#cart_item1").html(html);
		return;
		//console.log("---------------------------");
		//console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		//console.log("---------------------------");

	}
});

getWishList('${pageContext.request.userPrincipal != null ?"1":"0"}');