package lt.codeacademy.blog.model;

import lombok.Getter;
import lombok.Setter;
import lt.codeacademy.blog.validator.Password;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Setter
@Getter
@Password
public class UserRegistration {

    @NotBlank
    @Size(min = 6, max = 20)
    private String username;

    @NotBlank
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,32}$")   // At least 1 number, length between 8 and 32
    private String password;

    @NotBlank
    private String repeatPassword;

}
