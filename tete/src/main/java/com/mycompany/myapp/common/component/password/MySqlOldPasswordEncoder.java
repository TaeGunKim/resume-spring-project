package com.mycompany.myapp.common.component.password;

import org.springframework.security.crypto.password.PasswordEncoder;

public class MySqlOldPasswordEncoder implements PasswordEncoder {

    /* (non-Javadoc)
     * @see org.springframework.security.crypto.password.PasswordEncoder#encode(java.lang.CharSequence)
     */
    @Override
    public String encode(CharSequence rawPassword) {
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

    /* (non-Javadoc)
     * @see org.springframework.security.crypto.password.PasswordEncoder#matches(java.lang.CharSequence, java.lang.String)
     */
    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        if (encodedPassword == null || rawPassword == null) {
            return false;
        }

        if (!encodedPassword.equals(encode(rawPassword))) {
            return false;
        }

        return true;
    }

}
