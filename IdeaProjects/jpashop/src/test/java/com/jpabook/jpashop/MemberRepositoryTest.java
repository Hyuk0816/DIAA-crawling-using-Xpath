package com.jpabook.jpashop;

import com.jpabook.jpashop.domain.member.Entity.Member;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MemberRepositoryTest {
    @Autowired
    MemberRepository memberRepository;

    @Test
    @Transactional //테스트 케이스에 있으면 테스트가 끝난 뒤 롤백을 해버림, 그니까 없어짐 ㅎ
    //@Rollback(value = false) --> 이 옵션은 rollback을 막음
    public void testMember() throws Exception {

        //given
        Member member = new Member();
        member.setUserName("memberA");

        //when
        Long saveId = memberRepository.save(member);
        Member findMember = memberRepository.find(saveId);

        //then
        Assertions.assertEquals(saveId, member.getId());
        Assertions.assertEquals(findMember.getUserName(), member.getUserName());
        Assertions.assertEquals(member, findMember); //같은 영속성 컨텍스트라서 두 객체는 같게 나옴 --> 1차캐시
    }
}