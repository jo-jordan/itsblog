package com.lzjlxebr.blog.entity;

import javax.persistence.*;

/**
 * BlogSource
 * <p>
 * Description write in here.
 *
 * @author : lzjlxebr
 * @date : 2019-10-20 23:16
 **/
@Entity
@Table(name = "blog_source")
public class BlogSource {
    @Id
    @Column
    private Long id;

    @Lob
    @Column
    private byte[] blogSource;

    @Lob
    @Column
    private byte[] blogHtml;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getBlogSource() {
        return blogSource;
    }

    public void setBlogSource(byte[] blogSource) {
        this.blogSource = blogSource;
    }

    public byte[] getBlogHtml() {
        return blogHtml;
    }

    public void setBlogHtml(byte[] blogHtml) {
        this.blogHtml = blogHtml;
    }
}
