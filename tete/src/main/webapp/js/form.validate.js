jQuery(function($) {
	$(document).ready(function() {
		jQuery.validator.addMethod("alphanumeric", function(value, element) {
            return this.optional(element) || /^[a-zA-Z0-9]+$/.test(value);
		});
		jQuery.validator.addMethod("placeholder", function(value, element) {
			  return value!=$(element).attr("placeholder");
		}, jQuery.validator.messages.required);
	    $("form.accountForm").validate({
	    	rules: {
	    		firstName: {
	    			required: true
	    		},
	    		mbId: {
	    			required: true,
	    			minlength: 6,
	    			maxlength: 20,
	    			alphanumeric: true
	    		},
	    		mobile: {
	    			required: true
	    		},
	    		pwd: {
	    			required: true,
	    			minlength: 6,
	    			maxlength: 16
	    		},
	    		pwdchk: {
	    			required: true,
	    			equalTo: "form.accountForm #pwd"
	    		},
	    		modifyPwd : {
	    			required: true,
	    			minlength: 6,
	    			maxlength: 16
	    		},
	    		modifyPwdChk : {
	    			required: true,
	    			equalTo: "form.accountForm #modifyPwd"
	    		},
	    		nickname: {
	    			required: true,
	    			minlength: 8,
	    			maxlength: 16,
	    			alphanumeric: true
	    		},
	    		email1: {
	    			required: true
	    		},
	    		email2: {
	    			required: true
	    		},
	    		tel2: {
	    			required: true,
	    			number: true
	    		},
	    		tel3: {
	    			required: true,
	    			number: true
	    		},
	    		mobile2: {
	    			required: true,
	    			number: true
	    		},
	    		mobile3: {
	    			required: true,
	    			number: true
	    		},
	    		addr1: {
	    			required: true
	    		},
	    		addr2: {
	    			required: true
	    		},
	    		compyName: {
	    			required: true
	    		},
	    		idchkYn: {
	    			required: true
	    		},
	    		mobilechkYn: {
	    			required: true
	    		},
	    		emailchkYn: {
	    			required: true
	    		},
	    		nickNamechkYn: {
	    			required: true
	    		},
	    		dong: {
	    			required: true
	    		}
	    	},
	    	messages: {
	    		firstName: {
	    			required: "이름을 입력해주세요."
	    		},
	    		mbrId: {
	    			required: "아이디를 입력해주세요.",
	    			minlength: jQuery.validator.format("아이디는 최소 {0}자이상을 입력하셔야 합니다."),
	    			maxlength: jQuery.validator.format("아이디는 최대 {0}자이내로 입력하셔야 합니다."),
	    			alphanumeric: jQuery.validator.format("알파벳과 숫자만 사용가능합니다.")

	    		},
	    		mobile: {
	    			required: "핸드폰번호 입력해주세요."
	    		},
	    		pwd: {
	    			required: "비밀번호를 입력해주세요.",
	    			minlength: jQuery.validator.format("비밀번호는 최소 {0}자이상을 입력하셔야 합니다."),
	    			maxlength: jQuery.validator.format("비밀번호는 최대 {0}자이내로 입력하셔야 합니다.")
	    		},
	    		pwdchk: {
	    			required: "비밀번호확인을 입력해주세요.",
	    			equalTo: "비밀번호를 잘못 입력하셨습니다."
	    		},
	    		modifyPwd : {
	    			required: "변경할 비밀번호를 입력해주세요.",
	    			minlength: jQuery.validator.format("비밀번호는 최소 {0}자이상을 입력하셔야 합니다."),
	    			maxlength: jQuery.validator.format("비밀번호는 최대 {0}자이내로 입력하셔야 합니다.")
	    		},
	    		modifyPwdChk : {
	    			required: "변경할 비밀번호확인을 입력해주세요.",
	    			equalTo: "변경할 비밀번호를 잘못 입력하셨습니다."
	    		},
	    		firstName: {
	    			required: "이름을 입력해주세요.",
	    			minlength: jQuery.validator.format("최소 {0}자이상을 입력하셔야 합니다."),
	    			maxlength: jQuery.validator.format("최대 {0}자이내로 입력하셔야 합니다.")
	    		},
	    		nickname: {
	    			required: "닉네임을 입력해주세요.",
	    			minlength: jQuery.validator.format("닉네임는 최소 {0}자이상을 입력하셔야 합니다."),
	    			maxlength: jQuery.validator.format("닉네임호는 최대 {0}자이내로 입력하셔야 합니다."),
	    			alphanumeric: jQuery.validator.format("알파벳과 숫자만 사용가능합니다.")
	    		},
	    		email1: {
	    			required: "이메일 주소를 입력해주세요."
	    		},
	    		email2: {
	    			required: "이메일 주소를 입력해주세요."
	    		},
	    		tel2: {
	    			required: "연락처를 입력해주세요."
	    		},
	    		tel3: {
	    			required: "연락처를 입력해주세요."
	    		},
	    		mobile2: {
	    			required: "핸드폰을 입력해주세요."
	    		},
	    		mobile3: {
	    			required: "핸드폰을 입력해주세요."
	    		},
	    		addr1: {
	    			required: "주소를 입력해주세요."
	    		},
	    		addr2: {
	    			required: "상세주소를 입력해주세요."
	    		},
	    		compyName: {
	    			required: "회사 및 기관명을 입력해주세요"
	    		},
	    		emailchkYn: {
	    			required: "이메일 중복 체크를 하지 않았습니다."
	    		},
	    		idchkYn: {
	    			required: "아이디 중복 체크를 하지 않았습니다."
	    		},
	    		mobilechkYn: {
	    			required: "핸드폰번호 중복 체크를 하지 않았습니다."
	    		},
	    		nickNamechkYn: {
	    			required: "별명을 중복 체크를 하지 않았습니다."
	    		},
	    		dong: {
	    			required: "주소를 입력하세요."
	    		}
	    	},
    		groups: {
    			telnum: "tel2 tel3",
    			mobilenum : "mobile2 mobile3",
    			emailaddr : "email1 email2"
    		},
    		errorPlacement: function(error, element) {
    			if (element.attr("name") == "tel2" || element.attr("name") == "tel3" ) {
    				error.insertAfter("#tel3");
    			} else if (element.attr("name") == "mobile2" || element.attr("name") == "mobile3" ) {
    				error.insertAfter("#mobile3");
    			} else if (element.attr("name") == "email1" || element.attr("name") == "email2") {
    				error.insertAfter("#email2");
    			} else if (element.attr("name") == "emailchkYn") {
    				if ($("#email1").val()!="" && $("#email2").val()!="") error.insertAfter("#email2");
    			} else
    				error.insertAfter(element);
    		},
    		debug:true,
	    	submitHandler: function(f) {
	    		alert('');
		    	//if (isForms(f)) {
		    	//	f.submit();
		    	//}
	    	},
	    	success: function(e) {
	    		alert('111');
	    	}
	    });

	    $("form.accountSearchForm").validate({
	    	rules: {
	    		email: {
	    			required: true
	    		},
	    		firstName: {
	    			required: true
	    		},
	    		mobile: {
	    			required: true
	    		}
	    	},
	    	messages: {
	    		email: {
	    			required: "이메일 주소를 입력해주세요."
	    		},
	    		firstName: {
	    			required: "이름을 입력해주세요."
	    		},
	    		mobile: {
	    			required: "휴대폰번호를 입력해주세요."
	    		}
	    	},
	    	submitHandler: function(f) {
		    	if (isForms(f)) {
		    		f.submit();
		    	}
	    	},
	    	success: function(e) {
	    	}
	    });

	    $("form.orderForm").validate({
	    	rules: {
	    		prdId: {
	    			required: true
	    		},
	    		startDate: {
	    			required: true
	    		},
	    		endDate: {
	    			required: true
	    		},
	    		totalPrice: {
	    			required: true
	    		}
	    	},
	    	messages: {
	    		prdId: {
	    			required: "상품을 선택해주세요."
	    		},
	    		startDate: {
	    			required: "시작일을 입력해주세요."
	    		},
	    		endDate: {
	    			required: "종료일을 입력해주세요."
	    		},
	    		totalPrice: {
	    			required: "상품이 선택되지 않아 금액이 입력되지 않았습니다."
	    		}
	    	},
	    	submitHandler: function(f) {
		    	if (isForms(f)) {
		    		f.submit();
		    	}
	    	},
	    	success: function(e) {
	    	}
	    });

	    $("form.productForm").validate({
	    	rules: {
	    		cateId: {
	    			required: true
	    		},
	    		prdName: {
	    			required: true
	    		},
	    		price: {
	    			required: true
	    		},
	    		salePrice: {
	    			required: true
	    		},
	    		licenseCode: {
	    			required: true
	    		}
	    	},
	    	messages: {
	    		cateId: {
	    			required: "상품분류를 선택해주세요."
	    		},
	    		prdName: {
	    			required: "상품명을 입력해주세요."
	    		},
	    		price: {
	    			required: "가격을 입력해주세요."
	    		},
	    		salePrice: {
	    			required: "할인가격을 입력해주세요."
	    		},
	    		licenseCode: {
	    			required: "라이센스코드를 입력해주세요."
	    		}
	    	},
	    	submitHandler: function(f) {
		    	if (isForms(f)) {
		    		f.submit();
		    	}
	    	},
	    	success: function(e) {
	    	}
	    });

	    $("form.dataForm").validate({
	    	rules: {
	    		firstName: {
	    			required: true
	    		},
	    		mbrId: {
	    			required: true
	    		},
	    		name: {
	    			required: true,
	    			minlength: 4,
	    			maxlength: 100
	    		},
	    		pwd: {
	    			required: true,
	    			minlength: 6,
	    			maxlength: 16
	    		},
	    		email: {
	    			required: true,
	    			email: true
	    		},
	    		title: {
	    			required: true,
	    			minlength: 3,
	    			maxlength: 100
	    		},
	    		subTitle: {
	    			required: true,
	    			minlength: 4,
	    			maxlength: 100
	    		},
	    		boardKey: {
	    			required: true
	    		},
	    		bannerTitle: {
	    			required: true
	    		},
	    		compyName: {
	    			required: true
	    		},
	    		tags: {
	    			required: true
	    		},
	    		number: {
	    			required: true,
	    			number: true
	    		},
	    		loginId: {
	    			required: true
	    		},
	    		siteName: {
	    			required: true
	    		},
	    		siteUrl: {
	    			required: true
	    		},
	    		email1: {
	    			required: true
	    		},
	    		email2: {
	    			required: true
	    		},
	    		agree1: "required",
	    		agree2: "required",
	    		agree3: "required"
	    	},
	    	messages: {
	    		firstName: {
	    			required: "이름을 입력해주세요."
	    		},
	    		mbrId: {
	    			required: "아이디를 입력해주세요."
	    		},
	    		name: {
	    			required: "성명을 입력해주세요.",
	    			minlength: jQuery.validator.format("최소 {0}자이상을 입력하셔야 합니다."),
	    			maxlength: jQuery.validator.format("최대 {0}자이내로 입력하셔야 합니다.")
	    		},
	    		pwd: {
	    			required: "비밀번호를 입력해주세요.",
	    			minlength: jQuery.validator.format("최소 {0}자이상을 입력하셔야 합니다."),
	    			maxlength: jQuery.validator.format("최대 {0}자이내로 입력하셔야 합니다.")
	    		},
	    		email: {
	    			required: "이메일 주소를 입력해주세요.",
	    			email: "이메일주소가 잘못되었습니다."
	    		},
	    		title: {
	    			required: "제목을 입력해주세요.",
	    			minlength: jQuery.validator.format("최소 {0}자이상을 입력하셔야 합니다."),
	    			maxlength: jQuery.validator.format("최대 {0}자이내로 입력하셔야 합니다.")
	    		},
	    		subTitle: {
	    			required: "제목을 입력해주세요.",
	    			minlength: jQuery.validator.format("최소 {0}자이상을 입력하셔야 합니다."),
	    			maxlength: jQuery.validator.format("최대 {0}자이내로 입력하셔야 합니다.")
	    		},
	    		boardKey: {
	    			required: "게시판코드 입력해주세요"
	    		},
	    		bannerTitle: {
	    			required: "배너위치명을 입력해주세요"
	    		},
	    		bannerSize: {
	    			required: "배너사이즈를 입력해주세요"
	    		},
	    		compyName: {
	    			required: "회사 및 기관명을 입력해주세요"
	    		},
	    		tags: {
	    			required: "태그를 입력해주세요"
	    		},
	    		number: {
	    			required: "태그를 입력해주세요",
	    			number: "숫자만 입력이 가능합니다."
	    		},
	    		loginId: {
	    			required: "아이디를 입력해주세요."
	    		},
	    		siteName: {
	    			required: "외부 컨텐츠 사이트명을 입력해주세요."
	    		},
	    		siteUrl: {
	    			required: "외부 컨텐츠 사이트 주소를 입력해주세요."
	    		},
	    		email1: {
	    			required: "이메일 주소를 입력해주세요."
	    		},
	    		email2: {
	    			required: "이메일 주소를 입력해주세요."
	    		},
	    		agree1: "이용약관에 동의해 주세요",
	    		agree2: "개인정보 수집 및 이용 정책에 동의해 주세요",
	    		agree3: "개인정보 취급 위탁 정책에 동의해 주세요"
	    	},
    		groups: {
    			emailaddr : "email1 email2"
    		},
    		errorPlacement: function(error, element) {
    			if (element.attr("name") == "email1" || element.attr("name") == "email2") {
    				error.insertAfter("#email2");
    			} else
    				error.insertAfter(element);
    		},
	    	submitHandler: function(f) {
	    		if (!(typeof oEditors == "undefined")) {
	    			var contents = oEditors.getById["contents"].getIR();
	    			if (contents == "") {
	    				alert("내용을 입력해주세요.");
	    				return;
	    			}
	    			oEditors.getById["contents"].exec("UPDATE_IR_FIELD", []);
	    		}

	    		if (!(typeof $("#uploaded_file_list_1") == "undefined")) {
					$("#uploaded_file_list_1 option").each(function(){
						$("#dataForm").append("<input type='hidden' name='files' value='"
								+ uploadedFileType[$(this).val()]
								+ "|"
								+ uploadedFiles[$(this).val()]
								+ "|"
								+ uploadedfileNames[$(this).val()]
								+ "|"
								+ uploadedfileInfos[$(this).val()]
								+ "|"
								+ uploadedImageSize[$(this).val()]
								+ "' />");
					});
	    		}

		    	if (!(typeof $("#tags") == "undefined")) {
			    	var tags = "";
					$("span.tag").each(function(){
						tags += $(this).html()+",";
					});
					if(tags!="") {
						$("form.dataForm").append("<input type='hidden' name='otags' value='" + tags.substring(0,tags.length-1) + "' />");
					}

					if ($("#tags").val() == "태그와 태그는 쉼표로 구분하며, 10개까지 입력하실 수 있습니다.") $("#tags").val("");
				}
		    	if (isForms(f)) {
		    		f.submit();
		    	}
	    	},
	    	success: function(e) {
	    	}
	    });

	    $("form.dataForm1").validate({
	    	rules: {
	    		name: {
	    			required: true,
	    			minlength: 2,
	    			maxlength: 100
	    		},
	    		email1: {
	    			required: true
	    		},
	    		email2: {
	    			required: true
	    		},
	    		varFiled1: {
	    			required: true
	    		}
	    	},
	    	messages: {
	    		name: {
	    			required: "성명을 입력해주세요.",
	    			minlength: jQuery.validator.format("최소 {0}자이상을 입력하셔야 합니다."),
	    			maxlength: jQuery.validator.format("최대 {0}자이내로 입력하셔야 합니다.")
	    		},
	    		email1: {
	    			required: "이메일 주소를 입력해주세요."
	    		},
	    		email2: {
	    			required: "이메일 주소를 입력해주세요."
	    		},
	    		varFiled1: {
	    			required: "연락처를 입력해주세요."
	    		}
	    	},
    		groups: {
    			emailaddr : "email1 email2"
    		},
    		errorPlacement: function(error, element) {
    			if (element.attr("name") == "email1" || element.attr("name") == "email2") {
    				error.insertAfter("#email2");
    			} else
    				error.insertAfter(element);
    		},
	    	submitHandler: function(f) {
	    		if (!(typeof oEditors == "undefined")) {
	    			var contents = oEditors.getById["contents"].getIR();
	    			if (contents == "") {
	    				alert("내용을 입력해주세요.");
	    				return;
	    			}
	    			oEditors.getById["contents"].exec("UPDATE_IR_FIELD", []);
	    		}

		    	if (isForms(f)) {
		    		f.submit();
		    	}
	    	},
	    	success: function(e) {
	    	}
	    });

	    $("form.accountInfoForm").validate({
	    	rules: {
	    		firstName: {
	    			required: true,
	    			minlength: 2,
	    			maxlength: 100
	    		},
	    		email1: {
	    			required: true
	    		},
	    		email2: {
	    			required: true
	    		},
	    		infoBank: {
	    			required: true
	    		},
	    		infoAccNumber: {
	    			required: true
	    		},
	    		infoAccHolder: {
	    			required: true
	    		},
	    		infoSettlRates: {
	    			required: true,
	    			number: true
	    		}
	    	},
	    	messages: {
	    		firstName: {
	    			required: "성명을 입력해주세요.",
	    			minlength: jQuery.validator.format("최소 {0}자이상을 입력하셔야 합니다."),
	    			maxlength: jQuery.validator.format("최대 {0}자이내로 입력하셔야 합니다.")
	    		},
	    		email1: {
	    			required: "이메일 주소를 입력해주세요."
	    		},
	    		email2: {
	    			required: "이메일 주소를 입력해주세요."
	    		},
	    		infoBank: {
	    			required: "정산은행를 입력해주세요."
	    		},
	    		infoAccNumber: {
	    			required: "계좌번호를 입력해주세요."
	    		},
	    		infoAccHolder: {
	    			required: "예금주를 입력해주세요."
	    		},
	    		infoSettlRates: {
	    			required: "정산율를 입력해주세요."
	    		}
	    	},
    		groups: {
    			emailaddr : "email1 email2"
    		},
    		errorPlacement: function(error, element) {
    			if (element.attr("name") == "email1" || element.attr("name") == "email2") {
    				error.insertAfter("#email2");
    			} else
    				error.insertAfter(element);
    		},
	    	submitHandler: function(f) {
		    	if (isForms(f)) {
		    		f.submit();
		    	}
	    	},
	    	success: function(e) {
	    	}
	    });
	});
});