package com.example.ecommerce.controller;

import com.example.ecommerce.dto.LoginRequestDTO;
import com.example.ecommerce.security.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDTO loginRequest) {
        // Aqui você validaria usuário e senha no banco
        String token = jwtUtil.generateToken(loginRequest.getEmail());
        return ResponseEntity.ok(token);
    }
}
