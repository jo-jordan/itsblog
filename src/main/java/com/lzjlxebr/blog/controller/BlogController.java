package com.lzjlxebr.blog.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.lzjlxebr.blog.base.ResponseEntity;
import com.lzjlxebr.blog.entity.Blog;
import com.lzjlxebr.blog.service.BlogService;
import com.lzjlxebr.blog.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * BlogController
 * <p>
 * Description write in here.
 *
 * @author : lzjlxebr
 * @date : 2019-08-26 15:54
 **/
@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @PostMapping("/insert")
    public ResponseEntity insert(HttpServletRequest request, @RequestBody String requestBody) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(requestBody);

        Blog blog = new Blog();
        Long id = node.get("id").asLong();
        blog.setId(id);
        blogService.insert(blog);

        return ResponseUtil.success();
    }
}
