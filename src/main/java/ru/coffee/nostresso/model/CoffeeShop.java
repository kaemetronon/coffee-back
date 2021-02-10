package ru.coffee.nostresso.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "shops")
@Data
public class CoffeeShop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String description;
    private String phone;
    private String img;

}
