package lt.codeacademy.blog.service;

import lt.codeacademy.blog.model.Post;
import lt.codeacademy.blog.model.Comment;
import lt.codeacademy.blog.model.User;

import java.util.List;
import java.util.UUID;

public interface CommentService {

    void addComment(Post post, Comment comment, User user);

    List<Comment> getCommentsByPostId(UUID postId);

    void deleteComment(UUID id);

    Comment getCommentById(UUID id);

    void updateComment(Comment comment);

}
