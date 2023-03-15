package com.driver.services;

import com.driver.models.Blog;
import com.driver.models.Image;
import com.driver.models.User;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.ImageRepository;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BlogService {
    @Autowired
    BlogRepository blogRepository1;

    @Autowired
    UserRepository userRepository1;

    public Blog createAndReturnBlog(Integer userId, String title, String content) {
        User user = null;

        try{
            user = userRepository1.findById(userId).get();
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
        Blog blog = new Blog();
        blog.setTitle(title);
        blog.setContent(content);

        List<Blog> blogList = user.getBlogList();
        blogList.add(blog);

        return blog;

    }

    public void deleteBlog(int blogId){
        //delete blog and corresponding images
        Blog blog;
        try{
            blog = blogRepository1.findById(blogId).get();
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
        User user = (User) blog.getUser();
        List<Blog> blogList = user.getBlogList();
        blogList.remove(blog);

        blogRepository1.deleteById(blogId);
        List<Image> images = blog.getImage();
        images.clear();
    }
}
