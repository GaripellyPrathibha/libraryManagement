package com.cis.batch33.library.controller;

import com.cis.batch33.library.model.Member;
import com.cis.batch33.library.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @GetMapping("/{memberId}")
    public Member getMember(Long memberId){
        Member member=memberService.getMember(memberId);
        return member;
    }

    // create a member
    @PostMapping
    public Member createMember(@RequestBody  Member member){
        return memberService.createMember(member);
    }
    @PutMapping("/{memberId}")
    public Member updateMember(@PathVariable Long memberId,@RequestBody Member updatedMember)
    {
        return memberService.updateMember(memberId,updatedMember);
    }
    @DeleteMapping("/{memberId}")
    public void deleteMember(@PathVariable Long memberId)
    {
        memberService.deleteMember(memberId);
    }


}
