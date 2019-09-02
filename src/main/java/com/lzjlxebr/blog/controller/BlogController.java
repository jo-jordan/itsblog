package com.lzjlxebr.blog.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lzjlxebr.blog.base.ResponseEntity;
import com.lzjlxebr.blog.entity.Blog;
import com.lzjlxebr.blog.service.BlogService;
import com.lzjlxebr.blog.util.DataTimeUtil;
import com.lzjlxebr.blog.util.IdUtil;
import com.lzjlxebr.blog.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.Charset;
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
        Long id = IdUtil.gen();
        String title = node.get("title").asText("Untitled");
        String blogSource = node.get("blogSource").asText();
        String blogHtml = node.get("blogHtml").asText();
        Integer lines = node.get("lines").asInt();
        Integer words = node.get("words").asInt();
        String status = "draft";

        blog.setId(id);
        blog.setTitle(title);
        blog.setBlogHtml(blogHtml.getBytes(Charset.forName("utf-8")));
        blog.setBlogSource(blogSource.getBytes(Charset.forName("utf-8")));
        blog.setLines(lines);
        blog.setWords(words);
        blog.setCreateTime(DataTimeUtil.getCurrentDateTimeInString());
        blog.setStatus(status);

        blogService.insert(blog);

        return ResponseUtil.success();
    }

    @PostMapping("/publish")
    public ResponseEntity publishBlog(@RequestBody String requestBody) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(requestBody);

        Long id = node.get("id").asLong();
        Blog blog = blogService.findById(id);
        if(blog == null) {
            return ResponseUtil.failed("Blog was gone.");
        }

        blog.setStatus("published");
        blogService.update(blog);
        return ResponseUtil.success();
    }

    @PostMapping("/update")
    public ResponseEntity update(HttpServletRequest request, @RequestBody String requestBody) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(requestBody);

        Long id = node.get("id").asLong();
        Blog blog = blogService.findById(id);
        if(blog == null) {
            return ResponseUtil.failed("Blog was gone.");
        }
        String title = node.get("title").asText("Untitled");
        String blogSource = node.get("blogSource").asText();
        String blogHtml = node.get("blogHtml").asText();
        Integer lines = node.get("lines").asInt();
        Integer words = node.get("words").asInt();
        String status = "draft";

        blog.setId(id);
        blog.setTitle(title);
        blog.setBlogHtml(blogHtml.getBytes(Charset.forName("utf-8")));
        blog.setBlogSource(blogSource.getBytes(Charset.forName("utf-8")));
        blog.setLines(lines);
        blog.setWords(words);
        blog.setUpdateTime(DataTimeUtil.getCurrentDateTimeInString());
        blog.setStatus(status);

        blogService.update(blog);

        return ResponseUtil.success();
    }

    @PostMapping("/delete")
    public ResponseEntity deleteById(@RequestBody String requestBody) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(requestBody);

        Long id = node.get("id").asLong();
        Blog blog = blogService.findById(id);
        if(blog == null) {
            return ResponseUtil.failed("Blog was gone.");
        }
        blog.setStatus("deleted");
        blogService.update(blog);
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
    public ResponseEntity findAll(
            @RequestParam("page") Integer page,
            @RequestParam("size") Integer size,
            @RequestParam(name = "keyword", defaultValue = "") String keyword
    ) {
        page = page - 1;
        Page<Blog> blogPage = blogService.findAll(page, size, keyword);

        return ResponseUtil.success(blogPage.getContent(), blogPage.getTotalElements());
    }
}
