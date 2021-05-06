package lt.codeacademy.blog.validator;

import lombok.extern.slf4j.Slf4j;
import lt.codeacademy.blog.model.UserDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Slf4j
public class PasswordValidator implements ConstraintValidator<Password, UserDto> {

    @Override
    public boolean isValid(UserDto userDto, ConstraintValidatorContext context) {
        try {
            boolean isValid = userDto.getPassword().equals(userDto.getRepeatPassword());
            if (!isValid) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
                        .addPropertyNode("repeatPassword")
                        .addConstraintViolation();
            }
            return isValid;
        } catch (Exception e) {
            log.warn("Invalid password: " + e.getMessage());
        }
        return false;
    }
}
