package com.slipper.springcorestudy;

import com.slipper.springcorestudy.discount.FixDiscountPolicy;
import com.slipper.springcorestudy.member.MemberService;
import com.slipper.springcorestudy.member.MemberServiceImpl;
import com.slipper.springcorestudy.member.MemoryMemberRepository;
import com.slipper.springcorestudy.order.OrderService;
import com.slipper.springcorestudy.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
