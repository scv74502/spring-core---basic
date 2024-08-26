package com.example.core1.discount;

import com.example.core1.member.Grade;
import com.example.core1.member.Member;

public class FixDicountPolicy implements DiscountPolicy{
    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        } else{
            return 0;
        }
    }
}
