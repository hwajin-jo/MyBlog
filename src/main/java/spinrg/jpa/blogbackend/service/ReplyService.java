package spinrg.jpa.blogbackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spinrg.jpa.blogbackend.dto.reply.ReplyCreateReqDto;
import spinrg.jpa.blogbackend.entity.Member;
import spinrg.jpa.blogbackend.entity.Post;
import spinrg.jpa.blogbackend.entity.Reply;
import spinrg.jpa.blogbackend.repository.MemberRepository;
import spinrg.jpa.blogbackend.repository.PostRepository;
import spinrg.jpa.blogbackend.repository.ReplyRepository;

import java.time.LocalDateTime;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ReplyService {

    private final MemberRepository memberRepository;
    private final PostRepository postRepository;
    private final ReplyRepository replyRepository;

    @Transactional
    public void insertComment(ReplyCreateReqDto replyCreateReqDto) {
        Member member = memberRepository.findById(replyCreateReqDto.getMember_id()).get();
        Post post = postRepository.findById(replyCreateReqDto.getPost_id()).get();

        Reply reply = new Reply(member, post, replyCreateReqDto.getContent(), LocalDateTime.now(), LocalDateTime.now());

        replyRepository.save(reply);
    }
}
