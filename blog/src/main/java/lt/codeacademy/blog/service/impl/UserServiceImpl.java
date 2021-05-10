package lt.codeacademy.blog.service.impl;

import lombok.extern.slf4j.Slf4j;
import lt.codeacademy.blog.exception.UserNotFoundException;
import lt.codeacademy.blog.model.User;
import lt.codeacademy.blog.model.UserDto;
import lt.codeacademy.blog.repository.UserRepository;
import lt.codeacademy.blog.service.RoleService;
import lt.codeacademy.blog.service.UserService;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleService roleService;
    private final PasswordEncoder encoder;

    private final String message = "";

    public UserServiceImpl(UserRepository userRepository, RoleService roleService, @Lazy PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.encoder = encoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findUserByUsernameWithRoles(username)
                .orElseThrow(() -> new UsernameNotFoundException(message));
    }

    @Override
    public void addUser(User user) {
        try {
            if (user == null) {
                return;
            }
            userRepository.save(user);
        } catch (Exception e) {
            log.warn(e.getMessage());
        }
    }

    @Override
    public User convertUserDtoToUser(UserDto userDto) {
        try {
            if (userDto == null) {
                throw new UserNotFoundException();
            }
            User user = new User();

            user.setUsername(userDto.getUsername());
            user.setPassword(encoder.encode(userDto.getPassword()));
            user.setRoles(roleService.addUserRoleToSet());

            return user;
        } catch (Exception e) {
            log.warn(e.getMessage());
        }
        throw new UserNotFoundException();
    }

    @Override
    public User getUserById(UUID userId) {
        return userRepository.findById(userId)
                .orElseThrow(UserNotFoundException::new);
    }

}
