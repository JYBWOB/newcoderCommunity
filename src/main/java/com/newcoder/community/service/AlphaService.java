package com.newcoder.community.service;

import com.newcoder.community.dao.AlphaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
//@Scope("prototype") //prototype 每次实例化一个， singleton是默认的，是单例的意思
public class AlphaService {

    @Autowired
    private AlphaDao alphaDao;

    public String find() {
        return alphaDao.select();
    }

    public AlphaService() {
        System.out.println("实例化Service");
    }

    @PostConstruct
    public void init() {
        System.out.println("初始化Service");
    }

    @PreDestroy
    public void destory() {
        System.out.println("销毁Service");
    }
}
