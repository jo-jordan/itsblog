package com.lzjlxebr.blog.controller;

import com.lzjlxebr.blog.base.ResponseEntity;
import com.lzjlxebr.blog.service.StatisticsService;
import com.lzjlxebr.blog.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * StatisticsController
 * <p>
 * Description write in here.
 *
 * @author : lzjlxebr
 * @date : 2019-12-18 22:02
 **/
@RestController
@RequestMapping("/statistics")
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    @GetMapping(value = "/blog")
    public ResponseEntity getBlogStatistics() {
        // 统计近30天的写作情况
        return ResponseUtil.success(statisticsService.getBlogStatistics());
    }

    @GetMapping(value = "/visit")
    public ResponseEntity getVisitStatistics() {
        // 统计近30天的访问情况
        return ResponseUtil.success(statisticsService.getVisitStatistics());
    }

    @GetMapping(value = "/blog-read")
    public ResponseEntity getBlogReadStatistics() {
        // 统计文章的阅读情况
        return ResponseUtil.success(statisticsService.getBlogReadStatistics());
    }
}
