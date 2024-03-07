package spinrg.jpa.blogbackend.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import spinrg.jpa.blogbackend.dto.MemberCreateReqDto;
import spinrg.jpa.blogbackend.dto.MemberCreateRespDto;
import spinrg.jpa.blogbackend.entity.Address;
import spinrg.jpa.blogbackend.entity.Member;
import spinrg.jpa.blogbackend.service.MemberService;

import static spinrg.jpa.blogbackend.constant.ResultCode.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/members/new")
    private MemberCreateRespDto createMember(@RequestBody MemberCreateReqDto memberCreateReqDto) {
        try {
            Address address = new Address(memberCreateReqDto.getAddress().getCity(), memberCreateReqDto.getAddress().getStreet(), memberCreateReqDto.getAddress().getZipcode());

            Member member = new Member(memberCreateReqDto.getName(), memberCreateReqDto.getEmail(), memberCreateReqDto.getPassword(), address);
            memberService.createMember(member);

            return new MemberCreateRespDto(SUCCESS, "success");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("An error occurred in MemberController.createMember()");
            return new MemberCreateRespDto(UNKNOWN_ERR, "unKnown error.");
        }
    }
}
