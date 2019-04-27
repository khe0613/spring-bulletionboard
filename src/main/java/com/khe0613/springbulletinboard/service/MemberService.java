package com.khe0613.springbulletinboard.service;

import com.khe0613.springbulletinboard.domain.member.Member;
import com.khe0613.springbulletinboard.domain.member.MemberRepository;
import com.khe0613.springbulletinboard.dto.member.MemberSignupRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    @Transactional
    public void signup(MemberSignupRequestDto dto){
        memberRepository.save(dto.toEntity());
    }


    @Transactional
    // 로그인할때의 검증과정에서 사용됨
    public Member getMember(Map<String, String> login_info){
        return memberRepository.findById(login_info.get("id"));
    }
}
