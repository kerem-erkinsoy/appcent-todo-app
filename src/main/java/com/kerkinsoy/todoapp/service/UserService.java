package com.kerkinsoy.todoapp.service;

import com.kerkinsoy.todoapp.dto.LoginUserRequest;
import com.kerkinsoy.todoapp.exception.UserNotFoundException;
import com.kerkinsoy.todoapp.dto.CreateUserRequest;
import com.kerkinsoy.todoapp.model.User;
import com.kerkinsoy.todoapp.repository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.persistence.NonUniqueResultException;

@Service
public class UserService {

    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(()-> new UserNotFoundException("Girilen emaile gore bir kullanici bulunamadi"));
    }

    public User login(LoginUserRequest loginUserRequest){


        Authentication authentication = new UsernamePasswordAuthenticationToken(loginUserRequest.getEmail(),
                                                                                loginUserRequest.getPassword());

        final String name = (String) authentication.getPrincipal();

        final String password = (String) authentication.getCredentials();

        User tempUser = findUserByEmail(loginUserRequest.getEmail());

        if (!tempUser.getPassword().equals(loginUserRequest.getPassword())){
            throw new BadCredentialsException("Illegal passowrd");
        }

        final String storedPassword = userRepository.findByEmail(loginUserRequest.getEmail()).map(User::getPassword)
                .orElseThrow(() -> new BadCredentialsException("Illegal password"));

        SecurityContextHolder.getContext().setAuthentication(authentication);


        return userRepository.findByEmail(loginUserRequest.getEmail()).get();

    }

    public User addUser(CreateUserRequest createUserRequest){
        if(userRepository.findByEmail(createUserRequest.getEmail()).isPresent()){
            throw new NonUniqueResultException("User already exist exception!");
        }

        User user = new User();
        user.setEmail(createUserRequest.getEmail());
        user.setUsername(createUserRequest.getUsername());
        user.setPassword(createUserRequest.getPassword());

        return userRepository.save(user);

    }

    public User getUserById(Long userId){
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new UserNotFoundException("User not found, id: " + userId));
        return user;
    }

    //public void deleteUserById(Long userId) throws Exception{
    public User deleteUserById(Long userId){
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new UserNotFoundException("Silme işlemi için kullanıcı bulunamadı, girilen ID: " + userId));
        userRepository.delete(user);
        return user;
    }




}
