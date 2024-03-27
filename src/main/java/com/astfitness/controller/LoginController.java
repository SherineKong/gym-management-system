package com.astfitness.controller;

import com.astfitness.pojo.Admin;
import com.astfitness.pojo.Member;
import com.astfitness.service.AdminService;
import com.astfitness.service.EmployeeService;
import com.astfitness.service.EquipmentService;
import com.astfitness.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;


@Controller
public class LoginController {

    @Autowired
    private MemberService memberService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EquipmentService equipmentService;

    //link to admin login page
    @RequestMapping("/")
    public String toAdminLogin() {
        return "adminLogin";
    }

    //link to member login page
    @RequestMapping("/toUserLogin")
    public String toUserLogin() {
        return "userLogin";
    }

    //admin login
    @RequestMapping("/adminLogin")
    public String adminLogin(Admin admin, Model model, HttpSession session) {
        Admin admin1 = adminService.adminLogin(admin);
        if (admin1 != null) {
            //Number of members
            Integer memberTotal = memberService.selectTotalCount();
            model.addAttribute("memberTotal", memberTotal);
            session.setAttribute("memberTotal", memberTotal);

            //Number of employees
            Integer employeeTotal = employeeService.selectTotalCount();
            model.addAttribute("employeeTotal", employeeTotal);
            session.setAttribute("employeeTotal", employeeTotal);

            //Total number of people in the gym
            Integer humanTotal = memberTotal + employeeTotal;
            model.addAttribute("humanTotal", humanTotal);
            session.setAttribute("humanTotal", humanTotal);

            //Number of equipment
            Integer equipmentTotal = equipmentService.selectTotalCount();
            model.addAttribute("equipmentTotal", equipmentTotal);
            session.setAttribute("equipmentTotal", equipmentTotal);

            return "adminMain";
        }
        model.addAttribute("msg", "The account number or password you entered is incorrect, please re-enter it!");
        return "adminLogin";
    }

    //member login
    @RequestMapping("/userLogin")
    public String userLogin(Member member, Model model, HttpSession session) {
        Member member1 = memberService.userLogin(member);
        if (member1 != null) {
            model.addAttribute("member", member1);
            session.setAttribute("user", member1);
            return "userMain";
        }
        model.addAttribute("msg", "The account number or password you entered is incorrect, please re-enter it!");
        return "userLogin";
    }

    //link to admin homepage
    @RequestMapping("/toAdminMain")
    public String toAdminMain(Model model, HttpSession session) {
        Integer memberTotal = (Integer) session.getAttribute("memberTotal");
        Integer employeeTotal = (Integer) session.getAttribute("employeeTotal");
        Integer humanTotal = (Integer) session.getAttribute("humanTotal");
        Integer equipmentTotal = (Integer) session.getAttribute("equipmentTotal");
        model.addAttribute("memberTotal", memberTotal);
        model.addAttribute("employeeTotal", employeeTotal);
        model.addAttribute("humanTotal", humanTotal);
        model.addAttribute("equipmentTotal", equipmentTotal);
        return "adminMain";
    }

    //link to member homepage
    @RequestMapping("/toUserMain")
    public String toUserMain(Model model, HttpSession session) {
        Member member = (Member) session.getAttribute("user");
        model.addAttribute("member", member);
        return "userMain";
    }

}
