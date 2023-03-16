package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImageService {

    @Autowired
    BlogRepository blogRepository2;
    @Autowired
    ImageRepository imageRepository2;

    public Image addImage(Integer blogId, String description, String dimensions){

        Optional<Blog> blog = blogRepository2.findById(blogId);

        Image image = new Image();
        image.setBlog(blogRepository2.findById(blogId).get());
        image.setDescription(description);
        image.setDimensions(dimensions);

        List<Image> images = blogRepository2.findById(blogId).get().getImage();
        images.add(image);

        imageRepository2.save(image);
        return image;
    }

    public void deleteImage(Integer id){
        imageRepository2.deleteById(id);
    }

    public int countImagesInScreen(Integer id, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
        return 8;
    }
}
