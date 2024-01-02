package com.example.BloggingApplication.service.Impl;

import com.example.BloggingApplication.Exceptions.ResourceNotFoundException;
import com.example.BloggingApplication.Model.Posts;
import com.example.BloggingApplication.Model.User;
import com.example.BloggingApplication.Payloads.PostDto;
import com.example.BloggingApplication.Repository.PostRepo;
import com.example.BloggingApplication.Repository.UserRepo;
import com.example.BloggingApplication.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepo postRepo;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    UserRepo userRepo;


    @Override
    public PostDto createPost(PostDto postDto,Integer userId) {

        User user =  userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("user","Id",userId));

        Posts post = modelMapper.map(postDto, Posts.class);

        postRepo.findByTitle(post.getTitle())
                .ifPresent(existingPost -> {
                    throw new ResourceNotFoundException(post.getTitle());
                });

        post.setUser(user);
        post.setDate(LocalDateTime.now());
        Posts newPost = postRepo.save(post);
        return modelMapper.map(newPost,PostDto.class);
    }

    @Override
    public PostDto updatePost(PostDto postDto,Integer userId, Integer postId) {
        Posts posts =  postRepo.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("post","Id",postId));

        if(posts.getUser().getId() != userId){
            throw  new ResourceNotFoundException(userId);
        }
        posts.setTitle(postDto.getTitle());
        posts.setContent(postDto.getContent());
        posts.setDate(LocalDateTime.now());
        Posts newPost = postRepo.save(posts);

        return modelMapper.map(newPost,PostDto.class);
    }

    @Override
    public void deletePost(Integer userId,Integer postId) {
        Posts posts =  postRepo.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("post","Id",postId));
        if(posts.getUser().getId() != userId){
            throw  new ResourceNotFoundException(userId);
        }
         postRepo.deleteById(postId);
    }

    @Override
    public List<PostDto> getPostByUserId(Integer userId) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("user", "Id", userId));

        List<Posts> posts = postRepo.findByUserId(userId)
                .orElseThrow(() -> new ResourceNotFoundException("No posts exist for this user"));

        List<PostDto> postDtos =  posts.stream().map((post) -> this.modelMapper.map(post,PostDto.class)).collect(Collectors.toList());
        return postDtos;

    }

    @Override
    public PostDto getPostById(Integer postId) {
        Posts byId =postRepo.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("No posts exist for this postId"));

        return modelMapper.map(byId,PostDto.class);
    }

    @Override
    public List<PostDto> getAllPost() {
        List<Posts> posts = postRepo.findAll();

        if (posts.isEmpty()) {
            throw new ResourceNotFoundException("No posts exist");
        }

        List<PostDto> postDtos = posts.stream()
                .map(post -> modelMapper.map(post, PostDto.class))
                .collect(Collectors.toList());

        return postDtos;
    }

}
