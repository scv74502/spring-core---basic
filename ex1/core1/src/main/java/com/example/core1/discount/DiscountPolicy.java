package com.example.core1.discount;

import com.example.core1.member.Member;

public interface DiscountPolicy  {
    /**
     * @return 할인 대상 금액
     * */
    int discount(Member member, int price);
}
