package com.jpabook.jpashop.domain.order;

import com.jpabook.jpashop.domain.member.Entity.Address;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Delivery {

    @Id @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    private Orders orders;

    private Address address;

    @Enumerated(EnumType.STRING) //꼭 string 을 쓸 것 나중에 상태 추가 되면 값이 밀려서 달라짐
    private DeliveryStatus status; //READY, COMP(배송)




}
