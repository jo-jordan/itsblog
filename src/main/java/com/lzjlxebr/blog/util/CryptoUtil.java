package com.lzjlxebr.blog.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * CryptoUtil
 * <p>
 * Description write in here.
 *
 * @author : lzjlxebr
 * @date : 2019-11-15 20:05
 **/
public class CryptoUtil {
    public static String md5(String str) {
        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte[] b = md.digest();
            int i;
            StringBuffer buf = new StringBuffer();
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            result = buf.toString().substring(8, 24);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String md5TagName(String str) {
        return "md5" + md5(str);
    }
}
