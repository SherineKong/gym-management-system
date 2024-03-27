package com.astfitness.mapper;

import com.astfitness.pojo.ClassTable;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface ClassTableMapper {

    //Search all courses
    List<ClassTable> findAll();

    //Delete a course based on id
    Boolean deleteClassByClassId(Integer classId);

    //Add course
    Boolean insertClass(ClassTable classTable);

    //Query class schedule based on id
    ClassTable selectByClassId(Integer classId);

    //Delete scheduled courses based on ID
    Boolean deleteOrderByClassId(Integer classId);

}
