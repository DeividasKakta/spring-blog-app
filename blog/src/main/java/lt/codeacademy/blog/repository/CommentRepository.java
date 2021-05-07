package lt.codeacademy.blog.repository;

import lt.codeacademy.blog.model.Comment;
import lt.codeacademy.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface CommentRepository extends JpaRepository<Comment, UUID> {

    List<Comment> findCommentsByPostId(UUID postId);


}
