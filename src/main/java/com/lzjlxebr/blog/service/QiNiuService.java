package com.lzjlxebr.blog.service;

import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import org.springframework.stereotype.Service;

/**
 * QiNiuService
 * <p>
 * Description write in here.
 *
 * @author : lzjlxebr
 * @date : 2019-08-29 16:48
 **/
@Service
public class QiNiuService {
    private static final String AK = "jzIiPYX9D47bEfNFXhv2eOjapUeChR_J1cDsIS7W";
    private static final String SK = "Zir2oD1SPx4IIt7nE1u1R63ar27X2N4Tp-GKWr9L";

    public String getUploadToken(String fileKey) {
        String bucket = "itsblog";
        Auth auth = Auth.create(AK, SK);

        StringMap putPolicy = new StringMap();
        putPolicy.put("callbackUrl", "https://0bc2152c.ap.ngrok.io/dev/qiniu/upload/callback");
        putPolicy.put("callbackBody", "{\"key\":\"$(key)\",\"hash\":\"$(etag)\",\"bucket\":\"$(bucket)\",\"fsize\":$(fsize)}");
        putPolicy.put("callbackBodyType", "application/json");
        long expireSeconds = 3600;
        return auth.uploadToken(bucket, fileKey, expireSeconds, putPolicy);
    }
}
