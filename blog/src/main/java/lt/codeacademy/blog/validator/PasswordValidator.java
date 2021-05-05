package lt.codeacademy.blog.validator;

import lombok.extern.slf4j.Slf4j;
import lt.codeacademy.blog.model.UserRegistration;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Slf4j
public class PasswordValidator implements ConstraintValidator<Password, UserRegistration> {

    @Override
    public boolean isValid(UserRegistration registration, ConstraintValidatorContext context) {
        try {
            return registration.getPassword().equals(registration.getRepeatPassword());
        } catch (Exception e) {
            log.warn("Invalid password: " + e.getMessage());
        }
        return false;
    }
}
