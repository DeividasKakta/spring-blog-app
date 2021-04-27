package lt.codeacademy.blog.service;

import lt.codeacademy.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface BlogService {

    Page<Blog> getAllBlogsPaginated(Pageable pageable);

    void addBlog(Blog blog);

    Blog getBlogById(UUID blogId);

}
