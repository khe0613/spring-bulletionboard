package com.khe0613.springbulletinboard.service;

import com.khe0613.springbulletinboard.domain.members.Members;
import com.khe0613.springbulletinboard.domain.members.MembersRepository;
import com.khe0613.springbulletinboard.dto.members.MembersInfoModifyRequestDto;
import com.khe0613.springbulletinboard.dto.members.MembersSignupRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
public class MembersService {
    @Autowired
    private MembersRepository membersRepository;

    @Transactional
    // 회원 가입
    public void signup(MembersSignupRequestDto dto){
        membersRepository.save(dto.toEntity());
    }

    @Transactional
    // 회원 정보 수정
    public void modifyMemberInfo(MembersInfoModifyRequestDto dto, String id){
        Members member = membersRepository.findById(id);
        member.modifyPassword(dto.getPassword());
        member.modifyTel(dto.getTel());

        membersRepository.save(member);
    }

    @Transactional
    // 회원 탈퇴
    public void leaveMember(String id){
        membersRepository.deleteById(id);
    }


    @Transactional
    // 로그인할때의 검증과정에서 사용됨
    public Members getMember(Map<String, String> login_info){
        return membersRepository.findById(login_info.get("id"));
    }

    @Transactional
    // 회원가입할때의 검증과정(해당 아이디가 존재하는지 학인)에서 사용됨
    public Members getMember(String id){
        return membersRepository.findById(id);
    }


}