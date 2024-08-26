package com.example.core1.order;

import com.example.core1.discount.Order;
import com.example.core1.discount.OrderService;
import com.example.core1.discount.OrderServiceImpl;
import com.example.core1.member.Grade;
import com.example.core1.member.Member;
import com.example.core1.member.MemberService;
import com.example.core1.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder(){
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
