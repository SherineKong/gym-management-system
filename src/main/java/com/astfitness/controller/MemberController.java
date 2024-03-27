package com.astfitness.controller;

import com.astfitness.pojo.Member;
import com.astfitness.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;



@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    //inquiry member
    @RequestMapping("/selMember")
    public String selectMember(Model model) {
        List<Member> memberList = memberService.findAll();
        model.addAttribute("memberList", memberList);
        return "selectMember";
    }

    //switch to add member page
    @RequestMapping("/toAddMember")
    public String toAddMember() {
        return "addMember";
    }

    //add member
    @RequestMapping("/addMember")
    public String addMember(Member member) {
        //automatic generate userID
        Random random = new Random();
        String account1 = "2021";
        for (int i = 0; i < 5; i++) {
            account1 += random.nextInt(10);
        }
        Integer account = Integer.parseInt(account1);

        //initial password
        String password = "123456";

        //get present date
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String nowDay = simpleDateFormat.format(date);

        Integer nextClass = member.getCardClass();

        member.setMemberAccount(account);
        member.setMemberPassword(password);
        member.setCardTime(nowDay);
        member.setCardNextClass(nextClass);

        memberService.insertMember(member);

        return "redirect:selMember";

    }

    //delete member
    @RequestMapping("/delMember")
    public String deleteMember(Integer memberAccount) {
        memberService.deleteByMemberAccount(memberAccount);
        return "redirect:selMember";
    }

    //switch to update member page
    @RequestMapping("/toUpdateMember")
    public String toUpdateMember(Integer memberAccount, Model model) {
        List<Member> memberList = memberService.selectByMemberAccount(memberAccount);
        model.addAttribute("memberList", memberList);
        return "updateMember";
    }

    //update member
    @RequestMapping("/updateMember")
    public String updateMember(Member member) {
        memberService.updateMemberByMemberAccount(member);
        return "redirect:selMember";
    }


    //switch to userID inquiry page
    @RequestMapping("/toSelByCard")
    public String toSelectByCardId() {
        return "selectByMemberAccount";
    }

    //inquiry according to userID
    @RequestMapping("/selByCard")
    public String selectByCardId(Model model, Integer memberAccount) {
        List<Member> memberList = memberService.selectByMemberAccount(memberAccount);
        if (memberList != null) {
            model.addAttribute("memberList", memberList);
        } else {
            String message = "The userID does not exist!";
            model.addAttribute("noMessage", message);
        }
        return "selectByMemberAccount";
    }

}
