package com.driver.models;

import com.driver.models.Blog;
import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String description;

    private String dimesnsions;

    @ManyToOne
    @JoinColumn
    private Blog blog;
}