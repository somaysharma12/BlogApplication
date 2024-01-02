
# Blog Application

This project contains two journeys
1) user journey
2) post journey


This helps the user to create, update , read and delete post.


## Features

- You can Create User
- You can update , Get and delete User
- you can get a single user by providing its id and you can also get all users
- Once user is created you can create a post , You cannot create a post without    creating a user
- you can update and delete post created by you only.
- you can read any post by providing its id
- you can read all the posts.
- you can read posts uploaded by a user.






## API Reference

#### Create user

```http
  http://localhost:8080/api/users/createUser
```
request body

{
"name" : "",
"email" : "somya",
"password" : "somya@18csu211",
"about" : "I am a working man"
}

#### Update user

```http
  http://localhost:8080/api/users/updateUser/{userId}
```
request body

{ "name" : "", "email" : "somya", "password" : "somya@18csu211", "about" : "I am a working man" }

#### Get All user

```http
  http://localhost:8080/api/users/getAll
```

#### getSingleUser

```http
  http://localhost:8080/api/users/{userId}
```


#### Delete user

```http
  http://localhost:8080/api/users/{userId}
```


#### Create Post

```http
  http://localhost:8080/api/posts/create/{userId}
```
request body
{
"title" : "title five",
"content": "software engineering is great for career"
}


#### update Post

```http
  http://localhost:8080/api/posts/update/{userId}/{postId}
```
request body
{
"title" : "title five",
"content": "software engineering is great for career"
}



#### Delete Post

```http
  http://localhost:8080/api/posts/delete/{userId}/{postId}
```


#### getPost By User

```http
  http://localhost:8080/api/posts/getPost/452
```



#### getPost by postId

```http
  http://localhost:8080/api/posts/getPostById/{postId}
```



#### get All Post

```http
 http://localhost:8080/api/posts/getAllPosts
```






## Validations and Error Handling
Error Handling is done using GlobalExceptionHandler and CustomExceptionHandler

- You will get proper error messages for

        1) If you do not have access to update or delete user or post
        2) If you do not enter value for any key
        3) if you try to make a post with same title that is already uploaded previously
        4) If user or post do not exist
        5) If password length is not between 3-5
        6) If email address is invalid
        7) If username is less than 4 characters
        8) title must be between 3 to 25 characters
        9) content must be minimum 10 characters