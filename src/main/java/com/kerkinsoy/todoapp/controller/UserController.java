package com.kerkinsoy.todoapp.controller;

import com.kerkinsoy.todoapp.dto.CreateUserRequest;
import com.kerkinsoy.todoapp.dto.LoginUserRequest;
import com.kerkinsoy.todoapp.model.User;
import com.kerkinsoy.todoapp.service.TodoService;
import com.kerkinsoy.todoapp.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping(value = "/api/v1/users")
public class UserController {

    private final UserService userService;

    private final TodoService todoService;

    public UserController(UserService userService, TodoService todoService) {
        this.userService = userService;
        this.todoService = todoService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.getUserById(userId));
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@Valid @RequestBody LoginUserRequest loginUserRequest){


        return ResponseEntity.ok(userService.login(loginUserRequest));
    }


    @PostMapping("/register")
    public ResponseEntity<?> addUser(@Valid @RequestBody CreateUserRequest createUserRequest){
        return ResponseEntity.ok(userService.addUser(createUserRequest));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId){
        return ResponseEntity.ok(userService.deleteUserById(userId));
    }

}
