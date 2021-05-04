package lt.codeacademy.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
