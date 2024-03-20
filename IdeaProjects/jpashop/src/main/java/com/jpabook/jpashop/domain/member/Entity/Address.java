package com.jpabook.jpashop.domain.member.Entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter

public class Address {

    private String city;
    private String street;
    private String zipcode; //우편번호

    /**
     * JPA 스펙상 엔티티나 임베디드 타입은 자바 기본 생성자를 public 또는 protected로 설정 해야함
     * JPA가 이런 제약을 두는 이유는 jPA 구현 라이브러리가 객체를 생성할 때 리플렉션 같은 기술을 사용할 수 있도록
     * 지원해야 해서 --> 그래서 lombok에 NOARGS 를 두는 이유
     * 리플렉션: https://1-7171771.tistory.com/123
     *만약 인자가 있는 생성자를 정의하지 않았다면 자바에서 기본적으로 기본 생성자를 생성하기 떄문에 명시적으로 기본 생성자
     * 생성 안해도 된다!
     */
    protected Address(){}

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
