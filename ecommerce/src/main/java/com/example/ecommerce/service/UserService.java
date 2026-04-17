package com.example.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;


import com.example.ecommerce.dto.UserRequestDTO;
import com.example.ecommerce.dto.UserResponseDTO;
import com.example.ecommerce.entity.UserEntity;
import com.example.ecommerce.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    // Criar novo usuário
    public UserResponseDTO createUser(UserRequestDTO dto) {
        UserEntity entity = new UserEntity();
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setPhone(dto.getPhone());
        entity.setPassword(passwordEncoder.encode(dto.getPassword()));
        entity.setRoles(dto.getRoles());

        UserEntity saved = userRepository.save(entity);

        UserResponseDTO response = new UserResponseDTO();
        response.setId(saved.getId());
        response.setName(saved.getName());
        response.setEmail(saved.getEmail());
        response.setPhone(saved.getPhone());
        response.setRoles(saved.getRoles());

        return response;
    }

    // Buscar todos os usuários
    public List<UserResponseDTO> getAllUsers() {
        List<UserEntity> users = userRepository.findAll();
        List<UserResponseDTO> response = new ArrayList<>();  
        for (UserEntity user : users) {
            UserResponseDTO dto = new UserResponseDTO();
            dto.setId(user.getId());
            dto.setName(user.getName());
            dto.setEmail(user.getEmail());
            dto.setPhone(user.getPhone());
            dto.setRoles(user.getRoles());
        }
        return response;
    }   

    // Buscar usuário por ID
    public UserResponseDTO getUserById(UUID id) {
        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        UserResponseDTO response = new UserResponseDTO();
        response.setId(user.getId());
        response.setName(user.getName());
        response.setEmail(user.getEmail());
        response.setPhone(user.getPhone());
        response.setRoles(user.getRoles());

        return response;
    }

    // Atualizar usuário
    public UserResponseDTO updateUserById(UUID id, UserRequestDTO dto) {
        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPhone(dto.getPhone());
        user.setPassword(dto.getPassword());
        user.setRoles(dto.getRoles());

        UserEntity updated = userRepository.save(user);

        UserResponseDTO response = new UserResponseDTO();
        response.setId(updated.getId());
        response.setName(updated.getName());
        response.setEmail(updated.getEmail());
        response.setPhone(updated.getPhone());
        response.setRoles(updated.getRoles());

        return response;
    }

    // Deletar usuário
    public void deleteUserById(UUID id) {
        userRepository.deleteById(id);
    }
}
