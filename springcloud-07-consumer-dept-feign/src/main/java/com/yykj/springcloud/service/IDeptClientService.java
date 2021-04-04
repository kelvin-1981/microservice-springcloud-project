package com.yykj.springcloud.service;

import com.yykj.springcloud.pojo.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @FeignClient:微服务客户端注解,value:指定微服务的名字,这样就可以使Feign客户端直接找到对应的微服务
 */
@FeignClient(value = "springcloud-provider-dept", fallbackFactory = DeptClientServiceFallBackFactory.class)
public interface IDeptClientService {

    @GetMapping("/dept/get/{id}")
    public Dept queryByID(@PathVariable("id") long id);

    @GetMapping("/dept/list")
    public List<Dept> queryAll();

    @PostMapping("/dept/add")
    public boolean addDept(Dept dept);
}
