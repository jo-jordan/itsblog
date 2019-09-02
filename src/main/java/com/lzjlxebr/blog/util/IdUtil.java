package com.lzjlxebr.blog.util;

import java.util.UUID;

/**
 * IdUtil
 * <p>
 * Description write in here.
 *
 * @author : lzjlxebr
 * @date : 2019-08-27 18:27
 **/
public class IdUtil {
    public static Long gen(){
        return UUID.randomUUID().getMostSignificantBits() & Integer.MAX_VALUE;
    }
}
