package lt.codeacademy.blog.service;

import lt.codeacademy.blog.model.User;
import lt.codeacademy.blog.model.UserDto;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService extends UserDetailsService {

    @Override
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    void addUser(User user);

    boolean isUsernameFree(String username);

    User convertUserDtoToUser(UserDto userDto);

}
