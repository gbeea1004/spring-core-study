package com.slipper.springcorestudy.member;

public interface MemberRepository {
    void save(Member member);

    Member findById(Long memberId);
}
