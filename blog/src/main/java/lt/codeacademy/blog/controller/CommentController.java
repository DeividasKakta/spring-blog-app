package lt.codeacademy.blog.controller;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.blog.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
@RequestMapping("/blogs")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @GetMapping("{blogId}/comments/delete")
    public String delete(@PathVariable UUID blogId, @RequestParam UUID id) {
        commentService.deleteComment(id);

        return "redirect:/blogs/{blogId}";
    }


}