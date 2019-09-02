package com.lzjlxebr.blog.entity;

import javax.persistence.*;

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
    @Column
    private Long id;

    @Column
    private String title;

    @Column
    private Integer words;

    @Column(name = "total_lines")
    private Integer lines;

    /**
     * 状态
     * deleted
     * published
     * draft
     */
    @Column(name = "blog_status")
    private String status;

    @Column
    private String createTime;

    @Column
    private String updateTime;

    @Lob
    @Column
    private byte[] blogSource;

    @Lob
    @Column
    private byte[] blogHtml;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getWords() {
        return words;
    }

    public void setWords(Integer words) {
        this.words = words;
    }

    public Integer getLines() {
        return lines;
    }

    public void setLines(Integer lines) {
        this.lines = lines;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
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
