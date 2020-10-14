package com.cybertek.lambdastream.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class User {

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private Role role;
    private UserState state;

}
