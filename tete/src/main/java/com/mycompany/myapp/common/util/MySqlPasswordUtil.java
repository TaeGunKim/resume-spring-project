/**
 * Copyright 2016 Cloudci Pama Framework 1.0
 *
 * <pre>
 * <b>History:</b>
 * Author       Date        Description
 * 영수      2017. 1. 15.   초기작성
 * </pre>
 *
 * @title
 * @packgename com.mycompany.myapp.common.util
 * @filename MySqlOldPasswordUtil.java
 * @author 영수
 * @version 1.0, 2017. 1. 15. 초기작성
 * @see None
 */
package com.mycompany.myapp.common.util;

public class MySqlPasswordUtil {

    public  static String oldPassword(String rawPassword) {
        if (rawPassword == null) {
            throw new NullPointerException();
        }

        long lvar1 = 1345345333;
        long ladd = 7;
        long lvar2 = 0x12345671;

        byte[] bpara = new byte[rawPassword.length()];

        for (int i=0; i < rawPassword.length(); i++)
            bpara[i] = (byte)(rawPassword.charAt(i) & 0xff );



        for (int i=0; i < rawPassword.length(); i++) {

            if (bpara[i] == ' ' ||

                bpara[i] == 't') continue;

            lvar1 ^= (((lvar1 & 63) + ladd) * bpara[i]) + (lvar1 << 8);

            lvar2 += (lvar2 << 8) ^ lvar1;

            ladd += bpara[i];

        }

        lvar1 = lvar1 & 0x7fffffff;
        lvar2 = lvar2 & 0x7fffffff;

        StringBuffer sb = new StringBuffer(16);
        String x = Long.toHexString(lvar1);

        for (int i = 8; i > x.length(); i --)
            sb.append("0");

        sb.append(x);

        x = Long.toHexString(lvar2);

        for (int i = 8; i > x.length(); i --)

            sb.append("0");

        sb.append(x);

        return sb.toString();
    }

}
