package com.lzjlxebr.blog.dao;

import com.lzjlxebr.blog.entity.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * VisitorDao
 * <p>
 * Description write in here.
 *
 * @author : lzjlxebr
 * @date : 2019-12-14 15:46
 **/
public interface VisitorDao extends JpaRepository<Visitor, Long> {
}
