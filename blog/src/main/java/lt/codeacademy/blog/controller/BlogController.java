package lt.codeacademy.blog.controller;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.blog.model.Blog;
import lt.codeacademy.blog.model.Comment;
import lt.codeacademy.blog.service.BlogService;
import lt.codeacademy.blog.service.CommentService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@Controller
@RequestMapping("/blogs")
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;
    private final CommentService commentService;

    @GetMapping
    public String getBlogs(@PageableDefault(size = 5, sort = {"date"}, direction = Sort.Direction.DESC) Pageable pageable,
                           Model model) {
        model.addAttribute("blogPage", blogService.getAllBlogsPaginated(pageable));

        return "blogs";
    }

    @GetMapping("/create")
    public String openCreateBlog(Model model) {
        model.addAttribute("blog", new Blog());

        return "createBlog";
    }

    @PostMapping("/create")
    public String createBlog(@Valid Blog blog, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "createBlog";
        }
        blogService.addBlog(blog);

        return "redirect:/blogs";
    }

    @GetMapping("/update")
    public String openBlogUpdate(@RequestParam UUID id, Model model) {
        model.addAttribute("blog", blogService.getBlogById(id));

        return "createBlog";
    }

    @PostMapping("/update")
    public String updateBlog(Blog blog) {
        blogService.updateBlog(blog);

        return "redirect:/blogs";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam UUID id) {
        blogService.deleteBlog(id);

        return "redirect:/blogs";
    }

    @GetMapping("{blogId}")
    public String openBlog(@PathVariable UUID blogId, Model model) {
        model.addAttribute("blog", blogService.getBlogById(blogId));
        model.addAttribute("comments", commentService.getCommentsByBlogId(blogId));
        model.addAttribute("comment", new Comment());

        return "blog";
    }

    @PostMapping("{blogId}")
    public String createComment(@PathVariable UUID blogId, @Valid Comment comment, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {

            return "blog";
        }

        commentService.addComment(blogService.getBlogById(blogId), comment);

        return "redirect:/blogs/{blogId}";
    }
}
