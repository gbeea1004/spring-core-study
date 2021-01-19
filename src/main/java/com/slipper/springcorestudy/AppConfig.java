package com.slipper.springcorestudy;

import com.slipper.springcorestudy.discount.DiscountPolicy;
import com.slipper.springcorestudy.discount.FixDiscountPolicy;
import com.slipper.springcorestudy.member.MemberRepository;
import com.slipper.springcorestudy.member.MemberService;
import com.slipper.springcorestudy.member.MemberServiceImpl;
import com.slipper.springcorestudy.member.MemoryMemberRepository;
import com.slipper.springcorestudy.order.OrderService;
import com.slipper.springcorestudy.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    private DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}
