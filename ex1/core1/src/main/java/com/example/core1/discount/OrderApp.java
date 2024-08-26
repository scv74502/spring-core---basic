package com.example.core1.discount;

import com.example.core1.member.Grade;
import com.example.core1.member.Member;
import com.example.core1.member.MemberService;
import com.example.core1.member.MemberServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = "+order);
    }
}
