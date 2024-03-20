package com.jpabook.jpashop.domain.member.Repository;

import com.jpabook.jpashop.domain.member.Entity.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    //spring data jpa autowired 로 의존성 주입 해줌 // 그래서 RequiredArgs가 먹힘
    private final EntityManager em;

    public void save(Member member){
        em.persist(member);
    }

    public Member findOne(Long id){
        return em.find(Member.class, id);
    }

    public List<Member> findAll(){
        //jpql 은 member에 대한 엔티티를 대상으로 쿼리를 날림
        return em.createQuery("select m from  Member m", Member.class).getResultList();
    }

    public List<Member> findByName(String name){
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }



}
