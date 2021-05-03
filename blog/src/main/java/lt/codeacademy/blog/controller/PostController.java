package lt.codeacademy.blog.controller;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.blog.model.Post;
import lt.codeacademy.blog.model.Comment;
import lt.codeacademy.blog.service.PostService;
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
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    private final CommentService commentService;

    @GetMapping
    public String getPosts(@PageableDefault(size = 5, sort = {"date"}, direction = Sort.Direction.DESC) Pageable pageable,
                           Model model) {
        model.addAttribute("postPage", postService.getAllPostsPaginated(pageable));

        return "posts";
    }

    @GetMapping("/create")
    public String openCreatePost(Model model) {
        model.addAttribute("post", new Post());

        return "createPost";
    }

    @PostMapping("/create")
    public String createPost(@Valid Post post, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "createPost";
        }
        postService.addPost(post);

        return "redirect:/posts";
    }

    @GetMapping("/update")
    public String openPostUpdate(@RequestParam UUID id, Model model) {
        model.addAttribute("post", postService.getPostById(id));

        return "createPost";
    }

    @PostMapping("/update")
    public String updatePost(Post post) {
        postService.updatePost(post);

        return "redirect:/posts";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam UUID id) {
        postService.deletePost(id);

        return "redirect:/posts";
    }

}
