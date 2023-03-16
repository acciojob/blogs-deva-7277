package com.driver.models;

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

    private String dimensions;

    @ManyToOne
    @JoinColumn
    private Blog blog;

    public Image(Blog blog, String description, String dimensions) {
        this.blog = blog;
        this.description = description;
        this.dimensions = dimensions;
    }
}