package com.example.BloggingApplication.Controller;

import com.example.BloggingApplication.Payloads.ApiReponse;
import com.example.BloggingApplication.Payloads.UserDto;
import com.example.BloggingApplication.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;


    @Operation(description = "This Api Creates the User taking user information in request body")
    @PostMapping("/createUser")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
        UserDto createdUser = userService.createUser(userDto);
        return  new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }


    @Operation(description = "This Api Updates the user taking the user id in path variable and request body")
    @PutMapping("updateUser/{userId}")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto,@PathVariable("userId") Integer userId){
        UserDto updatedUser = userService.updateUser(userDto, userId);
        return ResponseEntity.ok(updatedUser);
    }


    @Operation(description = "This Api Deletes the user taking the user id in path variable")
    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiReponse> deleteUser(@PathVariable("userId") Integer uid){
        this.userService.deleteUser(uid);
        return new ResponseEntity(new ApiReponse("user Deleted SuccessFully",true),HttpStatus.OK);
    }


    @Operation(description = "This Api retrives all the users")
    @GetMapping("/getAll")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @Operation(description = "This Api retrives the user on the basis of user Id accepted in path variable")
    @GetMapping("/{userId}")
    public  ResponseEntity<UserDto> getSingleUser(@PathVariable("userId") Integer userId){
        return ResponseEntity.ok(userService.getUserById(userId));
    }

}
