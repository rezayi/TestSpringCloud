package com.mrezaei.admin.user.controllers;

import com.mrezaei.admin.user.dao.UserRepository;
import com.mrezaei.admin.user.to.UserEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin/user")
public class UserManagementController {
    private final UserRepository userRepository;

    public UserManagementController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public ResponseEntity<List<UserEntity>> getUsersList() {
        List<UserEntity> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @GetMapping("{userId}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable("userId") int userId) {
        var user = userRepository.findById(userId);
        return user
                .map(userEntity -> ResponseEntity.status(HttpStatus.OK).body(userEntity))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));

    }

    @PostMapping("/")
    public ResponseEntity<Integer> addUser(@RequestBody UserEntity user) {
        userRepository.save(user);
        return ResponseEntity.status(HttpStatus.OK).body(user.getId());
    }

    @PutMapping("{userId}")
    public ResponseEntity<Integer> updateUser(@PathVariable("userId") int userId, @RequestBody UserEntity user) {
        userRepository.findById(userId);
        return ResponseEntity.status(HttpStatus.OK).body(user.getId());
    }

    @DeleteMapping("{userId}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable("userId") int userId) {
        userRepository.deleteById(userId);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
