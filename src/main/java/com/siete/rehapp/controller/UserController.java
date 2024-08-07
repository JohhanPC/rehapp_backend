package com.siete.rehapp.controller;

import com.siete.rehapp.dto.UserDTO;
import com.siete.rehapp.dto.UserRegisterDTO;
import com.siete.rehapp.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/rehapp/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public ResponseEntity<UserRegisterDTO> createUser(@RequestBody UserRegisterDTO userRegister) {
        log.info("Creating user: {}", userRegister);
        UserRegisterDTO createdUser = userService.save(userRegister);
        log.info("Created user: {}", createdUser);
        return ResponseEntity.ok(createdUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        log.info("Fetching user with id: {}", id);
        UserDTO user = userService.getById(id);
        log.info("User fetched successfully: {}", user);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/update")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDto) {
        log.info("Updating user with id: {}", userDto.getUserId());
        UserDTO updatedUser = userService.updateUser(userDto);
        log.info("User updated successfully: {}", updatedUser);
        return ResponseEntity.ok(updatedUser);
    }

    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(
            @RequestParam String email,
            @RequestParam String password
    ){
        log.info("Logging in with email: {}", email);
        UserDTO user = userService.login(email, password);
        log.info("User logged in successfully: {}", user);
        return ResponseEntity.ok(user);
    }


}
