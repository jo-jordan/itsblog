package com.lzjlxebr.blog.util;

import com.lzjlxebr.blog.base.ResponseEntity;

/**
 * ResponseUtil
 * <p>
 * Description write in here.
 *
 * @author : lzjlxebr
 * @date : 2019-08-26 16:00
 **/
public class ResponseUtil {
    public static ResponseEntity success() {
        ResponseEntity entity = new ResponseEntity();
        entity.code = 1;
        entity.msg = "成功";
        return entity;
    }

    public static ResponseEntity success(Object data) {
        ResponseEntity entity = new ResponseEntity();
        entity.code = 1;
        entity.msg = "成功";
        entity.data = data;
        return entity;
    }

    public static ResponseEntity success(Object data, Long count) {
        ResponseEntity entity = new ResponseEntity();
        entity.code = 1;
        entity.msg = "成功";
        entity.data = data;
        entity.total = count;
        return entity;
    }

    public static ResponseEntity failed() {
        ResponseEntity entity = new ResponseEntity();
        entity.code = 0;
        entity.msg = "失败";
        return entity;
    }

    public static ResponseEntity failed(String msg) {
        ResponseEntity entity = new ResponseEntity();
        entity.code = 0;
        entity.msg = msg;
        return entity;
    }
}
