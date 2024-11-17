package com.ug.project.bookstore.service.user;


import com.ug.project.bookstore.dto.user.UserDTO;

public interface UserService {

    // Register new user
    UserDTO registerUser(UserDTO userDTO);

    // Update user details
    UserDTO updateUser(Long id, UserDTO userDTO);

    // Get user by username
    UserDTO getUserByUsername(String username);
}

