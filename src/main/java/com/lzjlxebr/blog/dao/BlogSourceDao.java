package com.lzjlxebr.blog.dao;

import com.lzjlxebr.blog.entity.BlogSource;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * BlogSourceDao
 * <p>
 * Description write in here.
 *
 * @author : lzjlxebr
 * @date : 2019-10-20 23:22
 **/
public interface BlogSourceDao extends JpaRepository<BlogSource, Long> {
}
