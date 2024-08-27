package com.example.core1.member;

import com.example.core1.AppConfig;

public class MemberApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        Member member1 = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member1);

        Member findMember1 = memberService.findMember(1L);
        System.out.println("findMember = " + findMember1.getName());
        System.out.println("Member = " + member1.getName());
    }
}
