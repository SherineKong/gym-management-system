package com.astfitness.mapper;

import com.astfitness.pojo.ClassOrder;
import org.apache.ibatis.annotations.*;

import java.util.List;



@Mapper
public interface ClassOrderMapper {

    //Query all registration  information
    List<ClassOrder> findAll();

    //Add registration information
    Boolean insertClassOrder(ClassOrder classOrder);

    //Query personal registration schedule based on userID
    List<ClassOrder> selectClassOrderByMemberAccount(Integer memberAccount);

    //Delete a scheduled course
    Boolean deleteByClassOrderId(Integer classOrderId);

    //Check whether members have registered for the course
    ClassOrder selectMemberByClassIdAndMemberAccount(Integer classId, Integer memberAccount);

    //Query all registered members based on course ID
    List<ClassOrder> selectMemberOrderList(Integer classId);

}
