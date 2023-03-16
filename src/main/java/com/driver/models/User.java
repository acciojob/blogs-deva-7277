package com.driver.models;

import com.driver.models.Blog;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;

    private String password;

    private String firstName;

    private String lastName;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<Blog> blogList = new ArrayList<>();
}