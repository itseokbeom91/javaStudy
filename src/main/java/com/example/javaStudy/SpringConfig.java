package com.example.javaStudy;

import com.example.javaStudy.repository.JdbcMemberRepository;
import com.example.javaStudy.repository.MemberRepository;
import com.example.javaStudy.repository.MemoryMemberRepository;
import com.example.javaStudy.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

// 해당 config 파일로 각 service, repository에 @ 안붙임
@Configuration
public class SpringConfig {

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){

        //return new MemoryMemberRepository();
        return new JdbcMemberRepository(dataSource);
    }
}
