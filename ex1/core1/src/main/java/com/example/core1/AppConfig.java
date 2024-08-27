package com.example.core1;

import com.example.core1.discount.FixDicountPolicy;
import com.example.core1.discount.OrderService;
import com.example.core1.discount.OrderServiceImpl;
import com.example.core1.member.MemberService;
import com.example.core1.member.MemberServiceImpl;
import com.example.core1.member.MemoryMemberRepository;

public class AppConfig {

    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(
                new MemoryMemberRepository(),
                new FixDicountPolicy()
        );
    }
}
