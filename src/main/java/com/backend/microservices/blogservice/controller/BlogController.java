package com.backend.microservices.blogservice.controller;

import com.backend.microservices.blogservice.dto.Blog;
import com.backend.microservices.blogservice.exception.NoBlogPresentException;
import com.backend.microservices.blogservice.service.BlogService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1")
public class BlogController {

//    private static final Logger logger= LoggerFactory.getLogger(BlogController.class);
    @Autowired
    private BlogService blogService;

    @GetMapping
    public String appName(){
        return "Blog Service";
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<Blog>> getAllBlog(){
        List<Blog> BlogList = blogService.getAllBlogService();
        return ResponseEntity.status(HttpStatus.OK).body(BlogList);
    }

    @GetMapping("/blogs/{blogId}")
    public ResponseEntity<Blog> getBlogById(@PathVariable("blogId") String blogId) throws NoBlogPresentException {
        Blog Blog = blogService.getBlogByIdService(blogId);
        return ResponseEntity.status(HttpStatus.OK).body(Blog);
    }

    @PostMapping("/blogs/add")
    public ResponseEntity<Blog> addBlog(@RequestBody @Valid Blog Blog){
        Blog= blogService.addBlogService(Blog);
        return ResponseEntity.status(HttpStatus.CREATED).body(Blog);
    }

    @PutMapping("/blogs")
    public ResponseEntity<Blog> updateBlogById(@RequestBody Blog Blog){
        Blog = blogService.updateBlogByIdService(Blog);
        return ResponseEntity.status(HttpStatus.OK).body(Blog);
    }

    @DeleteMapping("/blogs/{id}")
    public ResponseEntity<Boolean> deleteBlogById(@PathVariable("id") String blogId){
        boolean isDeleted = blogService.deleteBlogByIdService(blogId);
        return ResponseEntity.status(HttpStatus.OK).body(isDeleted);
    }
}
