package com.slipper.springcorestudy.discount;

import com.slipper.springcorestudy.member.Grade;
import com.slipper.springcorestudy.member.Member;

public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        }
        return 0;
    }
}
