package com.example.BloggingApplication.Controller;


import com.example.BloggingApplication.Exceptions.ResourceNotFoundException;
import com.example.BloggingApplication.Payloads.ApiReponse;
import com.example.BloggingApplication.Payloads.PostDto;
import com.example.BloggingApplication.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    PostService postService;

    @Operation(description = "This Api Creates the Post taking the user id in path variable and request body")
    @PostMapping("/create/{userId}")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto, @PathVariable Integer userId){
        PostDto post = postService.createPost(postDto, userId);
        return new ResponseEntity<>(post, HttpStatus.CREATED);
    }

    @Operation(description = "This Api updates the Post taking the user id in path variable and request body")
    @PostMapping("/update/{userId}/{postId}")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto, @PathVariable Integer userId,@PathVariable Integer postId){
        PostDto post = postService.updatePost(postDto, userId, postId);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @Operation(description = "This Api deletes the Post taking the user Id and post Id in path variable")
    @DeleteMapping("/delete/{userId}/{postId}")
    public ResponseEntity<ApiReponse> createPost(@PathVariable Integer userId,@PathVariable Integer postId){
         postService.deletePost(userId, postId);
        return new ResponseEntity(new ApiReponse("post Deleted SuccessFully",true),HttpStatus.OK);
    }

    @Operation(description = "This Api all the posts of a user by taking userId in path variable")
    @GetMapping("/getPost/{userId}")
    public ResponseEntity<List<PostDto>> getPostByUserId(@PathVariable Integer userId) {
        try {
            List<PostDto> posts = postService.getPostByUserId(userId);
            return ResponseEntity.ok(posts);
        } catch (ResourceNotFoundException e) {
            // Handle the exception, e.g., return a custom error response
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());
        }
    }

    @Operation(description = "This Api retrives the post by taking postId in path variable")
    @GetMapping("/getPostById/{postId}")
    public ResponseEntity<PostDto> getPostByPostId(@PathVariable Integer postId) {
        PostDto posts = postService.getPostById(postId);
        return ResponseEntity.ok(posts);

    }

    @Operation(description = "Thi api getas all the posts regardless of any user")
    @GetMapping("/getAllPosts")
    public ResponseEntity<List<PostDto>> getAllPost() {
        List<PostDto> posts = postService.getAllPost();
        return ResponseEntity.ok(posts);
    }


}
