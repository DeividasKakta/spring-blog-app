package lt.codeacademy.blog.service;

import lt.codeacademy.blog.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface PostService {

    Page<Post> getAllPostsPaginated(Pageable pageable);

    void addPost(Post post);

    Post getPostById(UUID postId);

    void updatePost(Post post);

    void deletePost(UUID id);

}
