package spinrg.jpa.blogbackend.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import spinrg.jpa.blogbackend.dto.member.*;
import spinrg.jpa.blogbackend.entity.Address;
import spinrg.jpa.blogbackend.entity.Member;
import spinrg.jpa.blogbackend.service.MemberService;

import java.util.List;

import static spinrg.jpa.blogbackend.constant.ResultCode.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/members")
    public MemberGetRespDto getMembers() {
        try {
            List<Member> members = memberService.findAll();

            return new MemberGetRespDto(SUCCESS, "success", members);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("An error occurred in MemberController.getMembers()");
            return new MemberGetRespDto(UNKNOWN_ERR, "unKnown error.", null);
        }
    }

    @PostMapping("/members/new")
    public MemberCreateRespDto createMember(@RequestBody MemberCreateReqDto memberCreateReqDto) {
        try {
            Address address = new Address(memberCreateReqDto.getAddress().getCity(), memberCreateReqDto.getAddress().getStreet(), memberCreateReqDto.getAddress().getZipcode());

            Member member = new Member(memberCreateReqDto.getName(), memberCreateReqDto.getEmail(), memberCreateReqDto.getPassword(), address);
            memberService.createMember(member);

            return new MemberCreateRespDto(SUCCESS, "success");
        } catch (IllegalStateException e) {
            log.error(e.getLocalizedMessage());
            return new MemberCreateRespDto(EXIST_ERR, e.getLocalizedMessage());
        } catch (Exception e) {
            log.error("An error occurred in MemberController.createMember()");
            return new MemberCreateRespDto(UNKNOWN_ERR, "unKnown error.");
        }
    }
}
