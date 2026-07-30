package com.api.inventary_and_loans.services;

import com.api.inventary_and_loans.entities.Member;
import com.api.inventary_and_loans.repositories.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> getMemberByNationalId(String nationalId) {
        return memberRepository.findByNationalId(nationalId);
    }

    public Member saveMember(Member member) {
        return memberRepository.save(member);
    }
}