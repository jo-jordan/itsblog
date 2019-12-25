package com.lzjlxebr.blog.dao;

import com.lzjlxebr.blog.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

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

    Blog findByBlogSourceId(Long id);

    @Query("SELECT a.createDate, count(a.createDate) FROM Blog a " +
            "where a.createDate > ?1 " +
            "group by a.createDate")
    List<Object> getBlogStatistics(Date sqlDate);

    @Query("SELECT a.title, a.readCount FROM Blog a " +
            "where a.createDate > ?1 " +
            "and a.status='published' ")
    List<Object> getBlogReadStatistics(Date sqlDate);
}
