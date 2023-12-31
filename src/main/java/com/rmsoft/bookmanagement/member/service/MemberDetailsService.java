package com.rmsoft.bookmanagement.member.service;

import com.rmsoft.bookmanagement.auth.exception.NotFoundMemberException;
import com.rmsoft.bookmanagement.entity.Member;
import com.rmsoft.bookmanagement.member.code.MemberErrorCode;
import com.rmsoft.bookmanagement.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        Member member = memberRepository.findById(Long.parseLong(id))
                .orElseThrow(() -> new NotFoundMemberException(MemberErrorCode.NOT_FOUND_MEMBER_BY_ID));

        return new User(member.getId().toString(), member.getPassword(), List.of(new SimpleGrantedAuthority("USER")));
    }
}
