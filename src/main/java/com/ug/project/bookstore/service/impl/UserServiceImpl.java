package com.ug.project.bookstore.service.impl;

import com.ug.project.bookstore.common.enums.ApiError;
import com.ug.project.bookstore.dto.user.UserDTO;
import com.ug.project.bookstore.entity.user.User;
import com.ug.project.bookstore.exception.ApiFailedException;
import com.ug.project.bookstore.repository.UserRepository;
import com.ug.project.bookstore.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public UserDTO registerUser(UserDTO userDTO) {
        if (userRepository.findByUsername(userDTO.getUsername()) != null) {
            throw new ApiFailedException(ApiError.USER_ALREADY_EXISTS);
        }
        if (userRepository.findByEmail(userDTO.getEmail()) != null) {
            throw new ApiFailedException(ApiError.EMAIL_ALREADY_EXISTS);
        }
        String encryptedPassword = passwordEncoder.encode(userDTO.getPassword());
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(encryptedPassword);
        userRepository.save(user);
        return userDTO;
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ApiFailedException(ApiError.USER_NOT_FOUND));
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        userRepository.save(user);
        return userDTO;
    }

    @Override
    public UserDTO getUserByUsername(String username) {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new ApiFailedException(ApiError.USER_NOT_FOUND);
        }
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(user.getUsername());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }
}
