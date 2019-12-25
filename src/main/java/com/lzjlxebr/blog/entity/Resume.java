package com.lzjlxebr.blog.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Resume
 * <p>
 * Description write in here.
 *
 * @author : lzjlxebr
 * @date : 2019-12-18 12:56
 **/
@Entity
@Table(name = "resume")
public class Resume {
    @Id
    private Long id;

    @Column(name = "field_name", length = 300, nullable = false)
    private String name;

    @Column(name = "field_value", length = 3000, nullable = false)
    private String value;

    public Resume() {
    }

    public Resume(Long id, String name, String value) {
        this.id = id;
        this.name = name;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
