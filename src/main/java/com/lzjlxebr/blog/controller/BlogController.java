package com.lzjlxebr.blog.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lzjlxebr.blog.base.ResponseEntity;
import com.lzjlxebr.blog.entity.Blog;
import com.lzjlxebr.blog.service.BlogService;
import com.lzjlxebr.blog.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    @PostMapping("/deleteById")
    public ResponseEntity deleteById(@RequestBody String requestBody) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(requestBody);

        Long id = node.get("id").asLong();
        blogService.deleteById(id);
        return ResponseUtil.success();
    }

    @PostMapping("/deleteInBatch")
    public ResponseEntity deleteInBatch(@RequestBody String requestBody) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(requestBody);

        List<Blog> ids = new ArrayList<>(node.size());
        node.iterator().forEachRemaining(item -> {
            Long id = item.asLong();
            ids.add(new Blog(id));
        });

        blogService.deleteInBatch(ids);
        return ResponseUtil.success();
    }

    @GetMapping("/list")
    public ResponseEntity findAll(@RequestParam("page")Integer page, @RequestParam("size")Integer size) {
        page = page - 1;
        Page<Blog> blogPage = blogService.findAll(page, size);

        return ResponseUtil.success(blogPage.getContent(), blogPage.getTotalElements());
    }
}
