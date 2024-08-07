package com.siete.rehapp.dto;

import com.siete.rehapp.enums.UserType;
import lombok.Data;

@Data
public class UserDTO {

    private Long userId;
    private String userName;
    private String password;
    private int age;
    private String sex;
    private String email;
    private String phoneNumber;
    private String city;
    private UserType userType;

}
