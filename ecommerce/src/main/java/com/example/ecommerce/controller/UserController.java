package com.example.ecommerce.controller;

import com.example.ecommerce.dto.UserRequestDTO;
import com.example.ecommerce.dto.UserResponseDTO;
import com.example.ecommerce.service.UserService;
import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<UserResponseDTO> createUser(@Valid @RequestBody UserRequestDTO userReq){
        UserResponseDTO userRes = userService.createUser(userReq);
        return ResponseEntity.ok(userRes);
    }
    @GetMapping("/show")
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        List<UserResponseDTO> response = userService.getAllUsers();
        return ResponseEntity.ok(response);
    }
    @GetMapping("/show/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable UUID id) {
        UserResponseDTO response = userService.getUserById(id);
        return ResponseEntity.ok(response);
    }
    @PutMapping("/update/id/{id}")
    public ResponseEntity <UserResponseDTO> updateUserById(@PathVariable UUID id, @RequestBody UserRequestDTO userReq){
        UserResponseDTO updatedUser = userService.updateUserById(id, userReq);
        return ResponseEntity.ok(updatedUser);
    }
    @DeleteMapping("/delete/id/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable UUID id){
        userService.deleteUserById(id);
        return ResponseEntity.ok("usuário deletado com sucesso!");
    }
}
