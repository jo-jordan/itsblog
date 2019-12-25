package com.lzjlxebr.blog.service.impl;

import com.lzjlxebr.blog.dao.BlogDao;
import com.lzjlxebr.blog.dao.VisitorDao;
import com.lzjlxebr.blog.service.StatisticsService;
import com.lzjlxebr.blog.util.DataTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * StatisticsServiceImpl
 * <p>
 * Description write in here.
 *
 * @author : lzjlxebr
 * @date : 2019-12-18 22:07
 **/
@Service
public class StatisticsServiceImpl implements StatisticsService {

    @Autowired
    private BlogDao blogDao;

    @Autowired
    private VisitorDao visitorDao;

    @Override
    public Object getBlogStatistics() {
        java.util.Date date = DataTimeUtil.getCurrentDateTime();
        java.util.Date dateUtil = DataTimeUtil.setDate(date, Calendar.DATE, -90);
        Date sqlDate = DataTimeUtil.convertUtilDateToSQLDate(dateUtil);

        List<Object> list = blogDao.getBlogStatistics(sqlDate);

        return resolveResult(list);
    }

    @Override
    public Object getVisitStatistics() {
        java.util.Date date = DataTimeUtil.getCurrentDateTime();
        java.util.Date dateUtil = DataTimeUtil.setDate(date, Calendar.DATE, -90);
        Date sqlDate = DataTimeUtil.convertUtilDateToSQLDate(dateUtil);

        List<Object> list = visitorDao.getVisitStatistics(sqlDate);

        return resolveResult(list);
    }

    @Override
    public Object getBlogReadStatistics() {
        java.util.Date date = DataTimeUtil.getCurrentDateTime();
        java.util.Date dateUtil = DataTimeUtil.setDate(date, Calendar.DATE, -90);
        Date sqlDate = DataTimeUtil.convertUtilDateToSQLDate(dateUtil);

        List<Object> list = blogDao.getBlogReadStatistics(sqlDate);

        return resolveResult(list);
    }

    private Object resolveResult(List<Object> list) {
        EChartDataEntity eChartDataEntity = new EChartDataEntity();
        eChartDataEntity.setX(new ArrayList<>(list.size()));
        eChartDataEntity.setY(new ArrayList<>(list.size()));
        for (Object o : list) {
            if (o instanceof Object[]) {
                Object[] arr = (Object[]) o;
                if (arr[0] instanceof Date) {
                    java.util.Date date = (Date) arr[0];
                    long count = (Long) arr[1];
                    eChartDataEntity.getX().add(DataTimeUtil.convertDateToString(date));
                    eChartDataEntity.getY().add(count);
                }

                if (arr[0] instanceof String) {
                    String name = (String) arr[0];
                    int count = (Integer) arr[1];
                    eChartDataEntity.getX().add(name);
                    eChartDataEntity.getY().add(count);
                }
            }
        }
        return eChartDataEntity;
    }

    private static class EChartDataEntity {
        private List<Object> x;
        private List<Object> y;

        public List<Object> getX() {
            return x;
        }

        public void setX(List<Object> x) {
            this.x = x;
        }

        public List<Object> getY() {
            return y;
        }

        public void setY(List<Object> y) {
            this.y = y;
        }
    }
}
