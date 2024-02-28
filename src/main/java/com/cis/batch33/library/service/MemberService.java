package com.cis.batch33.library.service;

import com.cis.batch33.library.model.AddressDTO;
import com.cis.batch33.library.model.CheckoutDTO;
import com.cis.batch33.library.model.Member;
import org.springframework.stereotype.Service;

import com.cis.batch33.library.entity.LibraryMember;
import com.cis.batch33.library.model.Member;
import com.cis.batch33.library.repository.LibraryMemberRepository;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class MemberService {
    @Autowired
    private LibraryMemberRepository memberRepository;

    public LibraryMember createMember(LibraryMember member){
        Integer memberId = new Random().nextInt();
        member.setMemberId(memberId);
        return memberRepository.save(member);
    }

    public Member getMember(Integer memberId)
    {

        Optional<LibraryMember> memberOptional =
                memberRepository.findById(memberId);
        System.out.println("entered  get member "+memberId);
        LibraryMember libraryMember =
                memberOptional.orElse(new LibraryMember());
        Member member = new Member();
        member.setMemberId(libraryMember.getMemberId());
        member.setMemberShipLevel(libraryMember.getMemberShipLevel());
        member.setEmailAddress(libraryMember.getEmailAddress());
        member.setFirstName(libraryMember.getFirstName());
        member.setLastName(libraryMember.getLastName());
        member.setPhoneNumber(libraryMember.getPhoneNumber());

        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setAddressId(libraryMember.getAddress().getAddressId());
        addressDTO.setLine1(libraryMember.getAddress().getLine1());
        addressDTO.setLine2(libraryMember.getAddress().getLine2());
        addressDTO.setCity(libraryMember.getAddress().getCity());
        addressDTO.setState(libraryMember.getAddress().getState());
        addressDTO.setZip(libraryMember.getAddress().getZip());
        List<CheckoutDTO> checkoutDTOS =
                libraryMember.getCheckouts().stream().map(c -> {
                    CheckoutDTO cdo = new CheckoutDTO();
                    cdo.setId(c.getId());
                    cdo.setIsbn(c.getIsbn());
                    cdo.setCheckoutDate(c.getCheckoutDate());
                    cdo.setDueDate(c.getDueDate());
                    cdo.setReturned(c.isReturned());
                    return cdo;
                }).collect(Collectors.toList());

        member.setAddress(addressDTO);
        member.setCheckouts(checkoutDTOS);

        return member;


    }
    public LibraryMember updateMember(Integer memberId, LibraryMember updatedMember) {
        Optional<LibraryMember> memberOptional = memberRepository.findById(memberId);
        LibraryMember libraryMember = memberOptional.orElseThrow(() -> new RuntimeException("Member not found"));
        libraryMember.setFirstName(updatedMember.getFirstName());
        libraryMember.setLastName(updatedMember.getLastName());
        libraryMember.setEmailAddress(updatedMember.getEmailAddress());
        libraryMember.setPhoneNumber(updatedMember.getPhoneNumber());
        return memberRepository.save(libraryMember);

    }
        /*Optional<LibraryMember> existingMemberOptional = memberRepository.findById(memberId);

        if (existingMemberOptional.isPresent()) {
            LibraryMember existingMember = existingMemberOptional.get();
            existingMember.setFirstName(updatedMember.getFirstName());
            existingMember.setLastName(updatedMember.getLastName());
            existingMember.setEmailAddress(updatedMember.getEmailAddress());
            existingMember.setPhoneNumber(updatedMember.getPhoneNumber());
            existingMember.setMemberShipLevel(updatedMember.getMemberShipLevel());
            existingMember.setAddressId(updatedMember.getAddressId());
            return memberRepository.save(existingMember);
        } else {
            return null;
        }*/



    public void deleteMember(Integer memberId) {
        memberRepository.deleteById(memberId);
    }
}



