package com.jpastudy.practice.repository;

import com.jpastudy.practice.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(false)
class MemberRepositoryTest {
    @Autowired
    MemberRepository memberRepository;

    @Test
    public void testmember(){
    Member memberA = new Member("memberA");
    Member savedmember = memberRepository.save(memberA);
    Member findmember = memberRepository.findById(savedmember.getId()).get();

    assertThat(findmember.getId()).isEqualTo(savedmember.getId());
    assertThat(findmember.getUsername()).isEqualTo(savedmember.getUsername());
    assertThat(findmember).isEqualTo(savedmember);
    }
}