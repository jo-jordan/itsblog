package com.lzjlxebr.blog.controller;

import com.lzjlxebr.blog.base.ResponseEntity;
import com.lzjlxebr.blog.service.QiNiuService;
import com.lzjlxebr.blog.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * QiNiuController
 * <p>
 * Description write in here.
 *
 * @author : lzjlxebr
 * @date : 2019-08-29 17:03
 **/
@RestController
@RequestMapping("/qiniu")
public class QiNiuController {
    private Logger logger = LoggerFactory.getLogger("QiNiuController");

    @Autowired
    private QiNiuService qiNiuService;
    @PostMapping("/upload/callback")
    public void callback(@RequestBody String requestBody) {
        logger.info("requestBody: {}", requestBody);
    }

    @GetMapping("/get-token")
    public ResponseEntity getToken(@RequestParam("fileKey") String fileKey) {
        return ResponseUtil.success(qiNiuService.getUploadToken(fileKey));
    }
}
