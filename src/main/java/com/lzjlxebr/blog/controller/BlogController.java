package com.lzjlxebr.blog.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lzjlxebr.blog.base.ResponseEntity;
import com.lzjlxebr.blog.entity.Blog;
import com.lzjlxebr.blog.entity.BlogSource;
import com.lzjlxebr.blog.service.BlogService;
import com.lzjlxebr.blog.service.BlogSourceService;
import com.lzjlxebr.blog.util.DataTimeUtil;
import com.lzjlxebr.blog.util.IdUtil;
import com.lzjlxebr.blog.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
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

    @Autowired
    private BlogSourceService blogSourceService;

    @PostMapping("/insert")
    public ResponseEntity insert(HttpServletRequest request, @RequestBody String requestBody) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(requestBody);

        Blog blog = new Blog();
        Long id = IdUtil.nextId();
        String title = node.get("title").asText("Untitled");
        String blogSourceString = node.get("blogSource").asText();
        String blogHtml = node.get("blogHtml").asText();
        Integer lines = node.get("lines").asInt();
        Integer words = node.get("words").asInt();
        String status = "draft";

        blog.setId(id);
        blog.setTitle(title);
        BlogSource blogSource = new BlogSource();
        blogSource.setId(IdUtil.nextId());
        blogSource.setBlogHtml(blogHtml.getBytes(StandardCharsets.UTF_8));
        blogSource.setBlogSource(blogSourceString.getBytes(StandardCharsets.UTF_8));
        blogSourceService.insert(blogSource);
        blog.setBlogSourceId(blogSource.getId());
        blog.setLines(lines);
        blog.setWords(words);
        blog.setCreateTime(DataTimeUtil.getCurrentDateTime());
        blog.setStatus(status);
        blog.setLikeCount(0);
        blog.setReadCount(0);
        blog.setReadDuration(words / 300 + "");

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

    @PostMapping("/archive")
    public ResponseEntity archiveBlog(@RequestBody String requestBody) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(requestBody);

        Long id = node.get("id").asLong();
        Blog blog = blogService.findById(id);
        if(blog == null) {
            return ResponseUtil.failed("Blog was gone.");
        }

        blog.setStatus("archived");
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
        String blogSourceString = node.get("blogSource").asText();
        String blogHtml = node.get("blogHtml").asText();
        Integer lines = node.get("lines").asInt();
        Integer words = node.get("words").asInt();
        String status = "draft";

        blog.setId(id);
        blog.setTitle(title);
        BlogSource blogSource = blogSourceService.findById(blog.getBlogSourceId());
        blogSource.setBlogHtml(blogHtml.getBytes(StandardCharsets.UTF_8));
        blogSource.setBlogSource(blogSourceString.getBytes(StandardCharsets.UTF_8));
        blogSourceService.update(blogSource);
        blog.setLines(lines);
        blog.setWords(words);
        blog.setUpdateTime(DataTimeUtil.getCurrentDateTime());
        blog.setStatus(status);

        blogService.update(blog);

        return ResponseUtil.success();
    }

    @PostMapping("/info-update")
    public ResponseEntity infoUpdate(HttpServletRequest request, @RequestBody String requestBody) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(requestBody);

        Long id = node.get("id").asLong();
        Blog blog = blogService.findById(id);
        if(blog == null) {
            return ResponseUtil.failed("Blog was gone.");
        }
        String title = node.get("title").asText("Untitled");
        String tags = node.get("tags").asText("NULL");
        String icon = node.get("icon").asText("NULL");
        String category = node.get("category").asText("NULL");

        blog.setId(id);
        blog.setTitle(title);

        blog.setUpdateTime(DataTimeUtil.getCurrentDateTime());
        blog.setTitle(title);
        blog.setCategory(category);
        blog.setIcon(icon);

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

    @GetMapping("/find-by-id")
    public ResponseEntity findById(@RequestParam("id") Long id) {
        return ResponseUtil.success(blogSourceService.findById(id));
    }
}
