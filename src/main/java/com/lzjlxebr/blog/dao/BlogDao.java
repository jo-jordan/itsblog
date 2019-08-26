package com.lzjlxebr.blog.dao;

import com.lzjlxebr.blog.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * BlogDao
 * <p>
 * Description write in here.
 *
 * @author : lzjlxebr
 * @date : 2019-08-26 15:15
 **/
public interface BlogDao extends JpaRepository<Blog, Long> {
}
