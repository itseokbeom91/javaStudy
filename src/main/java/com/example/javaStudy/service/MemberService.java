package com.example.javaStudy.service;

import com.example.javaStudy.domain.Member;
import com.example.javaStudy.repository.MemberRepository;
import com.example.javaStudy.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public class MemberService {

    private final MemberRepository memberRepository; //  = new MemoryMemberRepository()

    // Test에서 사용하기 위해 위에 주석처리하고 아래 생성
    @Autowired
    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }


    /**
     *
     * 회원가입
     */
    public Long join(Member member){
        // 중복회원 체크
        validateDuplicateMember(member);

        memberRepository.save(member);
        return member.getId();
    }

    public void validateDuplicateMember(Member member){
        /** case1
         Optional<Member> result = memberRepository.findByName(member.getName());
         result.ifPresent(member1 -> {
         throw new IllegalStateException("이미 존재하는 회원입니다.")
         });
         */
        memberRepository.findByName(member.getName())
                .ifPresent(member1 -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체 회원조회
     */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
