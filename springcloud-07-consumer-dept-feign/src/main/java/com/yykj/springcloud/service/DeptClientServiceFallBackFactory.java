package com.yykj.springcloud.service;

import com.yykj.springcloud.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeptClientServiceFallBackFactory implements FallbackFactory {

    /**
     * 针对接口实现服务降级
     * @param throwable
     * @return
     */
    @Override
    public IDeptClientService create(Throwable throwable) {

        // TODO: 工厂返回IService 针对类实现服务降级
        return new IDeptClientService() {
            @Override
            public Dept queryByID(long id) {
                return new Dept()
                        .setDeptno(id)
                        .setDname("没有对应的信息，客户端服务降级生效，该服务已经关闭！")
                        .setDb_source("no data");
            }

            @Override
            public List<Dept> queryAll() {
                return null;
            }

            @Override
            public boolean addDept(Dept dept) {
                return false;
            }
        };
    }
}
