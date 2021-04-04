package com.yykj.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.yykj.springcloud.pojo.Dept;
import com.yykj.springcloud.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 提供Restful服务
 */
@RestController
public class DeptController {

    @Autowired
    private IDeptService deptService;

    @GetMapping("/dept/get/{id}")
    @HystrixCommand(fallbackMethod = "hystrixGet")
    public Dept get(@PathVariable("id") long id) {
        Dept dept = deptService.queryById(id);
        if(dept == null){
            throw new RuntimeException("ID=>" + id + "不存在,或者信息无法找到!");
        }
        return dept;
    }

    public Dept hystrixGet(@PathVariable("id") long id) {
        return new Dept()
                .setDeptno(id)
                .setDname("ID=>" + id + "不存在,或者信息无法找到! Hystrix")
                .setDb_source("no database in mysqsl");
    }
}
