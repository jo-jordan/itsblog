package com.lzjlxebr.blog.controller;

import com.lzjlxebr.blog.base.ResponseEntity;
import com.lzjlxebr.blog.entity.Blog;
import com.lzjlxebr.blog.service.BlogService;
import com.lzjlxebr.blog.service.BlogSourceService;
import com.lzjlxebr.blog.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * BlogAppController
 * <p>
 * Description write in here.
 *
 * @author : lzjlxebr
 * @date : 2019-10-20 21:58
 **/
@RestController
@RequestMapping("/app/blog")
public class BlogAppController {
    @Autowired
    private BlogService blogService;

    @Autowired
    private BlogSourceService blogSourceService;

    @GetMapping(value = "/list")
    public ResponseEntity list(
            @RequestParam(value = "next") Integer next,
            @RequestParam(value = "keyword") String keyword) {
        Page<Blog> blogs = blogService.findAllByPublished(0, 10, "%" + keyword + "%");
        return ResponseUtil.success(blogs.getContent());
    }

    @GetMapping("/find-by-id")
    public ResponseEntity findById(@RequestParam("id") Long id) {
        return ResponseUtil.success(blogSourceService.findById(id));
    }
}
