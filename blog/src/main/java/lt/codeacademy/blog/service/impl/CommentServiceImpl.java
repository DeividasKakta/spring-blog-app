package lt.codeacademy.blog.service.impl;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.blog.model.Blog;
import lt.codeacademy.blog.model.Comment;
import lt.codeacademy.blog.repository.CommentRepository;
import lt.codeacademy.blog.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    @Override
    public void addComment(Blog blog, Comment comment) {
        comment.setBlog(blog);
        commentRepository.save(comment);
    }

    @Override
    public List<Comment> getCommentsByBlogId(UUID blogId) {
        return commentRepository.findCommentsByBlogId(blogId);
    }

    @Override
    public void deleteComment(UUID id) {
        commentRepository.deleteById(id);
    }
}
