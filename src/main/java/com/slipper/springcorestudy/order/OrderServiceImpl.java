package com.slipper.springcorestudy.order;

import com.slipper.springcorestudy.discount.DiscountPolicy;
import com.slipper.springcorestudy.discount.FixDiscountPolicy;
import com.slipper.springcorestudy.member.Member;
import com.slipper.springcorestudy.member.MemberRepository;
import com.slipper.springcorestudy.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
