package com.yykj.springcloud.service;

import com.yykj.springcloud.pojo.Dept;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IDeptService {

    /**
     * 添加部门
     * @param dept
     * @return
     */
    public boolean addDept(Dept dept);

    /**
     * 根据ID查询部门
     * @param id
     * @return
     */
    public Dept queryById(@Param("deptno") long id);

    /**
     * 查询全部部门
     * @return
     */
    public List<Dept> queryall();
}
