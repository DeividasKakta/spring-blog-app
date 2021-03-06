package lt.codeacademy.blog.controller;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.blog.model.Comment;
import lt.codeacademy.blog.model.User;
import lt.codeacademy.blog.service.CommentService;
import lt.codeacademy.blog.service.PostService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@Controller
@RequestMapping("/public/posts")
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
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public String createComment(@PathVariable UUID postId, @Valid Comment comment, BindingResult bindingResult,
                                Model model, @AuthenticationPrincipal User user) {
        if (bindingResult.hasErrors()) {
            setPostModel(model, postId);

            return "post";
        }

        commentService.addComment(postService.getPostById(postId), comment, user);

        return "redirect:/public/posts/{postId}";
    }

    @GetMapping("{postId}/comments/update")
    @PreAuthorize("#user.id eq #userId")
    public String openEditComment(@RequestParam UUID id, @PathVariable UUID postId, Model model,
                                  @RequestParam UUID userId, @AuthenticationPrincipal User user) {
        setPostModel(model, postId);
        model.addAttribute("comment", commentService.getCommentById(id));
        model.addAttribute("action", "update");

        return "post";
    }

    @PostMapping("{postId}/comments/update")
    @PreAuthorize("#user.id == #comment.user.id")
    public String editComment(@PathVariable UUID postId, @Valid Comment comment, BindingResult bindingResult,
                              Model model, @AuthenticationPrincipal User user) {
        if (bindingResult.hasErrors()) {
            setPostModel(model, postId);

            return "post";
        }

        comment.setPost(postService.getPostById(postId));
        commentService.updateComment(comment);

        return "redirect:/public/posts/{postId}";
    }

    @GetMapping("{postId}/comments/delete")
    @PreAuthorize("hasRole('ADMIN') or #user.id eq #userId")
    public String deleteComment(@PathVariable UUID postId, @RequestParam UUID id, @RequestParam UUID userId,
                                @AuthenticationPrincipal User user) {
        commentService.deleteComment(id);

        return "redirect:/public/posts/{postId}";
    }

    private void setPostModel(Model model, UUID postId) {
        model.addAttribute("post", postService.getPostById(postId));
        model.addAttribute("comments", commentService.getCommentsByPostId(postId));
    }

}
