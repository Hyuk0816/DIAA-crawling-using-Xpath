package com.jpabook.jpashop.domain.member.service;


import com.jpabook.jpashop.domain.member.Entity.Member;
import com.jpabook.jpashop.domain.member.Repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    //회원 가입
    @Transactional //따로 설정은 우선권을 가짐
    public Long join(Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        //중복 회원이면 예외 처리
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if (!findMembers.isEmpty()) {
            throw new IllegalArgumentException("이미 존재하는 회원입니다");
        }
    }

    //회원 전체 조회
    public List<Member> findMembers(){return memberRepository.findAll();}

    //하나의 회원 조회
    public Member findOne(Long id){return memberRepository.findOne(id);}

}
