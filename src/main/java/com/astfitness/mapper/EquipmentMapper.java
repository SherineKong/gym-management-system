package com.astfitness.mapper;

import com.astfitness.pojo.Equipment;
import org.apache.ibatis.annotations.*;

import java.util.List;



@Mapper
public interface EquipmentMapper {

    //Search all equipment
    List<Equipment> findAll();

    //Delete equipment by id
    Boolean deleteByEquipmentId(Integer equipmentId);

    //Add equipment
    Boolean insertEquipment(Equipment equipment);

    //Modify equipment information based on ID
    Boolean updateEquipmentByEquipmentId(Equipment equipment);

    //Query equipment by id
    List<Equipment> selectByEquipmentId(Integer equipmentId);

    //Query the total number of equipment
    Integer selectTotalCount();

}
