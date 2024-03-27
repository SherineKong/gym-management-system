package com.astfitness.service;

import com.astfitness.pojo.Equipment;

import java.util.List;



public interface EquipmentService {

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
