package lt.codeacademy.blog.service.impl;

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
        userRepository.save(user);
    }

    @Override
    public User convertUserDtoToUser(UserDto userDto) {
        User user = new User();

        user.setUsername(userDto.getUsername());
        user.setPassword(encoder.encode(userDto.getPassword()));
        user.setRoles(roleService.addUserRoleToSet());

        return user;
    }

}
