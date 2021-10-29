package com.kerkinsoy.todoapp.service;

import com.kerkinsoy.todoapp.exception.UserNotFoundException;
import com.kerkinsoy.todoapp.model.Todo;
import com.kerkinsoy.todoapp.model.User;
import com.kerkinsoy.todoapp.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    private UserService userService;

    private UserRepository userRepository;

    @BeforeEach
    public void setup(){
        userRepository = mock(UserRepository.class);

        userService = new UserService(userRepository);
    }

    @Test
    public void testFindByUserId_whenUserIdExist_shouldReturnUser(){

        User user = new User(1L,"e@mail","username","123456", new ArrayList<Todo>());

        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        User result = userService.getUserById(1L);

        assertEquals(result, user);
    }

    @Test
    public void testFindByUserId_whenUserIdDoesNotExist_shouldReturnUserNotFoundException(){

        Mockito.when(userRepository.findById(2L)).thenReturn(Optional.empty());

        assertThrows(UserNotFoundException.class,()->userService.getUserById(2L));
    }

}
