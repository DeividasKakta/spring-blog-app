package lt.codeacademy.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/register")
    public String openRegister() {

        return "register";
    }

    @GetMapping("/login")
    public String openLogin() {

        return "login";
    }
}
