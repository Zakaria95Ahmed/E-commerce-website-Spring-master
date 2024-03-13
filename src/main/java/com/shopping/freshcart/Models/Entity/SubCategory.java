package com.shopping.freshcart.Models.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "sub_category ")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SubCategory {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String slug;
    @ManyToOne
    private Category category;


}
