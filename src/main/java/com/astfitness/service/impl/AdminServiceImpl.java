package com.astfitness.service.impl;

import com.astfitness.mapper.AdminMapper;
import com.astfitness.pojo.Admin;
import com.astfitness.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin adminLogin(Admin admin) {
        return adminMapper.selectByAccountAndPassword(admin);
    }
}
