package lt.codeacademy.blog.service.impl;

import lt.codeacademy.blog.exception.UserNotFoundException;
import lt.codeacademy.blog.repository.UserRepository;
import lt.codeacademy.blog.service.RoleService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
    private static final String USERNAME = "username";

    @Mock
    private UserRepository userRepository;
    @Mock
    private RoleService roleService;
    @Mock
    private PasswordEncoder encoder;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    public void testLoadUserByUsernameWhenUsernameDoesNotExist() {
        doThrow(UserNotFoundException.class).when(userRepository).findUserByUsernameWithRoles(null);

        assertThrows(UserNotFoundException.class, () -> userService.loadUserByUsername(null));
    }
}