package lt.codeacademy.blog.service.impl;

import lt.codeacademy.blog.exception.UserNotFoundException;
import lt.codeacademy.blog.model.User;
import lt.codeacademy.blog.model.UserDto;
import lt.codeacademy.blog.repository.UserRepository;
import lt.codeacademy.blog.service.RoleService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;
import java.util.UUID;
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
    @Mock
    private User user;
    @Mock
    private UserDto userDto;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    public void testLoadUserByUsernameWhenUsernameDoesNotExist() {
        doThrow(UserNotFoundException.class).when(userRepository).findUserByUsernameWithRoles(null);

        assertThrows(UserNotFoundException.class, () -> userService.loadUserByUsername(null));
    }

    @Test
    public void testLoadUserByUsername() {
        when(userRepository.findUserByUsernameWithRoles(USERNAME)).thenReturn(Optional.of(user));

        UserDetails testUser = userService.loadUserByUsername(USERNAME);

        assertEquals(testUser, user);
    }

    @Test
    public void testAddUserWhenUserIsNull() {
        userService.addUser(null);

        verify(userRepository, times(0)).save(null);
    }

    @Test
    public void testAddUser() {
        when(userRepository.save(user)).thenReturn(user);

        userService.addUser(user);

        verify(userRepository, times(1)).save(user);
    }

    @Test
    public void testConvertUserDtoToUserWhenNull() {
        assertThrows(UserNotFoundException.class, () -> userService.convertUserDtoToUser(null));
    }

    @Test
    public void testConvertUserDtoToUser() {
        User userTest = userService.convertUserDtoToUser(userDto);

        assertNotNull(userTest);
    }

    @Test
    public void testGetUserByIdWhenNull() {
        doThrow(IllegalArgumentException.class).when(userRepository).findById(eq(null));

        assertThrows(IllegalArgumentException.class, () -> userService.getUserById(eq(null)));
    }

    @Test
    public void testGetUserByIdWhenUserDoesNotExist() {
        UUID uuid = UUID.randomUUID();
        doThrow(UserNotFoundException.class).when(userRepository).findById(uuid);

        assertThrows(UserNotFoundException.class, () -> userService.getUserById(uuid));
    }

    @Test
    public void testGetUserByIdWhenUserExists() {
        UUID uuid = UUID.randomUUID();
        when(userRepository.findById(uuid)).thenReturn(Optional.of(user));

        User testUser = userService.getUserById(uuid);

        assertEquals(user, testUser);
    }
}