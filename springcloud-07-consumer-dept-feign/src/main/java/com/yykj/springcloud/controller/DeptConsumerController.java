package com.yykj.springcloud.controller;

import com.yykj.springcloud.pojo.Dept;
import com.yykj.springcloud.service.IDeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 消费者: 远程调用方法
 */
@Controller
public class DeptConsumerController {

    /**
     * springcloud-01-api中定义的service
     */
    @Autowired
    private IDeptClientService deptClientService;

    /**
     * 远程调取Controller方法
     * @param id
     * @return
     */
    @GetMapping("/consumer/dept/{id}")
    @ResponseBody
    public Dept get(@PathVariable("id") long id){
        return deptClientService.queryByID(id);
    }

    /**
     * 远程调取Controller方法
     */
    @PostMapping("/consumer/dept/add")
    @ResponseBody
    public boolean add(Dept dept){
        return deptClientService.addDept(dept);
    }

    /**
     * 远程调取Controller方法
     */
    @GetMapping("/consumer/dept/list")
    @ResponseBody
    public List<Dept> query() {
        return deptClientService.queryAll();
    }

}
