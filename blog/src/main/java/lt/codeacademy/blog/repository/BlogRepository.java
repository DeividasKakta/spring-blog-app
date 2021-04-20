package lt.codeacademy.blog.repository;

import lt.codeacademy.blog.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BlogRepository extends JpaRepository<Blog, UUID> {
}
