package com.astfitness.controller;

import com.astfitness.pojo.Equipment;
import com.astfitness.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping("/equipment")
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;

    //inquiry equipment
    @RequestMapping("/selEquipment")
    public String selectEquipment(Model model, HttpSession session) {
        List<Equipment> equipmentList = equipmentService.findAll();
        session.setAttribute("equipmentList", equipmentList);
        model.addAttribute("equipmentList", equipmentList);
        return "selectEquipment";
    }

    //delete equipment
    @RequestMapping("/delEquipment")
    public String deleteEquipment(Integer equipmentId) {
        equipmentService.deleteByEquipmentId(equipmentId);
        return "redirect:selEquipment";
    }

    //switch to update equipment page
    @RequestMapping("/toUpdateEquipment")
    public String toUpdateEquipment(Integer equipmentId, Model model) {
        List<Equipment> equipmentList = equipmentService.selectByEquipmentId(equipmentId);
        model.addAttribute("equipmentList", equipmentList);
        return "updateEquipment";
    }

    //update equipment
    @RequestMapping("/updateEquipment")
    public String updateEquipment(Equipment equipment) {
        equipmentService.updateEquipmentByEquipmentId(equipment);
        return "redirect:selEquipment";
    }

    //switch to add equipment page
    @RequestMapping("/toAddEquipment")
    public String toAddEquipment() {
        return "addEquipment";
    }

    //add equipment
    @RequestMapping("/addEquipment")
    public String addEquipment(Equipment equipment) {
        equipmentService.insertEquipment(equipment);
        return "redirect:selEquipment";
    }

}
