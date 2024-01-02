package com.example.BloggingApplication.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    @Entity
    @Table(name = "users")
    public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int id;

        @NotEmpty
        @Size(min = 4,message = "username must be greater than 4 characters")
        private String name;

        @Email(message = "Invalid email address")
        private String email;

        @NotEmpty
        @Size(min = 3 , max = 15,message = "password must be between 3 to 16 characters")
        private String password;

        @NotEmpty
        private String about;

        @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
        private List<Posts> posts = new ArrayList<>();

    }

