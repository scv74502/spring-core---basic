package com.example.core.discount;

import com.example.core.member.Grade;
import com.example.core.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 되어야 함")
    void vip_o(){
        //Given
        Member member = new Member(1L, "memberVip", Grade.VIP);
        // When
        int discount = discountPolicy.discount(member, 10000);
        // Then
        assertThat(discount).isEqualTo(1000);

    }

    @Test
    @DisplayName("VIP가 아니면 10% 할인이 안 되어야 함")
    void vip_x(){
        //Given
        Member member = new Member(2L, "memberNormal", Grade.BASIC);
        // When
        int discount = discountPolicy.discount(member, 10000);
        // Then
        assertThat(discount).isEqualTo(0);

    }
}