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
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ReplyService {

    private final MemberRepository memberRepository;
    private final PostRepository postRepository;
    private final ReplyRepository replyRepository;

    @Transactional
    public void insertComment(ReplyCreateReqDto replyCreateReqDto) {
        Optional<Member> findMember = memberRepository.findById(replyCreateReqDto.getMember_id());
        Optional<Post> findPost = postRepository.findById(replyCreateReqDto.getPost_id());

        if (findMember.isPresent() && findPost.isPresent()) {
            Reply reply = new Reply(findMember.get(), findPost.get(), replyCreateReqDto.getContent(), LocalDateTime.now(), LocalDateTime.now());
            replyRepository.save(reply);
        } else {
            throw new IllegalStateException("잘못된 댓글 쓰기 입니다.");
        }
    }
}
