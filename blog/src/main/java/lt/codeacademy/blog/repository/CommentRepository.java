package lt.codeacademy.blog.repository;

import lt.codeacademy.blog.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CommentRepository extends JpaRepository<Comment, UUID> {

    List<Comment> findCommentsByBlogId(UUID blogId);

}
