package com.lzjlxebr.blog.service.impl;

import com.lzjlxebr.blog.dao.BlogSourceDao;
import com.lzjlxebr.blog.entity.BlogSource;
import com.lzjlxebr.blog.service.BlogSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * BlogSourceServiceImpl
 * <p>
 * Description write in here.
 *
 * @author : lzjlxebr
 * @date : 2019-10-20 23:23
 **/
@Service
public class BlogSourceServiceImpl implements BlogSourceService {
    @Autowired
    private BlogSourceDao dao;

    @Override
    public void insert(BlogSource entity) {
        dao.saveAndFlush(entity);
    }

    @Override
    public void insertInBatch(Iterable<BlogSource> entities) {

    }

    @Override
    public void update(BlogSource entity) {

    }

    @Override
    public void updateInBatch(Iterable<BlogSource> entities) {

    }

    @Override
    public BlogSource findById(Long id) {
        Optional<BlogSource> optionalBlogSource = dao.findById(id);
        return optionalBlogSource.orElse(null);
    }

    @Override
    public Page<BlogSource> findAll(Integer page, Integer size, String keyword) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void delete(BlogSource entity) {

    }

    @Override
    public void deleteInBatch(Iterable<BlogSource> entities) {

    }
}
