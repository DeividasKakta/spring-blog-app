package lt.codeacademy.blog.controller;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.blog.model.User;
import lt.codeacademy.blog.model.UserDto;
import lt.codeacademy.blog.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/register")
    public String openRegister(Model model) {
        model.addAttribute("userDto", new UserDto());

        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid UserDto userDto, BindingResult bindingResult) {
        if (!userService.isUsernameFree(userDto.getUsername())) {
            return "register";
        }

        if (bindingResult.hasErrors()) {
            return "register";
        }

        User user = userService.convertUserDtoToUser(userDto);
        userService.addUser(user);

        return "redirect:/login?success";
    }

//    @GetMapping("/login")
//    public String openLogin() {
//
//        return "login";
//    }
}
