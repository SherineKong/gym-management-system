package com.astfitness.mapper;

import com.astfitness.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface AdminMapper {

    Admin selectByAccountAndPassword(Admin admin);

}
