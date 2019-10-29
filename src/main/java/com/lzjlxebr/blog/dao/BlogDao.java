package com.lzjlxebr.blog.dao;

import com.lzjlxebr.blog.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * BlogDao
 * <p>
 * Description write in here.
 *
 * @author : lzjlxebr
 * @date : 2019-08-26 15:15
 **/
public interface BlogDao extends JpaRepository<Blog, Long> {
    @Query("select a from Blog a where lower(a.title) like lower(:keyword)")
    Page<Blog> findAllByKeyword(@Param("keyword") String keyword, Pageable pageable);

    Page<Blog> findAllByStatus(String published, Pageable pageable);

    @Query("select a from Blog a where a.status = :status and lower(a.title) like lower(:keyword)")
    Page<Blog> findAllByStatusAndKeyword(@Param("status") String status, @Param("keyword") String keyword, Pageable pageable);
}
