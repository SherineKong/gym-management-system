package com.astfitness;

import com.astfitness.mapper.MemberMapper;
import com.astfitness.pojo.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;


@SpringBootTest
class GymManagementSystemApplication {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    MemberMapper memberMapper;


    @Test
    void contextLoads() {
        Long aLong = jdbcTemplate.queryForObject("select count(*) from admin", Long.class);
        System.out.println("total number of records" + aLong);
    }

    @Test
    public void run() throws Exception {
        List<Member> list = memberMapper.findAll();
        for (Member member : list) {
            System.out.println(member);
        }

        Integer total = memberMapper.selectTotalCount();
        System.out.println(total);
    }

}
