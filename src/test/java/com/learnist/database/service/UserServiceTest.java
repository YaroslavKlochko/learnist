package com.learnist.database.service;

import com.learnist.config.WebSecurityConfig;
import com.learnist.database.repository.UserRepository;
import com.learnist.domain.User;
import org.junit.jupiter.api.Test;

import static java.util.Optional.of;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServiceTest {

    public final String email = "test@gmail";
    public final Long id = 1L;
    private User testUser = mock(User.class);
    private UserService underTest = mock(UserService.class);
    private WebSecurityConfig webSecurityConfig = mock(WebSecurityConfig.class);
    private UserRepository userRepository = mock(UserRepository.class);
    private RoleService roleService = mock(RoleService.class);

    @Test
    public void shouldAddUser(){
        userRepository.save(testUser);
    }

    @Test
    public void ShouldFindUserByEmail(){
        when(userRepository.findUserByEmail(email)).thenReturn(testUser);
    }

    @Test
    public void ShouldFindUserById(){
        when(userRepository.findById(id)).thenReturn(of(testUser));
    }

    @Test
    public void shouldCheckUserAvailability(){
        // подписывать как shouldReturnTrue?
        //зависит ли тип возвращаемого значения?
        userRepository.save(testUser); //userService метод, что за фигня?
    }

    @Test
    public void shouldCheckIfUserExistsByEmail(){
        when(userRepository.findUserByEmail(email)).thenReturn(testUser);
    }

    @Test
    public void shouldSaveUser(){
        when(userRepository.save(testUser)); // как тут закончить условие?
    }

    @Test
    public void shouldGetAllUsers(){
    }
}
