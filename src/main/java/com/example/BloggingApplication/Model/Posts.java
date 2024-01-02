package com.example.BloggingApplication.Model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @NotEmpty
    @Size(min = 3 , max = 25,message = "title must be between 3 to 25 characters")
    String title;

    @NotEmpty
    @Size(min = 20 ,message = "content must be minimum 10 characters")
    String content;

    LocalDateTime date;

    @ManyToOne
    User user;
}
