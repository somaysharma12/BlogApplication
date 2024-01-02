package com.example.BloggingApplication.Repository;

import com.example.BloggingApplication.Model.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepo extends JpaRepository<Posts,Integer> {
    Optional<Object> findByTitle(String title);


    @Query(nativeQuery = true, value = "SELECT * FROM blog.posts  WHERE user_id =?1 ")
    Optional<List<Posts>> findByUserId(Integer userId);
}
