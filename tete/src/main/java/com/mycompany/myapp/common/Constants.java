package com.mycompany.myapp.common;

public class Constants {

	/**
     * 카테고리 상태값 상수 정의
     */
    public static final String CATEGORY_STATE_TYPE_VIEW = "2";
    public static final String CATEGORY_STATE_TYPE_NO_VIEW = "1";

    /**
     * 상품 상태값 상수 정의
     */
    public static final String PRODUCT_STATE_TYPE_VIEW = "2";
    public static final String PRODUCT_STATE_TYPE_NO_VIEW = "1";

    /**
     * 상품 리스트 화면의 탭값 상수 정의
     */
    public static final String PRODUCT_SORT_TAB_NEW = "1";
    public static final String PRODUCT_SORT_TAB_BEST = "2";
    public static final String PRODUCT_SORT_TAB_CHEAP = "3";
    public static final String PRODUCT_SORT_TAB_EXPENSIVE = "4";


    /**
     * 서비스명 규칙
     * 파일업로드등에 사용(디렉토리)
     */
    public static final String SERVICE_ID_PRODUCTS      = "prd";
    public static final String SERVICE_ID_DNTV          = "dntv";
    public static final String SERVICE_ID_BBS           = "bbs";
    public static final String SERVICE_ID_BBSSITE       = "bbssite";
    public static final String SERVICE_ID_ORDER         = "ord";
    public static final String SERVICE_ID_ACCOUNT       = "mbr";
    public static final String SERVICE_ID_ACCOUNTINFO   = "mbrinfo";
    public static final String SERVICE_ID_SAMPLE        = "smp";//샘플
    public static final String SERVICE_ID_PORTLET       = "potlet";
    public static final String SERVICE_ID_BANNER        = "banner";
    public static final String SERVICE_ID_MENUTITLEIMG  = "menuTitleImg";
    public static final String SERVICE_ID_ROLLINGIMG    = "rollingImg";
    public static final String SERVICE_ID_PRODIMG       = "prodImg";
    public static final String SERVICE_ID_SURVEY       = "survey";
    public static final String SERVICE_ID_SMS           = "sms";

    public static final String FILE_NAME_DECIMAL   = "_";

    /**
     * TODO :  <!-- 카테고리타이틀관리 --> 확인필요
     */
    public static final String IMG_MENUTITLEIMG_SRC  = "/images/menuTitleImg/";
    public static final String IMG_PRODIMG_SRC  = "/images/prod/prodimg/";
    public static final String IMG_PRODADDIMG_SRC  = "/images/prod/prodaddimg/";

    /**
     * 보드타입
     */
    public static final String BBS_BOARD_TYPE_NOTICE   = "notice";
    public static final String BBS_BOARD_TYPE_QNA      = "qna";
    public static final String BBS_BOARD_TYPE_GENERAL  = "general";
    public static final String BBS_BOARD_TYPE_IMAGECONTENT = "imagecontent";
    public static final String BBS_BOARD_TYPE_DOCUMENT = "document";

    public static final String BBS_STATUS_TYPE_DEL = "0";
    public static final String BBS_STATUS_TYPE_OPEN = "1";
    public static final String BBS_STATUS_TYPE_BBSWAIT = "1";
    public static final String BBS_STATUS_TYPE_BBSOPEN = "2";

    /**
     * 파일타입에 대한 정의
     * 파일업로드후에 디비에 저장할때 적절하게 업무에 마추어서 정의하면됨.
     */
    public static final int FILE_TYPE_PDS  = 1; //첨부형
    public static final int FILE_TYPE_IMG  = 2; //이미지형
    public static final int FILE_TYPE_MOV  = 3; //동영상형

    /**
     * 이미지의 크기에 대한 정의
     * 1:리스트화면의 이미지
     * 2:상세화면의 이미지1
     * 3:상세화면의 이미지2
     * 4:상세화면의 이미지3
     * 5:상세화면의 이미지4
     */
    public static final String IMAGE_TYPE_LIST  = "1";
    public static final String IMAGE_TYPE_DETAIL1  = "2";
    public static final String IMAGE_TYPE_DETAIL2  = "3";
    public static final String IMAGE_TYPE_DETAIL3  = "4";
    public static final String IMAGE_TYPE_DETAIL4  = "5";
    public static final String IMAGE_TYPE_DETAIL5  = "6";
    public static final String IMAGE_TYPE_DETAIL6  = "7";
    public static final String IMAGE_TYPE_DETAIL7  = "8";
    public static final String IMAGE_TYPE_DETAIL8  = "9";
    public static final String IMAGE_TYPE_DETAIL9  = "10";

