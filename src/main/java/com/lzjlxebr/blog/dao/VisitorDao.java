package com.lzjlxebr.blog.dao;

import com.lzjlxebr.blog.entity.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;

/**
 * VisitorDao
 * <p>
 * Description write in here.
 *
 * @author : lzjlxebr
 * @date : 2019-12-14 15:46
 **/
public interface VisitorDao extends JpaRepository<Visitor, Long> {

    @Query("SELECT a.visitDate, count(a.visitDate) FROM Visitor a " +
            "where a.visitDate > ?1 " +
            "group by a.visitDate")
    List<Object> getVisitStatistics(Date sqlDate);
}
