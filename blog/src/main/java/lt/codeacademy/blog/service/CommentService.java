package lt.codeacademy.blog.service;

import lt.codeacademy.blog.model.Blog;
import lt.codeacademy.blog.model.Comment;

import java.util.List;
import java.util.UUID;

public interface CommentService {

    void addComment(Blog blog, Comment comment);

    List<Comment> getCommentsByBlogId(UUID blogId);

    void deleteComment(UUID id);

}