    /**
     * 로그인 세션명에 대한 정의
     */
    public static final String ACCOUNT_ADMIN_SESSION_NAME  = "accountAdminSession"; // 관리자 세션
    public static final String ACCOUNT_ADMIN_LOGIN_FORM    = "/admin/login/loginForm.do";//
    public static final String ACCOUNT_FRONT_SESSION_NAME  = "accountFrontSession"; // 프론트 세션
    public static final String ACCOUNT_FRONT_LOGIN_FORM    = "/login/loginForm.do";//

    public static final String ACCOUNT_FRONT_TWITTER_NAME   = "accountTwitterSession";

    /**
     * 회원 상태 정보에 대한 정의
     * 기본값 2  (관리자 등록시 관리자가 지정 사용자 등록시 2로 고정)
     */
    public static final String MBR_ACCOUNT_STATUS_TYPE  = "2";

    public static final String MBR_ACCOUNT_STATUS_TYPE_OUT  = "out";

    /**
     * 회원 레벨에 대한 정의
     */
    public static final int MBR_ACCOUNT_LEVEL_INDIVIDUAL  = 10;  // 일반회원
    public static final int MBR_ACCOUNT_LEVEL_BUSINESS_A  = 30;  // 전문가
    public static final int MBR_ACCOUNT_LEVEL_BUSINESS_B  = 40;  // 정보원
    public static final int MBR_ACCOUNT_LEVEL_ADMIN  = 90;  // 일반관리자
    public static final int MBR_ACCOUNT_LEVEL_SUPERADMIN  = 99;  // 슈퍼관리자

    public static final String MBR_ACCOUNT_INDIVIDUAL  = "individual";  // 일반회원
    public static final String MBR_ACCOUNT_BUSINESS  = "business";  // 비지니스회원
    public static final String MBR_ACCOUNT_MECHANIC  = "mechanic";  // 비지니스회원
    public static final String MBR_ACCOUNT_ADMIN  = "admin";  // 일반관리자



    /**
     * Request 관련변수명
     */
    public static final String REQUEST_CURRENT_URL = "currentURL";
    public static final String REQUEST_CURRENT_URI = "currentURI";

    /**
     * 게시물이 공지게시물인지 일반게시물인지 구분 정의
     */

    public static final String CONTENTS_STATUS_OFF = "0";
    public static final String CONTENTS_STATUS_WAIT = "1";
    public static final String CONTENTS_STATUS_ON = "2";

    public static final String CONTENTS_PROGRESS_WAIT = "0"; // 0대기
    public static final String CONTENTS_PROGRESS_PROG = "1"; // 1진행
    public static final String CONTENTS_PROGRESS_COMP = "2"; // 2완료
    public static final String CONTENTS_PROGRESS_HOLD = "3"; // 3보류
    /**
     * 상품 통계 (prd_statistics) STATUS_TYPE 및 STATISTICS_COUNT 정의
     */
    public static final String PRODUCT_STATISTICS_STATUS_TYPE = "1"; //
    public static final String PRODUCT_STATISTICS_STATISTICS_COUNT = "1"; //

    /**
     * 동영상 태그 타입 1: 동영상 타입, 2:슬라이드 타입
     */
    public static final String UCC_VIDEO_MEDIA_TYPE = "1";
    public static final String UCC_VIDEO_SLIDE_TYPE = "2";

    public static final String UCC_VIDEO_SITE_YOUTUBE = "B";
    public static final String UCC_VIDEO_SITE_PANDORA = "A";
    public static final String UCC_VIDEO_SITE_NORMAL = "C";

    public static final String USER_AGENT_IPHONE = "iPhone";
    public static final String USER_AGENT_ANDROID = "Android";
    public static final String USER_AGENT_IPAD = "iPad";
    public static final String USER_AGENT_TYPE_MOBILE = "mobile";
    public static final String USER_AGENT_TYPE_FRONT = "front";

    /**
     * 포인트관련
     */
    public static final String MBR_POINT_FLAG_CHARGING = "1";
    public static final String MBR_POINT_FLAG_USE = "2";
    public static final String MBR_POINT_FLAG_RETURN = "3";

    public static final int MBR_POINT_RETURN_POINT_NULLERROR = -2;
    public static final int MBR_POINT_RETURN_POINT_TYPEERROR = -1;
    public static final int MBR_POINT_RETURN_POINT_SUCCESS = 1;

    public static final int MBR_POINT_USE_POINT_NOPOINT = -1;
    public static final int MBR_POINT_USE_POINT_SUCCESS = 1;

    /**
     * 메시지 처리
     */
    public static final int RESULT_STATUS_ERROR_MESSAGE = -1;

    public static final String ERROR_LOGGER="ERROR_LOGGER";

}
