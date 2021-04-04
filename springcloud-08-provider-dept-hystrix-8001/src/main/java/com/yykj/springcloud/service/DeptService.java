package com.yykj.springcloud.service;

import com.yykj.springcloud.dao.IDeptDao;
import com.yykj.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptService implements IDeptService{

    @Autowired
    private IDeptDao deptDao;

    @Override
    public boolean addDept(Dept dept) {
        return deptDao.addDept(dept);
    }

    @Override
    public Dept queryById(long id) {
        return deptDao.queryById(id);
    }

    @Override
    public List<Dept> queryall() {
        return deptDao.queryall();
    }
}
