package com.example.core.member;

import com.example.core.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        Member member1 = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member1);

        Member findMember1 = memberService.findMember(1L);
        System.out.println("findMember = " + findMember1.getName());
        System.out.println("Member = " + member1.getName());
    }
}
