package com.itheima.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Emp;
import com.itheima.pojo.PageResult;
import com.itheima.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    //原始分页查询实现
//    @Override
//    public PageResult<Emp> page(Integer page, Integer pageSize) {
//        Long total = empMapper.count();
//
//        Integer start = (page - 1) * pageSize;
//        List<Emp> rows = empMapper.list(start, pageSize);
//
//        return new PageResult<Emp>(total, rows);
//    }
    @Override
    public PageResult<Emp> page(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);

        List<Emp> empList = empMapper.list();
        Page<Emp> p = (Page<Emp>) empList;

        return new PageResult<Emp>(p.getTotal(), p.getResult());
    }
}
