package com.example.e_commerce.services;

import com.example.e_commerce.dtos.requests.UserRequest;
import com.example.e_commerce.dtos.response.UserResponse;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
@Service
public interface UserService {
    UserResponse createUser(UserRequest userRequest);
   List<UserResponse> getAllUsers();
    UserResponse getUserById(Long id);
    UserResponse updateUser(UserRequest userRequest, Long id);
    HashMap<String , String> deleteUser(Long id);
}
