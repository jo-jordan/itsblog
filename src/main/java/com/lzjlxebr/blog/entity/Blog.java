package com.lzjlxebr.blog.entity;

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
    private Long id;
}
