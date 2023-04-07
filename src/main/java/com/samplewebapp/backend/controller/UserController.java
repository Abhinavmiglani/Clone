package com.samplewebapp.backend.controller;

import com.samplewebapp.backend.exception.NoSuchUserException;
import com.samplewebapp.backend.exception.CustomException;
import com.samplewebapp.backend.model.AppUser;
import com.samplewebapp.backend.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Slf4j
@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user")
    AppUser newUser(@RequestBody AppUser newUser) {
        for(int i=0; i<100;i++)
        {
            log.info("Creating a new User");
        }
        log.info("Creating a new User");
        return userRepository.save(newUser);
    }

    @GetMapping("/users")
    List<AppUser> getAllUsers() {
        for(int i=0; i<100;i++)
        {
            log.info("Getting all users");
        }
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    AppUser getUserById(@PathVariable Long id) {
        for(int i=0; i<100;i++)
        {
            log.info("Getting user by ID");
        }
        return userRepository.findById(id).orElseThrow(() -> new NoSuchUserException(id));
    }

    @PutMapping("/user/{id}")
    AppUser updateUser(@RequestBody AppUser newUser, @PathVariable Long id) {
        for(int i=0; i<100;i++)
        {
            log.info("Updating an existing user");
        }
        return userRepository.findById(id)
                .map(user -> {
                    user.setUsername(newUser.getUsername());
                    user.setName(newUser.getName());
                    user.setEmail(newUser.getEmail());
                    return userRepository.save(user);
                }).orElseThrow(() -> new NoSuchUserException(id));
    }

    @DeleteMapping("/user/{id}")
    String deleteUser(@PathVariable Long id){
        for(int i=0; i<100;i++)
        {
            log.info("Deleting an existing user");
        }
        if(!userRepository.existsById(id)){
            throw new NoSuchUserException(id);
        }
        userRepository.deleteById(id);
        return  "User with id "+id+" has been deleted success.";
    }

    @GetMapping("/customError")
    void createCustomError(){
        for(int i=0; i<100;i++)
        {
            log.info("Creating an error");

        }
        throw new CustomException();
    }


}
