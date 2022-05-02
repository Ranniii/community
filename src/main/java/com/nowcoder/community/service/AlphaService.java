package com.nowcoder.community.service;

import com.nowcoder.community.dao.AlphaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
//@Scope("prototype")
public class AlphaService {

    public AlphaService() {
        System.out.println("instantiate alphaservice.");
    }

    @PostConstruct
    public void init() {
        System.out.println("initialize alphaservice.");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("destroy alphaservice.");
    }

    @Autowired
    private AlphaDao alphaDao;

    public String find() {
        return alphaDao.select();
    }
}
