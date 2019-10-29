package com.lzjlxebr.blog.entity;

import javax.persistence.*;

/**
 * OperationLog
 * <p>
 * Description write in here.
 *
 * @author : lzjlxebr
 * @date : 2019-10-19 13:58
 **/
@Entity
@Table(name = "Operation_Log")
public class OperationLog {
    @Id
    @Column
    private Long id;

    @Column
    private Long visitorId;

    @Column
    private Long blogId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(Long visitorId) {
        this.visitorId = visitorId;
    }

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }
}
