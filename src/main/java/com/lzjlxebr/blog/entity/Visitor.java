package com.lzjlxebr.blog.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Statistics
 * <p>
 * Description write in here.
 *
 * @author : lzjlxebr
 * @date : 2019-10-19 13:56
 **/
@Entity
@Table(name = "Visitor")
public class Visitor {
    @Id
    @Column
    private Long id;

    @Column
    private String address;

    @Column
    private String lastTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLastTime() {
        return lastTime;
    }

    public void setLastTime(String lastTime) {
        this.lastTime = lastTime;
    }
}
