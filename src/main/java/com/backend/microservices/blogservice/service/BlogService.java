package com.backend.microservices.blogservice.service;

import com.backend.microservices.blogservice.contants.Constants;
import com.backend.microservices.blogservice.dto.Blog;
import com.backend.microservices.blogservice.exception.DateOfCreationNotValidException;
import com.backend.microservices.blogservice.exception.NoBlogPresentException;
import com.backend.microservices.blogservice.repository.BlogRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class BlogService {

    @Autowired
    BlogRepository blogRepo;

    public List<Blog> getAllBlogService() {
        return blogRepo.findAll();
    }

    public Blog getBlogByIdService(String blogId) throws NoBlogPresentException {
        Optional<Blog> blog = blogRepo.findById(blogId);
        if (blog.isEmpty()){
                throw new NoBlogPresentException(Constants.NO_USER_PRESENT_WITH_USERID + blogId);
        }
        return blog.get();
    }

    public Blog addBlogService(Blog Blog) {
        if(Blog.getDateOfCreation().before(get200YearOldDate())){
            log.info(Constants.EXCEPTION_OCCURED +this.getClass().getName() +":"+Thread.currentThread().getStackTrace()[1].getMethodName() + Constants.EXCEPTION_MESSAGE + Constants.DOC_NOT_VALID);
            throw new DateOfCreationNotValidException(Constants.DOC_NOT_VALID);
        }
        return blogRepo.save(Blog);
    }

    private Date get200YearOldDate() {
        Calendar cal=Calendar.getInstance();
        cal.add(Calendar.YEAR,-201);
        return cal.getTime();
    }

    public Blog updateBlogByIdService(Blog Blog) {
        if(Blog.getDateOfCreation().before(get200YearOldDate())){
            log.info(Constants.EXCEPTION_OCCURED +this.getClass().getName() +":"+Thread.currentThread().getStackTrace()[1].getMethodName() + Constants.EXCEPTION_MESSAGE + Constants.DOC_NOT_VALID);
            throw new DateOfCreationNotValidException(Constants.DOC_NOT_VALID);
        }
        return blogRepo.save(Blog);
    }

    public boolean deleteBlogByIdService(String blogId) {
        blogRepo.deleteById(blogId);
        return true;
    }
}
