
//cartList common js
$( document ).ready(function() {
	//결제방식 변경(후결제 -> 선결제)
	chgPaymethod = function (num) {
		if(num=="0"){
			alert("로그인해주세요.");
			return false;
		}
	    var params = {};
		var url = "/mypage/chgPaymethodD.json";
	    if( num != "0" ) {
			$.ajax({
	            async: false,
	            cache: false,
	            type: "GET",
	            url: url,
	            data: params,
	            success: function(data, textStatus) {
	            	if (data.status) {
	            		if (data.status == "1") {
	            			alert("결제 방식이 변경되었습니다.");	            			
	            			location.reload();
	            		} else if(data.status == "-5000"){
	            			alert("미결제 금액이 있어 변경이 불가합니다.\n 결제방식 변경을 위해서 1600-6215 행복중심 상담팀으로 연락 바랍니다.");
	            			return false;
	            		} else if(data.status == "-5001"){
	            			alert("오늘 결제방식 변경이 어렵습니다. \n CMS에서 온라인선결제로의 변경은 기본 월,금,토,일만 가능합니다.\n 자세한 내용은 1600-6215 행복중심 상담팀으로 연락 바랍니다.");
	            			return false;	            			
	            		} else if(data.status == "-5002"){
	            			alert("결제방식은 변경 되었습니다. \n 예치금 계좌가 없으므로 예치금 계좌를 설정하기 위한 페이지로 이동합니다.\n 예치금 계좌 신청 후 장보기 이용 바랍니다.");
	            			location.href='/mypage/chgPayMethod.do';	            			
	            		} else {
	            			alert("결제 방식 변경에 에러가 있습니다. \n 결제방식 변경을 위해서 1600-6215 행복중심 상담팀으로 연락 바랍니다.");
	            			return false;
	            		}
	            	}
	            	console.log(data);
	            }
	        });
			return false;
	    }
	}

});