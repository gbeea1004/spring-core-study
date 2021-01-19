package com.slipper.springcorestudy;

import com.slipper.springcorestudy.discount.DiscountPolicy;
import com.slipper.springcorestudy.discount.RateDiscountPolicy;
import com.slipper.springcorestudy.member.MemberRepository;
import com.slipper.springcorestudy.member.MemberService;
import com.slipper.springcorestudy.member.MemberServiceImpl;
import com.slipper.springcorestudy.member.MemoryMemberRepository;
import com.slipper.springcorestudy.order.OrderService;
import com.slipper.springcorestudy.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
