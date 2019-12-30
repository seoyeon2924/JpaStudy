package com.jpastudy.practice.repository;

import com.jpastudy.practice.entity.Member;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(false)
class MemberJpaRepositoryTest {

    @Autowired
    MemberJpaRepository memberJpaRepository;

    @Test // 여기서 테스트 하고 싶은 것은 저장, 조회 기능이 제대로 되는가이다.
    public void testMember(){
        Member memberA = new Member("memberA");
        Member savedmember = memberJpaRepository.save(memberA);
        Member findmember = memberJpaRepository.find(savedmember.getId());

        assertThat(findmember.getId()).isEqualTo(memberA.getId());
        assertThat(findmember.getUsername()).isEqualTo(memberA.getUsername());
        assertThat(findmember).isEqualTo(memberA);

    }
}