package lt.codeacademy.blog.controller;

import lt.codeacademy.blog.service.BlogService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogController {

    private BlogService blogService;

    @GetMapping
    public String getBlogs(@PageableDefault(size = 5, sort = {"date"}, direction = Sort.Direction.ASC) Pageable pageable,
                              Model model) {
        model.addAttribute("blogPage", blogService.getAllBlogsPaginated(pageable));

        return "blogs";
    }
}
