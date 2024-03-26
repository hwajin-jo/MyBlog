package spinrg.jpa.blogbackend.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import spinrg.jpa.blogbackend.dto.post.*;
import spinrg.jpa.blogbackend.entity.Member;
import spinrg.jpa.blogbackend.entity.Post;
import spinrg.jpa.blogbackend.exception.PostNotFoundException;
import spinrg.jpa.blogbackend.service.MemberService;
import spinrg.jpa.blogbackend.service.PostService;

import java.time.LocalDateTime;

import static spinrg.jpa.blogbackend.constant.ResultCode.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class PostController {

    private final PostService postService;
    private final MemberService memberService;

    @PostMapping("/posts/new")
    private PostCreateRespDto createPosts(@RequestBody PostCreateReqDto postCreateReqDto) {
        try {
            Member member = memberService.findMemberById(postCreateReqDto.getMember_id());
            Post post = new Post(member, postCreateReqDto.getTitle(), postCreateReqDto.getContent(), LocalDateTime.now(), LocalDateTime.now());

            postService.insertPost(post);
            return new PostCreateRespDto(SUCCESS, "success");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("An error occurred in PostController.createPosts()");
            return new PostCreateRespDto(UNKNOWN_ERR, "unKnown error.");
        }
    }

    @PatchMapping("/posts/edit/{postId}")
    private PostEditRespDto editPosts(@PathVariable("postId") Long postId, @RequestBody PostEditReqDto postEditReqDto) {
        try {
            postService.updatePosts(postId, postEditReqDto.getTitle(), postEditReqDto.getContent());

            return new PostEditRespDto(SUCCESS, "success");
        } catch (PostNotFoundException e) {
            log.error(e.getLocalizedMessage());
            return new PostEditRespDto(NOT_FOUND, e.getLocalizedMessage());
        } catch (Exception e) {
            e.printStackTrace();
            log.error("An error occurred in PostController.editPosts()");
            return new PostEditRespDto(UNKNOWN_ERR, "unKnown error.");
        }

    }

    @GetMapping("/posts/{postId}")
    private PostGetRespDto getPostById(@PathVariable("postId") Long postId) {
        try {
            Post post = postService.findPost(postId);

            return new PostGetRespDto(SUCCESS, "success", new PostDto(post.getId(), post.getMember().getName(), post.getTitle(), post.getContent(), post.getCreateDate(), post.getModifyDate()));
        } catch (PostNotFoundException e) {
            log.error(e.getLocalizedMessage());
            return new PostGetRespDto(NOT_FOUND, e.getLocalizedMessage(), new PostDto());
        } catch (Exception e) {
            e.printStackTrace();
            log.error("An error occurred in PostController.getPostById()");
            return new PostGetRespDto(UNKNOWN_ERR, "unKnown error.", new PostDto());
        }
    }

    @DeleteMapping("posts/{postId}")
    private PostDeleteRespDto deletePostById(@PathVariable("postId") Long postId) {
        try {
            postService.deletePost(postId);

            return new PostDeleteRespDto(SUCCESS, "success");
        } catch (Exception e) {
            log.error("An error occurred in PostController.deletePostById()");
            return new PostDeleteRespDto(UNKNOWN_ERR, "unKnown error.");
        }
    }
}
