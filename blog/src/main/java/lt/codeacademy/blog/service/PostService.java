package lt.codeacademy.blog.service;

import lt.codeacademy.blog.model.Post;
import lt.codeacademy.blog.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface PostService {

    Page<Post> getAllPostsPaginated(Pageable pageable);

    void addPost(Post post, User user);

    Post getPostById(UUID postId);

    void updatePost(Post post, User user);

    void deletePost(UUID id);

}
