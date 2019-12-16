package com.lzjlxebr.blog.base;

import com.lzjlxebr.blog.service.BlogService;
import com.lzjlxebr.blog.service.BlogSourceService;
import com.lzjlxebr.blog.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * BaseController
 * <p>
 * Description write in here.
 *
 * @author : lzjlxebr
 * @date : 2019-12-14 15:44
 **/
@RestController
public abstract class BaseController {
    @Autowired
    protected BlogService blogService;

    @Autowired
    protected BlogSourceService blogSourceService;

    @Autowired
    protected VisitorService visitorService;

}
