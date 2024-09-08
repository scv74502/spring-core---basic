package com.example.core.member;

import com.example.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class MemberServiceTest {
    MemberService memberService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }


    @Test
    void join(){
        // Given
        Member member1 = new Member(1L, "memberA", Grade.VIP);

        // when
        memberService.join(member1);
        Member findMember = memberService.findMember(1L);

        // then
        Assertions.assertThat(member1).isEqualTo(findMember);

    }
}
