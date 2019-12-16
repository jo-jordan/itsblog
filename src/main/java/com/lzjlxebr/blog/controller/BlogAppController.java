package com.lzjlxebr.blog.controller;

import com.lzjlxebr.blog.base.BaseController;
import com.lzjlxebr.blog.base.ResponseEntity;
import com.lzjlxebr.blog.entity.Blog;
import com.lzjlxebr.blog.util.ResponseUtil;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

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
public class BlogAppController extends BaseController {

    @GetMapping(value = "/list")
    public ResponseEntity list(
            @RequestParam(value = "next") Integer next,
            @RequestParam(value = "isArchived") Integer isArchived,
            @RequestParam(value = "keyword") String keyword) {
        Page<Blog> blogs = blogService.findAllByPublished(0, 10, "%" + keyword + "%", isArchived);
        return ResponseUtil.success(blogs.getContent());
    }

    @GetMapping("/find-by-id")
    public ResponseEntity findById(HttpServletRequest request, @RequestParam("id") Long id) {
        visitorService.save(request);
        Blog blog = blogService.findByBlogSourceId(id);
        Integer readCount = blog.getReadCount();
        if (readCount == null) {
            readCount = 0;
        }
        blog.setReadCount(readCount + 1);
        blogService.save(blog);
        return ResponseUtil.success(blogSourceService.findById(id));
    }
}
