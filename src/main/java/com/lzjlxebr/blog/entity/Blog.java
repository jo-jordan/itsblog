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
    private String icon;

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

    @Column
    private String keywords;

    @Column
    private String category;

    @Column
    private Integer readCount;

    @Column
    private Integer likeCount;

    @Column
    private String readDuration;

    @Column
    private String description;

    @Column
    private Long blogSourceId;


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

    public Long getBlogSourceId() {
        return blogSourceId;
    }

    public void setBlogSourceId(Long blogSourceId) {
        this.blogSourceId = blogSourceId;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getReadCount() {
        return readCount;
    }

    public void setReadCount(Integer readCount) {
        this.readCount = readCount;
    }

    public String getReadDuration() {
        return readDuration;
    }

    public void setReadDuration(String readDuration) {
        this.readDuration = readDuration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }
}
