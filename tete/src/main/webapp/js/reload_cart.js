$.ajax({
    async: false,
    cache: false,
    type: "GET",
    url: "/cart/getCartCommonList.json",
    data: "",
    success: function(result, textStatus) {
    	//console.log(result.cartList);
    	if (result.cartList == undefined || result.cartList =="") {
    		html="<p><span style='text-decoration:underline;'>예약, 택배, 김장, 명절 생활재</span>는 해당 퀵 장바구니에 보이지 않습니다. &lt;<a href='/cart/cartList.do?cartmode=yeyak'>장바구니바로가기</a>&gt;</p>장바구니가 비었습니다.";
    		$("#cart_item0").html(html);
    		return;
    	};
    	var prodImagesDomain = "/media/";
    	var Ahtml = "<form name='cartList'><p><span style='text-decoration:underline;'>예약, 택배, 김장, 명절 생활재</span>는 해당 퀵 장바구니에 보이지 않습니다. &lt;<a href='/cart/cartList.do?cartmode=yeyak'>장바구니바로가기</a>&gt;</p>";
//    	var Savehtml = "<p id='savehtml' style='text-align:center;color:#e44444;display:hidden'>수량변경 후 저장을 눌러야 반영됩니다.<br/><div style='font-size:20px;height:30px;background-color:#e44444;color:#fff;width:130px;cursor:pointer;' onclick='nowCartSave();'>변경된 수량 저장</div></p>";
//    	Ahtml += Savehtml;
   		var cartTotalCount =  0;
   		var cartTotalPrice = 0;
    	$.each(result.cartList, function(i){
    		var gcode = result.cartList[i].gcode;
    		var imglist = result.cartList[i].productVO.imglist;
    		var gname = result.cartList[i].gname;
    		var price = result.cartList[i].price;
    		var cartmode = result.cartList[i].cartmode;
    		var count = result.cartList[i].count;
    		var ordernumMin = result.cartList[i].ordernumMin;
    		var pid = result.cartList[i].pid;
    		cartTotalPrice += count * price;
    		Ahtml+="<div class=\"cart_item\">";
    		Ahtml+="	<input type=\"hidden\" name=\"prodCart_"+gcode+"\" id=\"prodCart_"+gcode+"\" value=\""+gcode+":"+cartmode+"\"/>";
    		Ahtml+=" 	<input type=\"hidden\" name=\"prodCartPrice_"+gcode+"\" id=\"prodCartPrice_"+gcode+"\" value=\""+price+"\"/>";
    		Ahtml+="	<div class=\"cart_img\"><img style=\"width:98px;height:98px;\" src=\""+prodImagesDomain+imglist+".image\">";
    		Ahtml+="	<div style=\"text-align:center;\">";
    		Ahtml+="	<a href=\"#\" onclick=\"return prodNomalDelSet('1','del','nomal','nomal','"+pid+"','"+gcode+"')\" class=\"del\">삭제</a>";
    		Ahtml+="	</div>";
    		Ahtml+="	</div>";
    		Ahtml+="	<div class=\"cart_nm\">"+gname+"</div>";
    		Ahtml+="	<div class=\"cart_price\">"+comma(price)+"원</div>";
    		Ahtml+="	<div class=\"cart_num_wrap\">";
    		Ahtml+="  	<div class=\"cart_num\">";
    		Ahtml+="      	<a href=\"#\" onclick=\"return prodNomalCountSet('1','"+gcode+"','down','nomal','"+ordernumMin+"')\" class=\"down\">down</a>";
    		Ahtml+="      	<input type=\"text\" readonly =\"readonly\" name=\"prodCartCount_"+gcode+"\" id=\"prodCartCount_"+gcode+"\" class=\"num\" value=\""+count+"\">";
    		Ahtml+="      	<a href=\"#\" onclick=\"return prodNomalCountSet('1','"+gcode+"','up','nomal','"+ordernumMin+"')\" class=\"up\">up</a>";
    		Ahtml+="	  	</div>";
    		Ahtml+="	</div>";
    		Ahtml+="</div>";
    		cartTotalCount++;
    	})
    	Ahtml += "</form>";
    	$("#cart_item0").html(Ahtml);

    	$("#cartCount").html(cartTotalCount+"개");
    	$("#cartPrice").val(comma(cartTotalPrice));

    	//console.log(result);
    }
	,error : function(request, status, error ) {   // 오류가 발생했을 때 호출된다.
		html="장바구니에 에러가 있습니다. 새로고침후 다시 이용바랍니다.";
		$("#cart_item0").html(html);
		return;

	}
});

