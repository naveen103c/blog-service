package com.backend.microservices.blogservice.repository;

import com.backend.microservices.blogservice.dto.Blog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends MongoRepository<Blog, String> {

//    @Query("{Category.name:?0")
//    List<Blog> findByCategory(String category);

//    List<Blog> findByCategoryName(String category);
}
