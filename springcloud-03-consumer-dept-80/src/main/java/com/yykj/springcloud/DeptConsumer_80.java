package com.yykj.springcloud;

import com.yykj.springcloud.config.ConfigBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "SPRINGCLOUD-PROVIDER-DEPT",configuration = ConfigBean.class)//开启负载均衡,并指定自定义的规则
public class DeptConsumer_80 {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_80.class, args);
    }
}
