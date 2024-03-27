package com.astfitness.service;

import com.astfitness.pojo.Member;

import java.util.List;



public interface MemberService {

    //Query member information
    List<Member> findAll();

    //Add member information
    Boolean insertMember(Member member);

    //Modify member information based on userID
    Boolean updateMemberByMemberAccount(Member member);

    //Query member account password (login)
    Member userLogin(Member member);
    //Member selectByAccountAndPassword(Member member);

    //Delete member information based on userID
    Boolean deleteByMemberAccount(Integer memberAccount);

    //Query the number of members
    Integer selectTotalCount();

    //Query members based on userID
    List<Member> selectByMemberAccount(Integer memberAccount);

}
