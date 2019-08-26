package com.lzjlxebr.blog.service.impl;

import com.lzjlxebr.blog.dao.BlogDao;
import com.lzjlxebr.blog.entity.Blog;
import com.lzjlxebr.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

/**
 * BlogServiceImpl
 * <p>
 * Description write in here.
 *
 * @author : lzjlxebr
 * @date : 2019-08-26 15:42
 **/
@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogDao dao;
    @Override
    public void insert(Blog entity) {
        dao.saveAndFlush(entity);
    }

    @Override
    public void insertInBatch(Iterable<Blog> entities) {
        dao.saveAll(entities);
    }

    @Override
    public void update(Blog entity) {
        dao.saveAndFlush(entity);
    }

    @Override
    public void updateInBatch(Iterable<Blog> entities) {
        dao.saveAll(entities);
    }

    @Override
    public Blog findById(Long id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    public Page<Blog> findAll(Integer page, Integer size) {
        Sort sort = Sort.by("id").descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return dao.findAll(pageable);
    }

    @Override
    public void deleteById(Long id) {
        dao.deleteById(id);
    }

    @Override
    public void delete(Blog entity) {
        dao.delete(entity);
    }

    @Override
    public void deleteInBatch(Iterable<Blog> entities) {
        dao.deleteInBatch(entities);
    }
}
