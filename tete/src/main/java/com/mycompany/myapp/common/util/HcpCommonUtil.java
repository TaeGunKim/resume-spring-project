/**
 * Copyright 2016 Cloudci Pama Framework 1.0
 *
 * <pre>
 * <b>History:</b>
 * Author       Date        Description
 * 영수      2016. 11. 25.   초기작성
 * </pre>
 *
 * @title
 * @packgename com.mycompany.myapp.common.util
 * @filename HcpCommonUtil.java
 * @author 영수
 * @version 1.0, 2016. 11. 25. 초기작성
 * @see None
 */
package com.mycompany.myapp.common.util;

public class HcpCommonUtil {

    // 특정 상품의 주문방법을 정의 한다
    public static String productShoopingFlag(String ca, String orderAb) {
        if (ca == null || orderAb == null) return null;
        String caCode = ca.substring(0, 1);
        String modeStr = "";

        // 일상
        if ("A".equals(orderAb)) {
            modeStr = "nomal";
        // 예약
        } else if ("B".equals(orderAb)) {
            modeStr = "yeyak";
        // 일반택배
        } else if ("C".equals(orderAb)) {
            modeStr = "delivermode";
        // 명절 택배
        } else if ("D".equals(orderAb)) {
            modeStr = "delivermodeM";
        // 주문방식이 없으면 일상코드로 고정
        } else {
            modeStr = "nomal";
        }

        // 명절택배 카테고리로 들어왔을 경우
        if ("E".equals(caCode) || "W".equals(caCode)) {
            modeStr = "delivermodeM";
        }
        // 김장 예약 카테고리로 들어 왔을 경우
        if ("E".equals(caCode)) {
            modeStr = "yeyak";
        }

        return modeStr;
    }

    /**
     * 보관방법
     * @param keepAb
     * @return
     */
    public static String productKeepName(String keepAb) {

        if (keepAb == null) return null;

        String keep_ab = "";
        if ("A".equals(keepAb)) {
            keep_ab = "상온";
        } else if ("F".equals(keepAb)) {
            keep_ab = "냉동-10℃";
        } else if ("E".equals(keepAb)) {
            keep_ab = "냉동-5℃";
        } else if ("D".equals(keepAb)) {
            keep_ab = "냉장3℃";
        } else if ("C".equals(keepAb)) {
            keep_ab = "냉장5℃-";
        } else if ("B".equals(keepAb)) {
            keep_ab = "냉장10℃-";
        }

        return keep_ab;
    }

    public static String mileageFeCode(int act) {
        if (act == 3) return "122";
        if (act == 4) return "127";
        if (act == 5) return "128";
        if (act == 6) return "136";
        return "0";
    }
}
