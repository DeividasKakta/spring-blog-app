package lt.codeacademy.blog.validator;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.blog.repository.UserRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class UsernameValidator implements ConstraintValidator<Username, String> {

    private final UserRepository userRepository;

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        return userRepository.findUserByUsername(username) == null;
    }
}
