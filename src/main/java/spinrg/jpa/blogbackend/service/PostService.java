package spinrg.jpa.blogbackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spinrg.jpa.blogbackend.entity.Post;
import spinrg.jpa.blogbackend.exception.PostNotFoundException;
import spinrg.jpa.blogbackend.repository.PostRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public void insertPost(Post post) {
        postRepository.save(post);
    }

    @Transactional
    public void updatePosts(Long postId, String title, String content) {
        Optional<Post> post = postRepository.findById(postId);
        if (post.isPresent()) {
            Post findPost = post.get();
            findPost.update(title, content, LocalDateTime.now());
            return;
        }

        throw new PostNotFoundException("it could not found post");
    }

    public Post findPost(Long postId) {
        Optional<Post> post = postRepository.findById(postId);

        if (post.isPresent()) {
            return post.get();
        }

        throw new PostNotFoundException("if could not found post");
    }

    @Transactional
    public void deletePost(Long postId) {
        Optional<Post> post = postRepository.findById(postId);
        if (post.isPresent()) {
            postRepository.deleteById(postId);
        }
    }
}
