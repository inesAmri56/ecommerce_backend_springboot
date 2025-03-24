package com.example.e_commerce.dtos.response;

import com.example.e_commerce.dtos.requests.UserRequest;
import com.example.e_commerce.models.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String Email;
    private String phoneNumber;
    private String password;
    private String username;
    public static UserResponse fromEntity(User user) {
        UserResponse userResponse = new UserResponse();
        BeanUtils.copyProperties(user,userResponse);
        return userResponse;
    }
    public static User toEntity(UserRequest userRequest){
        User user = new User();
        BeanUtils.copyProperties(userRequest,user);
        return user;
    }
}
