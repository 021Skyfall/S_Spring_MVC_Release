package com.jerry.slice.mock;

import com.jerry.exception.BusinessLogicException;
import com.jerry.member.entity.Member;
import com.jerry.member.repository.MemberRepository;
import com.jerry.member.service.MemberService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class MemberServiceMockTest {
    @Mock
    private MemberRepository memberRepository;

    @InjectMocks
    private MemberService memberService;

    @Test
    public void createMemberTest() {
        // given
        Member member = new Member("hgd@gmail.com", "홍길동", "010-1111-1111");
        given(memberRepository.findByEmail(member.getEmail()))
                .willReturn(Optional.of(member));

        // when / then
        assertThrows(BusinessLogicException.class, () -> memberService.createMember(member));
    }
}