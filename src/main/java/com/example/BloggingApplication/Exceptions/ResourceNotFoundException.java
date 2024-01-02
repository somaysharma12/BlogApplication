package com.example.BloggingApplication.Exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException{

    String resourceName;
    String fieldName;
    long fieldValue;
    String post;
    Integer userId;
    String title;

    public ResourceNotFoundException(String resourceName, String fieldName, long fieldValue){
        super(String.format("%s not found with %s : %s", resourceName,fieldName,fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public ResourceNotFoundException(Integer userId){
        super(String.format("%s this user id do not have the access to update/delete this post",userId));
        this.userId = userId;
    }

    public ResourceNotFoundException(String title){
        super(String.format("post already exist with title -------> %s",title));
        this.title = title;
    }
}
