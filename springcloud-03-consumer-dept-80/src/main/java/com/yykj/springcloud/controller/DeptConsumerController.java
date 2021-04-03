package com.yykj.springcloud.controller;

import com.yykj.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * 消费者: 远程调用方法
 */
@Controller
public class DeptConsumerController {

    /**
     * 我们这里的地址，应该是一个变量，通过服务名来访问
     */
    private static final String REST_URL_PREFIX = "http://SPRINGCLOUD-PROVIDER-DEPT";

    /**
     * RestTemplate 有很多方法给我们直接调用!它的类中没有Bean所以要我们自己把它注册到Bean中
     */
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 远程调取Controller方法
     * @param id
     * @return
     */
    @GetMapping("/consumer/dept/{id}")
    @ResponseBody
    public Dept get(@PathVariable("id") long id){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get" + id, Dept.class);
    }

    /**
     * 远程调取Controller方法
     */
    @PostMapping("/consumer/dept/add")
    @ResponseBody
    public boolean add(Dept dept){
        return restTemplate.postForObject(REST_URL_PREFIX+"dept/add", dept, boolean.class);
    }

    /**
     * 远程调取Controller方法
     */
    @GetMapping("/consumer/dept/list")
    @ResponseBody
    public List<Dept> query() {
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list", List.class);
    }

}
