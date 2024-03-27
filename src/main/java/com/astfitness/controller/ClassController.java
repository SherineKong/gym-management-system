package com.astfitness.controller;

import com.astfitness.pojo.ClassOrder;
import com.astfitness.pojo.ClassTable;
import com.astfitness.service.ClassOrderService;
import com.astfitness.service.ClassTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;



@Controller
@RequestMapping("/class")
public class ClassController {

    @Autowired
    private ClassTableService classTableService;

    @Autowired
    private ClassOrderService classOrderService;

    //Class enquiry
    @RequestMapping("/selClass")
    public String selectClass(Model model) {
        List<ClassTable> classList = classTableService.findAll();
        model.addAttribute("classList", classList);
        return "selectClass";
    }

    //switch to new add class page
    @RequestMapping("/toAddClass")
    public String toAddClass() {
        return "addClass";
    }

    //add class
    @RequestMapping("/addClass")
    public String addClass(ClassTable classTable) {
        classTableService.insertClass(classTable);
        return "redirect:selClass";
    }

    //delete class
    @RequestMapping("/delClass")
    public String deleteClass(Integer classId) {
        classTableService.deleteClassByClassId(classId);
        classTableService.deleteOrderByClassId(classId);
        return "redirect:selClass";
    }

    //inquiry for class order
    @RequestMapping("/selClassOrder")
    public String selectClassOrder(Integer classId, Model model) {
        List<ClassOrder> classOrderList = classOrderService.selectMemberOrderList(classId);
        model.addAttribute("classOrderList", classOrderList);
        return "selectClassOrder";
    }

}
