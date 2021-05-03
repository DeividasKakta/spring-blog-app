package lt.codeacademy.blog.service;

import lt.codeacademy.blog.model.Post;
import lt.codeacademy.blog.model.Comment;

import java.util.List;
import java.util.UUID;

public interface CommentService {

    void addComment(Post post, Comment comment);

    List<Comment> getCommentsByPostId(UUID postId);

    void deleteComment(UUID id);

}
