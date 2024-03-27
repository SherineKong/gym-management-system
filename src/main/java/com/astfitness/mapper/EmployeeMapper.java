package com.astfitness.mapper;

import com.astfitness.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;



@Mapper
public interface EmployeeMapper {

    //Query all employees
    List<Employee> findAll();

    //Delete employees based on staffID
    Boolean deleteByEmployeeAccount(Integer employeeAccount);

    //Add new employee
    Boolean insertEmployee(Employee employee);

    //Modify member information based on staffID
    Boolean updateMemberByEmployeeAccount(Employee employee);

    //Query employees based on staffID
    List<Employee> selectByEmployeeAccount(Integer employeeAccount);

    //Query the number of employees
    Integer selectTotalCount();

}
