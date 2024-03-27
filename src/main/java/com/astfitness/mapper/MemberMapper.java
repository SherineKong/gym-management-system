package com.astfitness.mapper;

import com.astfitness.pojo.Member;
import org.apache.ibatis.annotations.*;

import java.util.List;



@Mapper
public interface MemberMapper {

    //Query member information
    List<Member> findAll();

    //Add member information
    Boolean insertMember(Member member);

    //Modify member information based on userID
    Boolean updateMemberByMemberAccount(Member member);

    //Query member account password
    Member selectByAccountAndPassword(Member member);

    //Delete member information based on userID
    Boolean deleteByMemberAccount(Integer memberAccount);

    //Query the number of members
    Integer selectTotalCount();

    //Query members based on member account
    List<Member> selectByMemberAccount(Integer memberAccount);

}
