package com.example.core1.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


public class MemberServiceTest {
    MemberService memberService = new MemberServiceImpl();

    @Test
    void joint(){
        // Given
        Member member1 = new Member(1L, "memberA", Grade.VIP);

        // when
        memberService.join(member1);
        Member findMember = memberService.findMember(1L);

        // then
        Assertions.assertThat(member1).isEqualTo(findMember);

    }
}
