package lt.codeacademy.blog.service.impl;

import lt.codeacademy.blog.exception.CommentNotFoundException;
import lt.codeacademy.blog.model.Comment;
import lt.codeacademy.blog.model.Post;
import lt.codeacademy.blog.model.User;
import lt.codeacademy.blog.repository.CommentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CommentServiceImplTest {

    @Mock
    private CommentRepository commentRepository;
    @Mock
    private Post post;
    @Mock
    private User user;
    @Mock
    private Comment comment;

    @InjectMocks
    private CommentServiceImpl commentService;

    @Test
    public void testAddCommentWhenCommentIsNull() {
        commentService.addComment(post, null, user);

        verify(commentRepository, times(0)).save(eq(null));
    }

    @Test
    public void testAddCommentWhenCommentExists() {
        when(commentRepository.save(comment)).thenReturn(comment);

        commentService.addComment(post, comment, user);

        verify(commentRepository, times(1)).save(comment);
    }

    @Test
    public void testGetCommentsByPostIdWhenPostIdDoesNotExist() {
        List<Comment> comments = commentService.getCommentsByPostId(UUID.randomUUID());

        assertNotNull(comments);
        assertTrue(comments.isEmpty());
    }

    @Test
    public void testGetCommentsByPostIdWhenPostIdExists() {
        UUID uuid = UUID.randomUUID();
        when(commentRepository.findCommentsByPostId(uuid)).thenReturn(List.of(comment));

        List<Comment> comments = commentService.getCommentsByPostId(uuid);

        assertEquals(List.of(comment), comments);
    }

    @Test
    public void testDeleteCommentWhenCommentDoesNotExist() {
        doThrow(IllegalArgumentException.class).when(commentRepository).deleteById(any(UUID.class));

        assertThrows(IllegalArgumentException.class, () -> commentService.deleteComment(UUID.randomUUID()));
    }

    @Test
    public void testDeleteCommentWhenCommentExists() {
        UUID uuid = UUID.randomUUID();
        doNothing().when(commentRepository).deleteById(uuid);

        commentService.deleteComment(uuid);

        verify(commentRepository, times(1)).deleteById(uuid);
    }

    @Test
    public void testGetCommentByIdWhenCommentDoesNotExist() {
        when(commentRepository.findById(any(UUID.class))).thenReturn(Optional.ofNullable(null));

        assertThrows(CommentNotFoundException.class, () -> commentService.getCommentById(UUID.randomUUID()));
    }

    @Test
    public void testGetCommentByIdWhenCommentExists() {
        UUID uuid = UUID.randomUUID();
        when(commentRepository.findById(uuid)).thenReturn(Optional.of(comment));

        Comment testComment = commentService.getCommentById(uuid);

        assertEquals(comment, testComment);
    }

    @Test
    public void testUpdateCommentWhenCommentExists() {
        when(commentRepository.save(comment)).thenReturn(comment);

        commentService.updateComment(comment);

        verify(commentRepository, times(1)).save(comment);
    }
}