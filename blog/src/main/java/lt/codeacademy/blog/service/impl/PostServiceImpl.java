package lt.codeacademy.blog.service.impl;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.blog.exception.PostNotFoundException;
import lt.codeacademy.blog.model.Post;
import lt.codeacademy.blog.model.User;
import lt.codeacademy.blog.repository.PostRepository;
import lt.codeacademy.blog.service.PostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public Page<Post> getAllPostsPaginated(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    @Override
    public void addPost(Post post, User user) {
        post.setUser(user);
        postRepository.save(post);
    }

    @Override
    public Post getPostById(UUID postId) {
        return postRepository.findById(postId)
                .orElseThrow(PostNotFoundException::new);
    }

    @Override
    public void updatePost(Post post, User user) {
        post.setUser(user);
        postRepository.save(post);
    }

    @Override
    public void deletePost(UUID id) {
        postRepository.deleteById(id);
    }


}
