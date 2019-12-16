package com.lzjlxebr.blog.service.impl;

import com.lzjlxebr.blog.dao.VisitorDao;
import com.lzjlxebr.blog.entity.Visitor;
import com.lzjlxebr.blog.service.VisitorService;
import com.lzjlxebr.blog.util.DataTimeUtil;
import com.lzjlxebr.blog.util.IdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * VisitorServiceImpl
 * <p>
 * Description write in here.
 *
 * @author : lzjlxebr
 * @date : 2019-12-14 15:47
 **/
@Service
public class VisitorServiceImpl implements VisitorService {
    @Autowired
    private VisitorDao dao;
    @Override
    public void save(HttpServletRequest request) {
        String remoteAddr = request.getRemoteAddr();
        String localAddr = request.getLocalAddr();
        Visitor visitor = new Visitor();
        visitor.setRemoteAddr(remoteAddr);
        visitor.setLocalAddr(localAddr);
        visitor.setId(IdUtil.nextId());
        Date now = DataTimeUtil.getCurrentDateTime();
        visitor.setVisitTime(now);
        visitor.setVisitDate(now);
        dao.saveAndFlush(visitor);
    }
}
