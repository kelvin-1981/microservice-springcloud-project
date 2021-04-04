package com.yykj.springcloud.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.io.Serializable;

/**
 * 网络传输需要继承Serializable
 */
@Data
@NoArgsConstructor
@Accessors(chain = true) //链式写法注解
public class Dept implements Serializable {

    //主键自增
    private long deptno;
    //部门名称
    private String dname;
    //区分数据库
    private String db_source;

    /**
     * 有参构造
     * @param dname
     */
    public Dept(String dname) {
        this.dname = dname;
    }
}