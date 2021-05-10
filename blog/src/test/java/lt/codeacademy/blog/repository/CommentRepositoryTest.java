package lt.codeacademy.blog.repository;

import lt.codeacademy.blog.model.Comment;
import lt.codeacademy.blog.model.Post;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CommentRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CommentRepository commentRepository;

    @Mock
    private Post post;

    @Test
    public void testFindCommentsByPostId() {
        Comment comment = new Comment();
        comment.setDate(new Date());
        comment.setMessage("message");

        entityManager.persist(comment);

        List<Comment> comments = commentRepository.findCommentsByPostId(post.getId());

        assertEquals(1, comments.size());
        assertEquals("message", comments.get(0).getMessage());
    }
}