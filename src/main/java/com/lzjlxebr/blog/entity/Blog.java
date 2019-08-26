package com.lzjlxebr.blog.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Blog
 * <p>
 * Description write in here.
 *
 * @author : lzjlxebr
 * @date : 2019-08-26 15:13
 **/
@Entity
@Table(name = "blog")
public class Blog {
    @Id
    @Column(name = "id")
    private Long id;

    public Blog() {
    }

    public Blog(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
