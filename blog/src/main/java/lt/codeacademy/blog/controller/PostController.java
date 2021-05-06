package lt.codeacademy.blog.controller;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.blog.model.Post;
import lt.codeacademy.blog.service.PostService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@Controller
@RequestMapping("/public/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping
    public String getPosts(@PageableDefault(size = 5, sort = {"date"}, direction = Sort.Direction.DESC) Pageable pageable,
                           Model model) {
        model.addAttribute("postPage", postService.getAllPostsPaginated(pageable));

        return "posts";
    }

    @GetMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public String openCreatePost(Model model) {
        model.addAttribute("post", new Post());
        model.addAttribute("action", "create");

        return "createPost";
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public String createPost(@Valid Post post, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("action", "create");
            return "createPost";
        }
        postService.addPost(post);

        return "redirect:/public/posts";
    }

    @GetMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
    public String openPostUpdate(@RequestParam UUID id, Model model) {
        model.addAttribute("post", postService.getPostById(id));
        model.addAttribute("action", "update");

        return "createPost";
    }

    @PostMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
    public String updatePost(@Valid Post post, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("action", "update");
            return "createPost";
        }
        postService.updatePost(post);

        return "redirect:/public/posts";
    }

    @GetMapping("/delete")
    @PreAuthorize("hasRole('ADMIN')")
    public String delete(@RequestParam UUID id) {
        postService.deletePost(id);

        return "redirect:/public/posts";
    }

}
