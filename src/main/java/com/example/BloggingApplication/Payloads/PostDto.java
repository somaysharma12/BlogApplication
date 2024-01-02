package com.example.BloggingApplication.Payloads;

import com.example.BloggingApplication.Model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {

    private Integer id;
    private  String title;
    private  String content;
    private  String userName;

}
