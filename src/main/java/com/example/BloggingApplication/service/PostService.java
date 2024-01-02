package com.example.BloggingApplication.service;

import com.example.BloggingApplication.Model.Posts;
import com.example.BloggingApplication.Payloads.PostDto;

import java.util.List;

public interface PostService {

    PostDto createPost(PostDto postDto,Integer userId);

    PostDto updatePost(PostDto postDto,Integer userId,Integer postId);

    void deletePost(Integer userId, Integer postId);

    List<PostDto> getPostByUserId(Integer userId);

    PostDto getPostById(Integer postId);

    List<PostDto> getAllPost();



}
