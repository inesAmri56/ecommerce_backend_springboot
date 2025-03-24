package com.example.e_commerce.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

        private Long id;
        private String firstName;
        private String lastName;
        private String Email;
        private String phoneNumber;
        private String password;
        private String username;

    }
