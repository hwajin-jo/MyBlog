package spinrg.jpa.blogbackend.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import spinrg.jpa.blogbackend.dto.reply.ReplyCreateReqDto;
import spinrg.jpa.blogbackend.dto.reply.ReplyCreateRespDto;
import spinrg.jpa.blogbackend.entity.Member;
import spinrg.jpa.blogbackend.entity.Post;
import spinrg.jpa.blogbackend.entity.Reply;
import spinrg.jpa.blogbackend.service.MemberService;
import spinrg.jpa.blogbackend.service.PostService;
import spinrg.jpa.blogbackend.service.ReplyService;

import static spinrg.jpa.blogbackend.constant.ResultCode.SUCCESS;
import static spinrg.jpa.blogbackend.constant.ResultCode.UNKNOWN_ERR;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ReplyController {
    private final ReplyService replyService;

    @PostMapping("/reply/new")
    public ReplyCreateRespDto createReply(@RequestBody ReplyCreateReqDto replyCreateReqDto) {
        try {
            replyService.insertComment(replyCreateReqDto);

            return new ReplyCreateRespDto(SUCCESS, "success");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("An error occurred in ReplyController.createReply()");
            return new ReplyCreateRespDto(UNKNOWN_ERR, e.getLocalizedMessage());
        }
    }
}
