package lt.codeacademy.blog.controller;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.blog.model.Comment;
import lt.codeacademy.blog.service.CommentService;
import lt.codeacademy.blog.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@Controller
@RequestMapping("/posts")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;
    private final PostService postService;

    @GetMapping("{postId}")
    public String openPostWithComments(@PathVariable UUID postId, Model model) {
        setPostModel(model, postId);
        model.addAttribute("comment", new Comment());

        return "post";
    }

    @PostMapping("{postId}")
    public String createComment(@PathVariable UUID postId, @Valid Comment comment, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            setPostModel(model, postId);

            return "post";
        }

        commentService.addComment(postService.getPostById(postId), comment);

        return "redirect:/posts/{postId}";
    }

    @GetMapping("{postId}/comments/update")
    public String openEditComment(@RequestParam UUID id, @PathVariable UUID postId, Model model) {
        setPostModel(model, postId);
        model.addAttribute("comment", commentService.getCommentById(id));

        return "post";
    }

    @PostMapping("{postId}/comments/update")
    public String editComment(@PathVariable UUID postId, @Valid Comment comment, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            setPostModel(model, postId);

            return "post";
        }

        comment.setPost(postService.getPostById(postId));
        commentService.updateComment(comment);

        return "redirect:/posts/{postId}";
    }

    @GetMapping("{postId}/comments/delete")
    public String deleteComment(@PathVariable UUID postId, @RequestParam UUID id) {
        commentService.deleteComment(id);

        return "redirect:/posts/{postId}";
    }

    private void setPostModel(Model model, UUID postId) {
        model.addAttribute("post", postService.getPostById(postId));
        model.addAttribute("comments", commentService.getCommentsByPostId(postId));
    }

}
