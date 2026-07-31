package com.api.inventary_and_loans.controllers;

import com.api.inventary_and_loans.entities.Member;
import com.api.inventary_and_loans.services.MemberService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // Endpoint for getting all members of the brotherhood/cofradia. (GET)
    @GetMapping
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }

    // Endpoint for getting a member by his id. (GET)
    @GetMapping("/dni/{nationalId}")
    public ResponseEntity<Member> getMemberByNationalId(@PathVariable String nationalId) {
        return memberService.getMemberByNationalId(nationalId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Endpoint for creating a new member and validating him. (POST)
    @PostMapping
    public ResponseEntity<Member> createMember(@Valid @RequestBody Member member) {
        Member savedMember = memberService.saveMember(member);
        return ResponseEntity.ok(savedMember);
    }

    // Endpoint for getting members in a paginated way. (GET)
    @GetMapping("/paginated")
    public Page<Member> getMembersPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        return memberService.getMembersPaginated(page, size);
    }
}
