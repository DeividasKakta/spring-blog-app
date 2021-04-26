package lt.codeacademy.blog.service.impl;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.blog.model.Blog;
import lt.codeacademy.blog.repository.BlogRepository;
import lt.codeacademy.blog.service.BlogService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BlogServiceImpl implements BlogService {

    private final BlogRepository blogRepository;

    @Override
    public Page<Blog> getAllBlogsPaginated(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public void addBlog(Blog blog) {
        blogRepository.save(blog);
    }
}
