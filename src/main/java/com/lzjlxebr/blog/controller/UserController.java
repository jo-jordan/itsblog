package com.lzjlxebr.blog.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lzjlxebr.blog.base.ResponseEntity;
import com.lzjlxebr.blog.util.ResponseUtil;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * UserController
 * <p>
 * Description write in here.
 *
 * @author : lzjlxebr
 * @date : 2019-08-27 17:26
 **/
@RestController
@RequestMapping("/user")
public class UserController {
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody String requestBody) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(requestBody);

        String username = node.get("username").asText("editor");

        Map<String, Object> r = new LinkedHashMap<>(1);
        if("admin".equals(username)) {

            r.put("token", "admin-token");
            return ResponseUtil.success(r);
        }

        r.put("token", "editor-token");
        return ResponseUtil.success(r);
    }

    @GetMapping("/info")
    public ResponseEntity info(@RequestParam("token") String token){

        Map<String, Object> r = new LinkedHashMap<>(4);
        if("admin-token".equals(token)) {
            String[] roles = {"admin"};

            r.put("roles", roles);
            r.put("introduction", "I am a super administrator");
            r.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
            r.put("name", "Super Admin");

            return ResponseUtil.success(r);
        }

        String[] roles = {"eidtor"};
        r.put("roles", roles);
        r.put("introduction", "I am an editor");
        r.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        r.put("name", "Normal Editor");

        return ResponseUtil.success(r);
    }

    @PostMapping("/info")
    public ResponseEntity logout(){
        return ResponseUtil.success();
    }
}
