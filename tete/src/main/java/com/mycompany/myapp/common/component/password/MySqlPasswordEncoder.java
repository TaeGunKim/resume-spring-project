package com.mycompany.myapp.common.component.password;

import java.security.GeneralSecurityException;
import java.security.MessageDigest;

import org.springframework.security.crypto.password.PasswordEncoder;

public class MySqlPasswordEncoder implements PasswordEncoder {

    /* (non-Javadoc)
     * @see org.springframework.security.crypto.password.PasswordEncoder#encode(java.lang.CharSequence)
     */
    @Override
    public String encode(CharSequence rawPassword) {

        byte[] bpara = new byte[rawPassword.length()];
        byte[] rethash;

        for (int i=0; i < rawPassword.length(); i++)

            bpara[i] = (byte)(rawPassword.charAt(i) & 0xff );

        try {

            MessageDigest sha1er = MessageDigest.getInstance("SHA1");
            rethash = sha1er.digest(bpara);     // stage1
            rethash = sha1er.digest(rethash);   // stage2

        } catch (GeneralSecurityException e) {

            throw new RuntimeException(e);

        }

        StringBuffer sb = new StringBuffer(41);

        sb.append("*");

        for (int i=0; i < rethash.length; i++) {

            String x = Integer.toHexString(rethash[i] & 0xff).toUpperCase();

            if (x.length()<2)

                sb.append("0");

            sb.append(x);

        }

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
