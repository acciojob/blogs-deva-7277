package com.driver.models;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Entity
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private String content;

    private Date pubDate;

    @ManyToOne
    @JoinColumn(name = "image_id")
    private List<Image> image;

    @ManyToOne
    @JoinColumn
    private User user;


    @OneToMany(mappedBy = "blog", cascade = CascadeType.ALL)
    List<Image> imageList = new ArrayList<>();


    public Blog(User user, String title, String content) {
        this.user = user;
        this.title  = title;
        this.content = content;
    }
}