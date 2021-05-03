package lt.codeacademy.blog.service.impl;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.blog.exception.CommentNotFoundException;
import lt.codeacademy.blog.model.Post;
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
    public void addComment(Post post, Comment comment) {
        comment.setPost(post);
        commentRepository.save(comment);
    }

    @Override
    public List<Comment> getCommentsByPostId(UUID postId) {
        return commentRepository.findCommentsByPostId(postId);
    }

    @Override
    public void deleteComment(UUID id) {
        commentRepository.deleteById(id);
    }

    @Override
    public Comment getCommentById(UUID id) {
        return commentRepository.findById(id)
                .orElseThrow(CommentNotFoundException::new);
    }

    @Override
    public void updateComment(Comment comment) {
        commentRepository.save(comment);
    }
}
