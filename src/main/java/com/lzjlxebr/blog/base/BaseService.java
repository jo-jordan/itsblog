package com.lzjlxebr.blog.base;

import org.springframework.data.domain.Page;

import java.util.Collection;

/**
 * BaseService
 * <p>
 * Description write in here.
 *
 * @author : lzjlxebr
 * @date : 2019-08-26 15:32
 **/
public interface BaseService<T> {
    /**
     * 新增单条数据
     *
     * @param entity 实体类
     */
    void insert(T entity);

    /**
     * 新增多条数据
     *
     * @param entities 实体类集合
     */
    void insertInBatch(Iterable<T> entities);

    /**
     * 更新单条数据
     *
     * @param entity 实体类
     */
    void update(T entity);

    /**
     * 更新多条数据
     *
     * @param entities 实体类集合
     */
    void updateInBatch(Iterable<T> entities);

    /**
     * 根据数据唯一标识查找数据
     *
     * @param id 数据唯一标识
     * @return 数据实体类
     */
    T findById(Long id);

    /**
     * 分页查找数据
     *
     * @param page 页码
     * @param size 一页数据条数
     * @param keyword 搜索关键词
     * @return 分页信息对象
     */
    Page<T> findAll(Integer page, Integer size, String keyword);

    /**
     * 根据数据唯一标识删除数据
     *
     * @param id 数据唯一标识
     */
    void deleteById(Long id);

    /**
     * 删除数据
     *
     * @param entity 实体类
     */
    void delete(T entity);

    /**
     * 批量删除
     *
     * @param entities 实体类集合
     */
    void deleteInBatch(Iterable<T> entities);
}
