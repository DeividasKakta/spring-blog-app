package lt.codeacademy.blog.service;

import lt.codeacademy.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BlogService {

    Page<Blog> getAllBlogsPaginated(Pageable pageable);
}
